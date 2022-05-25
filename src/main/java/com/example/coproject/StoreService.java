package com.example.coproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StoreService {
    public static void appendData(int choice, int stressLevel, String result){
        String intoFile = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String algo = "";
        switch(choice){
            case 1 -> {algo = "Bailey-Borwein-Plouffe";}
            case 2 -> {algo = "Spigot";}
            case 3 -> {algo = "Leibnitz";}
            default -> {algo = "none";}
        }
        intoFile += dtf.format(now) + " " + algo + " "+stressLevel+ " "+result+ " \n";


        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("database.txt",true));
            out.write(intoFile);
            out.close();
        }catch (IOException e){
            System.out.println("Exception at file occurred"+ e.getMessage());
        }
    }
}
