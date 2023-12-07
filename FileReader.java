import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader{

    public static Scanner read(String filename) {
    filename = "data_file.txt";
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
    return file;
  }


}