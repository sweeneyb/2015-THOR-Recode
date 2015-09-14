package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Unclamps the clamp.
 * The command is short and uninterruptible to prevent clamp spamming and make sure the clamp is clamped.
 */
public class UnClamp extends Command {

    public UnClamp() {
        requires(Robot.clamp);
        setInterruptible(false);
        setTimeout(.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.clamp.clamp();
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
