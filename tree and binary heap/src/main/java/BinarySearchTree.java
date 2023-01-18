import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;
    BinarySearchTree(){
        root = null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println(value);
            return newNode ;
        }
        else if (value<= currentNode.value){
            currentNode.left = insert(currentNode.left , value);
            return currentNode;
        }
        else{
            currentNode.right =   insert(currentNode.right , value);
            return currentNode;
        }

    }
    void insert(int value){
        root = insert(root, value);
    }
    public void PreOrder(BinaryNode node){

        if(node == null){
            return;
        }
        else{
            System.out.print(node.value + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }
    public void LevelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode present = queue.remove();
            System.out.print(present.value+ " ");
            if(present.left != null)
                queue.add(present.left);
            if (present.right!= null){
                queue.add(present.right);
            }
        }
    }
    public void Search(int x){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode present = queue.remove();
            if(present.value == x) {
                System.out.println(present.value);
                return;
            }
            if(present.left != null)
                queue.add(present.left);
            if (present.right!= null){
                queue.add(present.right);
            }
        }
        System.out.println("Not");
    }
    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left == null){
            return root;
        }
        else{
            root.left = minimumNode(root.left);
            return minimumNode(root.left);
        }
    }
    public BinaryNode DeleteNode(BinaryNode root, int value){
        if(root == null){
            System.out.println("NOt");
            return null;
        }
        else if(value < root.value){
            root.left = DeleteNode(root.left, value);
        }
        else if(value > root.value){
            root.right = DeleteNode(root.right, value);
        }
        else{
            if(root.left!=null && root.right!=null) {
                BinaryNode temp = root;
                root.value = minimumNode(root.right).value;
                root.right = DeleteNode(root.right, minimumNode(root.right).value);
            }
            else if (root.left!=null){
                root = root.left;
            }
            else if (root.right!=null){
                root = root.right;
            }
            else{
                root = null;
            }

        }
        return root;
    }

}

