package org.usfirst.frc.team435.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// --------------------- SET THE VALUES AS WELL --------------------- //
	
	
	// -- PORT NUMBERS -- //
	
	public static final int FRONT_RIGHT_MOTOR = 0;
	public static final int REAR_RIGHT_MOTOR = 1;
	public static final int FRONT_LEFT_MOTOR = 2;
	public static final int REAR_LEFT_MOTOR = 3;
	
	public static final int LIFT_LEFT_MOTOR = 4;
	public static final int LIFT_RIGHT_MOTOR = 5;
	
	public static final int LEFT_LIFT_ENCODER_A = 0;
	public static final int LEFT_LIFT_ENCODER_B = 1;
	public static final int RIGHT_LIFT_ENCODER_A = 2;
	public static final int RIGHT_LIFT_ENCODER_B = 3;
	
	public static final int CLAMP_SOLENOID_FORWARD = 0;
	public static final int CLAMP_SOLENOID_REVERSE = 1;
	
	public static final int MAX_LIFT_SPEED = 50;
	
	// -- DEADBAND  VALUE -- //
	
	public static final double DEADBAND = .1;
	
	// -- VARIABLES FOR ROBOT PARTS -- //
	
	
	public static SpeedController frontLeftMotor = new CANTalon(FRONT_LEFT_MOTOR);
	public static SpeedController rearLeftMotor = new CANTalon(REAR_LEFT_MOTOR);
	public static SpeedController frontRightMotor = new CANTalon(FRONT_RIGHT_MOTOR);
	public static SpeedController rearRightMotor = new CANTalon(REAR_RIGHT_MOTOR);
	
	public static SpeedController liftLeftMotor = new CANTalon(LIFT_LEFT_MOTOR);
	public static SpeedController liftRightMotor = new CANTalon(LIFT_RIGHT_MOTOR);
	
	public static RobotDrive drive = new RobotDrive(frontLeftMotor,
			rearLeftMotor, frontRightMotor, rearRightMotor);
	
	public static Encoder leftLiftEnc = new Encoder(LEFT_LIFT_ENCODER_A, LEFT_LIFT_ENCODER_B);
	public static Encoder rightLiftEnc = new Encoder(RIGHT_LIFT_ENCODER_A, RIGHT_LIFT_ENCODER_B);
	
	public static DoubleSolenoid clamp = new DoubleSolenoid(CLAMP_SOLENOID_FORWARD, CLAMP_SOLENOID_REVERSE);
}
