// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ShooterConstants.*;

public class ShooterSubsystem extends SubsystemBase {
  //This is the motors
  private final SparkMax right1;
  private final SparkMax right2;
  private final SparkMax right3;
  private final SparkMax left1;
  private final SparkMax left2;
  private final SparkMax left3;

  private SparkMaxConfig genericSparkMaxConfig;

  public boolean isMoving = false;
  
  /** Creates a new Shooter. */
  public ShooterSubsystem() {
    right1 = new SparkMax(RIGHT_1_ID, MotorType.kBrushless);
    right2 = new SparkMax(RIGHT_2_ID, MotorType.kBrushless);
    right3 = new SparkMax(RIGHT_3_ID, MotorType.kBrushless);
    left1 = new SparkMax(LEFT_1_ID, MotorType.kBrushless);
    left2 = new SparkMax(LEFT_2_ID, MotorType.kBrushless);
    left3 = new SparkMax(LEFT_3_ID, MotorType.kBrushless);

    genericSparkMaxConfig = new SparkMaxConfig();

    genericSparkMaxConfig.inverted(true).idleMode(SHOOTER_IDLE_MODE).smartCurrentLimit(SHOOTER_CURRENT_MAX);

    right1.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right2.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right3.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    genericSparkMaxConfig.inverted(false);

    left1.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    left2.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    left3.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run.
  }


  //My attempt at lowering "noise" on the can bus. Probably not needed.
  public void runShooter() {
    right1.set(RIGHT_1_SPEED);
    right2.set(RIGHT_2_SPEED);
    right3.set(RIGHT_3_SPEED); 
    left1.set(LEFT_1_SPEED);
    left2.set(LEFT_2_SPEED);
    left3.set(LEFT_3_SPEED);
  }

  public void stopShooter() {
    right1.set(0);
    right2.set(0);
    right3.set(0);
    left1.set(0);
    left2.set(0);
    left3.set(0);
  }
}
