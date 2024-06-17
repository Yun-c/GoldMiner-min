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

    //定义得分
    public int count = 0;

    public void paintImage(Graphics graphics){


        // 画背景图
        graphics.drawImage(bg,0,120,null);
        // 画天空图
        graphics.drawImage(blue_sky,Constant.BLUE_SKY_X,Constant.BLUE_SKY_Y,Constant.BLUE_SKY_WIDTH,Constant.BLUE_SKY_HEIGHT,null);
        // 画人物图
        graphics.drawImage(miner_middle,(Constant.FRAME_WIDTH-80)/2,40,80,80,null);

        //画出得分
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("仿宋",Font.BOLD,30));
        graphics.drawString("积分:"+count,30,100);

    }

}
