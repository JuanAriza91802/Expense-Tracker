package com.mycompany.expensetracker.clases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private final String DATA_FILE = "expenses.json";
    private List<Expense> expenses;
    private Gson gson;

    public ExpenseManager() {
        gson = new Gson();
        expenses = loadExpenses();
    }

    // Cargar datos desde el archivo JSON
    private List<Expense> loadExpenses() {
        try (Reader reader = new FileReader(DATA_FILE)) {
            Type listType = new TypeToken<ArrayList<Expense>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Guardar datos en el archivo JSON
    private void saveExpenses() {
        try (Writer writer = new FileWriter(DATA_FILE)) {
            gson.toJson(expenses, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Agregar un gasto
    public void addExpense(String description, double amount, String category) {
        int id = expenses.stream().mapToInt(Expense::getId).max().orElse(0) + 1;
        Expense newExpense = new Expense(id, description, amount, category);
        expenses.add(newExpense);
        saveExpenses();
        System.out.println("Gasto agregado exitosamente: " + newExpense);
    }

    // Listar todos los gastos
    public void listExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No hay gastos registrados.");
        } else {
            expenses.forEach(System.out::println);
        }
    }

    // Resumen general
    public void showSummary() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.printf("Total de gastos: $%.2f%n", total);
    }

    // Eliminar un gasto
    public void deleteExpense(int id) {
        expenses.removeIf(expense -> expense.getId() == id);
        saveExpenses();
        System.out.println("Gasto con ID " + id + " eliminado exitosamente.");
    }
}
