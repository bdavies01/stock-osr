package org.usfirst.frc.team8.robot;

import org.usfirst.frc.team8.subsystems.Drivetrain;
import org.usfirst.frc.team8.subsystems.Intake;
import org.usfirst.frc.team8.subsystems.IntakeLG;
import org.usfirst.frc.team8.subsystems.IntakeWheel;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
*@author bertd
*/
public class HAL {
	public static CANTalon leftFrontMotor = new CANTalon(RobotMap.leftFrontMotor);
	public static CANTalon leftBackMotor = new CANTalon(RobotMap.leftBackMotor);
	public static CANTalon rightFrontMotor = new CANTalon(RobotMap.rightFrontMotor);
	public static CANTalon rightBackMotor = new CANTalon(RobotMap.rightBackMotor);
	
	public static CANTalon intakeArmMotor = new CANTalon(RobotMap.intakeArmMotor);
	public static CANTalon intakeWheelMotor = new CANTalon(RobotMap.intakeWheelMotor);
	public static CANTalon intakeLGMotor = new CANTalon(RobotMap.intakeLGMotor);
	
	public static Encoder leftDriveEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
	public static Encoder rightDriveEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
	
	public static ADXRS450_Gyro spartanBoard = new ADXRS450_Gyro();
	
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final IntakeWheel intakeWheel = new IntakeWheel();
	public static final IntakeLG intakeLG = new IntakeLG();
	
	public static final DriverStation ds = DriverStation.getInstance();
	public static final NetworkTable robotTable = NetworkTable.getTable("RobotTable");
}