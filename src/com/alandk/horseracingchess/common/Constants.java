/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.common;

/**
 *
 * @author phucdk
 */
public interface Constants {
    
    public static final int DIFF_IDX = 13;

    public interface HORSE {
    }

    public interface POSITION {

        public interface TYPE {

            public static final int START = 1;
            public static final int RUNNING = 2;
            public static final int FINISH = 3;

        }

        public interface INDEX {

            public static final int START_RUNNING_INDEX = -1000;
            public static final int FINISH_RUNNING_INDEX = 1000;
            public static final int MAX_INDEX_WHEN_END_RUNNING = 56;
        }
    }

    public interface PLAYER {

        public interface TYPE {

            public static final int COMPUTER = 1;
            public static final int HUMAN = 2;
        }

        public interface COLOR {

            public static final int RED = 1;
            public static final int BLUE = 2;
            public static final int GREEN = 3;
            public static final int YELLOW = 4;
        }
    }
}
