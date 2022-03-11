package com.github.mittyrobotics;

import com.github.mittyrobotics.commands.SpinTheWheels;
import com.github.mittyrobotics.subsystems.Lights;
import com.github.mittyrobotics.subsystems.SpinningWheels;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {

    SpinTheWheels instr = new SpinTheWheels();

    public Robot() {
        super(0.02);
    }

    @Override
    public void robotInit() {
        SpinningWheels.getInstance().initHardware();
        Lights.getInstance().initHardware();
    }
    @Override
    public void robotPeriodic() {
        if (OI.getInstance().getController().getAButton()) CommandScheduler.getInstance().schedule(instr);
        if (OI.getInstance().getController().getBButton()) CommandScheduler.getInstance().cancel(instr);
        CommandScheduler.getInstance().run();
    }
    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() { }

    @Override
    public void teleopPeriodic() { }

    @Override
    public void testInit() { }
    @Override
    public void testPeriodic() { }

}