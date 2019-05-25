package com.boast.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext("normal");
        context.getResult(35);
    }
}
