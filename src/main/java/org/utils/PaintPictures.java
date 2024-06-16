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

public class PaintPictures {

    Image bg = Toolkit.getDefaultToolkit().getImage(Constant.BACKGROUND_IMAGE);
    Image blue_sky = Toolkit.getDefaultToolkit().getImage(Constant.BLUE_SKY);
    Image miner_middle = Toolkit.getDefaultToolkit().getImage(Constant.MINER_MIDDLE);



    public void paintImage(Graphics graphics){
        // 画背景图
        graphics.drawImage(bg,0,120,null);
        // 画天空图
        graphics.drawImage(blue_sky,0,0,800,120,null);
        // 画人物图
        graphics.drawImage(miner_middle,0,40,80,80,null);

    }

}
