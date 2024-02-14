public interface IStopReservationCommand extends ICommand{
    void execute(Scooter scooter,User user);
}
