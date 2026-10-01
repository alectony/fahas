/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.Scanner;

/**
 *
 * @author NOT cl2-09 
 */
public class RPS {
            
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println( "Rock [1] - Paper [2] - Scissors [3]" );
        
        System.out.println( "Player 1's Move: ");
        int x = input.nextInt();
        System.out.println( "Player 2's Move: ");
        int y = input.nextInt();
        
        
        
        if(x == 1 && y == 2 || x == 2 && y == 3 || x == 3 && y == 1) // player 2 wins
        {
            System.out.println("Player 2 Wins!");
        }
        else if (x == 2 && y == 1 || x == 3 && y == 2 || x == 1 && y == 3) // player 1 wubs
        {
            System.out.println("Player 1 Wins!");
        }
        else if (x == 1 && y == 1 || x == 2 && y == 2 || x == 3 && y == 3) // draw
        {
            System.out.println("Draw!");
        }
    }
}