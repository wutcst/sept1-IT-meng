package cn.edu.whut.sept.zuul.command;

import cn.edu.whut.sept.zuul.Room;

@Cmd("look")
/**
 * look命令的具体实现
 */
public class LookCommand implements Command{
    private String commandWord;//命令
    private String secondWord;//命令参数

    public LookCommand(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public LookCommand() {
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
        Room room = (Room) args[0];
        System.out.println(room.getLongDescription());
        System.out.print("there are ");
        for (Object o:room.getGoods()){
            System.out.print(o+",");
        }
        System.out.print("in this room");
        System.out.println();
        return null;
    }
}
