package de.unistuttgart.iste.sqa.pse.sheet03.homework;

import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 *
 * A control unit to control a hamster.
 *
 * A HamsterController knows some behavioural patterns for hamsters and makes
 * the controlled hamsters act according to those patterns.
 *
 * @author Finn Österreicher 3777877 st193897@stud.uni-stuttgart.de
 * @author Tim Zimmermann 3787155 st192571@stud.uni-stuttgart.de
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
	 * Lets the hamster do a left half circle.
	 * Can be used for setting the hamster up to go on one row bellow when he has reached a left wall.
	 * Pre: There is a field to the hamsters left
	 * Post: Hamster is one field to the left where he started and turned in the opposite direction
	 */
	void hamsterLeftHalfCircle() {
		controlledHamster.write("Executing hamsterLeftHalfCircle:");
		controlledHamster.turnLeft();
		controlledHamster.move();
		controlledHamster.turnLeft();
		controlledHamster.write("I ran a half circle!");
	}

	/**
	 * turns the hamster right by turning him left three times
	 */
	void hamsterTurnRight(){
		for(int i=0; i<3; i++) {
			controlledHamster.turnLeft();
		}
	}

	/**
	 * Lets the hamster do a right half circle.
	 * Can be used for setting the hamster up to go on one row bellow when he has reached a right wall.
	 * Pre: There is a field to the hamsters right
	 * Post: Hamster is one field to the right where he started and turned in the opposite direction
	 */
	void hamsterRightHalfCircle() {
		controlledHamster.write("Executing hamsterRightHalfCircle:");
		hamsterTurnRight();
		controlledHamster.move();
		hamsterTurnRight();
		controlledHamster.write("I ran a half circle!");
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Lets the hamster pick up all grains and move forward while clear
	 * Pre: There are none besides that the hamster has to exist
	 * Post: Hamster is infront of a wall and he picked up all grains that he has passed
	 */
	void hamsterMoveAndPick() {
		controlledHamster.write("Executing hamsterMoveAndPick:");
		pickAllGrains();	// Modified for better use
		while (controlledHamster.frontIsClear()) {
			controlledHamster.move();
			pickAllGrains();	// Modified for better use
		}
		controlledHamster.write("I picked all grains, on the tile behind me!");
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.

	/**
	 * Turns the hamster left turns times
	 * @param turns Integer count of turns the hamster should make
	 * Pre: There are none besides that the hamster has to exist
	 *Post: Hamster turned turns times and looks towards the corresponding direction. If turns mod 4 = 0 -> same direction
	 */
	void hamsterTurn(Integer turns) {
		controlledHamster.write("Executing hamsterTurn:");
		for (Integer i = 0; i < turns; i++) {
			controlledHamster.turnLeft();
		}
		controlledHamster.write(String.format("I turned %d times!", turns));
	}

	// TODO replace this comment with JavaDoc, including Pre and Post Conditions.


	/**
	 * Moves the hamster either steps times or until the wall is reached
	 * @param steps Integer count of steps the hamster should make
	 * Pre: There are none besides that the hamster has to exist
	 * Post: Hamster either moved steps times or is infront of a wall
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
