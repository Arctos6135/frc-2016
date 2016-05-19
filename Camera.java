package org.usfirst.frc.team6135.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;

public class Camera {
    
	Servo cameraRotate;
	Servo cameraTilt;
	CameraServer server;
	double cameraDeadZone;
	int cameraLoopCount;
	double prevXAxisVal;
    double prevYAxisVal;
    double xCamera;
    double yCamera;
	public Camera()
    {
		cameraRotate = new Servo(2);
        cameraTilt = new Servo(3);
        
        cameraLoopCount = 0;
        prevXAxisVal = 0.0;
        prevYAxisVal = 0.0;
        xCamera = 0.5;
        yCamera = 0.5;
        
        cameraDeadZone = 0.5;
        
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
    }
	public void setCameraPos()
    {
    	if ((prevXAxisVal = Robot.driveStick.getRawAxis(4)) < -cameraDeadZone) {
    		if (xCamera >= 1.0){
    			xCamera = 1.0;
    		}
    		xCamera += 0.01;
    	}
    	else if ((prevXAxisVal = Robot.driveStick.getRawAxis(4)) > cameraDeadZone) {
    		if (xCamera <= 0.0){
    			xCamera = 0.0;
    		}
    		xCamera -= 0.01;
    	}	
        else {
        	cameraLoopCount = 0;
        }
        if ((prevYAxisVal = Robot.driveStick.getRawAxis(5)) > cameraDeadZone && cameraLoopCount < 15) {
        	yCamera = Math.min(yCamera + 0.01, 1.0); 
        	cameraLoopCount++;
        }
        else if (prevYAxisVal < -cameraDeadZone && cameraLoopCount < 15) {
        	yCamera = Math.max(yCamera - 0.01, 0.0);
        	cameraLoopCount++;
        }
        else {
        	cameraLoopCount = 0;
        }
    }
	public void relocateCamera()
	{
		xCamera = 0.33;
    	yCamera = 0.61;
	}
}
