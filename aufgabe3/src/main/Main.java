import javax.sound.midi.SysexMessage;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while (true) {
            int upperBoundary;
            int numberOfThreads;
            Scanner sc = new Scanner(System.in);

            //chance for the user to exit the program
            System.out.print("Do you want to find prime numbers? (y/n) ");
            char answer = sc.next().charAt(0);
            if (answer == 'n') {
                break;
            }
            if (answer != 'y') {
                continue;
            }

            try {
                System.out.print("Upper boundary?: ");
                upperBoundary = sc.nextInt();
                System.out.print("Number of threads?: ");
                numberOfThreads = sc.nextInt();
                System.out.println();
                if (upperBoundary <= 0 || numberOfThreads <= 0){
                    System.out.println("Please enter boundary > 0 and number of threads > 0!");
                    continue;
                }
                if (upperBoundary < numberOfThreads){
                    System.out.println("Number of threads must be >= upper boundary!");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("Wrong input type");
                sc.nextLine();
                continue;
            }

            ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(upperBoundary, numberOfThreads);
            c.run();

            //iterating through all threads and showing the numbers found by each of them
            List<PrimeNumbersThread> threadsList = c.getThreadsList();
            for (PrimeNumbersThread t : threadsList) {
                System.out.println("Thread from " + t.getStart() + " to " + t.getEnd() + ": " + t.getPrimeNumbers());
            }

            //showing all prime numbers in the chosen boundary
            System.out.println("All prime numbers: " + c.getAllPrimeNumbers());
            System.out.println();
        }
    }
}