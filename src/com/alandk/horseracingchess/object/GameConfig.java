/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.object;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phucdk
 */
public class GameConfig {

    private int numberOfPlayer;
    private int numberOfHumanPlayer;

    private Map<Integer, Integer> mapPlayerColor;
    private Map<Integer, Integer> mapPlayerType;

    public GameConfig() {
        mapPlayerColor = new HashMap<>();
        mapPlayerType = new HashMap<>();
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public int getNumberOfHumanPlayer() {
        return numberOfHumanPlayer;
    }

    public void setNumberOfHumanPlayer(int numberOfHumanPlayer) {
        this.numberOfHumanPlayer = numberOfHumanPlayer;
    }

    public Map<Integer, Integer> getMapPlayerColor() {
        return mapPlayerColor;
    }

    public void setMapPlayerColor(Map<Integer, Integer> mapPlayerColor) {
        this.mapPlayerColor = mapPlayerColor;
    }

    public Map<Integer, Integer> getMapPlayerType() {
        return mapPlayerType;
    }

    public void setMapPlayerType(Map<Integer, Integer> mapPlayerType) {
        this.mapPlayerType = mapPlayerType;
    }

}
