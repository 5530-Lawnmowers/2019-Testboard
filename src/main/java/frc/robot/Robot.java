/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANDigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.networktables.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public  CANSparkMax motor  = new CANSparkMax(2, MotorType.kBrushless);
  private ShuffleboardTab speedTab = Shuffleboard.getTab("Speed");
  SimpleWidget motorSpeedWidget;
  public CANDigitalInput digitalInput;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    SmartDashboard.putData("Auto choices", m_chooser);
    motorSpeedWidget = speedTab.add("motorSpeed", 0);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */

  @Override
  public void teleopInit(){
    final NetworkTableEntry motorSpeed = motorSpeedWidget.getEntry();
    motor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    motor.set(motorSpeed.getDouble(1.0));
    digitalInput = new CANDigitalInput(motor, CANDigitalInput.LimitSwitch.kReverse, CANDigitalInput.LimitSwitchPolarity.kNormallyClosed);


  }

  @Override
  public void teleopPeriodic() {
    System.out.println(digitalInput.get());

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
