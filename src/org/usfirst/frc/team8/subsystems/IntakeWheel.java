package org.usfirst.frc.team8.subsystems;

import org.usfirst.frc.team8.commands.SetState.StatefulSubsystem;
import static org.usfirst.frc.team8.robot.HAL.intakeWheelMotor;

/**
 * @author bertd
 */
public class IntakeWheel extends StatefulSubsystem<IntakeWheel.State> {

	public IntakeWheel() {
		intakeWheelMotor.enableBrakeMode(false);
		intakeWheelMotor.reverseOutput(false);
	}

	public enum State {
		INTAKE, EXPEL, STOPPED
	}

	@Override
	public void setState(State state) {
		switch (state) {
		case INTAKE:
			intake();
			break;
		case EXPEL:
			expel();
			break;
		case STOPPED:
			stop();
			break;
		}
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void intake() {
		intakeWheelMotor.set(0.5);
	}

	public void expel() {
		intakeWheelMotor.set(-0.5);
	}

	public void stop() {
		intakeWheelMotor.set(0.0);
	}
}
