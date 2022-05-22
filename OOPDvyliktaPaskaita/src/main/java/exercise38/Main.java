package exercise38;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeMachine coffeMachine = new CoffeMachine(1000);

        System.out.println("---------------MENU JUOSTA-----------------");
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isActive){
            System.out.println("Paspauskite 1, jeigu norite kavos, 2 - jeigu norite pripilti vandens, 3 - iseiti.");
            int atsakymas = scanner.nextInt();

            switch (atsakymas){
                case 1:
                    ipiltiKavos(scanner,coffeMachine);
                    break;
                case 2:
                    coffeMachine.fillUp();
                    break;
                case 3:
                    isActive=false;
                    break;
                default:
                    System.out.println("Atsiprasome,bet tokio pasirinkimo neturime!");

            }
        }

    }

    private static void ipiltiKavos(Scanner scanner, CoffeMachine coffeMachine){
        System.out.println("Pasirinkite talpa: 1 - 100ml, 2 - 150ml, 3 - 200ml.");
        int kiekMililitru = scanner.nextInt();

        switch (kiekMililitru){
            case 1:
                coffeMachine.makeCoffe(100);
                break;
            case 2:
                coffeMachine.makeCoffe(150);
                break;
            case 3:
                coffeMachine.makeCoffe(200);
                break;
            default:
                System.out.println("Atsiprasome,bet tokio pasirinkimo neturime!");
        }
    }
}
