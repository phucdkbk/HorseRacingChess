/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.ai;

import com.alandk.horseracingchess.common.Constants;
import com.alandk.horseracingchess.object.Game;
import com.alandk.horseracingchess.object.Horse;
import com.alandk.horseracingchess.object.Player;

/**
 *
 * @author phucdk
 */
public class Evaluator {

    //Cach tinh ham luong gia
    //So ngua cua minh
    //Tong so ngua cua doi thu
    //Vi tri cac ngua cua minh
    //Vi tri cac ngua cua doi thu
    //Da duoc ngua cua nguoi choi khac
    //Tinh den co hoi ve chuong
    public static int evaluatorFunction(Game game) {
        int value = 0;
        value = Parameter.NUMBER_OF_HORSE_FACTOER * evalueByNumberOfHorse(game) + Parameter.HOSRE_POSITION_FACTOR * evalueByHorsePosition(game);
        return value;
    }

    private static int evalueByNumberOfHorse(Game game) {
        int value = 0;
        int countMyRunningHorse = countRunningHorse(game.getCurrentPlayer());
        int countMyFinishHorse = countFinishHorse(game.getCurrentPlayer());

        int countOtherPlayersRunningHorse = countOtherPlayersRunningHorse(game);
        int countOtherPlayersFinishHorse = countOtherPlayersFinishHorse(game);
        value = countMyRunningHorse + countMyFinishHorse - (countOtherPlayersRunningHorse + countOtherPlayersFinishHorse);
        return value;
    }

    private static int evalueByHorsePosition(Game game) {
        int value = 0;
        int valueMyRunningPosition = getValueRunningPosition(game.getCurrentPlayer());
        int valueMyFinishPosition = getValueFinishPosition(game.getCurrentPlayer());

        int valueOtherRunningPosition = getOtherValueRunningPosition(game);
        int valueOtherFinishPosition = getOtherFinishPosition(game);
        value = Parameter.POSITION_VALUE.RUNNING_FACTOR * (valueMyRunningPosition - valueOtherRunningPosition)
                + Parameter.POSITION_VALUE.FINISH_FACTOR * (valueMyFinishPosition - valueOtherFinishPosition);
        return value;
    }

    private static int countRunningHorse(Player player) {
        int count = 0;
        for (int i = 0; i < player.getListHorse().size(); i++) {
            Horse aHorse = player.getListHorse().get(i);
            if (aHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                count++;
            }
        }
        return count;
    }

    private static int countFinishHorse(Player player) {
        int count = 0;
        for (int i = 0; i < player.getListHorse().size(); i++) {
            Horse aHorse = player.getListHorse().get(i);
            if (aHorse.getPostition().getType() == Constants.POSITION.TYPE.FINISH) {
                count++;
            }
        }
        return count;
    }

    private static int countOtherPlayersRunningHorse(Game game) {
        int count = 0;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (!game.getCurrentPlayer().equals(aPlayer)) {
                count += countRunningHorse(aPlayer);
            }
        }
        return count;
    }

    private static int countOtherPlayersFinishHorse(Game game) {
        int count = 0;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (!game.getCurrentPlayer().equals(aPlayer)) {
                count += countFinishHorse(aPlayer);
            }
        }
        return count;
    }

    private static int getValueRunningPosition(Player player) {
        int value = 0;
        for (int i = 0; i < player.getListHorse().size(); i++) {
            Horse aHorse = player.getListHorse().get(i);
            if (aHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                value += aHorse.getPostition().getIndex();
            }
        }
        return value;
    }

    private static int getValueFinishPosition(Player player) {
        int value = 0;
        for (int i = 0; i < player.getListHorse().size(); i++) {
            Horse aHorse = player.getListHorse().get(i);
            if (aHorse.getPostition().getType() == Constants.POSITION.TYPE.FINISH) {
                value += aHorse.getPostition().getIndex();
            }
        }
        return value;
    }

    private static int getOtherValueRunningPosition(Game game) {
        int value = 0;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (!game.getCurrentPlayer().equals(aPlayer)) {
                value += getValueRunningPosition(aPlayer);
            }
        }
        return value;
    }

    private static int getOtherFinishPosition(Game game) {
        int value = 0;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (!game.getCurrentPlayer().equals(aPlayer)) {
                value += getValueFinishPosition(aPlayer);
            }
        }
        return value;
    }

}
