/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.IterativeRobot;


import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import java.util.Arrays;

public class Robot extends IterativeRobot {

  WPI_TalonSRX talon;
  PigeonIMU pigeon;

  @Override
  public void robotInit() {
    
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    talon = new WPI_TalonSRX(3);
    pigeon = new PigeonIMU(talon);
    pigeon.setYaw(0);

  }



  @Override
  public void teleopPeriodic() {
    double[] output = new double[3];
    pigeon.getYawPitchRoll(output);
    System.out.println(Arrays.toString(output));


  }

  @Override
  public void testPeriodic() {
  }
}
