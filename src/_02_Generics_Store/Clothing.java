package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Clothing extends shoppingItem{
	public Clothing() {
		price = 10;
		if(new Random().nextBoolean()) {
			this.item = "clothing1.jpeg";
		}
		else {
			this.item = "clothing2.jpeg";
		}
	}

	@Override
	public JLabel getItem() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
	
	@Override
	public String toString() {
		return "Clothing";
	}
}
