package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.command.*;
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
    @Test
    public void testGo(){
        game.processCommand(new GoCommand("go","east"));
    }
    @Test
    public void testHelp(){
        game.processCommand(new HelpCommand("help",null));
    }

    @Test
    public void testQuit(){
        game.processCommand(new QuitCommand("quit",null));
    }

}
