package org.bin;

/**
 * @program: MyGame
 * @ClassName GameState
 * @description:
 * @author: Alice
 * @create: 2024-06-18 14:01
 * @Version 1.0
 **/
public enum GameState {

    WIN("win","游戏成功"),
    FAIL("fail","失败"),
    PREPARING("preparing","准备中"),
    IN_PROCESS("in_process","进行中");

    public final String state;
    public final String name;

    GameState(String state,String name) {
        this.name = name;
        this.state = state;
    }


}
