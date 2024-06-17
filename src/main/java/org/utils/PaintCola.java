package org.utils;

import org.bin.ObjectBin;

import java.awt.*;

/**
 * @program: MyGame
 * @ClassName PaintStone
 * @description:
 * @author: Alice
 * @create: 2024-06-17 10:03
 * @Version 1.0
 **/
public class PaintCola extends ObjectBin {

    public PaintCola(){
        int set_x = (int) (Constant.FRAME_WIDTH * Math.random());
        if (set_x > Constant.FRAME_WIDTH - 40) {
            set_x = Constant.FRAME_WIDTH - 40;
        }
        int set_y = (int) (Constant.FRAME_HEIGHT * Math.random()) + Constant.BLUE_SKY_HEIGHT;
        if (set_y > Constant.FRAME_HEIGHT) {
            set_y = Constant.FRAME_HEIGHT;
        }
        this.x = set_x;
        this.y = set_y;
        this.width = 40;
        this.height = 40;
        this.end_x = this.x + this.width;
        this.end_y = this.y + this.height;
        this.quality = 10;
        this.image = Toolkit.getDefaultToolkit().getImage(Constant.COAL_SMALL);
    }
}