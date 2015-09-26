package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive the robot backward at a specified speed for a specified length of time.
 */
public class DirectionalDrive extends Command {

	public enum MovementType {

		DRIVE_FORWARD(new int[] { 0, 1, 0 }),
		DRIVE_BACKWARD(new int[] { 0, -1,0 }),
		STRAFE_LEFT(new int[] { 1, 0, 0 }),
		STRAFE_RIGHT(new int[] { -1, 0, 0 }),
		TURN_LEFT(new int[] { 0, 0, 1 }),
		TURN_RIGHT(new int[] { 0, 0, -1 });

		public final int[] directions;

		MovementType(int[] dirs) {
			this.directions = dirs;
		}
	}

	private double speed;
	private MovementType movement;

	/**
	 * Initialized the command.
	 * 
	 * @param speed
	 *            The speed to drive at
	 * @param time
	 *            How long to drive at that speed
	 */
	public DirectionalDrive(double speed, double time, MovementType movement) {
		requires(Robot.driveTrain);
		setInterruptible(true);
		setTimeout(time);
		this.speed = speed;
		this.movement = movement;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.driveAuto(movement.directions[0]*speed, movement.directions[1]*speed, movement.directions[2]*speed);
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
