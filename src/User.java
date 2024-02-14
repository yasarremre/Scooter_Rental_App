/**
 * Author
 * Emre Yasar 20210808602
 */


public class User implements Observer {
    private String name;
    private String surname;
    private String email;
    private String password;
    private double balance;
    private String phoneNumber;
    private boolean isUsing; // true if user is using a scooter, user can not use more than one scooter at the same time

    public User(String name, String surname, String email, String password, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.balance = 0; // balance is 0 by default when you create a new user
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Amount must be greater than 0");
        }
    }

    public void decreaseBalance(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
            } else {
                System.out.println("You do not have enough balance, your balance will be negative");
                this.balance -= amount;
                System.out.println("Your balance is: " + this.balance);
            }
        } else {
            System.out.println("Amount must be greater than 0");
        }
    }

    public void setIsUsing(boolean isUsing) {
        this.isUsing = isUsing;
    }

    public boolean getIsUsing() {
        return this.isUsing;
    }

    public void StartUsingScooter(Scooter scooter) {
        StartUsingCommand startUsingCommand = new StartUsingCommand();
        startUsingCommand.execute(scooter, this);
    }

    public void stopReserveScooter(Scooter scooter) {
        StopReservationCommand stopReservationCommand = new StopReservationCommand();
        stopReservationCommand.execute(scooter, this);

    }

    public void ReserveScooter(Scooter scooter, int minutes) {
        ReservationCommand reservationCommand = new ReservationCommand();
        reservationCommand.execute(scooter, this, minutes);
    }

    public void StopUsingScooter(Scooter scooter, double seconds, double distance) {
        StopUsingScooterCommand stopUsingScooterCommand = new StopUsingScooterCommand();
        stopUsingScooterCommand.execute(scooter, this, seconds, distance);

    }

    @Override
    public void update(Observable o) {
        if (o instanceof Scooter) {
            Scooter scooter = (Scooter) o;
            if (scooter.getAvailable()) {
                System.out.println("Scooter is available");
            } else {
                System.out.println("Scooter is not available");
            }
        }
    }

    public void update(Observable o, double price, double oldPrice) {
        if (o instanceof ReservationPricingStrategy) {
            System.out.println("New Reservation price is: " + price + ", Old Reservation price is: " + oldPrice);
        } else if (o instanceof DistanceBasedPricingStrategy) {
            System.out.println("Distance based price is (per 100 meter): " + price + ", Old Distance based price is: " + oldPrice);
        } else if (o instanceof TimeBasedPricingStrategy) {
            System.out.println("Time based price is (per 1 minute): " + price + ", Old Time based price is: " + oldPrice);
        }
    }
}

