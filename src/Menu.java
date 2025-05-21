import java.util.Scanner;

public class Menu {

    Stations st = new Stations();
    public Menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MakerSpace!");
        System.out.println("Define the interval at which you want the report to be printed: ");
        int interval = sc.nextInt();

        System.out.println("Enter the amount for Figurines for Mazes and Monsters: ");
        int figureCount = sc.nextInt();

        System.out.println("Enter the amount for Motor Controller with Custom PCBs: ");
        int motorCount = sc.nextInt();

        System.out.println("Enter the amount for Chess Set: ");
        int chessSetCount = sc.nextInt();

        System.out.println("Enter the amount for Toaster pastry: ");
        int toasterCount = sc.nextInt();

        System.out.println("Enter the amount for Cup holder: ");
        int cupHolderCount = sc.nextInt();

        System.out.println("Enter the amount for SAK scales: ");
        int sakCount = sc.nextInt();

        System.out.println("Enter the amount for flashlight: ");
        int flashlightCount = sc.nextInt();

        // Create and start threads for each item production task
        Thread figurineThread = new Thread(new Figurine(figureCount, interval, st));
        Thread motorThread = new Thread(new MotorController(motorCount, interval, st));
        Thread chessThread = new Thread(new ChessSet(chessSetCount, interval, st));
        Thread toasterThread = new Thread(new Toaster(toasterCount, interval, st));
        Thread cupHolderThread = new Thread(new CupHolder(cupHolderCount, interval, st));
        Thread sakThread = new Thread(new Sak(sakCount, interval, st));
        Thread flashLightThread = new Thread(new Flashlight(flashlightCount, interval, st));



        figurineThread.start();
        motorThread.start();
        chessThread.start();
        toasterThread.start();
        cupHolderThread.start();
        sakThread.start();
        flashLightThread.start();

        // Wait for all threads to complete execution
        try {
            figurineThread.join();
            motorThread.join();
            chessThread.join();
            toasterThread.join();
            cupHolderThread.join();
            sakThread.join();
            flashLightThread.join();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        // display the final output after all the production is done.
        System.out.println();
        System.out.println("Finished producing all the knickKnacks!");
        System.out.println("Total number of Items produced: " + st.total);
        sc.close();
    }

    public static void main(String[] args) {
        Menu mn = new Menu();
    }
}

