// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterUnitSubsystem extends SubsystemBase {
  //This is the motors
  private final SparkMax unit;

  private SparkMaxConfig genericSparkMaxConfig;

  public boolean isMoving = false;
  
  //Creates a new Shooter.
  public ShooterUnitSubsystem(int can_id, boolean inverted) {
    unit = new SparkMax(can_id, MotorType.kBrushless);

    genericSparkMaxConfig = new SparkMaxConfig();

    genericSparkMaxConfig.inverted(inverted).idleMode(SHOOTER_IDLE_MODE).smartCurrentLimit(SHOOTER_CURRENT_MAX);

    unit.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run.
  }


  //My attempt at lowering "noise" on the can bus. Probably not needed.
  public void runShooter(int speed) {
    unit.set(speed);
  }

  public void stopShooter() {
    unit.set(0);
  }
}