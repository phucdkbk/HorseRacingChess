/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.ai;

/**
 *
 * @author phucdk
 */
public interface Parameter {

    public interface POSITION_VALUE {

        public static final int FINISH_FACTOR = 2;
        public static final int RUNNING_FACTOR = 1;

        public interface FINISH_POSITION_VALUE {

            public static final int FACTOR = 4;
        }

    }

    public static final int NUMBER_OF_HORSE_FACTOER = 1;
    public static final int HOSRE_POSITION_FACTOR = 2;
}
