package org.utils;

/**
 * @program: MyGame
 * @ClassName ColaAndGoldTotal
 * @description:
 * @author: Alice
 * @create: 2024-06-18 11:07
 * @Version 1.0
 **/

// 控制金块和石头的比重
public class ColaAndGoldTotal {

    //   public int level;
    public int cola_small;
    public int cola_big;
    public int gold_small;
    public int gold_big;

    public ColaAndGoldTotal(int level) {
        setNum(level);
    }

    public void setNum(int level) {
        // 设置总数是50
        int total = 20;
        // 设置每个值的占比
        double cola_small_proportion;
        double cola_big_proportion;
        double gold_small_proportion;
        double gold_big_proportion;

        //
        gold_big_proportion = 0.7 - 0.025 * level;
        cola_small_proportion = 0.9 - gold_big_proportion;
        gold_small_proportion = 1.2 - cola_small_proportion - gold_big_proportion;
        cola_big_proportion = 1.4 - cola_small_proportion - gold_small_proportion-gold_big_proportion ;

        cola_small = (int) (total * cola_small_proportion);
        cola_big = (int) (total * cola_big_proportion);
        gold_small = (int) (total * gold_small_proportion);
        gold_big = (int) (total * gold_big_proportion);


    }

    public int getCola_small() {
        return cola_small;
    }

    public int getCola_big() {
        return cola_big;
    }

    public int getGold_small() {
        return gold_small;
    }

    public int getGold_big() {
        return gold_big;
    }

    @Override
    public String toString() {
        return "{cola_small:" + cola_small + "cola_big:" + cola_big + "gold_small:" + gold_small + "gold_big:" + gold_big + "}";
    }
}
