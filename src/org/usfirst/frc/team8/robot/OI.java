package org.usfirst.frc.team8.robot;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

import org.usfirst.frc.team8.commands.ForwardDrive;
import org.usfirst.frc.team8.commands.ReverseDrive;
import org.usfirst.frc.team8.commands.SetState;
import org.usfirst.frc.team8.lib.ExpelButton;
import org.usfirst.frc.team8.lib.IntakeButton;
import org.usfirst.frc.team8.subsystems.IntakeLG;
import org.usfirst.frc.team8.subsystems.IntakeWheel;
import static org.usfirst.frc.team8.robot.HAL.intakeWheel;
import static org.usfirst.frc.team8.robot.HAL.intakeLG;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public static DoubleUnaryOperator deadband = (x) -> {
		return Math.abs(x) > Constants.inputDeadband ? x : 0;
	};
	
	public static Joystick driveStick = new Joystick(0);
	public static Joystick turnStick = new Joystick(1);
	public static Joystick xbox = new Joystick(4);
	
	public static DoubleSupplier driveStickValue = () -> deadband.applyAsDouble(Constants.drivetrainOrientation * driveStick.getY());
	public static DoubleSupplier turnStickValue = () -> deadband.applyAsDouble(turnStick.getX());
	
	public static Button forwardDrive = new JoystickButton(driveStick, 5);
	public static Button reverseDrive = new JoystickButton(driveStick, 3);
	
	public static Button quickTurn = new JoystickButton(turnStick, 1);
	
	public static DoubleSupplier intakeAxis = () -> -deadband.applyAsDouble(xbox.getRawAxis(1)); //xbox left y axis
	
	public static Button xboxA = new JoystickButton(xbox, 1);
	public static Button xboxB = new JoystickButton(xbox, 2);
	public static Button xboxX = new JoystickButton(xbox, 3);
	public static Button xboxY = new JoystickButton(xbox, 4);
	public static Button xboxLB = new JoystickButton(xbox, 5);
	public static Button xboxRB = new JoystickButton(xbox, 6);
	public static IntakeButton xboxLT = new IntakeButton(xbox);
	public static ExpelButton xboxRT = new ExpelButton(xbox);
	
	public OI() {
		xboxLT.whileHeld(new SetState<IntakeWheel.State>(intakeWheel, IntakeWheel.State.INTAKE, IntakeWheel.State.STOPPED));
		xboxRT.whileHeld(new SetState<IntakeWheel.State>(intakeWheel, IntakeWheel.State.EXPEL, IntakeWheel.State.STOPPED));
		
		xboxA.whileHeld(new SetState<IntakeLG.State>(intakeLG, IntakeLG.State.INTAKE, IntakeLG.State.STOPPED));
		xboxY.whileHeld(new SetState<IntakeLG.State>(intakeLG, IntakeLG.State.EXPEL, IntakeLG.State.STOPPED));
		
		forwardDrive.whenPressed(new ForwardDrive());
		reverseDrive.whenPressed(new ReverseDrive());
	}
	
}

