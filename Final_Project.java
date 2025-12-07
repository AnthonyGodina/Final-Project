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
    public static void startNewGame()
    {
        System.out.println("\nStarting a new game...");

        int[] playerStats = {100, 20, 15}; // The player stats
        int[] enemyStats = {200, 5, 10}; // The enemy stats

        enemycharged = false;
        gameLoop(player, enemy);
        gameMenu();
    }
    public static void gameLoop(int[] player, int[] enemy)
    {
        while (player[0] > 0 && enemy[0] > 0)
        {
            statsPrint(player, enemy);

            playerTurn(player, enemy);
            if (enemy[0] <= 0)
            {
                System.out.println("Aww ma- I- I mean good job you defeated the enemy yaayyy !! Exp gains -9999 + high five");
                return;
            }
            enemyTurn(player, enemy);
            if (player[0] <= 0)
            {
                System.out.println("You been defeated cuz ur bad try again.");
                return;
            }
        }
    }
    public static void playerTurn(int[] player, int[] enemy)
    {
        System.out.println("\nYour Turn! :)");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. heal");
        int[] choice = input.nextInt();
        if (choice == 1)
        {
            attack(player, enemy);
        }
        else if (choice == 2)
        {
            defend(player);
        }
        else
        {
            System.out.println("You drink a potion just to find out it was juice and realize you wasted your turn :) ");
        }
    }
    public static void enemyTurn(int[] player, int[] enemy)
    {
        System.out.println("\nEnemy's Turn >:) : ");

        if (enemycharged)
        {
            hugeAttack(enemy, player);
            enemycharged = false;
            return;
        }
        int action = rand.nextInt(3);
        if (action == 0)
        {
            System.out.Println("Enemy is attacking!");
            attack(enemy, player);
        }
        else if (action == 1)
        {
            System.out.Println("Enemy is defending!");
            defend(enemy);
        }
        else
        {
            System.out.Println("Enemy is charging up for a BIGGGG attack!");
            enemycharged = true;
        }
    }
    public static void attack(int[] attack, int[] defend)
    {
        int damage = attack[1] - defend[2];
        if ( damage < 0) damage = 0;

        int
    }
}