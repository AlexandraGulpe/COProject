package com.example.coproject;

public class OurAverages {
    public static String getAverages(int StressLevel, int choice){
        if(choice == 1)  {
            switch(StressLevel){
                case 50 -> {return "30.74";}
                case 100 -> {return "34.28";}
                case 200 -> {return "37.16";}
                case 500 -> {return "51.05";}
                case 1000 -> {return "74.88";}
                case 2000 -> {return "85.51";}
                case 5000 -> {return "91.72";}
                default -> {return "0";}
            }
        }
        else if(choice == 2){
            switch(StressLevel){
                case 50 -> {return "98,94";}
                case 100 -> {return "137.75";}
                case 200 -> {return "110,71";}
                case 500 -> {return "64.51";}
                case 1000 -> {return "43.04";}
                case 2000 -> {return "23.15";}
                case 5000 -> {return "8.86";}
                default -> {return "0";}
                }
        }
        else if(choice == 3){
            switch(StressLevel){
                case 50 -> {return "112.53";}
                case 100 -> {return "148.68";}
                case 200 -> {return "220.63";}
                case 500 -> {return "274.35";}
                case 1000 -> {return "308.61";}
                case 2000 -> {return "350.4";}
                case 5000 -> {return "390.36";}
                default -> {return "0";}
            }
        }
        else return "0";
    }

}
