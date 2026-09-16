import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentPrimeNumberCheckerTest {
    private static final String PATH = "savednumbers.txt";

    @BeforeEach
    void makeFile() {
        FileManager.writeInFile(Arrays.asList(2, 3, 5), PATH);
    }

    @AfterEach
    void removeFile() {
        File testFile = new File(PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void test1(){
        ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(12, 3);
        c.run();

        List<PrimeNumbersThread> threadsList = c.getList();
        List<Integer> savedPrimeNumbers = c.getSavedPrimeNumbers();
        List<Integer> allPrimeNumbers = c.getAllPrimeNumbers();

        assertEquals(threadsList.size(), 3);
        assertEquals(savedPrimeNumbers, Arrays.asList(2, 3, 5));
        assertEquals(allPrimeNumbers, Arrays.asList(2, 3, 5, 7, 11));
    }

    @Test
    void test2(){
        ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(31, 5);
        c.run();

        List<PrimeNumbersThread> threadsList = c.getList();
        List<Integer> savedPrimeNumbers = c.getSavedPrimeNumbers();
        List<Integer> allPrimeNumbers = c.getAllPrimeNumbers();

        assertEquals(threadsList.size(), 5);
        assertEquals(savedPrimeNumbers, Arrays.asList(2, 3, 5));
        assertEquals(allPrimeNumbers, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    }

    @Test
    void test3(){
        ConcurrentPrimeNumberChecker c = new ConcurrentPrimeNumberChecker(3, 1);
        c.run();

        List<PrimeNumbersThread> threadsList = c.getList();
        List<Integer> savedPrimeNumbers = c.getSavedPrimeNumbers();
        List<Integer> allPrimeNumbers = c.getAllPrimeNumbers();

        assertEquals(threadsList.size(), 1);
        assertEquals(savedPrimeNumbers, Arrays.asList(2, 3));
        assertEquals(allPrimeNumbers, Arrays.asList(2, 3));
    }
}