package cn.edu.whut.sept.zuul;


import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * 该类是项目中描述场景时所使用的类
 */
public class Room
{
    private String description;//场景的描述
    private HashMap<String, Room> exits;//该房间的门(出口)
    private ArrayList<Object> goods;//该场景下的物品信息
    private boolean isSpecial;//标识该房间是否是特殊的房间

    public HashMap<String, Room> getExits() {
        return exits;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap();
        goods = new ArrayList();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 返回出口的字符串表示形式
     * @return
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 返回direction方向的下一个房间
     * @param direction
     * @return
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * 向该场景下添加物品
     * @param o
     */
    public void addGoods(Object o){
        goods.add(o);
    }

    public ArrayList<Object> getGoods() {
        return goods;
    }
}


