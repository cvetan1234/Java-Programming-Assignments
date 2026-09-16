import java.util.ArrayList;
import java.util.List;

public class ConcurrentPrimeNumberChecker {
    private final int NUMBER_OF_THREADS;
    private final int UPPER_BOUNDARY;
    private static final List<PrimeNumbersThread> THREADS_LIST = new ArrayList<>();
    private static final List<Integer> ALL_PRIME_NUMBERS = new ArrayList<>();

    public ConcurrentPrimeNumberChecker(int upperBoundary, int numberOfThreads) {
        UPPER_BOUNDARY = upperBoundary;
        NUMBER_OF_THREADS = numberOfThreads;
    }

    public List<PrimeNumbersThread> getThreadsList(){ return THREADS_LIST; }

    public List<Integer> getAllPrimeNumbers(){ return ALL_PRIME_NUMBERS; }

    public void run(){
        THREADS_LIST.clear();
        ALL_PRIME_NUMBERS.clear();

        //create and start the threads
        for (int n = 0; n<NUMBER_OF_THREADS; n++){
            PrimeNumbersThread t  = new PrimeNumbersThread
                    ((int)Math.ceil(n*((float)UPPER_BOUNDARY/NUMBER_OF_THREADS)) + 1, (int)Math.ceil((n+1)*(float)UPPER_BOUNDARY/NUMBER_OF_THREADS));
            THREADS_LIST.add(t);
            t.start();
        }

        //collect the threads and save the numbers they found together
        for (PrimeNumbersThread t : THREADS_LIST){
            try{
                t.join();
                ALL_PRIME_NUMBERS.addAll(t.getPrimeNumbers());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
