# Entidades do PantryFit

Este documento descreve os modelos persistidos ou usados pelo projeto atual e uma sugestao de mapeamento para Spring/JPA.

## Visao geral

O projeto possui dois armazenamentos independentes:

- **Backend Flask + SQLite:** armazena usuarios na tabela `users`.
- **Aplicativo Flutter + SQLite local:** armazena refeicoes e itens de refeicao.

Atualmente nao existe sincronizacao entre refeicoes e backend. As refeicoes locais tambem nao possuem `user_id`.

## 1. User

Representa o usuario autenticado no backend.

### Tabela atual: `users`

| Campo | Tipo atual | Regras | Tipo sugerido no Java |
| --- | --- | --- | --- |
| `id` | INTEGER | PK, autoincremento | `Long` |
| `username` | TEXT | obrigatorio, unico, armazenado em minusculas | `String` |
| `password_hash` | TEXT | obrigatorio; nunca e retornado pela API | `String` |
| `display_name` | TEXT | obrigatorio | `String` |
| `created_at` | TEXT | obrigatorio, data/hora UTC | `Instant` |

### Entidade JPA sugerida para User

Classe: `User`

- `@Entity`
- `@Table(name = "users")`
- `@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)` em `id`
- `@Column(nullable = false, unique = true)` em `username`
- `@Column(name = "password_hash", nullable = false)` em `passwordHash`
- `@Column(name = "display_name", nullable = false)` em `displayName`
- `@Column(name = "created_at", nullable = false, updatable = false)` em `createdAt`

O JWT usa o ID do usuario como `sub`. O token tambem inclui `username`, mas o token nao e uma entidade do dominio nem precisa ser persistido neste projeto.

