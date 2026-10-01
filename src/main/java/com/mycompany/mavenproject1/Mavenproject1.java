/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.util.Scanner;

/**
 *
 * @author CL2-PC
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        int sum, diff, mult, quot;
        Scanner input = new Scanner(System.in);
        System.out.println( "Enter a number: ");
        int x = input.nextInt();
        System.out.println( "Enter a number: ");
        int y = input.nextInt();
        
        sum = x + y;
        diff = x - y;
        mult = x * y;
        quot = x / y;
        
        System.out.println(""+sum);
        System.out.println(""+diff);
        System.out.println(""+mult);
        System.out.println(""+quot);

    }
}
