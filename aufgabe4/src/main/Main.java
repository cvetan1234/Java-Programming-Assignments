import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //main loop
        while (true) {
            int upperBoundary;
            int numberOfThreads;
            Scanner sc = new Scanner(System.in);

            //chance for hte user to exit
            System.out.print("Do you wanna find more prime numbers? (y, n) ");
            char answer1 = sc.next().charAt(0);
            if (answer1 == 'n'){
                break;
            }
            if (answer1 != 'y'){
                continue;
            }

            //chance for the user to empty the file with saved numbers
            System.out.print("Do you wanna empty the File? (y, n) ");
            if (sc.next().charAt(0) == 'y'){
                FileManager.resetFile("savednumbers.txt");
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
            List<PrimeNumbersThread> threadsList = c.getList();
            //show which are directly loaded from the file
            System.out.println("From file: " + c.getSavedPrimeNumbers());
            for (int i = 0; i < threadsList.size(); i++){
                PrimeNumbersThread t = threadsList.get(i);
                //show which are found by the current threads
                System.out.println("Thread " + (i+1) + ": " + t.getPrimeNumbers());
            }
            System.out.println("All prime numbers: " + c.getAllPrimeNumbers());
            System.out.println();
        }

        //at the end the file is automatically reset
        FileManager.resetFile("savednumbers.txt");
    }
}