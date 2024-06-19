package org.utils;

import org.bin.GameState;
import org.main.GameFrame;

import java.awt.*;

/**
 * @program: MyGame
 * @ClassName GetPictures
 * @description:
 * @author: Alice
 * @create: 2024-06-15 21:56
 * @Version 1.0
 **/

public class PaintBackgroud {

    Image bg = Toolkit.getDefaultToolkit().getImage(Constant.BACKGROUND_IMAGE);
    Image blue_sky = Toolkit.getDefaultToolkit().getImage(Constant.BLUE_SKY);
    Image miner_middle = Toolkit.getDefaultToolkit().getImage(Constant.MINER_MIDDLE);
    Image gold_bomb = Toolkit.getDefaultToolkit().getImage(Constant.GOLD_BOMB);

    //定义得分
    public static int count = 0;
    public static int level = 1;
    public int target_points = level * 15;
    //定义炸弹数量及炸弹状态
    public int bombCount = 5;
    public boolean bombState = false;

    //定义开始时间和结束时间
    public long startTime;
    public long endTime;

    //定义药水价格
    int price = 5;
    //是否进入商店
    public boolean shop  = false;


    public void paintImage(Graphics graphics) {
        // 画背景图
        graphics.drawImage(bg, 0, 120, null);
        // 画天空图
        graphics.drawImage(blue_sky, Constant.BLUE_SKY_X, Constant.BLUE_SKY_Y, Constant.BLUE_SKY_WIDTH, Constant.BLUE_SKY_HEIGHT, null);
        // 画人物图
        graphics.drawImage(miner_middle, (Constant.FRAME_WIDTH - Constant.MINER_WIDTH) / 2, Constant.BLUE_SKY_HEIGHT - Constant.MINER_HEIGHT, Constant.MINER_WIDTH, Constant.MINER_HEIGHT, null);
//        System.out.println(GameFrame.gameState);
        // 画炸弹
        switch (GameFrame.gameState) {
            case IN_PROCESS:
                graphics.drawImage(gold_bomb, Constant.FRAME_WIDTH - 100, Constant.GOLD_BOMB_WIDTH / 2, Constant.GOLD_BOMB_WIDTH, Constant.GOLD_BOMB_HEIGHT, null);
                paintCount(graphics, Color.BLACK, 30, 60, 20, "积分:" + count);
                paintCount(graphics, Color.BLACK, 30, 90, 20, "关卡:" + level);
                paintCount(graphics, Color.BLACK, 30, 120, 20, "目标积分:" + target_points);
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH - 100 + Constant.GOLD_BOMB_WIDTH, Constant.GOLD_BOMB_HEIGHT, 20, "*" + bombCount);
                endTime = System.currentTimeMillis();
//                System.out.println(endTime);
                long time = Constant.LEVEL_TIME + level - (endTime - startTime) / 1000;
                paintCount(graphics, Color.green, Constant.FRAME_WIDTH - 130, Constant.GOLD_BOMB_WIDTH / 2 + 65, 20, "剩余时间:" + (time > 0 ? time : 0));
                break;
            case PREPARING:
//                System.out.println("写字"+Constant.FRAME_WIDTH/2+"//"+Constant.FRAME_HEIGHT/2);
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH / 2 - 100, Constant.FRAME_HEIGHT / 2, 30, "来一把吗");
                break;
            case FAIL:
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH / 2 - 100, Constant.FRAME_HEIGHT / 2, 50, "游戏结束");
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH / 2 - 100, Constant.FRAME_HEIGHT / 2 - 100, 50, "得分" + count);
                break;
            case WIN:
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH / 2 - 100, Constant.FRAME_HEIGHT / 2, 50, "游戏成功");
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH / 2 - 100, Constant.FRAME_HEIGHT / 2 - 100, 50, "得分" + count);
                break;
            case STORE:
                graphics.drawImage(gold_bomb, Constant.FRAME_WIDTH/2, Constant.FRAME_HEIGHT / 2, Constant.GOLD_BOMB_WIDTH, Constant.GOLD_BOMB_HEIGHT, null);
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH/2, Constant.FRAME_HEIGHT/2+60, 20, "价格：" +price);
                paintCount(graphics, Color.ORANGE, Constant.FRAME_WIDTH/2, Constant.FRAME_HEIGHT/2+80, 20, "是否购买：" );
                if (shop){

                    count = count - price;
                    bombCount++;
                    shop = false;
                    GameFrame.gameState = GameState.IN_PROCESS;
                    startTime = System.currentTimeMillis();
                }
                break;
        }


    }

    public static void paintCount(Graphics graphics, Color color, int x, int y, int size, String name) {
        //画出得分
        graphics.setColor(color);
        graphics.setFont(new Font("仿宋", Font.BOLD, size));
        graphics.drawString(name, x, y);
    }

    public boolean remainder() {
        long time = (endTime - startTime) / 1000;
//        System.out.println("时间差："+time+"///"+startTime+"///"+endTime);
        return time < Constant.LEVEL_TIME + level;
    }

    //重置元素
    public void reBulid() {
        count = 0;
        level = 1;
        //定义炸弹数量及炸弹状态
        bombCount = 5;
        bombState = false;
        target_points = level * 15;
        startTime = System.currentTimeMillis();
        //todo  失败回到上一个位置  成功关卡数据没有重置

    }

    @Override
    public String toString() {
        return "{"+count+","+level+","+target_points+"};";
    }
}
