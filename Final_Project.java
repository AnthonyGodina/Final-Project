// Anthony Godina
//11/27/25


import java.util.Scanner; // imported Scanner and random
import java.util.Random;


public class Final_Project
{
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random(); // Made a random num generator, something for the enemy to use, and the new Scanner
    static boolean enemycharged = false;

    public static void main(String[] args) 
    {
        gameMenu(); // This calls the game menu to start the program
    }

    
    public static void gameMenu()
    {
        System.out.println("Welcome to the Game Menu!"); // main menu options
        System.out.println("1. Start New Game");
        System.out.println("2. Exit");
        System.out.print("Please select an option: ");
        
        int choice = input.nextInt();
        
        switch (choice) // For what you pick in the menu
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
    public static void startNewGame() // When you start a new game it takes you here to begin the game
    {
        System.out.println("\nStarting a new game...");

        int[] player = {100, 20, 10}; // The player stats
        int[] enemy = {150, 15, 6}; // The enemy stats

        enemycharged = false;
        gameLoop(player, enemy);
        gameMenu();
    }
    public static void gameLoop(int[] player, int[] enemy) // This is where the turns would happen
    {
        while (player[0] > 0 && enemy[0] > 0)
        {
            statsPrint(player, enemy);

            playerTurn(player, enemy); //When you win
            if (enemy[0] <= 0)
            {
                System.out.println("Aww ma- I- I mean good job you defeated the enemy yaayyy !! Exp gains -9999 + high five");
                return;
            }
            enemyTurn(player, enemy); //When you are defeated
            if (player[0] <= 0)
            {
                System.out.println("You been defeated cuz ur bad try again.");
                return;
            }
        }
    }
    public static void playerTurn(int[] player, int[] enemy)
    {
        System.out.println("\nYour Turn! :)"); //The players options when it their turn
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. heal");
        int choice = input.nextInt();
        if (choice == 1)
        {
            attack(player, enemy);
        }
        else if (choice == 2) // what happens depending on what you choose
        {
            defend(player);
        }
        else if (choice == 3)
        {
            System.out.println("You drink a potion just to find out it was juice and realize you wasted your turn :) ");
        }
        else
        {
            System.out.println("Why'd you click that??? You lose your turn.");
        }
    }
    public static void attack(int[] attack, int[] defend) //how much damage you are doing to the enemy and as well as critical hits
    {
        int damage = attack[1] - defend[2];
        if ( damage < 0) damage = 0;

        int bonusDamage = rand.nextInt(6);
        int totalDamage = damage + bonusDamage;
        if (rand.nextInt (100) < 20)
        {
            totalDamage = damage * 2;
            System.out.println("yaaayy you did " + totalDamage + " damage, great job.... i guess");
        }
        defend[0] -= totalDamage;
        System.out.println("You did " + totalDamage + " damage!");
    }
    public static void hugeAttack(int[] attack, int [] defend) // This is where the enemy can have a chance to do there big attack
    {
      int baseDamage = (attack[1] * 2) - defend[2];
        if (baseDamage < 0) baseDamage = 0;

        int bonusDamage = rand.nextInt(11);
        int totalDamage = baseDamage + bonusDamage;
        defend[0] -= totalDamage;
        
    }
    public static void defend(int[] character) // This would add defense to whoever is defending
    {
        character[2] += 2;
        System.out.println("Defense increased");
    }
    public static void statsPrint(int[] player, int[] enemy) //  This would show the stats of both the player and enemy
    {
       System.out.println("\n  **Stats**  ");
       System.out.println("Player - Health: " + player[0] + ", Attack: " + player[1] + ", Defense: " + player[2]);
       System.out.println("Enemy - Health: " + enemy[0] + ", Attack: " + enemy[1] + ", Defense: " + enemy[2]);
    }
    public static void enemyTurn(int[] player, int[] enemy) // This is when it is the enemy's turn and they do their own action
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
            System.out.println("Enemy is attacking!");
            attack(enemy, player);
        }
        else if (action == 1)
        {
            System.out.println("Enemy is defending!");
            defend(enemy);
        }
        else
        {
             System.out.println("The her- I mean enemy is using a POWERFUL ATTACK!!");
            enemycharged = true;
        }
    }
}