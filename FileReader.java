import java.util.Scanner;
import com.google.common.graph.*;
import java.awt.Color;

public class FileReader{

    public void readFile(){
        Scanner scanner = new Scanner(System.in);
        MutableGraph<String> graph =
        GraphBuilder.directed().build();
        while(scanner.hasNextLine())
                String currentLine = scanner.nextLine();
                String lowercase_line = currentLine.toLowerCase();
                String[] words = lowercase_line.split(" ");  
                for(String a : words)
                
         scanner.close();
    }

}