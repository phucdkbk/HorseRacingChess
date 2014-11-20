/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.common;

import java.util.Random;

/**
 *
 * @author phucdk
 */
public class DiceUtils {

    public static int getNumber() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
