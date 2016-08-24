import java.util.Scanner;
public class Craps
	{
		static String name;
		static int total=100;
		static int bet, point, rollOne, rollTwo;
		static boolean win, playing;

		public static void main(String[] args)
			{
				greetUser();
				runGame();
			}
		public static void runGame()
		{
			askForBet();
			rollDice();
			check();
		}
		public static void greetUser()
		{
			System.out.println("Hello player! What is your name?");
			Scanner userInput=new Scanner(System.in);
			name=userInput.nextLine();
			System.out.println("Welcome to Craps, " + name + "!");
		}
		public static void askForBet()
		{
			System.out.println("Your total is " + total);
			System.out.println("How much would you like to bet?");
			try 
				{
			Scanner userInput=new Scanner(System.in);
			bet=userInput.nextInt();
			System.out.println("You bet " + bet);
			}catch(Exception e)
				{
				System.out.println("ERROR");
				askForBet();
				}
			if (bet>total || bet<0)
				{
					System.out.println("Nice try.");
					askForBet();
				}
		}
		public static void rollDice()
		{

			try 
				{
				Thread.sleep(300);


			} catch (InterruptedException e) {e.printStackTrace();}
			rollOne=(int)(Math.random()*6)+1;
			rollTwo=(int)(Math.random()*6)+1;
			if (rollOne==1 && rollTwo==1)
				{
					System.out.println("Snake Eyes!");
					win=false;
					winOrLoose();
				}
			else if (rollOne==6 && rollTwo==6)
				{
					System.out.println("Box Cars!");
					win=false;
					winOrLoose();
				}
		}
		public static void check()
		{
			System.out.println("You rolled a " + rollOne + " and a " + rollTwo + " For a total of " + (rollOne+rollTwo));
			if (rollOne+rollTwo==7||rollOne+rollTwo==11)
				{
					System.out.println("WINNER");
					win=true;
					playing=false;
					winOrLoose();
				}
			else
				{
					point=rollOne+rollTwo;
					playing=true;
					System.out.println("The point is " + point);
				}
			while (playing)	
				{
					rollDice();
					System.out.println("You rolled a " + rollOne + " and a " + rollTwo + " For a total of " + (rollOne+rollTwo));
					
					if (rollOne+rollTwo==point)
						{
							System.out.println("WINNER");
							win=true;
							winOrLoose();
						}
					else if (rollOne+rollTwo==7)
						{
							System.out.println("LOSER");
							win=false;
							winOrLoose();
						}
				}
			}
		public static void winOrLoose()
		{
			if (win)
				{
					total=total+bet;
				}
			else
				{
					total=total-bet;
				}
			System.out.println("You now have " + total);
			if (total<=0)
				{
					System.out.println("You have lost all of your money, and thus cant afford food and die. I hope it was worth it.");
					System.out.println("$$$ Thanks for your money! $$$");
					System.exit(0);
				}
			else if (total>=1000)
				{
					System.out.println("You should buy yourself something nice, and stop losing us our money! Get out!");
					System.out.println("Enjoy your money.... ");
					System.out.println("Total of " + total);
					System.exit(0);
				}
			keepPlaying();
		}
		public static void keepPlaying()
		{
			System.out.println("Keep playing? (y/n)");
			Scanner userInput=new Scanner(System.in);
			String ans = userInput.nextLine();
			if (ans=="no" || ans=="n" || ans=="nope")
				{
					System.out.println("Thanks for playing! You leave with " + total);
					System.exit(0);
				}
			else
				{
					runGame();
				}
		}

	}
