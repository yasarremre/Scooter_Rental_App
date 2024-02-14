public class StopUsingScooterCommand implements IStopUsingScooterCommand {

    @Override
    public void execute(Scooter scooter, User user, double seconds, double distance) {

        scooter.setAvailable(true);
        System.out.println("Scooter is stopped");
        TimeBasedPricingStrategy timeBasedPricingStrategy = new TimeBasedPricingStrategy();
        DistanceBasedPricingStrategy distanceBasedPricingStrategy = new DistanceBasedPricingStrategy();
        double cost = timeBasedPricingStrategy.calculateRentalCost(seconds) + distanceBasedPricingStrategy.calculateRentalCost(distance);
        System.out.println("Cost: " + cost);
        user.decreaseBalance(cost);

    }
}
