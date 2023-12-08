

import com.google.common.graph.*;
import java.awt.Color;
import java.util.Scanner;
import java.util.HashMap;

class Main{

  public static void main(String[] args){
    // Initialize graph
    MutableValueGraph<String,String> network = ValueGraphBuilder.directed().build();
    HashMap<String, String> tributes = new HashMap<>();


    // Specify where data is stored
    Scanner file = ReadFile.read("data_file.txt");

    // Read file line by lin
    while (file.hasNextLine()) {
      String line = file.nextLine();
      String[] fields = line.split("\\s+");
      System.out.println(fields[0]);
      if(fields[0].equals("n")){
        network.addNode(fields[2]);
        tributes.put(fields[1], fields[2]);
      }
       if(fields[0].equals("e")){
        String person1 = fields[1];
        String person2 = fields[2];
        System.out.println(fields.length);
          if(fields[3].equals("Targeted")){
            if(fields.length == 4){
              network.putEdgeValue(tributes.get(person1), tributes.get(person2), "Targeted");
            }
            else if(fields.length > 4){
              network.putEdgeValue(tributes.get(person1), tributes.get(person2), "Targeted Indirect");
            }

          }
           else if(fields[3].equals("Revenge")){
             network.putEdgeValue(tributes.get(person1), tributes.get(person2), "Revenge Targeted");
           }
           else if(fields[3].equals("Accidental")){
             network.putEdgeValue(tributes.get(person1), tributes.get(person2), "Accidental Indirect");
           }
           else if(fields[3].equals("Mercy")){
             network.putEdgeValue(tributes.get(person1), tributes.get(person2), "Mercy");
           }
      }}
      file.close();
     System.out.println(network);
     GraphDisplay d3 = new GraphDisplay(network);
     d3.setNodeColors(Color.PINK);
     d3.setEdgeColors(Color.BLACK);
     for (Object n : d3.getNodeSet()) {
       System.out.println(n+" : "+d3.getLabel(n));
     }
    for (Object e : d3.getEdgeSet()) {
      System.out.println(e+" : "+d3.getLabel(e));
    }
  }
}


