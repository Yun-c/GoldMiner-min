package org.bin;

/**
 * @program: MyGame
 * @ClassName LineStateBin
 * @description:
 * @author: Alice
 * @create: 2024-06-16 12:44
 * @Version 1.0
 **/

public enum LineStateBin {

    swing(0,"swing","旋转"),
    elongate(1,"elongate","延长"),
    shorten(2,"shorten","回收");

    private int value;

    private String state;

    private String name;

    LineStateBin(int value, String state,String name) {
        this.value = value;
        this.state = state;
        this.name = name;
    }


}
