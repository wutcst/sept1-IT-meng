package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.command.Cmd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * 该类保存着项目中所有的命令
 */
public class CommandWords
{

    //存储命令及每个命令对应的具体实现类eg:go->cn.edu.whut.sept.zuul.command.GoCommand
    private static HashMap<String,String> commands = new HashMap();

    //静态代码块：将项目中所有加了Cmd注解的类的信息添加到HashMap中
    static {
        Enumeration<URL> resources = null;
        try {
            resources = CommandWords.class.getClassLoader().getResources("cn/edu/whut/sept/zuul/command/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            String[] file = new File(url.getFile()).list();

            for (int i = 0; i < file.length; i++) {
                Class c = null;
                try {
                    c = Class.forName("cn.edu.whut.sept.zuul.command"+ "." + file[i].replaceAll("\\.class", ""));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if(c.isAnnotationPresent(Cmd.class)){
                    Cmd cmd = (Cmd)c.getAnnotation(Cmd.class);
                    commands.put(cmd.value(),"cn.edu.whut.sept.zuul.command"+ "." + file[i].replaceAll("\\.class", ""));
                }
            }

        }

    }


    public CommandWords()
    {
        // nothing to do at the moment...
    }

    public boolean isCommand(String aString)
    {
        if(commands.containsKey(aString)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 打印项目中所有的命令
     */
    public void showAll()
    {
      for (String c: commands.keySet()){
          System.out.println(c+" ");
      }
        System.out.println();
    }

    public static HashMap<String,String> getCommands(){
        return commands;
    }
}
