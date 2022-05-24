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
    public static String getResults(){
        CPUDigitsOfPi digitsCalc=new CPUDigitsOfPi();
        ITimer myNewTimer=new Timer();
        ILogger myNewLogger=new ConsoleLogger();
        Units myUnits=Units.Sec;


        List<String> optionsList = new ArrayList<>();
        optionsList.add("BBP Algo");
        optionsList.add("Spigot Algo");
        optionsList.add("Leibnitz Algo");

        int yourOption = 1 ;
        digitsCalc.warmUp();
        Integer[] stressArray = {50, 100, 200, 500, 1000, 2000, 5000};
        String scores = "";
        for (var it:stressArray) {
            myNewTimer.start();
            digitsCalc.run(it,yourOption);
            long timeOne = myNewTimer.stop();
            String optionInResult = null;
            switch(yourOption){
                case 1 -> optionInResult = "BBP Algo";

                case 2 -> optionInResult = "Spigot Algo";

                case 3 -> optionInResult = "Leibnitz Algo";

                default -> optionInResult = "no algo";
            }
//            optionInResult += " "+it + " stress level, time = ";
//            myNewLogger.writeTime(optionInResult, timeOne, myUnits);
//            myNewLogger.write("and score of: "+ digitsCalc.getScore(it, timeOne));
            scores += " " + digitsCalc.getScore(it,timeOne);
        }

        return scores;

    }
}