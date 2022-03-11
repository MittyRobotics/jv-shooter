package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI{
    private static OI instance;
    private XboxController controller = new XboxController(Constants.controllerID);

    public static OI getInstance(){
        return instance == null ? instance = new OI() : instance;
    }
    public void initOI(){}
    public XboxController getController(){
        return controller;
    }
}