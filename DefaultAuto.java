package org.usfirst.frc.team6135.robot;

public class DefaultAuto {
	     public static void defaultAutoCode()
			{
	         
	    	 if(AutoVariable.autonomousLoop < AutoVariable.autonomousLimit+12) {
	        		AutoVariable.driveTrain.leftDrive.set(AutoVariable.autonomousSpeed);
	        		AutoVariable.driveTrain.rightDrive.set(AutoVariable.autonomousSpeed);
	        		AutoVariable.autonomousLoop++;
	        		System.out.println(AutoVariable.autonomousLoop);
	        	}
	    		else
	    		{
	    			if(AutoVariable.autonomousLoop < (AutoVariable.autonomousLimit/4*9))
	    			{
	    				AutoVariable.driveTrain.leftDrive.set(AutoVariable.autonomousSpeed/2);
	    				AutoVariable.driveTrain.rightDrive.set(AutoVariable.autonomousSpeed/2);
	    				AutoVariable.autonomousLoop++;
	    				System.out.println(AutoVariable.autonomousLoop);
	    			}
	    			else
	    			{
	    				AutoVariable.driveTrain.leftDrive.set(0);
	        			AutoVariable.driveTrain.rightDrive.set(0);
	    			}
	    		}
			}
}
