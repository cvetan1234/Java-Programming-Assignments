import java.util.ArrayList;

public class PrimeNumbersThread extends Thread{
    private final int START;
    private final int END;
    private final ArrayList<Integer> PRIME_NUMBERS = new ArrayList<>();

    public int getStart(){
        return START;
    }

    public int getEnd(){
        return END;
    }

    public ArrayList<Integer> getPrimeNumbers(){ return PRIME_NUMBERS; }

    public PrimeNumbersThread(int start, int end){
        START = start;
        END = end;
    }

    //check if a single number is prime
    static boolean isPrime(int a){
        //Handling of 2 and 5
        if (a == 2 || a == 5){
            return true;
        }

        //we don't need to check any other number that ends on 0, 2, 4, 5, 6 or 8
        //also 1 and 0 are not prime
        int lastDigit = a%10;
        if (a <= 0 || a == 1 || lastDigit == 0 || lastDigit == 2 || lastDigit == 4
                || lastDigit == 5 || lastDigit == 6 || lastDigit == 8){
            return false;
        }

        //if the number can be divided than not prime
        for (int n = 2; n <= Math.sqrt(a); n++){
            if (a % n == 0){
                return false;
            }
        }
        return true;
    }

    //check all the numbers between start and end
    public void run(){
        for (int n = START; n <= END; n++){
            if (isPrime(n)){
                PRIME_NUMBERS.add(n);
            }
        }
    }
}
