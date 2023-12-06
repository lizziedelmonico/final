import com.google.common.graph.*;
import java.awt.Color;

class Main {
  public static void main(String[] args) {
    
    // Mutable graphs can be changed after we build them
    MutableGraph<String> graph =
    GraphBuilder.directed().build();


    // Network allows objects on the edges
    MutableNetwork<String,String> network = NetworkBuilder.undirected().build();
    network.addEdge("Northampton","Boston","I-90");
    network.addEdge("Northampton","New York","I-91");
    network.addEdge("New York","Boston","I-95");

    System.out.println(network);
    //System.out.println(network.incidentEdges("Northampton"));
    //System.out.println(network.successors("Northampton"));
    //System.out.println(network.incidentNodes("I-95"));
    GraphDisplay d3 = new GraphDisplay(network);
    d3.setNodeColors(Color.GREEN);
    d3.setEdgeColors(Color.BLUE);
    d3.setColor("Northampton",Color.RED);
    for (Object n : d3.getNodeSet()) {
      System.out.println(n+" : "+d3.getLabel(n));
    }
    for (Object e : d3.getEdgeSet()) {
      System.out.println(e+" : "+d3.getLabel(e));
    }
    //System.out.println(network instanceof MutableGraph);
    //System.out.println(network instanceof Graph);
    //System.out.println(network instanceof ValueGraph);
    //System.out.println(network instanceof Network);
  }
  
}