
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\budhr\\eclipse-workspace\\LabAlgo\\src\\Users.txt");
        Scanner sc = new Scanner(file);
        int size = sc.nextInt();
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        for (int i = 0; i<size; i++){
            String s = sc.next();
            nodeList.add(new GraphNode(s,i));
//            System.out.print(s);
        }
        Graph graph = new Graph(nodeList);
        System.out.println(sc.nextLine());
        while (sc.hasNext()){
            String s = sc.next();
//            System.out.print(s);
            String a = sc.next();
//            System.out.println(a);
            graph.addUndirectedEdge(getIndex(s,size,nodeList),getIndex(a,size,nodeList));
        }
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());

//        nodeList.add(new GraphNode("A",0));
//        nodeList.add(new GraphNode("B",1));
//        nodeList.add(new GraphNode("C",2));
//        nodeList.add(new GraphNode("D",3));
//
//        Graph graph = new Graph(nodeList);
//        graph.addUndirectedEdge(0,1);
//        graph.addUndirectedEdge(0,2);
//        graph.addUndirectedEdge(0,3);
//        graph.addUndirectedEdge(1,3);
//        graph.addUndirectedEdge(2,3);
//        System.out.println(graph.toString());
//        System.out.println();
//        System.out.println();
//       graph.topologicalSort();
//        graph.BFSForSssp(nodeList.get(0), nodeList.get(6));
        ArrayList<GraphNode> name= graph.Lab();
        Collections.sort(name);
//        System.out.println(name.size());
//        System.out.println();
//        System.out.println();
//        graph.toString();
//        for (int i = 0; i< name.size(); i++){
//            System.out.print(name.get(i).name);
//        }
//        System.out.println();
//        System.out.println(graph.toString());
        try {
            FileWriter myWriter = new FileWriter("Output.txt");
            myWriter.write(name.size() + "\n");
            for (int i = 0; i<name.size(); i++){
                myWriter.write(name.get(i).name + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static int getIndex(String s, int size, ArrayList<GraphNode> nodeList){
        for (int i = 0; i<size; i++){
            if (nodeList.get(i).name.equals(s)){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}

