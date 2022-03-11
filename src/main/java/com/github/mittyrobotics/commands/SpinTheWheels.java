package com.github.mittyrobotics.commands;
import com.github.mittyrobotics.Constants;
import com.github.mittyrobotics.subsystems.Lights;
import com.github.mittyrobotics.subsystems.SpinningWheels;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinTheWheels extends CommandBase {
    public SpinTheWheels(){
        addRequirements(SpinningWheels.getInstance());
        addRequirements(Lights.getInstance());
    }
    public void initialize(){

    }
    public void execute(){
        SpinningWheels.getInstance().setSpeed(Constants.desiredRPM);

        int offL = Math.abs(SpinningWheels.getInstance().leftSpeed() - Constants.desiredRPM);
        int offR = Math.abs(SpinningWheels.getInstance().rightSpeed() - Constants.desiredRPM);
        if (offL <= Constants.okRange && offR <= Constants.okRange) Lights.getInstance().setCol(true);
        else Lights.getInstance().setCol(false);
    }
    public void end(boolean isFinished){
        SpinningWheels.getInstance().setSpeed(0);
        Lights.getInstance().setCol(false);
    }
    public boolean isFinished(){
        return false;
    }

}
