package org.noman5237;

import java.util.List;

public class Main {
	
	public class Duck {
		public void quack() {
			System.out.println("Quack");
		}
	}
	
	// Different types of ducks
	public class MallardDuck extends Duck {
		public void quack() {
			System.out.println("Quack");
		}
	}
	
	public class RedheadDuck extends Duck {
		public void quack() {
			System.out.println("Quack");
		}
	}
	
	public class RubberDuck extends Duck {
		public void quack() {
			System.out.println("Squeak");
		}
	}
	
	public class DecoyDuck extends Duck {
		public void quack() {
			System.out.println("Silent");
		}
	}
	
	public class ModelDuck extends Duck {
		public void quack() {
			System.out.println("Quack");
		}
	}
	
	public class Goose {
		public void honk() {
			System.out.println("Honk");
		}
	}
	
	public class GreylagGoose extends Goose {
		public void honk() {
			System.out.println("Honk");
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		Duck mallardDuck = main.new MallardDuck();
		Duck redheadDuck = main.new RedheadDuck();
		Duck rubberDuck = main.new RubberDuck();
		Duck decoyDuck = main.new DecoyDuck();
		Duck modelDuck = main.new ModelDuck();
		
		List<Duck>  ducks = List.of(mallardDuck, redheadDuck, rubberDuck, decoyDuck, modelDuck, new GreylagGoose());
		for (Duck duck : ducks) {
			duck.quack();
		}
	}
}