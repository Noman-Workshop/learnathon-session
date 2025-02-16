package org.noman5237.behaviours.quack;

import org.noman5237.QuackBehaviour;

public enum QuackBehaviours {
	
	QUACK(() -> System.out.println("Quack")),
	SQUEAK(() -> System.out.println("Squeak")),
	MUTE(() -> System.out.println("Silent"));
	
	public final QuackBehaviour behaviour;
	
	QuackBehaviours(QuackBehaviour behaviour) {
		this.behaviour = behaviour;
	}
}
