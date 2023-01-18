package com.company;// Java program to print Postorder traversal from
// given Inorder and Preorder traversals.
import java.util.*;

class UserMainCode {
    static int preIndex = 0;
    static List<Integer> list = new ArrayList<>();
    void UserMainCode(int[] in, int[] pre, int inStrt,
                      int inEnd, HashMap<Integer, Integer> hm)
    {
        if (inStrt > inEnd)
            return;

        int inIndex = hm.get(pre[preIndex++]);

        UserMainCode(in, pre, inStrt, inIndex - 1, hm);

        UserMainCode(in, pre, inIndex + 1, inEnd, hm);

        list.add(in[inIndex]);

    }

    void printPostMain(int[] in, int[] pre)
    {
        int n = pre.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++)
            hm.put(in[i], i);

        UserMainCode(in, pre, 0, n-1, hm);
    }

    // Driver code
    public static void main(String ars[])
    {
        int in[] = { 4, 2, 5, 1, 3};
        int pre[] = { 1, 2, 4, 5, 3};
        UserMainCode tree = new UserMainCode();
        tree.printPostMain(in, pre);
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size();i++){
            arr[i] = list.get(i);
            System.out.print(arr[i]+" ");
        }
    }
}
