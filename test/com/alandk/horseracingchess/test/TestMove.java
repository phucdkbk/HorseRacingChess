package com.alandk.horseracingchess.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.alandk.horseracingchess.common.CommonUtils;
import com.alandk.horseracingchess.object.Game;
import com.alandk.horseracingchess.object.Horse;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phucdk
 */
public class TestMove {

    public TestMove() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCanMove() throws IOException {
        Game game = TestUtils.readGameFromFile();
        List<Horse> listCanMoveHorse = CommonUtils.getListCanMoveHorse(game, 2);
        assertEquals(listCanMoveHorse.size(), 2);
    }

    @Test
    public void testCanKick() throws IOException {
        Game game = TestUtils.readGameFromFile();
        boolean canKick = CommonUtils.canKickOtherPlayer(game, 2, game.getListPlayers().get(0).getListHorse().get(0));
        assertEquals(canKick, true);
    }
}
