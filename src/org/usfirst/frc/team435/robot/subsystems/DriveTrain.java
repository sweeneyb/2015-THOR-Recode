package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive = RobotMap.drive;

    public void initDefaultCommand() {}
    
    /**
     * Caused the robot to drive, just a wrapper for the mecanumDrive function
     * @param x The x value
     * @param y The y value
     * @param rot The rotation value
     */
    public void drive(double x, double y, double rot){
    	drive.mecanumDrive_Cartesian(x, y, rot, 0);
    }
    
    /**
     * Drives the robot, for use during autonomous. The Y value will be inverted to compensate
     * for the inversion caused by the robot drive.
     * @param x The x value
     * @param y The y value
     * @param rot The rotation value
     */
    public void driveAuto(double x, double y, double rot){
    	drive(x, -y, rot);
    }
}

