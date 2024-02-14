/**
 * Author
 * Emre Yasar 20210808602
 */


public class Scooter extends Observable {
    private String id;
    private double batteryPercentage;
    private boolean isAvailable;



    public Scooter(String id) {
        this.id = id;
        this.batteryPercentage = 100; // battery percentage is 100 by default when you create a new scooter
        this.isAvailable = true; // scooter is available by default when you create a new scooter
    }

    public String getId() {
        return this.id;
    }

    public boolean IsAvailable() {
        return this.isAvailable;
    }

    public double getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void chargeScooter(double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void chargeScooter() {
        this.batteryPercentage = 100;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
        notifyObservers(available);
    }
    public void setAvailableWithoutNotification(boolean available) {
        this.isAvailable = available;
    }
    public boolean getAvailable() {
        return this.isAvailable;
    }

    public void decreaseBattery(double batteryPercentage) {
        this.batteryPercentage -= batteryPercentage;
    }



}
