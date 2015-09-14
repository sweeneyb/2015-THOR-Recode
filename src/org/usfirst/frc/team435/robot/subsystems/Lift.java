package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.RobotMap;
import org.usfirst.frc.team435.robot.commands.StopLift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * This is a PIDSubsystem used for controlling the lifter. Due to the possible discrepancy between
 * PID  values on each side, and the lack of the allowance for multiple motor PID values with a
 * PIDSubsytem each side must be initialized independently.
 */
public class Lift extends PIDSubsystem {
	
	private CANTalon motor;
	private Encoder enc;
	private boolean stopped;
	
	/**
	 * Sets the default command for the lifter to stop and hold the lift in place.
	 * This will make sure that when no other command is run the lifter will maintain position
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new StopLift());
	}
	
	/**
	 * Initializes one of the sides of the lifter
	 * @param isLeft If the side to be initialized is the left side
	 * @param p The p value for the side
	 * @param i The i value for the side
	 * @param d The d value for the side
	 */
	public Lift(boolean isLeft, double p, double i, double d) {
		super("Lift " + (isLeft ? "Left" : "Right"), p, i, d);
		if (isLeft) {
			this.motor = (CANTalon) RobotMap.liftLeftMotor;
			this.enc = RobotMap.leftLiftEnc;
		} else {
			this.motor = (CANTalon) RobotMap.liftRightMotor;
			this.enc = RobotMap.rightLiftEnc;
		}
	}

	/**
	 * Tells the PIDSubsystem to stop moving
	 */
	public void stop(){
		setSetpoint(0);
		enc.reset();
		stopped = true;
	}
	
	/**
	 * Moves the lifter up at the specified speed.
	 * @param speed The speed to move the lifter at
	 */
	public void up(double speed){
		setSetpoint(speed);
		stopped = false;
	}
	
	/**
	 * Moves the lifter down at the specified speed.
	 * @param speed The speed the lifter will descend at
	 */
	public void down(double speed){
		setSetpoint(-speed);
		stopped = true;
	}
	
	@Override
	protected double returnPIDInput() {
		return (stopped ? enc.getDistance() : enc.getRate());
	}

	@Override
	protected void usePIDOutput(double output) {
		motor.pidWrite(output);
	}
}
