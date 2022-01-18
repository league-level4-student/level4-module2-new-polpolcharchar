package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Cereal extends shoppingItem{
	public Cereal() {
		price = 5;
		if(new Random().nextBoolean()) {
			this.item = "cereal1.jpeg";
		}
		else {
			this.item = "cereal2.jpeg";
		}
	}

	@Override
	public JLabel getItem() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
	
	@Override
	public String toString() {
		return "Cereal";
	}
}
