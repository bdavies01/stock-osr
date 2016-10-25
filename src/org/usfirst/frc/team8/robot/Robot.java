
package org.usfirst.frc.team8.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team8.autonomous.sequences.BD;
import org.usfirst.frc.team8.autonomous.sequences.Lowbar;
import org.usfirst.frc.team8.commands.PeriodicUpdater;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static HAL hal;
	public static Constants constants;

    Command autonomousCommand;
    Command periodicUpdater;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		hal = new HAL();
		constants = new Constants();
		periodicUpdater = new PeriodicUpdater();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	HAL.drivetrain.disableBrake();
    }
	
	public void disabledPeriodic() {
		if(!periodicUpdater.isRunning()) {
        	periodicUpdater.start();
        }
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        String autoPath = HAL.robotTable.getString("autopath", "none");
        switch(autoPath) {
        case "none":
        	autonomousCommand = null;
        case "b/d": 
        	autonomousCommand = new BD();
        case "low bar":
        	autonomousCommand = new Lowbar();
        default:
        	autonomousCommand = null;
        }
        
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
        
        if(!periodicUpdater.isRunning()) {
        	periodicUpdater.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if(!periodicUpdater.isRunning()) {
        	periodicUpdater.start();
        }
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
