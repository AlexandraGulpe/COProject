package com.example.coproject.testbench;



import com.example.coproject.bench.CPUDigitsOfPi;
import com.example.coproject.logging.ConsoleLogger;
import com.example.coproject.logging.ILogger;
import com.example.coproject.logging.Units;
import com.example.coproject.timing.ITimer;
import com.example.coproject.timing.Timer;

import java.util.ArrayList;
import java.util.List;

public class TestCpuDigitsOfPi  {
    public static String getResults(int stressLevel, int choice){
        //stress Level shall be 50, 100, 200, 500, 1000, 2000, 5000
        // choice shall be 1- BBP, 2-Spigot, 3-Leibnitz

        CPUDigitsOfPi digitsCalc=new CPUDigitsOfPi();
        ITimer myNewTimer=new Timer();
        digitsCalc.warmUp();
        String scores = "";
        myNewTimer.start();
        digitsCalc.run(stressLevel,choice);
        long timeOne = myNewTimer.stop();
        String optionInResult = null;
        double scoreObtained = digitsCalc.getScore(stressLevel,timeOne);
        scores += " " + String.format("%.2f", scoreObtained);
        return scores;
        }


    }
