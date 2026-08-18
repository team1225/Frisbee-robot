package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.PneumaticsConstants.*;

public abstract class PneumaticsSubsystem extends SubsystemBase {
    //Intializing the pneumatic hub
    PneumaticHub hub = new PneumaticHub(PneumaticHub);
    

    //Intializing the loader
    DoubleSolenoid loaderDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, LoaderForward, LoaderBackward);

    public void FireLoader() {
        loaderDoubleSolenoid.set(Value.kForward);
    }

     public void ReloadLoader() {
        loaderDoubleSolenoid.set(Value.kReverse);
    }

    public void SwitchLoead() {
        loaderDoubleSolenoid.toggle();
    }

    public void TurnLoaderOff() {
        loaderDoubleSolenoid.set(Value.kOff);
    }
    
    public boolean IsloaderForward() {
        if (loaderDoubleSolenoid.get() == DoubleSolenoid.Value.kForward) {
            return true;
        }
        else {
            return false;
        }
    }
}