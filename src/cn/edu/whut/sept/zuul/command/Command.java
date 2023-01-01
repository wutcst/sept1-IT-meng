package cn.edu.whut.sept.zuul.command;

/**
 * 抽象命令接口，所有的命令类都必须实现此接口
 */
public interface Command {
    Object processCommand(Object...args);
}
