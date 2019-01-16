/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class drivetrain extends Subsystem {
  public boolean ran = false;
  TalonSRX Leftup = new TalonSRX(02);
  TalonSRX Leftback = new TalonSRX(04);
  TalonSRX Rightup = new TalonSRX(01);
  TalonSRX Rightdown = new TalonSRX(03);
    
    
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void setSpeed(double Rspeed, double Lspeed){
   
    Rightdown.set(ControlMode.PercentOutput, Rspeed);
    Rightup.set(ControlMode.PercentOutput, Rspeed);
    Leftback.set(ControlMode.PercentOutput, Lspeed);
    Leftup.set(ControlMode.PercentOutput, Lspeed);
    SmartDashboard.putBoolean("Moter poower set ran?", true);
    SmartDashboard.updateValues();

  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}