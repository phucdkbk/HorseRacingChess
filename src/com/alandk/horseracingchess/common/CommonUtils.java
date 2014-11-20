/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.common;

import com.alandk.horseracingchess.object.Game;
import com.alandk.horseracingchess.object.Horse;
import com.alandk.horseracingchess.object.Player;
import com.alandk.horseracingchess.object.Position;

/**
 *
 * @author phucdk
 */
public class CommonUtils {

    public static final int getIndexSegmentByColor(int color) {
        return color;
    }

    public static boolean checkCanMoveByAHorse(Game game, int step, Horse aHorse) {
        return true;
    }

    public static boolean canKickOtherPlayer(Game game, int step, Horse runningHorse) {
        boolean canKick = false;
        int currentIdxPosition = runningHorse.getPostition().getIndex();
        int nextIdxPositionIfMove = runningHorse.getPostition().getIndex() + step;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (aPlayer.getColor() != game.getCurrentPlayer().getColor()) {
                for (int j = 0; j < aPlayer.getListHorse().size(); j++) {
                    Horse standHorse = aPlayer.getListHorse().get(j);
                    if (standHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                        int relativePosition = getRelativePosition(standHorse, game.getCurrentPlayer(), aPlayer);
                        if (relativePosition > currentIdxPosition && relativePosition < nextIdxPositionIfMove) {
                            canKick = false;
                            break;
                        }
                        if (relativePosition == nextIdxPositionIfMove) {
                            canKick = true;
                        }
                    }
                }
            }
        }
        return canKick;
    }

    private static Horse getBeKickedHorse(Game game, int step, Horse runningHorse) {
        Horse beKickedHorse = null;
        int nextIdxPositionIfMove = runningHorse.getPostition().getIndex() + step;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            Player aPlayer = game.getListPlayers().get(i);
            if (aPlayer.getColor() != game.getCurrentPlayer().getColor()) {
                for (int j = 0; j < aPlayer.getListHorse().size(); j++) {
                    Horse standHorse = aPlayer.getListHorse().get(j);
                    if (standHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                        int relativePosition = getRelativePosition(standHorse, game.getCurrentPlayer(), aPlayer);
                        if (relativePosition == nextIdxPositionIfMove) {
                            beKickedHorse = standHorse;
                        }
                    }
                }
            }
        }
        return beKickedHorse;
    }

    public static void kickOtherHorse(Game game, int step, Horse runningHorse) {
        Horse beKickedHorse = getBeKickedHorse(game, step, runningHorse);
        beKickedHorse.getPostition().setType(Constants.POSITION.TYPE.START);
        runningHorse.getPostition().setIndex(runningHorse.getPostition().getIndex() + step);
    }

    public static void runHorse(Position position, int step) {
        if (position.getIndex() == Constants.POSITION.INDEX.START_RUNNING_INDEX) {
            position.setIndex(step);
        } else {
            position.setIndex(position.getIndex() + step);
        }
        if (position.getIndex() == Constants.POSITION.INDEX.MAX_INDEX_WHEN_FINIH) {
            position.setType(Constants.POSITION.TYPE.FINISH);
        }
    }

    private static int getRelativePosition(Horse standHorse, Player currentPlayer, Player standPlayer) {
        int postionIdx = standHorse.getPostition().getIndex();
        return postionIdx += 13 * (currentPlayer.getIndexSegment() - standPlayer.getIndexSegment());
    }

}
