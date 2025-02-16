package org.noman5237;

import org.noman5237.behaviours.quack.QuackBehaviours;

import java.util.List;
import java.util.function.Consumer;

class Duck {
	
	private QuackBehaviour quackBehaviour;
	
	public void quack() {
		quackBehaviour.act();
	}
	
	public QuackBehaviour getQuackBehaviour() {
		return quackBehaviour;
	}
	
	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}
}

// Different types of ducks
class MallardDuck extends Duck {
	public MallardDuck() {
		this.setQuackBehaviour(QuackBehaviours.QUACK.behaviour);
	}
}

class RedheadDuck extends Duck {
	
	public RedheadDuck() {
		this.setQuackBehaviour(QuackBehaviours.QUACK.behaviour);
	}
}

class RubberDuck extends Duck {
	
	public RubberDuck() {
		this.setQuackBehaviour(QuackBehaviours.SQUEAK.behaviour);
	}
}

class DecoyDuck extends Duck {
	
	public DecoyDuck() {
		this.setQuackBehaviour(QuackBehaviours.MUTE.behaviour);
	}
}

class Goose {
	private HonkBehaviour honkBehaviour;
	
	public void honk() {
		honkBehaviour.act();
	}
	
	public HonkBehaviour getHonkBehaviour() {
		return honkBehaviour;
	}
	
	public void setHonkBehaviour(HonkBehaviour honkBehaviour) {
		this.honkBehaviour = honkBehaviour;
	}
}

class GreylagGoose extends Goose {
	
	public GreylagGoose() {
		this.setHonkBehaviour(() -> System.out.println("Honk"));
	}
	
}

class DuckGooseAdapter extends Duck {
	
	private Goose goose;
	
	public DuckGooseAdapter(Goose goose) {
		this.goose = goose;
	}
	
	public void quack() {
		goose.honk();
	}
	
	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		goose.setHonkBehaviour(quackBehaviour::act);
	}
}

public class Main {
	
	
	public static void main(String[] args) {
//		QuackBehaviour customQuack = () -> System.out.println("Custom quack");
		
		Duck mallardDuck = new MallardDuck();
		Duck redheadDuck = new RedheadDuck();
		Duck rubberDuck = new RubberDuck();
		Duck decoyDuck = new DecoyDuck();
		Goose greylagGoose = new GreylagGoose();
		
		DuckGooseAdapter imposterDuck = new DuckGooseAdapter(greylagGoose);
		List<Duck> ducks = List.of(mallardDuck,
		                           redheadDuck,
		                           rubberDuck,
		                           decoyDuck,
		                           imposterDuck);
//		List<Duck> ducks = List.of(mallardDuck,
//		                           redheadDuck,
//		                           rubberDuck,
//		                           decoyDuck);
		ducks.forEach(Duck::quack);
		
		HonkBehaviour doubleHonk = () -> System.out.println("Honk Honk");
		// TODO: how to set a honk behaviour for our DuckGooseAdapter
//		imposterDuck.setQuackBehaviour(doubleHonk);
		
		
		// TODO: make all the ducks mute
		ducks.forEach(duck -> duck.setQuackBehaviour(QuackBehaviours.MUTE.behaviour));
		
		System.out.println("After making all ducks mute");
		
		ducks.forEach(Duck::quack);
		
		// TODO: duck quack, display
		// on event trigger, do something
	}
}