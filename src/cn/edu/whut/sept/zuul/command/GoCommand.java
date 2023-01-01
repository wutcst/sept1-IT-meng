package cn.edu.whut.sept.zuul.command;

import cn.edu.whut.sept.zuul.Room;

@Cmd("go")
/**
 * go命令的具体实现
 */
public class GoCommand implements Command{
    private String commandWord;//命令
    private String secondWord;//命令参数


    public GoCommand() {
    }

    public GoCommand(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
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
        Room curRoom = null;
        if(args!=null){
            curRoom = (Room) args[0];
            if(this.getSecondWord()==null || "".equals(this.getSecondWord())){
                System.out.println("Go where?");
            }else{
                String direction = this.getSecondWord();

                // Try to leave current room.
                Room nextRoom = curRoom.getExit(direction);

                if (nextRoom == null) {
                    System.out.println("There is no door!");
                }
                else {
                    curRoom = nextRoom;
                    System.out.println(curRoom.getLongDescription());
                }
            }
        }
        return curRoom;
    }
}
