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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class drivetrain extends Subsystem {
  TalonSRX Leftup = new TalonSRX(0);
  TalonSRX Leftback = new TalonSRX(0);
  TalonSRX Rightup = new TalonSRX(0);
  TalonSRX Rightdown = new TalonSRX(0);
    
    
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void setSpeed(double Rspeed, double Lspeed){
    Rightdown.set(ControlMode.PercentOutput, Rspeed);
    Rightup.set(ControlMode.PercentOutput, Rspeed);
    Leftback.set(ControlMode.PercentOutput, Lspeed);
    Leftup.set(ControlMode.PercentOutput, Lspeed);
    

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}