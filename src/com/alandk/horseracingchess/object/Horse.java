/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.object;

import com.alandk.horseracingchess.common.Constants;

/**
 *
 * @author phucdk
 */
public class Horse {

    private Position postition;
    private int id;

    public Horse(int id) {
        this.id = id;
        this.postition = new Position(Constants.POSITION.TYPE.START);
    }

    public Position getPostition() {
        return postition;
    }

    public void setPostition(Position postition) {
        this.postition = postition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
