import java.util.ArrayList;
import java.util.List;

public class ConcurrentPrimeNumberChecker {
    String path = "savednumbers.txt";
    static List<PrimeNumbersThread> threadsList = new ArrayList<>();
    private final int UPPER_BOUNDARY;
    private final int NUMBER_OF_THREADS;
    List<Integer> allNumbers = new ArrayList<>();
    List<Integer> savedNumbers = FileManager.readFromFile(path);
    List<Integer> numbersFromFile = new ArrayList<>();
    int start_value = 0;

    public ConcurrentPrimeNumberChecker(int upperBoundary, int numberOfThreads) {
        UPPER_BOUNDARY = upperBoundary;
        NUMBER_OF_THREADS = numberOfThreads;
    }

    public List<PrimeNumbersThread> getList(){ return threadsList; }

    public List<Integer> getAllPrimeNumbers(){ return allNumbers; }

    public List<Integer> getSavedPrimeNumbers(){ return numbersFromFile; }

    public void run(){
        threadsList.clear();
        allNumbers.clear();

        //if there are saved numbers get the biggest of them
        if (!savedNumbers.isEmpty()){
            start_value = savedNumbers.get(savedNumbers.size() - 1);
        }

        //start the threads
        for (int n = 0; n < NUMBER_OF_THREADS; n++){
            PrimeNumbersThread t  = new PrimeNumbersThread
                    ((int)Math.ceil(n*((float)(UPPER_BOUNDARY-start_value)/NUMBER_OF_THREADS)) + 1 + start_value, (int)Math.ceil((n+1)*((float)(UPPER_BOUNDARY-start_value)/NUMBER_OF_THREADS)) + start_value);
            threadsList.add(t);
            t.start();
        }

        //collect and join the threads
        for (PrimeNumbersThread t : threadsList){
            try{
                t.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //collect the numbers from the file which are <= upper boundary
        for (Integer number : savedNumbers){
            if (number <= UPPER_BOUNDARY){
                allNumbers.add(number);
                numbersFromFile.add(number);
            }
        }

        //save the prime numbers from all threads
        for (PrimeNumbersThread t : threadsList){
            allNumbers.addAll(t.getPrimeNumbers());
        }

        //if there are new numbers to save, save them to the file
        if (start_value < allNumbers.get(allNumbers.size() - 1)) {
            FileManager.writeInFile(allNumbers, path);
        }
    }
}
