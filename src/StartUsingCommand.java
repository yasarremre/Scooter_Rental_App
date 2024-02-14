public class StartUsingCommand implements IStartUsingCommand {
    @Override
    public void execute(Scooter scooter, User user) {
        if (scooter.getAvailable() && !user.getIsUsing()) {
            if (scooter.getBatteryPercentage() > 10) {
                scooter.setAvailableWithoutNotification(false);
            } else {
                System.out.println("Scooter's charge is not enough to use");
            }
        } else if (!scooter.getAvailable()) {
            System.out.println("Scooter is already in use");
        } else {
            System.out.println("You are already using a scooter");
        }

    }
}
