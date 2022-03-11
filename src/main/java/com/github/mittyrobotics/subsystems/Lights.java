package com.github.mittyrobotics.subsystems;
import com.github.mittyrobotics.Constants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase{
    private static Lights instance;

    AddressableLED led = new AddressableLED(Constants.lightsID);
    AddressableLEDBuffer buffer = new AddressableLEDBuffer(Constants.lightsLength);

    public static Lights getInstance(){
        return instance == null ? instance = new Lights() : instance;
    }
    public void initHardware(){
        led.setLength(buffer.getLength());
        led.setData(buffer);
        led.start();
    }
    public void setCol(boolean turnOn){
        for (int i = 0; i < Constants.lightsLength; i++) buffer.setRGB(i, turnOn ? 255 : 0, 0, 0);
        led.setData(buffer);
    }
}
