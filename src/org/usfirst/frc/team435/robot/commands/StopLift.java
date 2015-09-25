package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is for stopping the lift. Used as the default command for the lift.
 */
public class StopLift extends Command {

    public StopLift() {
        requires(Robot.leftLift);
        requires(Robot.rightLift);
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.rightLift.stop();
    	Robot.leftLift.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
