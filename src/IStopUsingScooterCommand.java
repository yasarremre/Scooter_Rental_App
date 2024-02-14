public interface IStopUsingScooterCommand extends ICommand{
    void execute(Scooter scooter,User user,double seconds,double distance);
}

