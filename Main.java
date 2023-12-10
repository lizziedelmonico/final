import java.util.Set;
import com.google.common.graph.*;
import java.awt.Color;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Main{

  /**
   * Calculates the number of nodes in the graph from the file provided
   * @return  The number of nodes in the graph
   */
  public static int calculateNodes(){
    
    int node_count = 0;
    Scanner file = ReadFile.read("data_file.txt");
    
    while(file.hasNextLine()){
      String line = file.nextLine();
      String[] fields = line.split("\\s");

      if(fields[0].equals("n")){
        node_count++;
      }

    }
    return node_count;
  }

  /**
   * Calculates the number of edges in the graph from the file provided
   * @return  The number of edges in the graph
   */
  public static int calculateEdges(){
    int edge_count = 0;
    Scanner file = ReadFile.read("data_file.txt");
    
    while(file.hasNextLine()){
      String line = file.nextLine();
      String[] fields = line.split("\\s");

      if(fields[0].equals("e")){
        edge_count++;
      }

    }
    return edge_count;
  }

  /**
   * Calculates the maximum outward degree in the graph 
   * @param network   The graph created using the file provided
   * @return  The maximum outward degree in the graph
   */
  public static int maxDegree(MutableValueGraph<String,String> network){
    int degree_max = 0;

    Set<Object> nodes = new HashSet(network.nodes()); 
    Set<Integer> all_kills = new HashSet();

    for(Object node : nodes){
      int kill_count = network.outDegree((String)node);
      all_kills.add(kill_count);
    }

    degree_max = Collections.max(all_kills);

    return degree_max;

  }

  /**
   * Calculates the average outward degree in the file (as a float to be more precise)
   * @param network   The graph created using the file provided
   * @return  The averge outward degree in the file 
   */
  public static float averageDegree(MutableValueGraph<String,String> network){
    float degree_avrg;

    Set<Object> nodes = new HashSet(network.nodes());
    Set<Integer> all_kills = new HashSet();

    for(Object node : nodes){
      int kill_count = network.outDegree((String) node);
      all_kills.add(kill_count);
    }

    float sum = 0;
    
    for(float i : all_kills){
      sum += 1;
    }
    float num_nodes = network.nodes().size();
    degree_avrg = sum/num_nodes;
    
    return degree_avrg;
  }

  /**
   * Finds the outward degree (aka the number of kills) of a specific node (tribute) as specified by the user
   * @param network   The graph created using the file provided
   * @return  The outward degree of the specified node
   */
  public static int degree(MutableValueGraph<String,String> network){

    Scanner user = new Scanner(System.in);
    System.out.println("Which tribute would you like to assess?");
    String input = user.nextLine();

    int degree = network.outDegree(input);
  
    return degree;
  }

  // public HashMap<Integer, String> killRankings(MutableValueGraph<String,String> network, HashMap<String,String> tributes){
    
      
  // }

  
  /**
   * Reads the file, creates the graph network, and allows the user to choose their next moves
   * @param args  The arguments provided
   */
  public static void main(String[] args){
    // Initialize graph
    MutableValueGraph<String,String> network = ValueGraphBuilder.directed().build();
    HashMap<String, String> tributes = new HashMap<>();


    // Specify where data is stored
    Scanner file = ReadFile.read("data_file.txt");

    while (file.hasNextLine()) {
      String line = file.nextLine();
      String[] fields = line.split("\\s+");
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
     System.out.println(maxDegree(network));
     System.out.println(averageDegree(network));
     System.out.println(degree(network));
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


