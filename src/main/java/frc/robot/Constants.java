// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    // Motor controller IDs for drivetrain motors
    public static final int LEFT_LEADER_ID = 2;
    public static final int LEFT_FOLLOWER_ID = 3;
    public static final int RIGHT_LEADER_ID = 4;
    public static final int RIGHT_FOLLOWER_ID = 5;

    // Current limit for drivetrain motors. 60A is a reasonable maximum to reduce
    // likelihood of tripping breakers or damaging CIM motors
    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 100; //fuse 40A
  }

  public static final class OperatorConstants {
    // Port constants for driver and operator controllers. These should match the
    // values in the Joystick tab of the Driver Station software
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;

    // This value is multiplied by the joystick value when rotating the robot to
    // help avoid turning too fast and begin difficult to control
    public static final double DRIVE_SCALING = .7;
    public static final double ROTATION_SCALING = .8;
  }

  public static final class ShooterConstants {
    //So we can switch the ids easily.
    public static final int Right_1_ID = 2;
    public static final int Right_2_ID = 3;
    public static final int Right_3_ID = 4;
    public static final int Left_1_ID = 5;
    // public static final int Left_2_ID = 10;
    // public static final int Left_3_ID = 11;

    //We probably want it in coast. May want brake.
    public static final IdleMode SHOOTER_IDLE_MODE = IdleMode.kCoast;

    public static final int SHOOTER_CURRENT_MAX = 100;

    //So we can change individual motors
    public static final double Right_1_speed = 1;
    public static final double Right_2_speed = 1;
    public static final double Right_3_speed = 1;
    public static final double Left_1_speed = 1;
    // public static final double Left_2_speed = 1;
    // public static final double Left_3_speed = 1;
  }
}
