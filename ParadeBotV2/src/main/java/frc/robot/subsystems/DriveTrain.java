// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class DriveTrain extends SubsystemBase {
  
  private static WPI_VictorSPX leftLeader = new WPI_VictorSPX(3); //Ports
  private WPI_VictorSPX leftFollow = new WPI_VictorSPX(2);
  private static WPI_VictorSPX rightLeader = new WPI_VictorSPX(0);
  private WPI_VictorSPX rightFollow = new WPI_VictorSPX(1);

  private static DifferentialDrive chassis;
  private static RobotContainer robotContainer;


  /** Creates a new DriveTrain. */
  public DriveTrain(RobotContainer robotContainer) {
    this.robotContainer = robotContainer;

    rightLeader.setInverted(true);
    rightFollow.setInverted(true);
    leftFollow.follow(leftLeader);
    rightFollow.follow(rightLeader);

    // chassis.setDeadband(0.05);
    // chassis.setMaxOutput(1);

    chassis = new DifferentialDrive(leftLeader, rightLeader);
  }

  @Override
  public void periodic() {
    chassis.arcadeDrive(-robotContainer.getController().getLeftY(), -robotContainer.getController().getRightX());
  }

 public void arcadeDrive(double throttle, double turn) {
      // throttle *= 1.2;
      // chassis.arcadeDrive(throttle, turn, false);
  }
}