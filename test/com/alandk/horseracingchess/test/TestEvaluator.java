/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alandk.horseracingchess.test;

import com.alandk.horseracingchess.ai.Evaluator;
import com.alandk.horseracingchess.object.Game;
import java.io.IOException;
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
public class TestEvaluator {

    public TestEvaluator() {
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
    // @Test
    // public void hello() {}
    @Test
    public void testEvaluator() throws IOException {
        Game game = TestUtils.readGameFromFile();
        int value = Evaluator.evaluatorFunction(game);
        assertEquals(1, 1);
    }
}
