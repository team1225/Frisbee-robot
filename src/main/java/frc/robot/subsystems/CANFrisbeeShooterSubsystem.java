// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

// Alternate subsystem with finer control of each motor.

public class CANFrisbeeShooterSubsystem extends SubsystemBase {
  private final SparkMax motorA;
  private final SparkMax motorB;
  private final SparkMax motorC;
  private final SparkMax motorD;
  private final SparkMax motorE;
  private final SparkMax motorF;

  /** Creates a new CANDriveSubsystem2. */
  public CANFrisbeeShooterSubsystem() {
    // create brushed motors for drive
    motorA = new SparkMax(CAN_A, MotorType.kBrushless);
    motorB = new SparkMax(CAN_B, MotorType.kBrushless);
    motorC = new SparkMax(CAN_C, MotorType.kBrushless);
    motorD = new SparkMax(CAN_D, MotorType.kBrushless);
    motorE = new SparkMax(CAN_E, MotorType.kBrushless);
    motorF = new SparkMax(CAN_F, MotorType.kBrushless);

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    motorA.setCANTimeout(250);
    motorB.setCANTimeout(250);
    motorC.setCANTimeout(250);
    motorD.setCANTimeout(250);
    motorE.setCANTimeout(250);
    motorF.setCANTimeout(250);

    // Create the configuration to apply to motors. Voltage compensation
    // helps the robot perform more similarly on different
    // battery voltages (at the cost of a little bit of top speed on a fully charged
    // battery). The current limit helps prevent tripping
    // breakers.
    SparkMaxConfig config = new SparkMaxConfig();
    config.voltageCompensation(12);
    config.smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);

    // Apply configuration the above parameters to each
    // motor. Resetting in case a new controller is swapped
    // in and persisting in case of a controller reset due to breaker trip
    motorA.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorB.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorC.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // Invert half of the motors, assuming the motors control the opposite side.
    // Comment out this invert line if all motors go in the same direction.
    config.inverted(true);
    motorD.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorE.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorF.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
  }

  public void run() {
    motorA.set(1);
    motorB.set(1);
    motorC.set(1);
    motorD.set(1);
    motorE.set(1);
    motorF.set(1);
  }

  public void runEnd() {
    motorA.set(0);
    motorB.set(0);
    motorC.set(0);
    motorD.set(0);
    motorE.set(0);
    motorF.set(0);
  }

}
