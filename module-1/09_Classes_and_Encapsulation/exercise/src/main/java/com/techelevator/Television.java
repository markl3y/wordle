package com.techelevator;

public class Television {
    private boolean isOn;	            //Whether the TV is turned on.
    private int currentChannel = 3;     //The value for the current channel. Channel levels go between 3 and 18.
    private int currentVolume = 2;      //The current volume level.

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
    //void turnOff()
    //    void turnOn()
    //    void changeChannel(int newChannel)
    //    void channelUp()
    //    void channelDown()
    //    void raiseVolume()
    //    void lowerVolume()

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel != this.currentChannel && newChannel >= 3 && newChannel <= 18) {
                this.currentChannel = newChannel;
            }
        }
    }

    public void channelUp() {
        if (isOn) {
            currentChannel++;
            if (currentChannel == 19) {
                currentChannel = 3;
            }
        }
    }
    public void channelDown() {
        if (isOn) {
            currentChannel--;
            if (currentChannel == 2) {
                currentChannel = 18;
            }
        }
    }
    public void raiseVolume() {
        if (isOn) {
            if (currentVolume != 10) {
                currentVolume++;
            }
        }
    }
    public void lowerVolume() {
        if (isOn) {
            if (currentVolume != 0) {
                currentVolume--;
            }
        }

    }
    //turnOff() turns off the TV.
    //turnOn() turns the TV on and also resets the channel to three and the volume level to two.
    //changeChannel(int newChannel) changes the current channel—only if it's on—to the value of newChannel as long as it's between 3 and 18.
    //channelUp() increases the current channel by one, only if it's on. If the value goes past 18, then the current channel must be set to three.
    //channelDown() decreases the current channel by one, only if it's on. If the value goes below three, then the current channel must be set to 18.
    //raiseVolume() increases the volume by one, only if it's on. The limit is 10.
    //lowerVolume() decreases the volume by one, only if it's on. The limit is zero.
}
