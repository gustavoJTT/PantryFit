package br.com.pantryfit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String period;

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

    @Column(name = "icon_code_point")
    private Integer iconCodePoint;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealItem> items = new ArrayList<>();

    protected Meal() {
    }

    public Meal(String name, LocalTime time, String period, BigDecimal calories,
            BigDecimal proteins, BigDecimal carbohydrates, BigDecimal fats,
            BigDecimal fibers, Integer iconCodePoint) {
        this.name = name;
        this.time = time;
        this.period = period;
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fibers = fibers;
        this.iconCodePoint = iconCodePoint;
    }

    public void addItem(MealItem item) {
        items.add(item);
        item.setMeal(this);
    }

    public void removeItem(MealItem item) {
        items.remove(item);
        item.setMeal(null);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public Integer getIconCodePoint() {
        return iconCodePoint;
    }

    public void setIconCodePoint(Integer iconCodePoint) {
        this.iconCodePoint = iconCodePoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MealItem> getItems() {
        return items;
    }
}
