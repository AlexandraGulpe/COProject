package com.example.coproject.timing;

public class Timer implements ITimer {

    private long totalTime;
    private long currentTime;

    @Override
    public void start() {
        totalTime=0L; //resetting any previous time
        currentTime=System.nanoTime();
    }

    @Override
    public long stop() {
        long difference=System.nanoTime()-currentTime;
        totalTime=totalTime+difference;
        return totalTime;
    }

    /**
     * Saves the current elapsed time in a variable
     * without resetting any previous saved times
     */
    @Override
    public void resume() {
        currentTime=System.nanoTime();
    }

    @Override
    public long pause() {
        long difference=System.nanoTime()-currentTime;
        totalTime=totalTime+difference;
        return difference;
    }
}
