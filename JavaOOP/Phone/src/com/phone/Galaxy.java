package com.phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String Ring() {
        // your code here
    	return this.getRingTone();
    }
    @Override
    public String unlock() {
        // your code here
    	return "Unlocked with facial recognition";
    }
    @Override
    public void displayInfo() {
        // your code here
    	System.out.println("Version Number: " + this.getVersionNumber());
    	System.out.println("Battery Percentage: " + this.getBatteryPercentage());
    	System.out.println("Carrier: " + this.getCarrier());
    	System.out.println("RingTone: " + this.getRingTone());
    }
}
