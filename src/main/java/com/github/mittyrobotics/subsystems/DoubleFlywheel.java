package com.github.mittyrobotics.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DoubleFlywheel extends SubsystemBase {

    //initialize motors
    //make functions for the motors

    private static DoubleFlywheel instance;

    CANSparkMax sparkLeft;
    CANSparkMax sparkRight;

    public static DoubleFlywheel getInstance() {
        if(instance==null) {
            instance = new DoubleFlywheel();
        }
        return instance;
    }

    public void initHardware() {
        sparkLeft = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkRight = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkRight.restoreFactoryDefaults();
        sparkLeft.restoreFactoryDefaults();
    }

    public void setMotors(double speed) {
        sparkLeft.set(speed);
        sparkRight.set(speed);
    }

}
