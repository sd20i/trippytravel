package com.helper;

import java.util.Random;

public class RandomObject {
    Random rand = new Random();

    public int pickRandomObject(int arrayLength){
        int randomNum = rand.nextInt((arrayLength - 0)) + 0;
        return randomNum;
    }

    public int randomPrice(){
        int randomInt = rand.nextInt((2500 - 50));
        return randomInt;
    }
}
