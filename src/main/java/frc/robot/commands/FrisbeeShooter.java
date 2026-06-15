// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CANFrisbeeShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class FrisbeeShooter extends Command {
  /** Creates a new FrisbeeShooter. */
  CANFrisbeeShooterSubsystem frisbeeShooter;
  CommandXboxController controller;

  public FrisbeeShooter(CANFrisbeeShooterSubsystem frisbeeSystem, CommandXboxController frisbeeController) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(frisbeeSystem);
    frisbeeShooter = frisbeeSystem;
    controller = frisbeeController;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    frisbeeShooter.run();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    frisbeeShooter.runEnd();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
