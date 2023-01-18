
import java.util.*;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        s.append("   ");
//        for (int i = 0; i < nodeList.size(); i++) {
//            s.append(nodeList.get(i).name + " ");
//        }
//        s.append("\n");
//        for (int i = 0; i < nodeList.size(); i++) {
//            s.append(nodeList.get(i).name + ": ");
//            for (int j : adjacencyMatrix[i]) {
//                s.append((j) + " ");
//            }
//            s.append("\n");
//        }
//        return s.toString();
//    }
public String toString() {
    for (int i = 0; i<adjacencyMatrix.length; i++){
        for (int j = 0; j<adjacencyMatrix.length; j++){
            System.out.print(adjacencyMatrix[i][j]);
        }
        System.out.println();
    }
    return "ab" ;
}
    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbour = new ArrayList<GraphNode>();
        int index = node.index;
        for (int i = 0; i<adjacencyMatrix.length; i++){
            if (adjacencyMatrix[index][i]==1){
                neighbour.add(nodeList.get(i));
            }
        }
        return neighbour;
    }
    ArrayList<GraphNode> Lab(){
        HashSet<GraphNode> set = new HashSet<>();
        ArrayList<GraphNode> S = new ArrayList<>();
        for (int i = 0; i<adjacencyMatrix.length; i++){
            for(int j = 0; j<adjacencyMatrix.length; j++){
                if (adjacencyMatrix[i][j] == 1){
                    method(i,j,S);
                }
            }
        }
        return S;
    }
    void method(int i, int j, ArrayList<GraphNode> S){

//        if(!set.contains(nodeList.get(i))) {
            S.add(nodeList.get(i));
//        }
        ArrayList<GraphNode> nodeList1 = getNeighbors(nodeList.get(i));
        for (GraphNode node : nodeList1) {
            adjacencyMatrix[i][node.index] = 0;
//                System.out.print(node.index);
            adjacencyMatrix[node.index][i] = 0;
        }
//        set.add(nodeList.get(j
        ArrayList<GraphNode> nodeList2 = getNeighbors(nodeList.get(i));
        for (GraphNode node : nodeList2) {
            adjacencyMatrix[node.index][j] = 0;
            adjacencyMatrix[j][node.index] = 0;
        }
    }

}
