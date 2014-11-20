/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import com.alandk.horseracingchess.common.Constants;
import com.alandk.horseracingchess.object.Game;
import com.alandk.horseracingchess.object.GameConfig;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author phucdk
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
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
        List<String> listLines = Files.readAllLines(Paths.get("E:\\phucdk\\HippocampusChess\\logic\\HippocampusChessLogic\\test\\com\\alandk\\hippocampuschess\\test\\game"), Charset.defaultCharset());
    }
    
}
