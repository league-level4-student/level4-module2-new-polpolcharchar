package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Candy extends shoppingItem{
	
	
	public Candy() {
		this.price = 1;
		if(new Random().nextBoolean()) {
			this.item = "candy1.jpeg";
		}
		else {
			this.item = "candy2.jpeg";
		}
	}

	@Override
	public JLabel getItem() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
	
	@Override
	public String toString() {
		return "Candy";
	}
}
