package br.com.pantryfit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pantry_items")
public class PantryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MeasurementUnit unit;

    @Column(nullable = false, precision = 12, scale = 3)
    private BigDecimal quantity;

    @Column(name = "minimum_quantity", nullable = false, precision = 12, scale = 3)
    private BigDecimal minimumQuantity;

    @Column(name = "calories_per_100g", precision = 10, scale = 2)
    private BigDecimal caloriesPer100g;

    @Column(name = "proteins_per_100g", precision = 10, scale = 2)
    private BigDecimal proteinsPer100g;

    @Column(name = "carbohydrates_per_100g", precision = 10, scale = 2)
    private BigDecimal carbohydratesPer100g;

    @Column(name = "fats_per_100g", precision = 10, scale = 2)
    private BigDecimal fatsPer100g;

    @Column(name = "fibers_per_100g", precision = 10, scale = 2)
    private BigDecimal fibersPer100g;

    @OneToMany(mappedBy = "pantryItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockMovement> stockMovements = new ArrayList<>();

    protected PantryItem() {
    }

    public PantryItem(String name, String category, MeasurementUnit unit,
            BigDecimal quantity, BigDecimal minimumQuantity) {
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(BigDecimal minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public BigDecimal getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(BigDecimal caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public BigDecimal getProteinsPer100g() {
        return proteinsPer100g;
    }

    public void setProteinsPer100g(BigDecimal proteinsPer100g) {
        this.proteinsPer100g = proteinsPer100g;
    }

    public BigDecimal getCarbohydratesPer100g() {
        return carbohydratesPer100g;
    }

    public void setCarbohydratesPer100g(BigDecimal carbohydratesPer100g) {
        this.carbohydratesPer100g = carbohydratesPer100g;
    }

    public BigDecimal getFatsPer100g() {
        return fatsPer100g;
    }

    public void setFatsPer100g(BigDecimal fatsPer100g) {
        this.fatsPer100g = fatsPer100g;
    }

    public BigDecimal getFibersPer100g() {
        return fibersPer100g;
    }

    public void setFibersPer100g(BigDecimal fibersPer100g) {
        this.fibersPer100g = fibersPer100g;
    }

    public List<StockMovement> getStockMovements() {
        return stockMovements;
    }
}
