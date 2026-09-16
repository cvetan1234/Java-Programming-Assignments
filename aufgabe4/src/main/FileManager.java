import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void writeInFile(List<Integer> l, String path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path));){
            for (Integer i : l){
                writer.write(String.valueOf(i));
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println("Problem by writing in file");
            e.printStackTrace();
        }
    }

    public static List<Integer> readFromFile(String path){
        List<Integer> returnList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path));){
            String line;
            while((line = reader.readLine()) != null){
                returnList.add(Integer.parseInt(line));
            }
        }catch (Exception e){
            System.out.println("Problem by reading of file");
            e.printStackTrace();
        }
        return returnList;
    }

    public static void resetFile(String path) {
        File file = new File(path);
        try {
            file.delete();
            file.createNewFile();
            System.out.println("File is successfully reset");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
