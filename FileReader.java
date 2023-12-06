import java.util.Scanner;
import com.google.common.graph.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader{

    public static void main(String[] args) {
    String filename = (args.length > 0) ? args[0] : "data_file.txt";
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      String line = file.nextLine();
      String[] fields = line.split("\\s+");
      String type = fields[1];
      if(type.equals("n")){
        String tribute_num = fields[2];
        String tribute_name = fields[3];
      }
      if(type.equals("e")){
        String killer = fields[2];
        String dead = fields[3];
        String cause = fields[4];
      }
      if(type.equals("p")){
        String num_nodes = fields[2];
        String num_edges = fields[3];
      }

    }
    file.close();
  }


}