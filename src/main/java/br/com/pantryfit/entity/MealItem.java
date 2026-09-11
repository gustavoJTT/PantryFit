package br.com.pantryfit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "meal_items")
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_from_pantry", nullable = false)
    private Boolean fromPantry;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal calories;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal proteins;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal carbohydrates;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal fats;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal fibers;

    @Column(name = "quantity_g", nullable = false, precision = 10, scale = 2)
    private BigDecimal quantityG = BigDecimal.valueOf(100);

    protected MealItem() {
    }

    public MealItem(String name, Boolean fromPantry, BigDecimal calories,
            BigDecimal proteins, BigDecimal carbohydrates, BigDecimal fats,
            BigDecimal fibers, BigDecimal quantityG) {
        this.name = name;
        this.fromPantry = fromPantry;
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fibers = fibers;
        if (quantityG != null) {
            this.quantityG = quantityG;
        }
    }

    public Long getId() {
        return id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFromPantry() {
        return fromPantry;
    }

    public void setFromPantry(Boolean fromPantry) {
        this.fromPantry = fromPantry;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public void setProteins(BigDecimal proteins) {
        this.proteins = proteins;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public BigDecimal getFats() {
        return fats;
    }

    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }

    public BigDecimal getFibers() {
        return fibers;
    }

    public void setFibers(BigDecimal fibers) {
        this.fibers = fibers;
    }

    public BigDecimal getQuantityG() {
        return quantityG;
    }

    public void setQuantityG(BigDecimal quantityG) {
        this.quantityG = quantityG;
    }
}
