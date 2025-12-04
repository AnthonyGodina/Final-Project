// Anthony Godina
//11/27/25


import java.util.Scanner;
import java.util.Random;


public class Final_Project
{
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) 
    {
        gameMenu();
    }
    public static void startNewGame()
    {
        System.out.println("Starting a new game...");
        int[] playerStats = {100, 10, 5};
        System.out.println("Player Stats - Health: " + playerStats[0] + ", Attack: " + playerStats[1] + ", Defense: " + playerStats[2]);
        int[] enemyStats = {200, 15, 8};
        System.out.println("Enemy Stats - Health: " + enemyStats[0] + ", Attack: " + enemyStats[1] + ", Defense: " + enemyStats[2]);

    }
    public static void gameMenu()
    {
        System.out.println("Welcome to the Game Menu!");
        System.out.println("1. Start New Game");
        System.out.println("2. Exit");
        System.out.print("Please select an option: ");
        
        int choice = input.nextInt();
        
        switch (choice) 
        {
            case 1:
                startNewGame();
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                gameMenu();
                break;
        }
        
    } 
    public static void turnSequence(int[] playerStats, int[] enemyStats)
    {
        System.out.println("Player's Turn:");
        int playerDamage
    }

}