### API relacionada

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/auth/validate`
- `GET /api/users`
- `GET /api/users/{id}`
- `PUT /api/users/{id}`
- `DELETE /api/users/{id}`

A resposta publica do usuario contem apenas `id`, `username`, `display_name` e `created_at`. `password_hash` deve ficar fora dos DTOs de resposta.

## 2. Meal

Representa uma refeicao criada pelo usuario no aplicativo. Hoje e persistida somente no SQLite local do Flutter.

### Tabela atual: `meals`

| Campo | Tipo atual | Regras | Tipo sugerido no Java |
| --- | --- | --- | --- |
| `id` | TEXT | PK; o app gera o identificador | `UUID` ou `String` |
| `name` | TEXT | obrigatorio | `String` |
| `time` | TEXT | obrigatorio; horario como texto | `LocalTime` ou `String` |
| `period` | TEXT | obrigatorio; ex.: cafe da manha, almoco | `String` ou enum |
| `calories` | REAL | obrigatorio; total calculado da refeicao | `BigDecimal` |
| `proteins` | REAL | obrigatorio; gramas | `BigDecimal` |
| `carbohydrates` | REAL | obrigatorio; gramas | `BigDecimal` |
| `fats` | REAL | obrigatorio; gramas | `BigDecimal` |
| `fibers` | REAL | obrigatorio; gramas | `BigDecimal` |
| `icon_code_point` | INTEGER | obrigatorio; codigo visual do Flutter | `Integer` ou remover |

### Relacionamento

Uma refeicao possui varios itens:

```text
Meal 1 ---- N MealItem
```

No modelo Spring, a sugestao e:

- `Meal` com `@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)`.
- `MealItem` com `@ManyToOne(fetch = FetchType.LAZY)` e `@JoinColumn(name = "meal_id")`.
- Se as refeicoes forem movidas para o backend, adicionar `@ManyToOne` de `Meal` para `User`, com uma coluna `user_id` obrigatoria.

### Observacoes de modelagem

- `calories` e os macronutrientes sao totais da refeicao e podem ser recalculados a partir dos itens. No backend, defina se serao persistidos como snapshot ou sempre derivados.
- `time` deveria ser convertido para `LocalTime` se o backend for responsavel por validar horario.
- `period` pode virar um enum, por exemplo `BREAKFAST`, `LUNCH`, `DINNER`, `SNACK`, caso os valores sejam controlados.
- `icon_code_point` e detalhe de apresentacao do Flutter. Para uma API independente do app, e melhor armazenar um campo semantico como `icon` ou deixar a escolha para o frontend.

## 3. MealItem

Representa um alimento usado em uma refeicao.

### Tabela atual: `meal_items`

| Campo | Tipo atual | Regras | Tipo sugerido no Java |
| --- | --- | --- | --- |
| `id` | INTEGER | PK, autoincremento | `Long` |
| `meal_id` | TEXT | FK para `meals.id`, obrigatorio | relacionamento `Meal` |
| `name` | TEXT | obrigatorio | `String` |
| `is_from_pantry` | INTEGER | booleano `0`/`1` | `Boolean` |
| `calories` | REAL | calorias da quantidade usada | `BigDecimal` |
| `proteins` | REAL | proteinas da quantidade usada, em gramas | `BigDecimal` |
| `carbohydrates` | REAL | carboidratos da quantidade usada, em gramas | `BigDecimal` |
| `fats` | REAL | gorduras da quantidade usada, em gramas | `BigDecimal` |
| `fibers` | REAL | fibras da quantidade usada, em gramas | `BigDecimal` |
| `quantity_g` | REAL | obrigatorio; padrao 100 | `BigDecimal` |

### Entidade JPA sugerida para MealItem

Classe: `MealItem`

- `@Entity`
- `@Table(name = "meal_items")`
- `@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)` em `id`
- `@ManyToOne(fetch = FetchType.LAZY)` para `Meal`
- `@JoinColumn(name = "meal_id", nullable = false)`
- `@Column(name = "is_from_pantry", nullable = false)` em `isFromPantry`
- `@Column(name = "quantity_g", nullable = false)` em `quantityG`

A exclusao de uma `Meal` deve excluir seus itens, equivalente ao `ON DELETE CASCADE` usado no SQLite.

## 4. OpenFoodProduct: DTO externo, nao entidade atual

`OpenFoodProduct` representa o resultado da busca na API Open Food Facts. Ele nao e salvo no banco e nao possui ID no modelo atual.

Campos usados pelo app:

- `name` <- `product_name`
- `brand` <- `brands`
- `imageUrl` <- `image_front_small_url`
- `calories` <- `energy-kcal_100g` ou `energy-kcal`
- `proteins` <- `proteins_100g`
- `carbohydrates` <- `carbohydrates_100g`
- `fats` <- `fat_100g`
- `fibers` <- `fiber_100g`

No Spring, modele isso como `OpenFoodProductDto` ou `FoodSearchResultDto`, usado somente na integracao com a API externa. Nao crie uma entidade JPA para ele a menos que queira implementar um catalogo/cache local.

## Entidades que NAO existem atualmente

- **Pantry/Despensa:** existe apenas o booleano `MealItem.is_from_pantry`; nao existe tabela de alimentos da despensa.
- **NutritionalProfile/Perfil nutricional:** a meta de 2000 Kcal aparece fixa na interface e nao e persistida.
- **RefreshToken:** o backend usa JWT com expiracao de 2 horas e nao persiste tokens.
- **Food/Product persistido:** os alimentos da Open Food Facts sao consultados em tempo real e incorporados ao item da refeicao como valores nutricionais.

## Modelo recomendado para o Spring

Se a ideia e transformar o app em uma aplicacao com dados sincronizados entre dispositivos, o modelo minimo recomendado seria:

```text
User 1 ---- N Meal 1 ---- N MealItem
```

Nesse caso, incluir em `meals`:

```text
user_id BIGINT NOT NULL REFERENCES users(id)
```

E consultar refeicoes sempre pelo usuario autenticado. Uma versao futura com despensa poderia adicionar:

```text
User 1 ---- N PantryItem
MealItem N ---- 0..1 PantryItem
```

Mas isso exige definir se `MealItem` referencia um produto cadastrado ou se continua guardando um snapshot dos valores nutricionais. Para preservar o historico nutricional, o snapshot dos valores usados na refeicao deve continuar salvo no proprio `MealItem`.

## Resumo para implementacao

Entidades JPA iniciais:

1. `User`
2. `Meal`
3. `MealItem`

DTO de integracao, sem tabela propria:

- `OpenFoodProductDto`

Relacionamentos essenciais:

- `User` possui varias `Meal` (recomendado para o backend Spring).
- `Meal` possui varias `MealItem`.
- `MealItem` pertence a uma `Meal`.
