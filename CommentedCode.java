package org.usfirst.frc.team6135.robot;

public class CommentedCode {
       // In Robo Ini
	//encoder = new Encoder(1, 2, true, Encoder.EncodingType.k4X);
    //encoder.setDistancePerPulse(8 * Math.PI);
    //leftArmRotate = new CANTalon(1);
    //armExtend = new Talon(7);
    //rightArmRotate = new CANTalon(2);
	
	//lockWinch = new Servo(6);
	
	//rightArmRotate.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    //leftArmRotate.changeControlMode(CANTalon.TalonControlMode.Follower);
    //leftArmRotate.set(rightArmRotate.getDeviceID());
	//liftRobot = new Victor(4);
	
	// In Auto ini
//	autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
	
	//tele
	/*if (driveStick.getRawButton(7)) {// && debounceLoopCount < 1) {
	
	reverse = 1;
	//debounceLoopCount = 15;
	System.out.println("Direction 1");
}
else if(driveStick.getRawButton(8)) {
	reverse = -1;
	System.out.println("Direction 2");
}*/
	//test.arcadeDrive(driveStick.getRawAxis(0), driveStick.getRawAxis(1), true);
	/*leftDriveSet = sensitivity * Math.pow((driveStick.getRawAxis(1) - driveStick.getRawAxis(0)),3) 
	   + (1 - sensitivity) * ((driveStick.getRawAxis(1) - driveStick.getRawAxis(0)));
rightDriveSet = sensitivity * Math.pow((driveStick.getRawAxis(1) + driveStick.getRawAxis(0)),3) 
+ (1 - sensitivity) * ((driveStick.getRawAxis(1) + driveStick.getRawAxis(0)));*/

/*if (debounceLoopCount > 0) {
debounceLoopCount--;
}*/
//System.out.println("Debounce Loop: " + debounceLoopCount);
	/*if(driveStick.getRawButton(1) && rightArmRotate.getOutputCurrent() < 58) {
	rightArmRotate.set(1.0);
}
else if(driveStick.getRawButton(2)) {
	rightArmRotate.set(-1.0);
}
else {
	rightArmRotate.set(0.0);;
}
if(driveStick.getRawButton(3)) {
	lockWinch.set(unlock);
	//liftRobot.set(liftRobotSpeed);
}
else {
	//liftRobot.set(0.0);
	lockWinch.set(lock);
}*/
/*
if(driveStick.getRawButton(3)) {
	leftArmRotate.set(1.0);
}
else if(driveStick.getRawButton(4)) {
	leftArmRotate.set(-1.0);
}
else {
	leftArmRotate.set(0.0);
}*/
/*if(driveStick.getRawButton(5)) {
	armExtend.set(1.0);
}
else if(driveStick.getRawButton(6)) {
	armExtend.set(-1.0);
}
else {
	armExtend.set(0.0);
}*/
}
