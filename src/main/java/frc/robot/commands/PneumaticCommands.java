package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PneumaticsSubsystem;
import static frc.robot.Constants.PneumaticsConstants.*;

public abstract class PneumaticCommands extends Command {
    private PneumaticsSubsystem solenoids;
    private XboxController controller;
    private int SlackTime;
    private int Direction;

    public PneumaticCommands(PneumaticsSubsystem TEMPSOLENOIDS, XboxController PassingInController) {
        addRequirements(TEMPSOLENOIDS);
        solenoids = TEMPSOLENOIDS;
        controller = PassingInController;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if (controller.getRightBumperButtonPressed() == true) {
            Direction = 1;
            SlackTime = Slacktimer;
        }

        if (controller.getLeftBumperButtonPressed() == true) {
            Direction = -1;
            SlackTime = Slacktimer;
        }

        --SlackTime;
        if (SlackTime == 0) {
            Direction = 0;
        }

        if (Direction == 1) {
            solenoids.FireLoader();
        }

        if (Direction == 0) {
            solenoids.TurnLoaderOff();
        }

        if (Direction == -1) {
            solenoids.ReloadLoader();
        }
    }

    @Override
    public void end(boolean interrupted) {
        solenoids.TurnLoaderOff();
    }

    public boolean isFinished() {
        return false;
    }
}
