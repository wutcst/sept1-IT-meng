package cn.edu.whut.sept.zuul.command;

import cn.edu.whut.sept.zuul.Room;

import java.util.Stack;

@Cmd("back")
/**
 * back命令的具体实现
 */
public class BackCommand implements Command{
    private String commandWord;//命令
    private String secondWord;//命令参数

    public BackCommand(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public BackCommand() {
    }

    public String getCommandWord() {
        return commandWord;
    }

    public void setCommandWord(String commandWord) {
        this.commandWord = commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    @Override
    public Object processCommand(Object... args) {
        Stack<Room> stack = (Stack<Room>) args[2];
        Room curRoom = (Room) args[0];
       if (!stack.isEmpty()){
            curRoom = stack.pop();
        }else {
           System.out.println("unable to back.");
       }
        System.out.println(curRoom.getLongDescription());
        return curRoom;
    }
}
