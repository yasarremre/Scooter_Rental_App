public interface IReservationCommand extends ICommand{
    void execute(Scooter scooter,User user, int minute);
}
