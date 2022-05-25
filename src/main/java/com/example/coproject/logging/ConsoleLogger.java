package com.example.coproject.logging;

public class ConsoleLogger implements ILogger{
    @Override
    public void write(long number) {
        System.out.println(number);
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }


    /**
     * It takes as arguments a variable number of arguments, of any types
     * @param values
     * It prints them one by one on the screen
     */
    @Override
    public void write(Object... values) {
        for(var obj:values){
            System.out.println(obj+" ");
        }
    }

    @Override
    public void writeTime(String string, long value, Units unit) {
        switch (unit) {
            case Nano -> System.out.println(string + " " + value + " " + unit.toString());
            case Micro -> System.out.println(string + " " + (double) value / 1000 + " " + unit.toString());
            case Milli -> System.out.println(string + " " + (double) value / 1_000_000 + " " + unit.toString());
            case Sec -> System.out.println(string + " " + (double) value / 1_000_000_000 + " " + unit.toString());
        }
    }

    @Override
    public void close() {

    }
}