package com.mycompany.expensetracker.clases;

import java.time.LocalDate;

public class Expense {
    private int id;
    private String date;
    private String description;
    private double amount;
    private String category;

    // Constructor
    public Expense(int id, String description, double amount, String category) {
        this.id = id;
        this.date = LocalDate.now().toString();
        this.description = description;
        this.amount = amount;
        this.category = category != null ? category : "Uncategorized";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Fecha: %s | Descripción: %s | Monto: $%.2f | Categoría: %s",
                id, date, description, amount, category);
    }
}
