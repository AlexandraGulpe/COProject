package com.example.coproject;

public class MyChoice {
    public static String value;
    public static String algoChoice;

    public static String getAlgoChoice() {
        return switch (algoChoice) {
            case "Bailey-Borwein-Plouffe" -> "1";
            case "Spigot" -> "2";
            case "Leibnitz" -> "3";
            default -> "none";
        };
    }

    public static void setAlgoChoice(String algoChoice) {
        MyChoice.algoChoice = algoChoice;
    }

    public static String getValue() {
        return value;
    }

    public static void setValue(String value) {
        MyChoice.value = value;
    }
}
