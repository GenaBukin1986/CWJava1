package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        LotteryToys lotteryToys = new LotteryToys();
        lotteryToys.createToy();
        lotteryToys.createToy();
        lotteryToys.createToy();
        lotteryToys.changeToyChange();
        lotteryToys.changeToyPrize();
        lotteryToys.changeToyPrize();
        lotteryToys.getToyPrize();
    }
}