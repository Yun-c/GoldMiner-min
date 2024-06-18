package org.bin;

/**
 * @program: MyGame
 * @ClassName ObjcetName
 * @description:
 * @author: Alice
 * @create: 2024-06-17 16:35
 * @Version 1.0
 **/
public enum ObjectName {

    //todo  定义物体的类型 名称  用以区分物体的不同
    BOMB("bomb","炸弹"),
    GOLD("gold","黄金"),
    COLA("cola","煤炭");

    public String type;
    public String name;

    ObjectName(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
