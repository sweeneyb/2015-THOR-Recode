package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;
import org.usfirst.frc.team435.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Lowers the lift at the specified speed for the specified amount of time
 */
public class LiftMover extends Command {

	private double speed;
	private LiftDirection direction;

	
	/*
	 * To construct, you'd do something like:
	 * new 
	 */
	public LiftMover(double speed, double time, LiftDirection direction) {
		requires(Robot.leftLift);
		requires(Robot.rightLift);
		setTimeout(time);
		setInterruptible(true);
		this.speed = speed;
		this.direction = direction;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		direction.moveLift(Robot.leftLift, speed);
		direction.moveLift(Robot.rightLift, speed);
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

	public abstract static class LiftDirection {
		public abstract void moveLift(Lift lift, double speed);
	}

	public static class MoveLiftDown extends LiftDirection {
		public void moveLift(Lift lift, double speed) {
			lift.down(speed);
		}
	}

	public static class MoveLiftUp extends LiftDirection {
		public void moveLift(Lift lift, double speed) {
			lift.up(speed);
		}
	}
}
