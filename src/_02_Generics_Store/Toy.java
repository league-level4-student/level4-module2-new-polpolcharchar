package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Toy extends shoppingItem {
	public Toy() {
		price = 5;
		if(new Random().nextBoolean()) {
			this.item = "toy1.jpeg";
		}
		else {
			this.item = "toy2.jpeg";
		}
	}

	@Override
	public JLabel getItem() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
	
	@Override
	public String toString() {
		return "Toy";
	}
}
