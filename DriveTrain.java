package org.usfirst.frc.team6135.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {
		public static Victor leftDrive;                     
		public static Victor rightDrive;
		public static double xSensitivity;
	    public static double ySensitivity;
	    public static double xInput;
		public static double yInput;
		public static int sensitivityXLoop;
		public static int sensitivityYLoop;
		public static double sensitivity;
		public static double deadZone;
	    public static double leftDriveValue;
	    public static double rightDriveValue;
	    public static int turnLoop;
		public static int turnLoopCount;
		public int turnDebounce;
		public DriveTrain()
		{
			leftDrive = new Victor(0);
	        rightDrive = new Victor(1);
	        
	        deadZone = 0.12;
	        
	        sensitivityXLoop = 0;
	        sensitivityYLoop = 0;
	        sensitivity = 0.5;
	        
	        turnLoop = 0;
	        turnLoopCount = 16;
	        turnDebounce = 0;
		}
		public void setDriveValues()
		{
			xSensitivity = sensitivity * Math.pow(xInput = Robot.driveStick.getRawAxis(0), 5)
	    			+ (1 - sensitivity) * xInput;
	    	ySensitivity = sensitivity * Math.pow(yInput = Robot.driveStick.getRawAxis(1), 5)
	    			+ (1 - sensitivity) * yInput;
	    	if(xSensitivity > 0.7 && sensitivityXLoop < 15 && !Robot.driveStick.getRawButton(6)) {// && !driveStick.getRawButton(6)) {
	    		xSensitivity = 0.7 + (xSensitivity - 0.7) * (sensitivityXLoop / 15.0);
	    		sensitivityXLoop++;
	    	}
	    	if(xSensitivity < -0.7 && sensitivityXLoop < 15 && !Robot.driveStick.getRawButton(6)) {
	    		xSensitivity = -0.7 + (xSensitivity + 0.7) * (sensitivityXLoop / 15.0);
	    		sensitivityXLoop++;
	    	}
	    	if(Math.abs(xSensitivity) <= 0.7 || Robot.driveStick.getRawButton(6)) {
	    		sensitivityXLoop = 0;
	    	}
	    	if(ySensitivity > 0.7 && sensitivityYLoop < 15 && !Robot.driveStick.getRawButton(6)) {
	    		ySensitivity = 0.7 + (ySensitivity - 0.7) * (sensitivityYLoop / 15.0);
	    		sensitivityYLoop++;
	    	}
	    	if(ySensitivity < -0.7 && sensitivityYLoop < 15 && !Robot.driveStick.getRawButton(6)) {
	    		ySensitivity = -0.7 + (ySensitivity + 0.7) * (sensitivityYLoop / 15.0);
	    		sensitivityYLoop++;
	    	}
	    	if(Math.abs(ySensitivity) <= 0.7 || Robot.driveStick.getRawButton(6)) {
	    		sensitivityYLoop = 0;
	    	}
	    	
	    	leftDriveValue = -1 * ySensitivity + xSensitivity;
	    	rightDriveValue = -1 * ySensitivity - xSensitivity;
		}
		public void updateMotor()
		{
			if (Math.abs(leftDriveValue) > deadZone && Math.abs(rightDriveValue) > deadZone || turnLoop != 0) {
	    		if(turnLoop > 0) {
	    			leftDrive.set(-1);
	        		rightDrive.set(1);
	        		turnLoop--;
	    		}
	    		else if(turnLoop < 0) {
	    			leftDrive.set(1);
	    			rightDrive.set(-1);
	    			turnLoop++;
	    		}
	    		else {
	    			leftDrive.set(leftDriveValue); //Comment out for testing inputs
	    			rightDrive.set(rightDriveValue); //Comment out for testing inputs
	    		}
	            //System.out.println("Driver values set");
	    	}
	    	else if(!(Robot.driveStick.getRawButton(1) || Robot.driveStick.getRawButton(4) || Robot.driveStick.getRawButton(2) || Robot.driveStick.getRawButton(3))){
	    		leftDrive.set(0);
	            rightDrive.set(0);
	            //System.out.println("Driver values not set");
	    	}
		}
		public void driveBack()
		{
			leftDrive.set(-0.8);
        	rightDrive.set(-0.8);
		}
		public void driveForward()
		{
			leftDrive.set(0.8);
        	rightDrive.set(0.8);
		}
		public void turn90toLeft()
		{
			leftDrive.set(-0.5);
        	rightDrive.set(0.5);
		}
		public void turn90toRight()
		{
			leftDrive.set(0.5);
        	rightDrive.set(-0.5);
		}
		public void turn180toLeft()
		{
			if(turnDebounce==0)
			{
				leftDrive.set(-1);
	        	rightDrive.set(1);
	        	turnLoop = turnLoopCount;
	        	turnDebounce = turnLoopCount + 1;
			}
		}
		public void turn180toRight()
		{
			if(turnDebounce==0)
			{
				leftDrive.set(1);
	        	rightDrive.set(-1);
	        	turnLoop = turnLoopCount;
	        	turnDebounce = turnLoopCount + 1;
			}
		}
		public void turnDebounceDecrease()
		{
			if(turnDebounce != 0) {
	        	turnDebounce--;
	        }
		}
}
