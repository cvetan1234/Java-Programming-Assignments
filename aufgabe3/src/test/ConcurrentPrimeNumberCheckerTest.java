import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ConcurrentPrimeNumberCheckerTest {
    @Test
    void test1(){
        ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(20, 2);
        c.run();
        assertIterableEquals(c.getAllPrimeNumbers(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        List<PrimeNumbersThread> list = c.getThreadsList();
        assertEquals(list.size(), 2);

        PrimeNumbersThread t1 = list.get(0);
        assertEquals(t1.getStart(), 1);
        assertEquals(t1.getEnd(), 10);
        assertIterableEquals(t1.getPrimeNumbers(), Arrays.asList(2, 3, 5, 7));

        PrimeNumbersThread t2 = list.get(1);
        assertEquals(t2.getStart(), 11);
        assertEquals(t2.getEnd(), 20);
        assertIterableEquals(t2.getPrimeNumbers(), Arrays.asList(11, 13, 17, 19));
    }

    @Test
    void test2(){
        ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(100, 3);
        c.run();
        assertIterableEquals(c.getAllPrimeNumbers(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));

        List<PrimeNumbersThread> list = c.getThreadsList();
        assertEquals(list.size(), 3);

        PrimeNumbersThread t1 = list.get(0);
        assertEquals(t1.getStart(), 1);
        assertEquals(t1.getEnd(), 34);
        assertIterableEquals(t1.getPrimeNumbers(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

        PrimeNumbersThread t2 = list.get(1);
        assertEquals(t2.getStart(), 35);
        assertEquals(t2.getEnd(), 67);
        assertIterableEquals(t2.getPrimeNumbers(), Arrays.asList(37, 41, 43, 47, 53, 59, 61, 67));

        PrimeNumbersThread t3 = list.get(2);
        assertEquals(t3.getStart(), 68);
        assertEquals(t3.getEnd(), 100);
        assertIterableEquals(t3.getPrimeNumbers(), Arrays.asList(71, 73, 79, 83, 89, 97));
    }



}