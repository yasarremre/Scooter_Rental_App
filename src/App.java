import java.util.Scanner;

/**
 * Authors
 * Deniz Mutlu 20200808042
 * Emre Yasar 20210808602
 */

public class App {

    public static void main(String[] args) {
        User user = new User("Emre","Yasar","emreyasar@gmail.com","123456","0555 555 55 55");
        Scooter scooter = new Scooter("1");

        ReservationPricingStrategy reservationPricingStrategy = new ReservationPricingStrategy();
        DistanceBasedPricingStrategy distanceBasedPricingStrategy = new DistanceBasedPricingStrategy();
        TimeBasedPricingStrategy timeBasedPricingStrategy = new TimeBasedPricingStrategy();

        scooter.registerObserver(user);
        reservationPricingStrategy.registerObserver(user);
        distanceBasedPricingStrategy.registerObserver(user);
        timeBasedPricingStrategy.registerObserver(user);

        boolean loop = true;
        user.addBalance(10000);
        Scanner scanner = new Scanner(System.in);

        user.setIsUsing(false);
        scooter.setAvailableWithoutNotification(true);

        System.out.println("Welcome to Scooter System");
        while(loop){
            int distance = 0;
            int duration = 0;
            System.out.println("\nYour balance is " + user.getBalance() + " TL");
            System.out.println("0- Exit");
            System.out.println("1- Reserve a scooter");
            System.out.println("2- Start using a scooter");
            System.out.println("3- Find closest scooter");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if(choice == 0){
                System.out.println("Thank you for using our system");
                loop = false;
                break;

            }
            else if(choice == 1){
                System.out.print("Enter the minute you want to reserve ");
                int minute = scanner.nextInt();
                ReservationCommand reservationCommand = new ReservationCommand();
                reservationCommand.execute(scooter,user,minute);

            }
            else if(choice == 2){
                while(true){
                    System.out.println("\n0- Finish using a scooter");
                    System.out.println("1- Go 100 meters with scooter in 1 minute");
                    System.out.println("2- To enable the lights");
                    System.out.println("3- To disable the lights");
                    System.out.println("4- To enable the lock");
                    System.out.println("5- To disable the lock");
                    System.out.print("Enter your choice: ");
                    int selection = scanner.nextInt();

                    if(selection == 0){
                        StopUsingScooterCommand stopUsingScooterCommand = new StopUsingScooterCommand();
                        stopUsingScooterCommand.execute(scooter,user,duration,distance);
                        break;
                    }
                    else if(selection == 1){
                        distance += 100;
                        duration += 60;
                    }
                    else if(selection == 2){
                        InterfaceCommand interfaceCommand = new InterfaceCommand();
                        interfaceCommand.EnableLights();
                    }
                    else if(selection == 3){
                        InterfaceCommand interfaceCommand = new InterfaceCommand();
                        interfaceCommand.DisableLights();
                    }
                    else if(selection == 4){
                        InterfaceCommand interfaceCommand = new InterfaceCommand();
                        interfaceCommand.EnableLocks();
                    }
                    else if(selection == 5){
                        InterfaceCommand interfaceCommand = new InterfaceCommand();
                        interfaceCommand.DisableLocks();
                    }
                    else{
                        System.out.println("Invalid choice");
                    }

                }


            }
            else if(choice == 3){
                InterfaceCommand interfaceCommand = new InterfaceCommand();
                interfaceCommand.Ring();
            }


        }



    }
}
