package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PneumaticsSubsystem;

public abstract class LoaderBackward extends Command {
    private PneumaticsSubsystem loaderSubsystem;
    private boolean hasSent;

    public LoaderBackward(PneumaticsSubsystem TEMPPNEUMATICSUBSYSTEM) {
        addRequirements(TEMPPNEUMATICSUBSYSTEM);
        loaderSubsystem = TEMPPNEUMATICSUBSYSTEM;
    }

    @Override
    public void initialize() {
        hasSent = false;
    }

    @Override
    public void execute() {
        if (hasSent == false) {
            loaderSubsystem.ReloadLoader();
            hasSent = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        loaderSubsystem.TurnLoaderOff();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}