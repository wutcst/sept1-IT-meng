package cn.edu.whut.sept.zuul.command;

@Cmd("quit")
/**
 * quit 命令的具体实现
 */
public class QuitCommand implements Command{
    private String commandWord;//命令
    private String secondWord;//命令参数

    public QuitCommand(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public QuitCommand() {
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
        if(this.getSecondWord()!=null && !"".equals(this.getSecondWord())) {
            System.out.println("Quit what?");
            return false;
        }else {
            return true;
        }
    }
}
