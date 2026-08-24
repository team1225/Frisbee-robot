package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PneumaticsSubsystem;

public class LoaderForward extends Command {
    private PneumaticsSubsystem loaderSubsystem;
    private boolean hasSent;

    public LoaderForward(PneumaticsSubsystem TEMPPNEUMATICSUBSYSTEM) {
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
            loaderSubsystem.FireLoader();
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
