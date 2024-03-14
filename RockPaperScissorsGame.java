import java.util.Random;
import java.util.Scanner;

enum AttackType
{
    ROCK,
    PAPER,
    SCISSORS
}

enum PlayerType
{
    PLAYER,
    BOT
}

enum GameMode
{
    BOT_VS_BOT,
    PLAYER_VS_BOT,
    PLAYER_VS_PLAYER
}

public class RockPaperScissorsGame
{
    PlayerType player1;
    PlayerType player2;
    //GameMode mode;
    int numRounds;
    
    public RockPaperScissorsGame() // this is the constructor
    {
        String str = "JavaTpoint! 13 + 13.0 = 26.0 false ";

        Scanner scn = new Scanner(System.in);
        //scn = scn.useDelimiter("3");

        String x = scn.nextLine();

        //setupGame();
    }

    public void run()
    {
        System.out.println("Player 1 is a " + player1);
        System.out.println("Player 2 is a " + player1);
        //System.out.println("Game mode: " + mode);
        System.out.println("Number of rounds: " + numRounds);
    }

    private void setupGame()
    {
        System.out.println("Welcome to Rock-Paper-Scissors!");
        
        System.out.println(); // blank line
        
        Scanner scn = new Scanner(System.in);
        
        ///// CHOOSE GAME MODE /////
        System.out.println("Which game mode would you like to play?");
        System.out.println("0: 0-player     (bot vs bot)");
        System.out.println("1: 1-player  (player vs bot)");
        System.out.println("2: 2-player  (player vs player)");
        
        int choice = -1; // give temporary value to enter the while loop
        
        // https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
        while (choice < 0 || choice > 2)
        {
            System.out.print("Type 0 or 1 or 2: ");
            while (!scn.hasNextInt())
            {
                System.out.println("Must be an integer.");
                scn.next();
            }
            choice = scn.nextInt();
        }

        if (choice == 0)
        {
            //mode = GameMode.BOT_VS_BOT;
            player1 = PlayerType.BOT;
            player2 = PlayerType.BOT;
        }
        else if (choice == 1)
        {
            //mode = GameMode.PLAYER_VS_BOT;
            player1 = PlayerType.PLAYER;
            player2 = PlayerType.BOT;
        }
        else
        {
            //mode = GameMode.PLAYER_VS_PLAYER;
            player1 = PlayerType.PLAYER;
            player2 = PlayerType.PLAYER;
        }
        ///// END OF CHOOSE GAME MODE SECTION /////

        System.out.println(); // blank line

        ///// CHOOSE NUMBER OF ROUNDS /////
        numRounds = -2; // give temporary value to enter the while loop
        
        while (numRounds <= 0 && numRounds % 2 == 0) // must be positive and odd
        {
            System.out.print("How many rounds would you like to play?\nMust be an odd, positive integer. ");
            while (!scn.hasNextInt())
            {
                System.out.println("Must be an integer.");
                scn.next();
            }
            numRounds = scn.nextInt();
        }

        ///// END CHOOSE NUMBER OF ROUNDS SECTION /////

        System.out.println(); // blank line

        scn.close();
    }

    /*private void play()
    {
        if (mode == 0) // 0-player
        {
            AttackType bot1 = botChoose();
            AttackType bot2 = botChoose();
            String resultText = "";

            if (bot1 == bot2)
            {
                resultText = "It's a tie.";
            }

            else if (bot1 == AttackType.ROCK)
            {
                if (bot2 == AttackType.PAPER)
                {
                    resultText = "Bot 2 wins.";
                }
                else
                {
                    resultText = "Bot 1 wins.";
                }
            }

            else if (bot1 == AttackType.PAPER)
            {
                if (bot2 == AttackType.SCISSORS)
                {
                    resultText = "Bot 2 wins.";
                }
                else
                {
                    resultText = "Bot 1 wins.";
                }
            }

            else if (bot1 == AttackType.SCISSORS)
            {
                if (bot2 == AttackType.ROCK)
                {
                    resultText = "Bot 2 wins.";
                }
                else
                {
                    resultText = "Bot 1 wins.";
                }
            }
            
            System.out.println(bot1);
            System.out.println(bot2);
            System.out.println(resultText);
        }

        else if (mode == 1) // 1-player
        {

        }

        else // 2-player
        {

        }
    }*/

    private AttackType playerChoose()
    {
        Scanner scn = new Scanner(System.in);
        int choice;

        ///// CHOOSE NUMBER OF ROUNDS /////
        choice = -1; // give temporary value to enter the while loop
        
        while (choice < 0 || choice > 2) // must be 0, 1, or 2
        {
            System.out.print("Choose your move... ");
            while (!scn.hasNextInt())
            {
                System.out.println("Must be an integer.");
                scn.next();
            }
            choice = scn.nextInt();
        }
        
        scn.close();
        return intToAttackType(choice);
    }

    private AttackType botChoose()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(2);
        
        // 0->rock, 1->paper, 2->scissors
        return intToAttackType(randInt);
    }

    private AttackType intToAttackType(int number)
    {
        if (number == 0)
        {
            return AttackType.ROCK;
        }
        else if (number == 1)
        {
            return AttackType.PAPER;
        }
        else
        {
            return AttackType.SCISSORS;
        }
    }
}

