package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Raises the lift at the specified speed for the specified amount of time
 */
public class LiftUp extends Command {

	private double speed;
	
    public LiftUp(double speed, double time) {
        requires(Robot.leftLift);
        requires(Robot.rightLift);
        setTimeout(time);
        setInterruptible(true);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.leftLift.up(speed);
    	Robot.rightLift.up(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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

