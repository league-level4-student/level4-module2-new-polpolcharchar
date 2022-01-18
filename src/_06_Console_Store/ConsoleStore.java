package _06_Console_Store;

import java.util.Scanner;

import _02_Generics_Store.Candy;
import _02_Generics_Store.Cart;
import _02_Generics_Store.Cereal;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Toy;
import _02_Generics_Store.shoppingItem;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */

    public static void main(String[] args) {

    	
    	Scanner s = new Scanner(System.in);
    	int response;
    	int balance = 30;
    	
    	Cart<shoppingItem> c = new Cart<shoppingItem>();
    	
    	
		System.out.println("You have $" + balance);
    	do {
	    	do {
	    		System.out.println("What do you want to do? (Buy(0), Remove(1), ViewItems(2), CheckOut(3)");
	    		response = s.nextInt();
	    	}while(response < 0 || response > 3);
	    	
	    	if(response == 0) {
	    		int item;
	    		do {
	    			System.out.println("Buy: candy $1 (0), cereal $5 (1), clothing $10 (2), toy $5 (3)");
	    			item = s.nextInt();
	    		}while(item < 0 || item > 3);
	    		
	    		c.add(item == 0 ? new Candy() : item == 1 ? new Cereal() : item == 2 ? new Clothing() : new Toy());
	    		
	    	}else if(response == 1) {
	    		if(c.length() != 0) {
		    		int item;
		    		c.print();
		    		do {
		    			System.out.println("Remove item #: ");
		    			item = s.nextInt();
		    		}while(item < 0 || item > c.length() - 1);
		    		
		    		c.remove(item);
		    		c.print();
	    		}else {
	    			System.out.println("Nothing to remove!");
	    		}
	    	}else if(response == 2) {
	    		c.print();
	    	}else {
	    		if(c.totalCost() <= balance) {
	    			System.out.println("Recipt: ");
	    			c.print();
	    			System.out.println("Total Cost: " + c.totalCost());
	    			balance -= c.totalCost();
	    			c = new Cart<shoppingItem>();
	    			System.out.println();
	        		System.out.println("You have $" + balance);
	    		}else {
	    			System.out.println("You don't have enough money!");
	        		System.out.println("You have $" + balance);
	    		}
	    	}
    	}while(balance > 0);
    	
    	
    }

}
