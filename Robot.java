

package org.usfirst.frc.team6135.robot;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;

import java.util.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static Joystick driveStick;
	
	public static DriveTrain driveTrain=null;
	//Victor liftRobot;
	//CANTalon rightArmRotate;
	//CANTalon leftArmRotate;
	//Talon armExtend;
	
	//Servo lockWinch;
	//RobotDrive test;
	Camera camera=null;
    int reverse;
    	
    //int session;
    // frame;
    
    //int debounceLoopCount;
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
	//Encoder encoder;
	
	//int pulsesPerRevolution;
	
	
	//double lock;
	//double unlock;
	//double liftRobotSpeed;
	//boolean released;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain=new DriveTrain();
    	camera=new Camera();
    	chooser = new SendableChooser();
        SmartDashboard.putData("Auto choices", chooser);
        driveStick = new Joystick(0);
        
        //debounceLoopCount = 0;
        
       // pulsesPerRevolution = 1;
        reverse = -1;
        //released = false;
        
        
        //the camera name (ex "cam0") can be found through the roborio web interface
        
        
        //lock = 1.0;
        //unlock = 0.0;
        //liftRobotSpeed = 1.0;
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        
        //cameraRotate.
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
    	AutoInit.autoInit();
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	DefaultAuto.defaultAutoCode();
            break;
    	}
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic(){
    	
    	
    	driveTrain.setDriveValues();
    	//Update motors
    	driveTrain.updateMotor();
    	//Camera
    	camera.setCameraPos();
    	
        if(driveStick.getRawButton(10)){
        	camera.relocateCamera();
        }
        if(driveStick.getRawButton(2)){
        	driveTrain.driveBack();
        }
        else if(driveStick.getRawButton(4)){
        	driveTrain.driveForward();
        }
        else if(driveStick.getRawButton(3)){
        	driveTrain.turn90toLeft();
        }
        else if(driveStick.getRawButton(1)){
        	driveTrain.turn90toRight();
        }
        if (driveStick.getRawButton(5) ) {
        	driveTrain.turn180toLeft();
        }
        else if(driveStick.getRawButton(6) ) {
        	driveTrain.turn180toRight();
        }
        
        driveTrain.turnDebounceDecrease();
    	//cameraRotate.set(xCamera);
    	//cameraTilt.set(yCamera);
    	/*System.out.println("Joystick X Input: " + xInput);
    	System.out.println("Joystick Y Input: " + yInput);
    	System.out.println("Left Drive Sensitivity: " + xSensitivity);
    	System.out.println("Right Drive Sensitivity: " + ySensitivity);
        System.out.println("Left Drive Value: " + leftDriveValue);
        System.out.println("Right Drive Value: " + rightDriveValue);*/
    	/*System.out.println("Camera X: " + xCamera);
    	System.out.println("Camera Y: " + yCamera);
    	System.out.println("Pwm X: " + cameraRotate.getRaw());
    	System.out.println("Pwm Y: " + cameraTilt.getRaw());*/
    	System.out.println("End of loop");
        System.out.println();
        System.out.println();
    
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    public static void delay(int ms) {
    	try {
    		Thread.sleep(ms);
    	}
    	catch (InterruptedException e) {
    		System.out.println(e);
    	}
    }
    
}