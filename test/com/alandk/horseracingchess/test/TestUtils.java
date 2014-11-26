/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.test;

import com.alandk.horseracingchess.common.Constants;
import com.alandk.horseracingchess.object.Game;
import com.alandk.horseracingchess.object.GameConfig;
import com.alandk.horseracingchess.object.Horse;
import com.alandk.horseracingchess.object.Player;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author phucdk
 */
public class TestUtils {

    public static Game readGameFromFile() throws IOException {
        GameConfig gameConfig = new GameConfig();
        gameConfig.setNumberOfPlayer(4);
        gameConfig.getMapPlayerColor().put(1, Constants.PLAYER.COLOR.BLUE);
        gameConfig.getMapPlayerColor().put(2, Constants.PLAYER.COLOR.GREEN);
        gameConfig.getMapPlayerColor().put(3, Constants.PLAYER.COLOR.RED);
        gameConfig.getMapPlayerColor().put(4, Constants.PLAYER.COLOR.YELLOW);

        gameConfig.getMapPlayerType().put(1, Constants.PLAYER.TYPE.HUMAN);
        gameConfig.getMapPlayerType().put(2, Constants.PLAYER.TYPE.HUMAN);
        gameConfig.getMapPlayerType().put(3, Constants.PLAYER.TYPE.HUMAN);
        gameConfig.getMapPlayerType().put(4, Constants.PLAYER.TYPE.HUMAN);
        Game game = new Game(gameConfig);

        List<String> listLines = Files.readAllLines(Paths.get("E:\\phucdk\\HorseRacingChess\\logic\\HorseRacingChess\\test\\com\\alandk\\horseracingchess\\test\\game"), Charset.defaultCharset());

        String line1 = listLines.get(0);
        line1 = line1.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine1 = line1.split(" ");
        insertValueToGame(arrLine1[1], 1, game);
        insertValueToGame(arrLine1[2], 56, game);
        insertValueToGame(arrLine1[3], 55, game);

        String line2 = listLines.get(1);
        line2 = line2.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine2 = line2.split(" ");
        insertValueToGame(arrLine2[0], 2, game);
        insertValueToGame(arrLine2[1], 54, game);
        
        String line3 = listLines.get(2);
        line3 = line3.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine3 = line3.split(" ");
        insertValueToGame(arrLine3[0], 3, game);
        insertValueToGame(arrLine3[1], 53, game);
        
        String line4 = listLines.get(3);
        line4 = line4.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine4 = line4.split(" ");
        insertValueToGame(arrLine4[0], 4, game);
        insertValueToGame(arrLine4[1], 52, game);
        
        
        String line5 = listLines.get(4);
        line5 = line5.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine5 = line5.split(" ");
        insertValueToGame(arrLine5[0], 5, game);
        insertValueToGame(arrLine5[1], 51, game);
        
        
        String line6 = listLines.get(5);
        line6 = line6.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine6 = line6.split(" ");
        insertValueToGame(arrLine6[0], 6, game);
        insertValueToGame(arrLine6[1], 50, game);
        
        String line7 = listLines.get(6);
        line7 = line7.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine7 = line7.split(" ");
        insertValueToGame(arrLine7[0], 13, game);
        insertValueToGame(arrLine7[1], 12, game);
        insertValueToGame(arrLine7[2], 11, game);
        insertValueToGame(arrLine7[3], 10, game);
        insertValueToGame(arrLine7[4], 9, game);
        insertValueToGame(arrLine7[5], 8, game);
        insertValueToGame(arrLine7[6], 7, game);
        insertValueToGame(arrLine7[7], 49, game);
        insertValueToGame(arrLine7[8], 48, game);
        insertValueToGame(arrLine7[9], 47, game);
        insertValueToGame(arrLine7[10], 46, game);
        insertValueToGame(arrLine7[11], 45, game);
        insertValueToGame(arrLine7[12], 44, game);
        insertValueToGame(arrLine7[13], 43, game);
        
        String line8 = listLines.get(7);
        line8 = line8.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine8 = line8.split(" ");
        insertValueToGame(arrLine8[0], 14, game);
        insertValueToGame(arrLine8[1], 42, game);
        
        
        String line9 = listLines.get(8);
        line9 = line9.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine9 = line9.split(" ");
        insertValueToGame(arrLine9[0], 15, game);
        insertValueToGame(arrLine9[1], 16, game);
        insertValueToGame(arrLine9[2], 17, game);
        insertValueToGame(arrLine9[3], 18, game);
        insertValueToGame(arrLine9[4], 19, game);
        insertValueToGame(arrLine9[5], 20, game);
        insertValueToGame(arrLine9[6], 21, game);
        insertValueToGame(arrLine9[7], 35, game);
        insertValueToGame(arrLine9[8], 36, game);
        insertValueToGame(arrLine9[9], 37, game);
        insertValueToGame(arrLine9[10], 38, game);
        insertValueToGame(arrLine9[11], 39, game);
        insertValueToGame(arrLine9[12], 40, game);
        insertValueToGame(arrLine9[13], 41, game);
        
        String line10 = listLines.get(9);
        line10 = line10.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine10 = line10.split(" ");
        insertValueToGame(arrLine10[0], 22, game);
        insertValueToGame(arrLine10[1], 34, game);
        
        String line11 = listLines.get(10);
        line11 = line11.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine11 = line11.split(" ");
        insertValueToGame(arrLine11[0], 23, game);
        insertValueToGame(arrLine11[1], 33, game);
        
        String line12 = listLines.get(11);
        line12 = line12.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine12 = line12.split(" ");
        insertValueToGame(arrLine12[0], 24, game);
        insertValueToGame(arrLine12[1], 32, game);
        
        String line13 = listLines.get(12);
        line13 = line13.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine13 = line13.split(" ");
        insertValueToGame(arrLine13[0], 25, game);
        insertValueToGame(arrLine13[1], 31, game);
        
        String line14 = listLines.get(13);
        line14 = line14.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine14 = line14.split(" ");
        insertValueToGame(arrLine14[0], 26, game);
        insertValueToGame(arrLine14[1], 30, game);
        
        String line15 = listLines.get(14);
        line15 = line15.replaceAll("       ", " ").replaceAll("   ", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ");
        String[] arrLine15 = line15.split(" ");
        insertValueToGame(arrLine15[0], 27, game);
        insertValueToGame(arrLine15[1], 28, game);
        insertValueToGame(arrLine15[2], 29, game);

        return game;
    }

    private static void insertValueToGame(String value, int positionIdx, Game game) {
        if (!"-".equals(value)) {
            Player player = null;
            switch (Integer.valueOf(value).intValue()) {
                case 1:
                    player = game.getListPlayers().get(0);
                    break;
                case 2:
                    player = game.getListPlayers().get(1);
                    break;
                case 3:
                    player = game.getListPlayers().get(1);
                    break;
                case 4:
                    player = game.getListPlayers().get(1);
                    break;
            }
            if (player != null) {
                player.setCountRunningHorse(player.getCountRunningHorse() + 1);
                Horse aHorse = player.getListHorse().get(player.getCountRunningHorse() - 1);
                aHorse.getPostition().setType(Constants.POSITION.TYPE.RUNNING);
                aHorse.getPostition().setIndex(positionIdx + (Integer.valueOf(value).intValue() - 1) * Constants.DIFF_IDX);
            }
        }
    }
}
