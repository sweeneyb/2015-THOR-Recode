package org.usfirst.frc.team435.robot;

import org.usfirst.frc.team435.robot.commands.ToggleClamp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// -- PORT NUMBERS -- //
	
	public static final int DRIVE_STICK_PORT = 0;
	public static final int HALF_SPEED_BUTTON = 0;
	
	public static final int SMO_STICK_PORT = 1;
	public static final int CLAMP_BUTTON = 0;
	public static final int LIFT_UP_AXIS = 1;
	public static final int LIFT_DOWN_AXIS = 2;
	
	// -- OI VARIABLES -- //
	
	Joystick driveStick = new Joystick(DRIVE_STICK_PORT);
	Button btnHalfSpeed = new JoystickButton(driveStick, HALF_SPEED_BUTTON);
	
	Joystick smoStick = new Joystick(SMO_STICK_PORT);
	Button btnToggleClamp = new JoystickButton(smoStick, CLAMP_BUTTON);
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public OI(){
		btnToggleClamp.whenPressed(new ToggleClamp());
	}
}

