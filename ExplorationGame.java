//Kevin Elfert
//07/27/2020
import java.util.Scanner;
import java.lang.Math;
public class ExplorationGame
{
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int WEST = 2;
	private static final int SOUTH = 3;
	//room description array
	private static String[] roomDescription = new String[17];
	//criminal room description array
	private static String[] roomDescriptionCriminal = new String[17];
	//You start in the Entrance Hall
	private static int currentRoom = 5;
	//int for hasMap()
	private static int room3Count = 0;
	//The burglar starts randomly placed in the house
	private static int currentCriminalRoom = (int) ((Math.random() * 15) +1);
	//count for burglar to escape
	private static int count = 0;
	//boolean variable to quit if need be
	private static boolean resume = true;
	//int for printOptions()
	private static int printRoom = 0;
	//2D int array to get room exits
	private static int[][] roomExits = {
										{2,-1,6,-1},//0
										{3,-1,-1,-1},//1
										{-1,3,-1,0},//2
										{-1,-1,2,1},//3
										{7,5,-1,-1},//4
										{8,6,4,-1},//5
										{-1,0,5,-1},//6
										{-1,9,-1,4},//7
										{11,-1,-1,5},//8
										{-1,-1,7,-1},//9
										{13,11,-1,-1},//10
										{14,-1,10,8},//11
										{15,-1,-1,-1},//12
										{-1,14,-1,10},//13
										{16,15,13,11},//14
										{-1,-1,14,12},//15
										{-1,-1,-1,14},//16
									};

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		//room description array
		roomDescription[0] = "Basement Staircase heading to the First Floor";
		roomDescription[1] = "Storage Room";
		roomDescription[2] = "Laundry Room";
		roomDescription[3] = "Wine Cellar";
		roomDescription[4] = "Living Room";
		roomDescription[5] = "Entrance Hall"; 
		roomDescription[6] = "First Floor Staircase leading to the Basement";
		roomDescription[7] = "Dining Room";
		roomDescription[8] = "Staircase to the Second Floor";
		roomDescription[9] = "Kitchen";
		roomDescription[10] = "Guest Bedroom";
		roomDescription[11] = "South Hall/Staircase to First Floor";
		roomDescription[12] = "Master Bathroom";
		roomDescription[13] = "Guest Bathroom";
		roomDescription[14] = "North Hall";
		roomDescription[15] = "Master Bedroom";
		roomDescription[16] = "Balcony";

		//array for where burglar is located
		roomDescriptionCriminal[0] = "Basement Staircase heading to the First Floor";
		roomDescriptionCriminal[1] = "Storage Room";
		roomDescriptionCriminal[2] = "Laundry Room";
		roomDescriptionCriminal[3] = "Wine Cellar";
		roomDescriptionCriminal[4] = "Living Room";
		roomDescriptionCriminal[5] = "Entrance Hall"; 
		roomDescriptionCriminal[6] = "First Floor Staircase leading to the Basement";
		roomDescriptionCriminal[7] = "Dining Room";
		roomDescriptionCriminal[8] = "Staircase to the Second Floor";
		roomDescriptionCriminal[9] = "Kitchen";
		roomDescriptionCriminal[10] = "Guest Bedroom";
		roomDescriptionCriminal[11] = "South Hall/Staircase to First Floor";
		roomDescriptionCriminal[12] = "Master Bathroom";
		roomDescriptionCriminal[13] = "Guest Bathroom";
		roomDescriptionCriminal[14] = "North Hall";
		roomDescriptionCriminal[15] = "Master Bedroom";
		roomDescriptionCriminal[16] = "Balcony";

		//game setup
		System.out.println("You, a police officer, see a burglar break into a vacant house");
		System.out.println("Better check it out!");

