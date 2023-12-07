

import com.google.common.graph.*;
import java.awt.Color;
import java.util.Scanner;

class Main{

  public static void main(String[] args){
    // Initialize graph
    MutableNetwork<String,String> network = NetworkBuilder.directed().build();

    // Specify where data is stored
    Scanner file = ReadFile.read("data_file.txt");

    // Read file line by line
    Integer lineCount = 0;
    while (file.hasNextLine() && lineCount < 10) {
      String line = file.nextLine();
      System.out.println(line);
      String[] fields = line.split("\\s+");
      if(fields[0].equals("e")){
        if(fields[3].equals("Targeted") && fields[4].equals(""))
          network.addEdge(fields[1], fields[2], "Targeted");
      }
        if(fields[3].equals("Revenge")){
          network.addEdge(fields[1], fields[2], "Revenge Targeted");
        }
        if(fields[3].equals("Targeted") && fields[4].equals("Indirect")){
          network.addEdge(fields[1], fields[2], "Targeted Indirect");
        }
        if(fields[3].equals("Accidental")){
          network.addEdge(fields[1], fields[2], "Accidental Indirect");
        }
        if(fields[3].equals("Mercy")){
          network.addEdge(fields[1], fields[2], "Mercy");
        }
      }
      lineCount += 1;
    file.close();
    System.out.println(network);
    GraphDisplay d3 = new GraphDisplay(network);
    d3.setNodeColors(Color.GREEN);
    d3.setEdgeColors(Color.BLUE);
    for (Object n : d3.getNodeSet()) {
      System.out.println(n+" : "+d3.getLabel(n));
    }
    for (Object e : d3.getEdgeSet()) {
      System.out.println(e+" : "+d3.getLabel(e));
    }
  }
}


