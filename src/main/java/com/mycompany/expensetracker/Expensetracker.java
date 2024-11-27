/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.expensetracker;

import com.mycompany.expensetracker.clases.ExpenseManager;
import java.util.Scanner;


/**
 *
 * @author JAVIER ARIZA
 */
public class Expensetracker {

    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al rastreador de gastos.");
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar gasto");
            System.out.println("2. Listar gastos");
            System.out.println("3. Resumen general");
            System.out.println("4. Eliminar gasto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> {
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();
                    System.out.print("Monto: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Categoría (opcional): ");
                    String category = scanner.nextLine();
                    manager.addExpense(description, amount, category.isEmpty() ? null : category);
                }
                case 2 ->
                    manager.listExpenses();
                case 3 ->
                    manager.showSummary();
                case 4 -> {
                    System.out.print("ID del gasto a eliminar: ");
                    int id = scanner.nextInt();
                    manager.deleteExpense(id);
                }
                case 5 -> {
                    System.out.println("¡Gracias por usar el rastreador de gastos!");
                    return;
                }
                default ->
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
