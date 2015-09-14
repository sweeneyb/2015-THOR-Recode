package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.RobotMap;
import org.usfirst.frc.team435.robot.SolenoidStateUndeterminedException;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem for controlling the clamp.
 */
public class Clamp extends Subsystem {
	
	DoubleSolenoid clamp = RobotMap.clamp;
	
	/**
	 * Closes the clamp
	 */
	public void clamp() {
		clamp.set(Value.kForward);
	}
	
	/**
	 * Opens the clamp
	 */
	public void unclamp() {
		clamp.set(Value.kReverse);
	}
	
	/**
	 * Toggles the state of the clamp. If the clamp is closed the clamp will be opened.
	 * It the clamp is open or the state cannot be determined the clamp will be closed.
	 */
	public void toggleClamp() {
		try {
			if (!isClamped())
				clamp();
			else
				unclamp();
		} catch (SolenoidStateUndeterminedException e) {
			clamp();
		}
	}
	
	/**
	 * Gets the current state of the clamp
	 * @return The state of the clamp, true if clamped, false if not
	 * @throws SolenoidStateUndeterminedException Thrown if the state of the clamp cannot be determined
	 */
	public boolean isClamped() throws SolenoidStateUndeterminedException{
		if (clamp.get() == Value.kForward)
			return true;
		else if(clamp.get() == Value.kReverse)
			return false;
		else throw new SolenoidStateUndeterminedException();
	}
	
	public void initDefaultCommand() {
	}
}