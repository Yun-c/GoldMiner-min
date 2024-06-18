package org.utils;

import org.bin.ObjectBin;
import org.bin.ObjectName;

import java.awt.*;

/**
 * @program: MyGame
 * @ClassName PaintGold
 * @description:
 * @author: Alice
 * @create: 2024-06-16 13:51
 * @Version 1.0
 **/
public class PaintGold extends ObjectBin {


    public PaintGold() {
        int set_x = (int) (Constant.FRAME_WIDTH * Math.random());
        if (set_x > Constant.FRAME_WIDTH - 40) {
            set_x = Constant.FRAME_WIDTH - 40;
        }
        int set_y = (int) (Constant.FRAME_HEIGHT * Math.random()) + Constant.BLUE_SKY_HEIGHT;
        if (set_y > Constant.FRAME_HEIGHT) {
            set_y = Constant.FRAME_HEIGHT - 40;
        }
        this.x = set_x;
        this.y = set_y;
        this.width = 35;
        this.height = 35;
        this.end_x = this.x + this.width;
        this.end_y = this.y + this.height;
        this.quality = 5;
        this.count = 5;
        this.objectName = ObjectName.GOLD;
        this.image = Toolkit.getDefaultToolkit().getImage(Constant.GOLD_SMALl);
    }

    public PaintGold(int width, int height,String image,int quality) {
        int set_x = (int) (Constant.FRAME_WIDTH * Math.random());
        if (set_x > Constant.FRAME_WIDTH - 40) {
            set_x = Constant.FRAME_WIDTH - 40;
        }
        int set_y = (int) (Constant.FRAME_HEIGHT * Math.random()) + Constant.BLUE_SKY_HEIGHT;
        if (set_y > Constant.FRAME_HEIGHT) {
            set_y = Constant.FRAME_HEIGHT - 40;
        }
        this.x = set_x;
        this.y = set_y;
        this.width = width;
        this.height = height;
        this.end_x = this.x + this.width;
        this.end_y = this.y + this.height;
        this.quality = quality;
        this.count = 10;
        this.objectName = ObjectName.GOLD;
        this.image = Toolkit.getDefaultToolkit().getImage(image);
    }




}
