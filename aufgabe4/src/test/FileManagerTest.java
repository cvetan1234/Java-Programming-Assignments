import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private static final String PATH = "testfile.txt";

    @BeforeEach
    void makeFile() {
        FileManager.writeInFile(Arrays.asList(1, 2, 3, 4, 5), PATH);
    }

    @AfterEach
    void removeFile() {
        File testFile = new File(PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testReadFromFile() {
        List<Integer> numbersRead = FileManager.readFromFile(PATH);
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expectedNumbers, numbersRead);
    }

    @Test
    void testWriteInFile() {
        List<Integer> numbersToWrite = Arrays.asList(10, 12, 15);
        FileManager.writeInFile(numbersToWrite, PATH);

        List<Integer> numbersRead = FileManager.readFromFile(PATH);
        assertEquals(numbersToWrite, numbersRead);
    }

    @Test
    void testResetFile() {
        FileManager.resetFile(PATH);
        List<Integer> numbersRead = FileManager.readFromFile(PATH);
        assertTrue(numbersRead.isEmpty());
    }
}