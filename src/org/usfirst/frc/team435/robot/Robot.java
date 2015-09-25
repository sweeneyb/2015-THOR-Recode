package org.usfirst.frc.team435.robot;

import static org.usfirst.frc.team435.robot.RobotMap.*;

import org.usfirst.frc.team435.robot.subsystems.Clamp;
import org.usfirst.frc.team435.robot.subsystems.DriveTrain;
import org.usfirst.frc.team435.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final Lift leftLift = new Lift(true, 0, 0, 0); // Must be calibrated
	public static final Lift rightLift = new Lift(false, 0, 0, 0); // Must be calibrated
	public static final Clamp clamp = new Clamp();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	
	// Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		// autonomousCommand = new ExampleCommand();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null)
		// autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null)
		// autonomousCommand.cancel();
	}
	
	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		if (oi.btnHalfSpeed.get())
			drive.mecanumDrive_Cartesian(calc(oi.driveStick.getX()),
					calc(oi.driveStick.getY()), 
					calc(oi.driveStick.getTwist()), 0);
		else
			drive.mecanumDrive_Cartesian(calc(oi.driveStick.getX() / 2),
					calc(oi.driveStick.getY() / 2),
					calc(oi.driveStick.getTwist() / 2), 0);
		
		if(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS) > DEADBAND){
			leftLift.up(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS));
			rightLift.up(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS));
		}else if(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS) > DEADBAND){
			leftLift.down(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS));
			rightLift.down(oi.driveStick.getRawAxis(OI.LIFT_UP_AXIS));
		}else{
			leftLift.stop();
			rightLift.stop();
		}
		
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static double calc(double value) {
		if (Math.abs(value) < DEADBAND) {
			return 0;
		} else {
			return (value - (Math.abs(value) / value * DEADBAND))
					/ (1 - DEADBAND);
		}
	}
}
