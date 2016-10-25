package org.usfirst.frc.team8.autonomous.sequences;

import org.usfirst.frc.team8.autonomous.Drive;
import org.usfirst.frc.team8.autonomous.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
*@author bertd
*/
public class Lowbar extends CommandGroup {
	public Lowbar() {
		addSequential(new Wait(1000)); 
		addSequential(new Drive(true, 5, 0.5)); //just guessing lol
	}
}
