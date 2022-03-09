package com.github.mittyrobotics;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static OI instance;
    private XboxController controller;

    public static OI getInstance() {
        if(instance==null) {
            instance = new OI();
        }
        return instance;
    }

    public void initOI() {
        controller = new XboxController(0);
    }

    public boolean getAButtonPressed() {
        return controller.getAButtonPressed();
    }

    public boolean getBButtonPressed() {
        return controller.getBButtonPressed();
    }
}
