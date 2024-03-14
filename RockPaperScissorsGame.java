import java.util.Random;     // need this for the random function
import java.util.Scanner;    // need this for the user input function

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
        
        System.out.println(getUserInt(-3, 6));
        
        //setupGame();
    }

    /*public void run()
    {
        System.out.println("Player 1 is a " + player1);
        System.out.println("Player 2 is a " + player1);
        //System.out.println("Game mode: " + mode);
        System.out.println("Number of rounds: " + numRounds);
    }*/

    /*private void setupGame()
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
    }*/

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

    /*private AttackType playerChoose()
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
        
        return intToAttackType(choice);
    }*/

    /*private AttackType botChoose()
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
    }*/

    // 'getRandomInt' returns a random integer that is at least 'min' and at most 'max'.
    private int getRandomInt(int min, int max)
    {
        Random rand = new Random();
        return min + rand.nextInt(max - min + 1);
    }

    // 'getUserInt' loops until a valid integer has been submitted by the user that is at least 'min' and at most 'max'.
    // The function returns the valid integer that the user typed in.
    private int getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);
        
        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";
        boolean repeat = false;

        while (userNumber < min || userNumber > max) // Note: || means or
        {
            // Modify the prompt based on whether we are repeating or not.
            if (repeat)
            {
                System.out.println("Number must be at least " + min + " and at most " + max + ".\n");
                System.out.print(prompt);
            }
            else
            {
                repeat = true;
                System.out.print(prompt);
            }
            
            // Loop as long as an integer has NOT been inputted.
            while (!scn.hasNextInt())
            {
                System.out.println("That is not an integer.\n");
                System.out.print(prompt);
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

            // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }

        return userNumber;
    }
}

