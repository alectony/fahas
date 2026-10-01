/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.Scanner;
/**
 *
 * @author CL2-PC
 */
public class cli_cafe {
    
    
    public static void main(String[] args) {

        act();

    }

    // Recursion method
    private static void act() {

        Scanner input = new Scanner(System.in);

        System.out.println("[1] = Snacks");
        System.out.println("[2] = Drinks");
        System.out.println("Enter your choice:");
        int choice1 = input.nextInt();

        if (choice1 == 1) {

            System.out.println("Snacks");
            System.out.println("[1] = Piatos [22 pesos]");
            System.out.println("[2] = Nova [25 pesos]");
            System.out.println("Enter your choice:");
            int snackschoi1 = input.nextInt();

            if (snackschoi1 == 1) {

                System.out.println("You chose Piatos");
                System.out.println("Price is 22 pesos");

                int piatos = 22;

                System.out.println("Enter quantity:");
                int quan1 = input.nextInt();

                int subtot = quan1 * piatos;

                System.out.println("Subtotal is: " + subtot);

                System.out.println("Enter cash:");
                int cash = input.nextInt();

                while (cash < subtot) {
                    System.out.println("Insufficient cash!");
                    System.out.println("Enter cash:");
                    cash = input.nextInt();
                }

                int tot = cash - subtot;

                System.out.println("Your change is: " + tot);
            }

            else if (snackschoi1 == 2) {

                System.out.println("You chose Nova");
                System.out.println("Price is 25 pesos");

                int nova = 25;

                System.out.println("Enter quantity:");
                int quan1 = input.nextInt();

                int subtot = quan1 * nova;

                System.out.println("Subtotal is: " + subtot);

                System.out.println("Enter cash:");
                int cash = input.nextInt();

                while (cash < subtot) {
                    System.out.println("Insufficient cash!");
                    System.out.println("Enter cash:");
                    cash = input.nextInt();
                }

                int tot = cash - subtot;

                System.out.println("Your change is: " + tot);
            }
        }

        // Ask if the user wants to repeat
        System.out.println("\nDo you want to order again?");
        System.out.println("[1] = Yes");
        System.out.println("[2] = No");
        System.out.println("Enter choice:");

        int again = input.nextInt();

        if (again == 1) {

            // RECURSION
            act();

        } else {

            System.out.println("Thank you for ordering!");
        }
    }
}


