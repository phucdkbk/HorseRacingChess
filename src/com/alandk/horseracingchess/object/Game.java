/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.object;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phucdk
 */
public class Game {

    private List<Player> listPlayers;
    private Player currentPlayer;
    private int currentPlayerIdx;
    private GameConfig gameConfig;

    public Game(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        listPlayers = new ArrayList<>();
        for (int i = 1; i <= gameConfig.getNumberOfPlayer(); i++) {
            Player aPlayer = new Player(i, gameConfig.getMapPlayerType().get(i), gameConfig.getMapPlayerColor().get(i));
            listPlayers.add(aPlayer);
        }
        currentPlayer = listPlayers.get(0);
        currentPlayerIdx = 0;
    }        
    
    private Player getNextMovePlayer(){
        currentPlayerIdx ++;
        return listPlayers.get(currentPlayerIdx);
    }

    public void setListPlayers(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }        

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }
       
}
