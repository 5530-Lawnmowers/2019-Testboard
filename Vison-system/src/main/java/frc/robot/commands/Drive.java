/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.sensors.*;
import frc.robot.*;
public class Drive extends Command {


  PigeonIMU gryoscope = new PigeonIMU(04);
  public double Rspeed = .25;
  public double Lspeed = -.25;
  double foward = 0;
  double heading = 0;

  public Drive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    super("Drive");
    requires(Robot.m_subsystem);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(100);
    foward = gryoscope.getCompassHeading();
    SmartDashboard.putBoolean("test", true);
    SmartDashboard.updateValues();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    heading = gryoscope.getCompassHeading();
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("gyroscope value foward", foward);
    SmartDashboard.putNumber("Gyroscope value", heading);
    SmartDashboard.updateValues();
     
    if(heading >= foward){
      Rspeed = .1;
    }
    else if(heading <= foward){
      Lspeed = .1;
    }
    else{
      Lspeed = 0;
      Rspeed = 0;
      //TODO write turn code here
      
    }
    gryoscope.getCompassHeading();
    Robot.m_subsystem.setSpeed(Rspeed, Lspeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
