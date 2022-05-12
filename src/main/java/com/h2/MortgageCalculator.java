package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate){
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;

    }

    private int getNumberOfPayments(){
        return this.termInYears * 12;
    }

    private float getMonthlyInterestRate(){
        float interestRate = this.annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment(){
        long P = this.loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
        this.monthlyPayment = M;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());

    }
}
