/*
   Author: Savaas Iqbal
   Purpose: This program allows the user to order a pizza
   Date: 10/3/2022
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class PizzaOrder
{
	public static void main (String [] args)
	{
		//TASK #5 Create a DecimalFormat object with 2 decimal places
				
		//Create a Scanner object to read input
		Scanner keyboard = new Scanner (System.in);
		
		String firstName;					//user's first name
		boolean discount = false;		//flag, true if user is eligible for discount
		int inches;							//size of the pizza
		char crustType;					//code for type of crust
		String crust = "Hand-tossed"; //name of crust
		double cost = 12.99;				//cost of the pizza
		final double TAX_RATE = .08;	//sales tax rate
		double tax;							//amount of tax
		char choice;						//user's choice
		String input;						//user input
		String toppings = "Cheese ";	//list of toppings	
		int numberOfToppings = 0;		//number of toppings
		
		//prompt user and get first name
		System.out.println("Welcome to Mike and Diane's Pizza");
		System.out.print("Enter your first name:  ");
		firstName = keyboard.nextLine();
		
		//determine if user is eligible for discount by
		//having the same first name as one of the owners
		//ADD LINES HERE FOR TASK #1
		if(firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Diane")){
         discount = true; 
      }
      
		//prompt user and get pizza size choice
		System.out.println("Pizza Size (inches)   Cost");
		System.out.println("        10            $10.99");
		System.out.println("        12            $12.99");
		System.out.println("        14            $14.99");
		System.out.println("        16            $16.99");
		System.out.println("What size pizza would you like?"); 
		System.out.print("10, 12, 14, or 16 (enter the number only): ");
		inches = keyboard.nextInt();
		
		//set price and size of pizza ordered
		//ADD LINES HERE FOR TASK #2
		if(inches == 10) {
         cost = 10.99; 
      }
      else if (inches == 12) {
         cost = 12.99; 
      } 
      else if (inches == 14) {
         cost = 14.99; 
      } 
      else if (inches == 16) {
         cost = 16.99; 
      }
      else {
         System.out.println("An incorrect size was entered");
         System.out.println("You will receive a 12\" pizza");
         inches = 12; 
      }
		//consume the remaining newline character
		keyboard.nextLine();	
		
		//prompt user and get crust choice
		System.out.println("What type of crust do you want? ");
		System.out.print("(H) Hand-tossed, (T) Thin-crust, or " +
			"(D) Deep-dish (enter H, T, or D): ");
		input = keyboard.nextLine();
		crustType = input.charAt(0);
	
		//set user's crust choice on pizza ordered
		//ADD LINES FOR TASK #3
		crustType = input.toUpperCase().charAt(0); 
      switch (crustType) {
         case 'H' : crust = "Hand-tossed"; 
            break;
         case 'T' : crust = "Thin-crust"; 
            break; 
         case 'D' : crust = "Deep-dish"; 
            break; 
         default : System.out.println("Incorrect Input: a Hand-tossed crust will be prepared"); 
      
      }						
		//prompt user and get topping choices one at a time					
		System.out.println("All pizzas come with cheese."); 
		System.out.println("Additional toppings are $1.25 each,"
				+" choose from");
		System.out.println("Pepperoni, Sausage, Onion, Mushroom");
	
		//if topping is desired, 
		//add to topping list and number of toppings
		System.out.print("Do you want Pepperoni?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Pepperoni ";
		}
		System.out.print("Do you want Sausage?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Sausage ";
		}
		System.out.print("Do you want Onion?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Onion ";
		}
		System.out.print("Do you want Mushroom?  (Y/N):  ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
		{
			numberOfToppings += 1;
			toppings = toppings + "Mushroom ";
		}

		//add additional toppings cost to cost of pizza
		cost = cost + (1.25*numberOfToppings);
		
		//display order confirmation
		System.out.println();
		System.out.println("Your order is as follows: ");
		System.out.println(inches + " inch pizza");
		System.out.println(crust + " crust");
		System.out.println(toppings);		
		
		//apply discount if user is elibible
		//ADD LINES FOR TASK #4 HERE
		if (discount) {
         System.out.println("You are eligible for a $2 discount"); 
         cost -= 2; // or you could have cost = cost -2; 
      }
      
		//EDIT PROGRAM FOR TASK #5
		//SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES
		System.out.printf("The cost of your order is: $%.2f\n" ,cost);
			
		//calculate and display tax and total cost
		tax = cost * TAX_RATE;
		System.out.printf("The tax is:  $%.2f\n", tax);
		System.out.printf("The total due is:  $%.2f\n", (tax+cost));
		
		System.out.println("Your order will be ready for pickup in 30 minutes.");
	}	
}
/* OUTPUT
Welcome to Mike and Diane's Pizza
 Enter your first name:  Savaas
 Pizza Size (inches)   Cost
         10            $10.99
         12            $12.99
         14            $14.99
         16            $16.99
 What size pizza would you like?
 10, 12, 14, or 16 (enter the number only): 10
 What type of crust do you want? 
 (H)Hand-tossed, (T) Thin-crust, or (D) Deep-dish (enter H, T, or D): H
 All pizzas come with cheese.
 Additional toppings are $1.25 each, choose from
 Pepperoni, Sausage, Onion, Mushroom
 Do you want Pepperoni?  (Y/N):  Y
 Do you want Sausage?  (Y/N):  N
 Do you want Onion?  (Y/N):  Y
 Do you want Mushroom?  (Y/N):  N
 
 Your order is as follows: 
 10 inch pizza
 Hand-tossed crust
 Cheese Pepperoni Onion 
 The cost of your order is: $13.49
 The tax is:  $1.08
 The total due is:  $14.57
 Your order will be ready for pickup in 30 minutes.
*/