package org.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * @program: MyGame
 * @ClassName PaintHanger
 * @description:
 * @author: Alice
 * @create: 2024-06-16 14:26
 * @Version 1.0
 **/
public class PaintHanger {


    Image hanger_image = Toolkit.getDefaultToolkit().getImage(Constant.HANGER);

    public void swingImage(double angel,Graphics graphics) {
    // todo 钩子旋转 与线保持垂直
        AffineTransform affineTransform = new AffineTransform();
    }

    public void paintHanger(int hanger_x, int hanger_y, Graphics graphics){
//        System.out.println(hanger_image.getHeight(null));
        graphics.drawImage(hanger_image, hanger_x-20, hanger_y-10,Constant.HANGER_WIDTH,Constant.HANGER_HEIGHT, null);

    }

}
