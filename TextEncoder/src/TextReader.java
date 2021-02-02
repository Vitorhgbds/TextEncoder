import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {

    public static String readTextOf(String fileName){
        System.out.println("Reading file...\n");

        Path filePath = Paths.get("src\\" + fileName);
        StringBuilder textInOneLine = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("utf8"))){
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("you message is: " + line);
                line = line.replaceAll("[^a-zA-Z0-9]"," ");
                textInOneLine.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error in reading file: " + e.getMessage());
        }

        return textInOneLine.toString();
    }

    public static boolean writeSolution(String solution){
        System.out.println("Writing a solution...\n");
        try{
            FileWriter fw=new FileWriter("src\\out.txt");
            fw.write(solution);
            fw.close();
        }catch(Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }
}
