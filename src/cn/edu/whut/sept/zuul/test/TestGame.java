package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.BackCommand;
import cn.edu.whut.sept.zuul.command.LookCommand;
import org.junit.Before;
import org.junit.Test;

/**
 * test for project
 */
public class TestGame {
    private Game game;
    @Before
    public void newGame(){
        game = new Game();
    }

    @Test
    public void testRoomSpecial(){
        game.play();
    }

    @Test
    public void testLook(){
        game.processCommand(new LookCommand("look",null));
    }

    @Test
    public void testBack(){
        game.processCommand(new BackCommand("back",null));
    }

}
