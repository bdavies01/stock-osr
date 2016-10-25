package org.usfirst.frc.team8.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team8.robot.HAL.intake;

import java.util.function.DoubleSupplier;

/**
*@author bertd
*/
public class TeleopIntake extends Command {

	public TeleopIntake(DoubleSupplier yAxis) {
		super("Teleop Intake");
		requires(intake);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
		
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
