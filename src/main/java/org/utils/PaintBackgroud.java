package org.utils;

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
    public int count = 0;
    //定义炸弹数量及炸弹状态
    public int bombCount = 5;
    public boolean bombState = false;

    public  void paintImage(Graphics graphics){


        // 画背景图
        graphics.drawImage(bg,0,120,null);
        // 画天空图
        graphics.drawImage(blue_sky,Constant.BLUE_SKY_X,Constant.BLUE_SKY_Y,Constant.BLUE_SKY_WIDTH,Constant.BLUE_SKY_HEIGHT,null);
        // 画人物图
        graphics.drawImage(miner_middle,(Constant.FRAME_WIDTH-Constant.MINER_WIDTH)/2,Constant.BLUE_SKY_HEIGHT-Constant.MINER_HEIGHT,Constant.MINER_WIDTH,Constant.MINER_HEIGHT,null);
        // 画炸弹
        graphics.drawImage(gold_bomb,Constant.FRAME_WIDTH-100,Constant.GOLD_BOMB_WIDTH/2,Constant.GOLD_BOMB_WIDTH,Constant.GOLD_BOMB_HEIGHT,null);


    }

    public void paintCount(Graphics graphics,Color color,int x,int y,int size,String name,int count){
        //画出得分
        graphics.setColor(color);
        graphics.setFont(new Font("仿宋",Font.BOLD,size));
        graphics.drawString(name+count,x,y);
    }

}
