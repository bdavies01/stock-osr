package org.usfirst.frc.team8.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team8.robot.HAL.drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import org.usfirst.frc.team8.lib.CheezyDriveHelper;

/**
*@author bertd
*/
public class TeleopDrive extends Command {
	
	private final CheezyDriveHelper cdh;
	private final DoubleSupplier driveStick;
	private final DoubleSupplier turnStick;
	private final BooleanSupplier isQuickTurn;
	
	public TeleopDrive(DoubleSupplier driveStick, DoubleSupplier turnStick, BooleanSupplier isQuickTurn) {
		super("Teleop Drive");
		requires(drivetrain);
		this.cdh = new CheezyDriveHelper();
		this.driveStick = driveStick;
		this.turnStick = turnStick;
		this.isQuickTurn = isQuickTurn;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		cdh.cheezyDrive(driveStick.getAsDouble(), turnStick.getAsDouble(), isQuickTurn.getAsBoolean());
	}

	@Override
	protected boolean isFinished() {
		return false;
		
	}

	@Override
	protected void end() {
		drivetrain.tank(0, 0);
	}

	@Override
	protected void interrupted() {
		drivetrain.tank(0, 0);
	}

}
