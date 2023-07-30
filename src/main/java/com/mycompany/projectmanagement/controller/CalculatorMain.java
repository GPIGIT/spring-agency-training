package com.mycompany.projectmanagement.controller;

public class CalculatorMain {


    public static void main(String[] args) {
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(3.5,3.5);
        System.out.println(result);
    }
}
