/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alandk.horseracingchess.object;

/**
 *
 * @author phucdk
 */
public class Position {
    private int type;
    private int index;

    public Position(int type) {
        this.type = type;
        this.index = -1;
    }        

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
