package org.usfirst.frc.team8.commands;

import static org.usfirst.frc.team8.robot.HAL.ds;
import static org.usfirst.frc.team8.robot.HAL.robotTable;

import edu.wpi.first.wpilibj.command.Command;

/**
*@author bertd
*/
public class PeriodicUpdater extends Command {

	public PeriodicUpdater() {
		
	}
	
	@Override
	protected void initialize() {
		robotTable.putNumber("match-time", 90);
		robotTable.putString("game-period", "DISABLED");
		robotTable.putBoolean("brownout-status", false);
		robotTable.putNumber("battery", 12.0);
		robotTable.putString("alliance", "invalid");
		robotTable.putString("accumulatorstate", "Disabled");
		robotTable.putString("drivetrainstate", "Disabled");
		robotTable.putString("shooterstate", "Disabled");
		robotTable.putString("breacherstate", "Disabled");
		robotTable.putString("grabberstate", "Disabled");
	}

	@Override
	protected void execute() {
		if (ds.isAutonomous()) {
			robotTable.putString("game-period", "Autonomous");
		} else if (ds.isDisabled()) {
			robotTable.putString("game-period", "Disabled");
		} else if (ds.isOperatorControl()) {
			robotTable.putString("game-period", "TeleOperated");
		} else if (ds.isTest()) {
			robotTable.putString("game-period", "Test");
		} else {
			robotTable.putString("game-period", "Unidentified");
		}
		
		switch (ds.getAlliance()) {
		case Blue:
			robotTable.putString("alliance", "blue");
			break;
		case Red:
			robotTable.putString("alliance", "red");
			break;
		case Invalid:
			robotTable.putString("alliance", "invalid");
		}
		
		robotTable.putNumber("match-time", ds.getMatchTime());
		robotTable.putBoolean("brownout-status", ds.isBrownedOut());
		robotTable.putNumber("battery", ds.getBatteryVoltage());
		
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
