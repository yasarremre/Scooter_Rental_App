public class StopReservationCommand implements IStopReservationCommand{

    @Override
    public void execute(Scooter scooter, User user) {
        if(scooter.getAvailable()){
            System.out.println("Scooter is not reserved");
        }
        else{
            scooter.setAvailable(true);
            System.out.println("Reservation is cancelled");
            user.setIsUsing(false);
        }
    }
}
