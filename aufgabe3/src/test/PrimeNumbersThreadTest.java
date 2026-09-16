import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumbersThreadTest {
    @Test
    void testIsPrime(){
        assertTrue(PrimeNumbersThread.isPrime(2));
        assertTrue(PrimeNumbersThread.isPrime(3));
        assertTrue(PrimeNumbersThread.isPrime(5));
        assertTrue(PrimeNumbersThread.isPrime(13));
        assertTrue(PrimeNumbersThread.isPrime(71));
        assertTrue(PrimeNumbersThread.isPrime(1009));
        assertFalse(PrimeNumbersThread.isPrime(0));
        assertFalse(PrimeNumbersThread.isPrime(1));
        assertFalse(PrimeNumbersThread.isPrime(-1));
        assertFalse(PrimeNumbersThread.isPrime(-7));
        assertFalse(PrimeNumbersThread.isPrime(20));
        assertFalse(PrimeNumbersThread.isPrime(1000));
    }

    @Test
    void testGetPrimeNumbers1(){
        PrimeNumbersThread t = new PrimeNumbersThread(1, 20);
        t.start();
        assertIterableEquals(t.getPrimeNumbers(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    }

    @Test
    void testGetPrimeNumbers2(){
        PrimeNumbersThread t = new PrimeNumbersThread(20, 40);
        t.start();
        assertIterableEquals(t.getPrimeNumbers(), Arrays.asList(23, 29, 31, 37));
    }

    @Test
    void testGetPrimeNumbers3(){
        PrimeNumbersThread t = new PrimeNumbersThread(300, 1000);
        t.start();
        List<Integer> primeNumbers = t.getPrimeNumbers();

        assertFalse(primeNumbers.contains(301));
        assertFalse(primeNumbers.contains(293));
        assertFalse(primeNumbers.contains(992));
        assertFalse(primeNumbers.contains(1009));

        assertTrue(primeNumbers.contains(307));
        assertTrue(primeNumbers.contains(571));
        assertTrue(primeNumbers.contains(683));
        assertTrue(primeNumbers.contains(997));
    }

    @Test
    void testGetStartGetEnd(){
        PrimeNumbersThread t = new PrimeNumbersThread(10, 101);
        assertEquals(t.getStart(), 10);
        assertEquals(t.getEnd(), 101);
    }
}