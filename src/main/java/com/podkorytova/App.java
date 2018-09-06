package com.podkorytova;

public class App {
    public static final String ERROR_MANY = "Error! Many parameters.";
    public static final String ERROR_EMPTY = "Error! Empty parameter.";
    public static final String ERROR_NUMBER = "Error! Incorrect number.";

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                double x = Double.parseDouble(args[0]);
                double res = 1 / x;
                System.out.print(res);
            } catch (Exception e) {
                System.out.print(ERROR_NUMBER);
            }
        } else if (args.length > 1) {
            System.out.print(ERROR_MANY);
        } else {
            System.out.print(ERROR_EMPTY);
        }
    }
}
