package org.usfirst.frc.team8.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import static org.usfirst.frc.team8.robot.HAL.*;

import org.usfirst.frc.team8.commands.TeleopDrive;
import org.usfirst.frc.team8.robot.OI;

/**
*@author bertd
*/
public class Drivetrain extends Subsystem {
	private final RobotDrive robotDrive;
	
	public Drivetrain() {
		super("Drivetrain");
		leftFrontMotor.reverseOutput(false);
		leftBackMotor.reverseOutput(false);
		rightFrontMotor.reverseOutput(true);
		rightBackMotor.reverseOutput(true);
		
		robotDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
		robotDrive.setSafetyEnabled(false);
		
		resetDriveSensors();
	}
	
	public void arcade(double driveSpeed, double turnSpeed) {
		leftFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		leftBackMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightBackMotor.changeControlMode(TalonControlMode.PercentVbus);
		robotDrive.arcadeDrive(driveSpeed, turnSpeed);
	}
	
	public void tank(double left, double right) {
		leftFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		leftBackMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightBackMotor.changeControlMode(TalonControlMode.PercentVbus);
		robotDrive.tankDrive(left, right);
	}
	
	public void resetDriveSensors() {
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
		spartanBoard.reset();
	}
	
	public void enableBrake() {
		leftFrontMotor.enableBrakeMode(true);
		leftBackMotor.enableBrakeMode(true);
		rightFrontMotor.enableBrakeMode(true);
		rightBackMotor.enableBrakeMode(true);
	}
	
	public void disableBrake() {
		leftFrontMotor.enableBrakeMode(false);
		leftBackMotor.enableBrakeMode(false);
		rightFrontMotor.enableBrakeMode(false);
		rightBackMotor.enableBrakeMode(false);
	}
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TeleopDrive(OI.driveStickValue, OI.turnStickValue, () -> OI.quickTurn.get()));
	}

}
