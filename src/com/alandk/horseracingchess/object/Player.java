/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.object;

import com.alandk.horseracingchess.common.CommonUtils;
import com.alandk.horseracingchess.common.Constants;
import com.alandk.horseracingchess.common.DiceUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phucdk
 */
public class Player {

    private int id;
    private List<Horse> listHorses;
    private int type;
    private int color;
    private int indexSegment;
    private int countRunningHorse;

    public Player(int id, int type, int color) {
        this.id = id;
        listHorses = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            listHorses.add(new Horse(i));
        }
        this.color = color;
        this.indexSegment = CommonUtils.getIndexSegmentByColor(color);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Horse> getListHorse() {
        return listHorses;
    }

    public void setListHorse(List<Horse> listHorse) {
        this.listHorses = listHorse;
    }

    private Horse chooseHorse(int step, Game game) {
        for (int i = 0; i < listHorses.size(); i++) {
        }
        return listHorses.get(1);
    }

    private List<Horse> getListCanMoveHorse(Game game, int step) {
        List<Horse> listCanMoveHorse = new ArrayList<>();
        for (int i = 0; i < listHorses.size(); i++) {
            if (CommonUtils.checkCanMoveByAHorse(game, step, listHorses.get(i))) {
                listCanMoveHorse.add(listHorses.get(i));
            }
        }
        return listCanMoveHorse;
    }

    private void move(Game game, int step, Horse aHorse) {
        Position position = aHorse.getPostition();
        switch (position.getType()) {
            case Constants.POSITION.TYPE.START:
                position.setType(Constants.POSITION.TYPE.RUNNING);
                position.setIndex(Constants.POSITION.INDEX.START_RUNNING_INDEX);
                break;
            case Constants.POSITION.TYPE.RUNNING:
                if (CommonUtils.canKickOtherPlayer(game, step, aHorse)) {
                    CommonUtils.kickOtherHorse(game, step, aHorse);
                } else {
                    CommonUtils.runHorse(position, step);
                }
        }
    }

    private int getStep() {
        return DiceUtils.getNumber();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIndexSegment() {
        return indexSegment;
    }

    public void setIndexSegment(int indexSegment) {
        this.indexSegment = indexSegment;
    }

    public int getCountRunningHorse() {
        return countRunningHorse;
    }

    public void setCountRunningHorse(int countRunningHorse) {
        this.countRunningHorse = countRunningHorse;
    }        

}
