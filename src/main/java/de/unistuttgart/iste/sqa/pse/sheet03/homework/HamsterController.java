package de.unistuttgart.iste.sqa.pse.sheet03.homework;

import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 *
 * A control unit to control a hamster.
 *
 * A HamsterController knows some behavioural patterns for hamsters and makes
 * the controlled hamsters act according to those patterns.
 *
 * @author (Your name)
 *
 */
public class HamsterController {

	private Hamster controlledHamster;

	/**
	 * Create a new controller for the controlling the given hamster.
	 *
	 * @param hamster The hamster that will be controlled, must not be null.
	 */
	public HamsterController(Hamster hamster) {
		this.controlledHamster = hamster;
	}

	/**
	 * Pick all grains on the controlled hamster's tile.
	 *
	 * Ensures that the tile is empty.
	 */
	void pickAllGrains() {
		controlledHamster.write("Executing pickAllGrains:");
		Integer counter = 0;
		while (controlledHamster.grainAvailable()) {
			controlledHamster.pickGrain();
			counter++;
		}
		controlledHamster.write(String.format("%d available grains on my Tile. I picked all of them!", counter));
	}

	/**
	 * Put all the controlled hamster's grain on the current tile.
	 *
	 * Ensures that the controlled hamster's mouth is empty.
	 */
	void putAllGrains() {
		controlledHamster.write("Executing putAllGrains:");
		Integer counter = 0;
		while (!controlledHamster.mouthEmpty()) {
			controlledHamster.putGrain();
			counter++;
		}
		controlledHamster.write(String.format("I had %d grains in my mouth. I put all of them on my Tile!", counter));
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Lets the hamster do a left half circle
	 */
	void hamsterHalfCircle() {
		controlledHamster.write("Executing helper0:");
		controlledHamster.turnLeft();
		controlledHamster.move();
		controlledHamster.turnLeft();
		controlledHamster.write("I ran a half circle!");
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Lets the hamster pick up all grains and move forward while clear
	 */
	void hamsterMoveAndPick() {
		controlledHamster.write("Executing helper1:");
		while (controlledHamster.frontIsClear()) {
			pickAllGrains();
			controlledHamster.move();
		}
		controlledHamster.write("I picked all grains, on the tile behind me!");
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Turns the hamster left turns times
	 * @param turns Integer count of turns the hamster should make
	 */
	void hamsterTurn(Integer turns) {
		controlledHamster.write("Executing helper2:");
		for (Integer i = 0; i < turns; i++) {
			controlledHamster.turnLeft();
		}
		controlledHamster.write(String.format("I turned %d times!", turns));
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Moves the hamster either steps times or until the wall is reached
	 * @param steps Integer count of steps the hamster should make
	 */
	void hamsterMoveSteps(Integer steps) {
		controlledHamster.write("Executing helper3:");
		Integer counter = 0;
		for (; counter < steps && controlledHamster.frontIsClear(); counter++) {
			controlledHamster.move();
		}
		controlledHamster.write(String.format("I moved %d out of %d steps!", counter, steps));
	}
}
