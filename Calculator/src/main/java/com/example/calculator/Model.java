package com.example.calculator;

public class Model {


    public static float model(float n1, float n2, String s){
        switch (s){
            case "+" :
                return n1+n2;
            case "-" :
                return n1-n2;
            case "*" :
                return n1*n2;
            case "/" :
                if (n2==0){
                    return Integer.MAX_VALUE;
                }
                return n1/n2;
        }
        return 0;
    }
}
