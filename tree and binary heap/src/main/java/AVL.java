import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;
    AVL(){
        root = null;
    }
    public int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    private BinaryNode rotateright(BinaryNode disbalanced){
        BinaryNode newNode = disbalanced.left;
        disbalanced.left = disbalanced.left.right;
        newNode.right = disbalanced;
        disbalanced.height = 1 + Math.max(getHeight(disbalanced.left), getHeight(disbalanced.right));
        newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
        return newNode;
    }
    private BinaryNode rotateleft(BinaryNode disbalanced){
        BinaryNode newNode = disbalanced.right;
        disbalanced.right = disbalanced.right.left;
        newNode.left = disbalanced;
        disbalanced.height = 1 + Math.max(getHeight(disbalanced.left), getHeight(disbalanced.right));
        newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
        return newNode;
    }
    public int getBalnce(BinaryNode node){
        if (node == null){
            return 0;
        }
        else{
            return getHeight(node.left) - getHeight(node.right);
        }
    }
    public BinaryNode insertNode(BinaryNode node, int nodeValue){
        if(node == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        }
        else if(nodeValue < node.value){
            node.left = insertNode(node.left, nodeValue);
        }
        else{
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));
        int balance= getBalnce(node);
        if(balance > 1 && nodeValue < node.left.value){
            return rotateright(node);
        }
        if(balance > 1 && nodeValue > node.left.value){
            node.left = rotateleft(node.left);
            return rotateright(node);
        }
        if (balance < -1 && nodeValue > node.right.value){
            return rotateleft(node);
        }
        if (balance < -1 && nodeValue < node.right.value){
            node.right = rotateright(node.right);
            return rotateleft(node);
        }
        return node;

    }
    public void insert(int value){
        root = insertNode(root, value);
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
    public BinaryNode deleteNode(BinaryNode node, int value){
        if (value > node.value){
            node.right = deleteNode(node.right, value);
        }
        else if (value < node.value){
            node.left = deleteNode(node.left, value);
        }
        else{
            if (node.left!= null && node.right!= null){
                node.value = minimumNode(node.right).value;
                node.right = deleteNode(node.right, minimumNode(node.right).value);
            }else if(node.left!=null){
                node=node.left;
            }
            else if(node.right!=null){
                node = node.right;
            }
            else{
                node =null;
            }

        }
        int balance = getBalnce(node);
        if(balance>1 && getBalnce(node.left)>=0){
            return rotateright(node);
        }
        if (balance>1 && getBalnce(node.left)<0){
            node.left=rotateleft(node.left);
            return rotateright(node);
        }
        if(balance<-1 && getBalnce(node.right)>=0){
            return rotateleft(node);
        }
        if (balance<-1 && getBalnce(node.right)<0) {
            node.right = rotateright(node.right);
            return rotateleft(node);
        }
        return node;
    }
    void delete(int value){
        root = deleteNode(root,value);
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
}
