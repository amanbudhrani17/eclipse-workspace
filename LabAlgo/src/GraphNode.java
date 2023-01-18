
public class GraphNode implements Comparable<GraphNode> {
    String name;
    int index;
    public boolean isVisited = false;
    GraphNode parent = null;
    public GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(GraphNode o) {
        String s = this.name;
        String a = o.name;
        String[] as = s.split("_", 2);
        String[] aa = a.split("_", 2);
        return Integer.parseInt(as[0]) - Integer.parseInt(aa[0]);
    }
}
