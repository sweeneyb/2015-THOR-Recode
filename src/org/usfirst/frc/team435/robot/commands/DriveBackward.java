package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive the robot backward at a specified speed for a specified length of time.
 */
public class DriveBackward extends Command {

private double speed;
	
	/**
	 * Initialized the command.
	 * @param speed The speed to drive at
	 * @param time How long to drive at that speed
	 */
    public DriveBackward(double speed, double time) {
        requires(Robot.driveTrain);
        setInterruptible(true);
        setTimeout(time);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveAuto(0, -speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
