public class InterfaceCommand implements IInterfaceCommand {
    @Override
    public void EnableLights() {
        System.out.println("Lights are enabled");
    }

    @Override
    public void DisableLights() {
        System.out.println("Lights are disabled");
    }

    @Override
    public void Ring() {
        System.out.println("Lights are enabled and scooter is ringing");
    }

    @Override
    public void EnableLocks() {
        System.out.println("Locks are enabled");
    }

    @Override
    public void DisableLocks() {
        System.out.println("Locks are disabled");
    }
}