		//You have 25 chances to catch the burglar
		while(resume == true && count < 25)
		{
			//selection statement to check if player has caught the burglar
			if (currentRoom == currentCriminalRoom) 
			{
				//winning print
				System.out.println();
				System.out.println("You caught the burglar!");
				input.close();
				break;
			}
			//printing where you are and where you hear the burglar
			System.out.println();
			System.out.println("You are in the " + roomDescription[currentRoom]);
			//print if hasMap() == true
			if (currentRoom == 3 && room3Count == 0) 
			{
				System.out.println("You found a map of the house!");
				room3Count++;
			}
			System.out.println( "You hear a noise in the " + roomDescriptionCriminal[currentCriminalRoom]);
			System.out.println("What direction would you like to go?");
			//method call to print player movement options
			printOptions();
			String choice = input.nextLine();
			//Random burglar movement
			int criminalChoiceInt = (int) (Math.random() * 4);
			String criminalChoice = "";
			//converting int criminalChoiceInt to String criminalChoice
			if (criminalChoiceInt == 0) 
			{
				criminalChoice = "n";
			}
			else if (criminalChoiceInt == 1) 
			{
				criminalChoice = "e";
			}
			else if (criminalChoiceInt == 2) 
			{
				criminalChoice = "w";
			}
			else if (criminalChoiceInt == 3) 
			{
				criminalChoice = "s";
			}
			//method calls
			choice(choice);
			criminal(criminalChoice);
			//incrementing the count
			count++;
		}
		if (count == 25) 
		{
			System.out.println("The burglar got away!");
			input.close();	
		}	
	}//end main method

	//method for player movement
	public static void choice(String choice)
	{ 
		//slection statement for player movement
		if (choice.equals("n")) 
		{
			//anticipation of user error
			if (roomExits[currentRoom][NORTH] == -1) 
			{
				System.out.println("That is not an exit");
			}
			else
			{
				currentRoom = roomExits[currentRoom][NORTH];
			}	
		}
		else if (choice.equals("e")) 
		{
			//anticipation of user error
			if (roomExits[currentRoom][EAST] == -1) 
			{
				System.out.println("That is not an exit");
			}
			else
			{
				currentRoom = roomExits[currentRoom][EAST];
			}	
		}	
		else if (choice.equals("w")) 
		{
			//anticipation of user error
			if (roomExits[currentRoom][WEST] == -1) 
			{
				System.out.println("That is not an exit");
			}
			else
			{
				currentRoom = roomExits[currentRoom][WEST];
			}	
		}
		else if (choice.equals("s")) 
		{	
			//anticipation of user error
			if (roomExits[currentRoom][SOUTH] == -1) 
			{
				System.out.println("That is not an exit");
			}
			else
			{
				currentRoom = roomExits[currentRoom][SOUTH];
			}	
		}
		//prints a map of the house
		else if (choice.equals("m") && hasMap() == true)
		{
			System.out.println("\t\t\t\t\tBalcony");
			System.out.println("Guest Bathroom\t\t\t\tNorth Hall\t\t\tMaster Bedroom");
			System.out.println("Guest Bedroom\t\t\tSouth Hall/Staircase to First Floor\tMaster Bathroom");
			System.out.println();
			System.out.println("Dining Room\t\t\tStaircase to Second Floor\t\tKitchen");
			System.out.println("Living Room\t\t\tEntrance Hall\t\t\tStaircase to Basement");
			System.out.println();
			System.out.println("\t\tLaundry Room\t\t\tWine Cellar");
			System.out.println("\t\tStaircase to First Floor\t\tStorage Room");
		}
		else if (choice.equals("q")) 
		{
			System.out.println("Thank you for playing!");
			resume = false;
		}
		//anticipation of user error
		else
		{
			System.out.println("Not a valid input");
		}
	}//end choice method

	//method for burglar movement
	public static void criminal(String criminalChoice)
	{ 
		//selection statement for burglar movement
		if (criminalChoice.equals("n")) 
		{
			if (roomExits[currentCriminalRoom][NORTH] != -1) 
			{
				currentCriminalRoom = roomExits[currentCriminalRoom][NORTH];
			}	
		}
		else if (criminalChoice.equals("e")) 
		{
			if (roomExits[currentCriminalRoom][EAST] != -1) 
			{
				currentCriminalRoom = roomExits[currentCriminalRoom][EAST];
			}	
		}	
		else if (criminalChoice.equals("w")) 
		{
			if (roomExits[currentCriminalRoom][WEST] != -1) 
			{
				currentCriminalRoom = roomExits[currentCriminalRoom][WEST];
			}	
		}
		else if (criminalChoice.equals("s")) 
		{	
			if (roomExits[currentCriminalRoom][SOUTH] != -1) 
			{
				currentCriminalRoom = roomExits[currentCriminalRoom][SOUTH];
			}	
		}
	}//end criminal choice method

	public static boolean hasMap()
	{
		if (currentRoom == 3) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}//end hasMap

	public static void printOptions()
	{
		//North
		if (roomExits[currentRoom][NORTH] == -1) 
		{
			System.out.println("[N]orth: NOT AN EXIT");
		}
		else
		{
			printRoom = roomExits[currentRoom][NORTH];
			System.out.println("[N]orth: " + roomDescription[printRoom]);
		}

		//East
		if (roomExits[currentRoom][EAST] == -1) 
		{
			System.out.println("[E]ast: NOT AN EXIT");
		}
		else
		{
			printRoom = roomExits[currentRoom][EAST];
			System.out.println("[E]ast: " + roomDescription[printRoom]);
		}

		//West
		if (roomExits[currentRoom][WEST] == -1) 
		{
			System.out.println("[W]est: NOT AN EXIT");	
		}
		else
		{
			printRoom = roomExits[currentRoom][WEST];
			System.out.println("[W]est: " + roomDescription[printRoom]);
		}

		//South
		if (roomExits[currentRoom][SOUTH] == -1) 
		{
			System.out.println("[S]outh: NOT AN EXIT");
		}
		else
		{
			printRoom = roomExits[currentRoom][SOUTH];
			System.out.println("[S]outh: " + roomDescription[printRoom]);
		}

		//hasMap
		if (hasMap() == true) 
		{
			System.out.println("[M]ap");
		}

		//Quit
		System.out.println("[Q]uit");
	}//end print options
}