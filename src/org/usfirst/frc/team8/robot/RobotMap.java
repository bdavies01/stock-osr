package org.usfirst.frc.team8.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int leftFrontMotor = 2;
	public static int leftBackMotor = 3;
	public static int rightFrontMotor = 4;
	public static int rightBackMotor = 1;
	
	public static int intakeArmMotor = 0;
	public static int intakeWheelMotor = 1;
	public static int intakeLGMotor = 3;
	
	public static int leftEncoderA = 2;
	public static int leftEncoderB = 3;
	
	public static int rightEncoderA = 0;
	public static int rightEncoderB = 1;
}