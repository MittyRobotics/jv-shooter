package com.github.mittyrobotics.commands;
import com.github.mittyrobotics.OI;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.github.mittyrobotics.subsystems.DoubleFlywheel;

public class FlyWheelCommand extends CommandBase{
    @Override
    public void initialize() {
        DoubleFlywheel.getInstance().initHardware();
        OI.getInstance().initOI();

    }

    @Override
    public void execute() {
        if (OI.getInstance().getAButtonPressed()){
            DoubleFlywheel.getInstance().setMotors(0.5);
        }



    }

    @Override
    public void end(boolean interrupted) {
        DoubleFlywheel.getInstance().setMotors(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }


}
