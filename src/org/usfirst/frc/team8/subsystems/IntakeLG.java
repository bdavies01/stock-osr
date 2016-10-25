package org.usfirst.frc.team8.subsystems;

import org.usfirst.frc.team8.commands.SetState.StatefulSubsystem;
import static org.usfirst.frc.team8.robot.HAL.intakeLGMotor;

/**
 * @author bertd
 */
public class IntakeLG extends StatefulSubsystem<IntakeLG.State> {

	public IntakeLG() {
		intakeLGMotor.enableBrakeMode(false);
		intakeLGMotor.reverseOutput(false);
	}
	
	public enum State {
		INTAKE, 
		EXPEL, 
		STOPPED
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
		intakeLGMotor.set(0.5);
	}
	
	public void expel() {
		intakeLGMotor.set(-0.5);
	}

	public void stop() {
		intakeLGMotor.set(0.0);
	}
}
