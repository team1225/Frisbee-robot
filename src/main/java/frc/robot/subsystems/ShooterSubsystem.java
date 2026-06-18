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
  // private final SparkMax left2;
  // private final SparkMax left3;

  private SparkMaxConfig genericSparkMaxConfig;

  public boolean isMoving = false;
  
  /** Creates a new Shooter. */
  public ShooterSubsystem() {
    right1 = new SparkMax(Right_1_ID, MotorType.kBrushless);
    right2 = new SparkMax(Right_2_ID, MotorType.kBrushless);
    right3 = new SparkMax(Right_3_ID, MotorType.kBrushless);
    left1 = new SparkMax(Left_1_ID, MotorType.kBrushless);
    // left2 = new SparkMax(Left_2_ID, MotorType.kBrushless);
    // left3 = new SparkMax(Left_3_ID, MotorType.kBrushless);

    genericSparkMaxConfig = new SparkMaxConfig();

    genericSparkMaxConfig.inverted(false).idleMode(SHOOTER_IDLE_MODE).smartCurrentLimit(SHOOTER_CURRENT_MAX);

    right1.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right2.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right3.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    left1.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // left2.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // left3.configure(genericSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  //My attempt at lowering "noise" on the can bus. Probably not needed.
  public void runShooter() {
    if (isMoving=false) {
      right1.set(Right_1_speed);
      right2.set(Right_2_speed);
      right3.set(Right_3_speed);
      left1.set(Left_1_speed);
      // left2.set(Left_2_speed);
      // left3.set(Left_3_speed);
      isMoving=true;
    }
  }

  public void stopShooter() {
    if (isMoving=true) {
      right1.set(0);
      right2.set(0);
      right3.set(0);
      left1.set(0);
      // left2.set(0);
      // left3.set(0);
      isMoving=false;
    }
  }
}
