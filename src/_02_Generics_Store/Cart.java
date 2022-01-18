package _02_Generics_Store;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * The Cart class is a Bounded Type Generic class
 * 
 * <T extends Food> means we can only create a Cart with objects part of the 
 * Food class
 */

@SuppressWarnings("unchecked")
public class Cart<T extends shoppingItem> {
    private T[] cart;

    public Cart() {
        cart = (T[]) new shoppingItem[5];
    }

    // Adds an item to the cart
    public void add(T item) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = item;
                return;
            }
        }
        System.out.println("You can't have more than 5 items in your cart!");
    }
    
    // Removes an item from the cart
    public void remove(int index) {
    	T[] newCart = (T[]) new shoppingItem[5];
    	int currentPlacement = 0;
    	for(int i = 0; i < cart.length; i++) {
    		if(i != index) {
    			newCart[currentPlacement] = cart[i];
    			currentPlacement++;
    		}
    	}
    	cart = newCart;
    }
    
    // Prints the content of the cart
    public void print() {
    	String output = "";
    	for(T item : cart) {
    		if(item != null) {
    			output += (item.toString()) + "($" + item.price + ")\n";
    		}
    	}
    	if(output.length() > 2) {
    		output = output.substring(0, output.length() - 1);
    	}
    	System.out.println("Cost: " + totalCost());
    	System.out.println(output);
    }
    
    //returns the total cost of all items
    public int totalCost() {
    	int result = 0;
    	for(T item : cart) {
    		if(item != null) {
    			result += item.price;
    		}
    	}
    	return result;
    }

    // Displays everything currently in the cart
    public void showCart() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                panel.add(cart[i].getItem());
            }
        }
        frame.pack();

    }

    public int length() {
        return cart.length;
    }
}
