public class ReservationCommand implements IReservationCommand{
    @Override
    public void execute(Scooter scooter, User user, int minute) {
        if ((scooter.getAvailable()) && !user.getIsUsing()) {
            if (scooter.getBatteryPercentage() > 10) {
                scooter.setAvailableWithoutNotification(false);
                System.out.println("Scooter is reserved");
                ReservationPricingStrategy reservationPricingStrategy = new ReservationPricingStrategy();
                double cost = reservationPricingStrategy.calculateRentalCost(minute);
                System.out.println("Reservation cost is: " + cost + " TL");
                user.decreaseBalance(cost);
                user.setIsUsing(true);
            } else if (scooter.getBatteryPercentage() < 10 && !user.getIsUsing()) {
                System.out.println("Scooter's charge is not enough to reserve");
            } else if (!user.getIsUsing()) {
                System.out.println("You can not reserve a scooter while you are using a scooter");
            } else {
                System.out.println("Scooter is already in use");
            }
        }
    }


}
