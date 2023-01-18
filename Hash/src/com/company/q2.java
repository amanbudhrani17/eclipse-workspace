package com.company;

import java.util.*;

class ab {
    int num, st, fi, pi;
}

class method {
    LinkedList<ab> ll;
    int st;

    void method2(ArrayList<ArrayList<Integer>> adj, int ver, int vis[], int par) {

        this.st++;
        vis[ver] = 1;
        ab v1 = new ab();
        v1.num = ver;
        v1.st = st;
        v1.pi = par;
        for (int i = 0; i < adj.get(ver).size(); i++) {
            if (vis[adj.get(ver).get(i)] == 1)
                continue;
            method2(adj, adj.get(ver).get(i), vis, ver);
        }
        this.st++;
        v1.fi = st;
        ll.add(0, v1);
    }
}

class q2 {

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), ed;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        int vis[] = new int[1000];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
            vis[i] = 0;
        }
        ed = sc.nextInt();
        int a, b;
        for (int i = 0; i < ed; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            adj.get(a).add(b);
        }
        method ne = new method();
        ne.ll = new LinkedList<ab>();
        ne.st = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 1)
                continue;
            ne.method2(adj, i, vis, -1);
        }
        String stn[] = { "Shirt", "tie", "jacket", "watch", "belt",  "pants","Undershots", "shocks", "Shoes" };
        for (ab x : ne.ll) {
            System.out.print(stn[x.num] + " " + "st= " + x.st + " fi= " + x.fi + " P= ");
            if (x.pi != -1) {
                System.out.println(stn[x.pi]);
            } else {
                System.out.println();
            }
        }
        sc.close();
    }
}
/*
9
9
0 1
1 2
0 4
4 2
6 4
6 8
5 6
5 8
7 8
 */