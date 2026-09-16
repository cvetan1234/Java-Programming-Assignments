import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersThreadTest {
    @Test
    void testIsPrime(){
        assertTrue(PrimeNumbersThread.isPrime(2));
        assertTrue(PrimeNumbersThread.isPrime(5));
        assertTrue(PrimeNumbersThread.isPrime(7));
        assertTrue(PrimeNumbersThread.isPrime(23));
        assertTrue(PrimeNumbersThread.isPrime(97));
        assertTrue(PrimeNumbersThread.isPrime(1847));
        assertFalse(PrimeNumbersThread.isPrime(0));
        assertFalse(PrimeNumbersThread.isPrime(1));
        assertFalse(PrimeNumbersThread.isPrime(-1));
        assertFalse(PrimeNumbersThread.isPrime(-111));
        assertFalse(PrimeNumbersThread.isPrime(15));
        assertFalse(PrimeNumbersThread.isPrime(200));
    }

    @Test
    void testGetPrimeNumbers1(){
        PrimeNumbersThread t = new PrimeNumbersThread(5, 18);
        t.start();
        assertEquals(t.getPrimeNumbers(), Arrays.asList(5, 7, 11, 13, 17));
    }

    @Test
    void testGetPrimeNumbers2(){
        PrimeNumbersThread t = new PrimeNumbersThread(111, 140);
        t.start();
        assertEquals(t.getPrimeNumbers(), Arrays.asList(113, 127, 131, 137, 139));
    }

    @Test
    void testGetPrimeNumbers3(){
        PrimeNumbersThread t = new PrimeNumbersThread(250, 500);
        t.start();
        List<Integer> primeNumbers = t.getPrimeNumbers();

        assertFalse(primeNumbers.contains(241));
        assertFalse(primeNumbers.contains(343));
        assertFalse(primeNumbers.contains(340));
        assertFalse(primeNumbers.contains(503));

        assertTrue(primeNumbers.contains(251));
        assertTrue(primeNumbers.contains(311));
        assertTrue(primeNumbers.contains(443));
        assertTrue(primeNumbers.contains(499));
    }

    @Test
    void testGetStartGetEnd(){
        PrimeNumbersThread t = new PrimeNumbersThread(5, 21);
        assertEquals(t.getStart(), 5);
        assertEquals(t.getEnd(), 21);
    }


}