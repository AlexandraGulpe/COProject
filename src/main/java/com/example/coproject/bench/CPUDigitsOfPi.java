package com.example.coproject.bench;

import com.example.coproject.bench.IBenchmark;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CPUDigitsOfPi implements IBenchmark {
    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {
        int option=(Integer) params[0];
        int choice = (Integer) params[1];

        switch (choice) {
            case 1 -> {
                BigDecimal one, two, four, five, six, eight, sixteen, iMod, firstTwo, secondTwo, iterationStep;
                BigDecimal res1, res2, res3, res4, res5;
                BigDecimal result = new BigDecimal(0);
                for (int i = 0; i < option; i++) {
                    res1 = new BigDecimal(0);
                    res2 = new BigDecimal(0);
                    res3 = new BigDecimal(0);
                    res4 = new BigDecimal(0);
                    res5 = new BigDecimal(0);
                    one = new BigDecimal(1);
                    two = new BigDecimal(2);
                    four = new BigDecimal(4);
                    five = new BigDecimal(5);
                    six = new BigDecimal(6);
                    eight = new BigDecimal(8);
                    sixteen = new BigDecimal(16);
                    iMod = new BigDecimal(i);
                    firstTwo = new BigDecimal(0);
                    secondTwo = new BigDecimal(0);
                    iterationStep = new BigDecimal(0);

                    //this is 1/16^k
                    res1 = one.divide((sixteen.pow(i)), new MathContext(1000, RoundingMode.HALF_DOWN));

                    //this is 4/(8k+1)
                    res2 = four.divide((eight.multiply(iMod).add(one)), new MathContext(1000, RoundingMode.HALF_DOWN));

                    //this is 2/(8k+4)
                    res3 = two.divide((eight.multiply(iMod).add(four)), new MathContext(1000, RoundingMode.HALF_DOWN));

                    //this is 1/(8k+5)
                    res4 = one.divide((eight.multiply(iMod).add(five)), new MathContext(1000, RoundingMode.HALF_DOWN));

                    //this is 1/(8k+6)
                    res5 = one.divide((eight.multiply(iMod).add(six)), new MathContext(1000, RoundingMode.HALF_DOWN));

                    //first two diff
                    firstTwo = res2.subtract(res3);

                    //-third-fourth
                    secondTwo = (res4.negate()).subtract(res5);

                    iterationStep = res1.multiply((firstTwo.add(secondTwo)));

                    result = result.add(iterationStep);

                }
                //  System.out.println("BBP algo: "+result);
            }
            case 2 -> {
                BigDecimal my_result = new BigDecimal(0);
                BigDecimal two_sec = new BigDecimal(2);
                for (int i = 0; i < option; i++) {
                    BigDecimal one_option = getFactorial(i);
                    BigDecimal result1 = one_option.pow(2);
                    BigDecimal result2 = two_sec.pow(i + 1);
                    BigDecimal result_upp = result1.multiply(result2);
                    BigDecimal result_down = getFactorial(2 * i + 1);
                    //System.out.println("result down "+result_down);
                    BigDecimal iteration_step = result_upp.divide(result_down, new MathContext(1000, RoundingMode.HALF_DOWN));
                    my_result = my_result.add(iteration_step);
                }
                // System.out.println("Approx result for Spigot: " + my_result);
            }
            case 3 -> {
                BigDecimal result_leib = new BigDecimal(0);
                BigDecimal two_third = new BigDecimal(2);
                BigDecimal minus_one = new BigDecimal(-1);
                BigDecimal one = new BigDecimal(1);

                for (int i = 0; i < option; i++){
                    BigDecimal rez_one = minus_one.pow(i);
                    BigDecimal iMod = new BigDecimal(i);
                    BigDecimal rez_two = two_third.multiply(iMod).add(one);
                    BigDecimal iteration_step = rez_one.divide(rez_two, new MathContext(1000, RoundingMode.HALF_DOWN));
                    result_leib = result_leib.add(iteration_step);
                }
                //System.out.println("Approx result for Leibnitz: " + result_leib.multiply(new BigDecimal(4)));
            }
            default -> System.out.println("no choice");
        }

        // System.out.println("An approximate result is: "+result);
    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp(){
        run(5_000,1);
    }

    private BigDecimal getFactorial(int i){
        BigDecimal ret_val = new BigDecimal(1);
        BigDecimal jmod;
        if(i <= 1) return new BigDecimal(1);
        else {
            for (int j = i; j >= 2; j--) {
                jmod = new BigDecimal(j);
                ret_val = ret_val.multiply(jmod);
            }
            return ret_val;
        }
    }

    public double getScore (int iterations, double time){
        return Math.sqrt((double) iterations / (time/1_000_000_000.0));
    }
}