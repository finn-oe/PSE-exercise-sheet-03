package de.unistuttgart.iste.sqa.pse.sheet03.homework;

/**
 * Describe the class TwoHamstersHamsterGame here.
 *
 * @author Finn Österreicher 3777877 st193897@stud.uni-stuttgart.de
 * @author Tim Zimmermann 3787155 st192571@stud.uni-stuttgart.de
 *
 */
public class TwoHamstersHamsterGame extends InternalTwoHamstersHamsterGame {

	@Override
	void hamsterRun() {

		// TODO implement Exercise 2 (b) here
		// Paule pick all grains and move to the meeting point
		// Row 1
		controllerPaule.hamsterMoveAndPick();
		controllerPaule.hamsterRightHalfCircle();

		// Row 2
		controllerPaule.hamsterMoveAndPick();
		controllerPaule.hamsterLeftHalfCircle();

		// Row 3
		controllerPaule.hamsterMoveAndPick();
		controllerPaule.hamsterRightHalfCircle();

		// Row 4
		controllerPaule.hamsterMoveAndPick();
		controllerPaule.hamsterTurn(2);
		controllerPaule.hamsterMoveSteps(3);


		//Tiffany pick all grains and move to the meeting point
		// Set up tiffany towards the right direction
		controllerTiffany.hamsterTurn(1);
		// Row 1
		controllerTiffany.hamsterMoveAndPick();
		controllerTiffany.hamsterRightHalfCircle();

		// Row 2
		controllerTiffany.hamsterMoveAndPick();
		controllerTiffany.hamsterLeftHalfCircle();

		// Row 3
		controllerTiffany.hamsterMoveAndPick();
		controllerTiffany.hamsterRightHalfCircle();
		controllerTiffany.pickAllGrains();
		// Row 4
		controllerTiffany.hamsterMoveSteps(3);


		// Put all grains
		controllerTiffany.putAllGrains();
		controllerPaule.putAllGrains();

	}
}
