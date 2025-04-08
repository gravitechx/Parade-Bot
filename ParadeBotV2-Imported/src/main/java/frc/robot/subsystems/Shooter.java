// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private TalonSRX leftMotor;
  private TalonSRX rightMotor;

  /** Creates a new Shooter. */
  public Shooter() {
    leftMotor = new TalonSRX(0);
    rightMotor = new TalonSRX(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed) {
    leftMotor.set(TalonSRXControlMode.PercentOutput, speed);
    rightMotor.set(TalonSRXControlMode.PercentOutput, -speed);
  }
}
