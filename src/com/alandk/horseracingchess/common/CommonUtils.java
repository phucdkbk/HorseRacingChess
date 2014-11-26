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
import java.util.ArrayList;
import java.util.List;

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
        switch (position.getIndex()) {
            case Constants.POSITION.INDEX.START_RUNNING_INDEX:
                position.setIndex(step);
                break;
            case Constants.POSITION.INDEX.MAX_INDEX_WHEN_END_RUNNING:
                position.setType(Constants.POSITION.TYPE.FINISH);
                position.setIndex(step);
                break;
        }
    }

    private static int getRelativePosition(Horse standHorse, Player currentPlayer, Player standPlayer) {
        int postionIdx = standHorse.getPostition().getIndex();
        return postionIdx += 13 * (currentPlayer.getIndexSegment() - standPlayer.getIndexSegment());
    }

    public static List<Horse> getListCanMoveHorse(Game game, int step) {
        List<Horse> listCanMoveHorses = new ArrayList<>();
        Player runningPlayer = game.getCurrentPlayer();
        for (int i = 0; i < runningPlayer.getListHorse().size(); i++) {
            Horse aHorse = runningPlayer.getListHorse().get(i);
            if (canMoveAHorse(aHorse, game, step)) {
                listCanMoveHorses.add(aHorse);
            }
        }
        return listCanMoveHorses;
    }

    private static boolean canMoveAHorse(Horse runningHorse, Game game, int step) {
        boolean canMove = false;
        switch (runningHorse.getPostition().getType()) {
            case Constants.POSITION.TYPE.START:
                if (step == 1 || step == 6) {
                    if (!haveHorseInStartPosition(game)) {
                        canMove = true;
                    }
                }
                break;
            case Constants.POSITION.TYPE.RUNNING:
                int currentIdxPosition = runningHorse.getPostition().getIndex();
                int nextIdxPositionIfMove = runningHorse.getPostition().getIndex() + step;

                int absCurrentIdxPositon = getAbsoluteIdxPosition(currentIdxPosition, game.getCurrentPlayer());
                int absNextIdxPositonIfMove = getAbsoluteIdxPosition(nextIdxPositionIfMove, game.getCurrentPlayer());

                boolean haveHorseBetween = false;
                for (int i = absCurrentIdxPositon + 1; i < absNextIdxPositonIfMove; i++) {
                    Horse aHorse = getHorseInRunningPosition(game, i);
                    if (aHorse != null) {
                        haveHorseBetween = true;
                        break;
                    }
                }
                if (!haveHorseBetween) {
                    Horse aHorse = getHorseInRunningPosition(game, absNextIdxPositonIfMove);
                    if (aHorse != null) {
                        if (game.getCurrentPlayer().getListHorse().contains(aHorse)) {
                            canMove = true;
                        } else {
                            canMove = false;
                        }
                    } else {
                        canMove = true;
                    }
                } else {
                    canMove = false;
                }
                break;
            case Constants.POSITION.TYPE.FINISH:
                canMove = false;
                if (runningHorse.getPostition().getIndex() + 1 == step) {
                    if (getHorseInFinishPosition(game.getCurrentPlayer(), step) != null) {
                        canMove = true;
                    }
                }
                break;
        }
        return canMove;
    }

    private static boolean haveHorseInStartPosition(Game game) {
        boolean haveHorseInStartPosition = false;
        Player currentPlayer = game.getCurrentPlayer();
        for (int i = 0; i < currentPlayer.getListHorse().size(); i++) {
            Horse aHorse = currentPlayer.getListHorse().get(i);
            if (aHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                if (aHorse.getPostition().getIndex() == Constants.POSITION.INDEX.START_RUNNING_INDEX) {
                    haveHorseInStartPosition = true;
                    break;
                }
            }
        }
        return haveHorseInStartPosition;
    }

    private static Horse getHorseInRunningPosition(Game game, int index) {
        Horse aHorse = null;
        for (int i = 0; i < game.getListPlayers().size(); i++) {
            for (int j = 0; j < game.getListPlayers().get(i).getListHorse().size(); j++) {
                Horse checkHorse = game.getListPlayers().get(i).getListHorse().get(j);
                if (checkHorse.getPostition().getType() == Constants.POSITION.TYPE.RUNNING) {
                    int idxPosition = checkHorse.getPostition().getIndex();
                    int absoluteIdxPosition = getAbsoluteIdxPosition(idxPosition, game.getListPlayers().get(i));
                    if (index == absoluteIdxPosition) {
                        return checkHorse;
                    }
                }
            }
        }
        return aHorse;
    }

    private static Horse getHorseInFinishPosition(Player player, int index) {
        Horse aHorse = null;
        for (int i = 0; i < player.getListHorse().size(); i++) {
            Horse checkHorse = player.getListHorse().get(i);
            if (checkHorse.getPostition().getType() == Constants.POSITION.TYPE.FINISH) {
                if (checkHorse.getPostition().getIndex() == index) {
                    return checkHorse;
                }
            }
        }
        return aHorse;
    }

    private static int getAbsoluteIdxPosition(int index, Player player) {
        int absoluteIdxPosition = index - player.getIndexSegment() * Constants.DIFF_IDX;
        if (absoluteIdxPosition < 0) {
            absoluteIdxPosition += Constants.POSITION.INDEX.MAX_INDEX_WHEN_END_RUNNING;
        }
        return absoluteIdxPosition;
    }
}
