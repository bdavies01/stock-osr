package org.usfirst.frc.team8.subsystems;

import org.usfirst.frc.team8.commands.TeleopIntake;
import org.usfirst.frc.team8.robot.OI;
import static org.usfirst.frc.team8.robot.HAL.intakeArmMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
*@author bertd
*/
public class Intake extends Subsystem {

	public Intake() {
		intakeArmMotor.enableBrakeMode(true);
		intakeArmMotor.reverseOutput(false);
	}
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TeleopIntake(OI.intakeAxis));
	}
	
	public void enableBrake() {
		intakeArmMotor.enableBrakeMode(true);
	}
}
