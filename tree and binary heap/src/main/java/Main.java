class Main {
    public static void main(String[] args){
        //AVL avl = new AVL();
        //BinarySearchTree bst = new BinarySearchTree();

        //bst.PreOrder(bst.root);

        //bst.Search(20);

       // System.out.println(" ");
        //avl.insert(5);
        //avl.insert(10);
        //avl.insert(15);
        //avl.insert(20);
        //System.out.println(" ");
        //avl.LevelOrder();
        //avl.delete(10);
        //avl.delete(5);
        //System.out.println();
        //avl.LevelOrder();
        //bst.PreOrder(avl.root);
        BinaryHeap BP = new BinaryHeap(10);
        BP.insert(10, "Min");
        BP.insert(5, "Min");
        BP.insert(15, "Min");
        BP.insert(1, "Min");
        //BP.insert(18, "Min");
        //BP.insert(25, "Min");
        BP.LevelOrder();

    }

}
