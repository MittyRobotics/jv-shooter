package com.github.mittyrobotics.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpinningWheels extends SubsystemBase{
    private static SpinningWheels instance;

    private WPI_TalonSRX leftTalon = new WPI_TalonSRX(Constants.leftTalonID);
    private WPI_TalonSRX rightTalon = new WPI_TalonSRX(Constants.rightTalonID);

    PIDController LPid = new PIDController(0.001, 0, 0.0000001);
    PIDController RPid = new PIDController(0.001, 0, 0.0000001);

    public static SpinningWheels getInstance(){
        return instance == null ? instance = new SpinningWheels() : instance;
    }
    public void initHardware(){
        leftTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rightTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }
    public int leftSpeed(){
        return leftTalon.getSelectedSensorVelocity();
    }
    public int rightSpeed() {
        return rightTalon.getSelectedSensorVelocity();
    }
    public void setSpeed(double rpm){
        leftTalon.set(LPid.calculate(leftSpeed(), rpm));
        rightTalon.set(-RPid.calculate(rightSpeed(), rpm));
    }
}
