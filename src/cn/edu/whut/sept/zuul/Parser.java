package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.command.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 该类负责将用户输入的命令转化为项目中的Command对象
 */
public class Parser
{
    private CommandWords commands;//存储着项目中所有的命令
    private Scanner reader;//读取用户输入的命令

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 将用户输入的命令转化为Command对象
     * @return
     */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        HashMap<String, String> commands = this.commands.getCommands();
        if(commands.containsKey(word1)){
            Class<?> c = null;
            try {
                c = Class.forName(commands.get(word1));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Command cmd = null;
            try {
                cmd = (Command)c.getConstructor(String.class, String.class).newInstance(word1, word2);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return cmd;
        }else{
            System.out.println("invalid command.");
            return null;
        }
    }

    public CommandWords getCommands() {
        return commands;
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
