package org.utils;

import org.bin.LineStateBin;

import java.awt.*;

/**
 * @program: MyGame
 * @ClassName PaintLine
 * @description:
 * @author: Alice
 * @create: 2024-06-16 10:47
 * @Version 1.0
 **/
public class PaintLine {

    int begin_x = 40;
    int end_x = 100;
    int begin_y = 100;
    int end_y = 400;

    //线长
    double line_length = 100;
    //角度 x轴向右  y轴向下  垂直部分为PI/2 90度
    double angle = 0;
    //方向  当angle转到了边界，开始反向
    int line_boundary = 1;
    //线的状态 延长 收回 摇摆
    LineStateBin lineStateBin;

    public  void setLineStateBin(LineStateBin lineStateBin) {
       this.lineStateBin = lineStateBin;
    }

    public void paintLine(Graphics graphics){
        System.out.println("drawing line");
        switch (lineStateBin){
            case swing:
                if (angle < 0.1){
                    line_boundary = 1;
                }else if (angle > 0.9){
                    line_boundary = -1;
                }
                // angle 有可能超过平面，处理方式 if处理，强制缩小范围，但是理论上是可以允许平行抓取的
                angle = angle + 0.005*line_boundary;
                end_x = (int)(begin_x + line_length*Math.cos(angle*Math.PI));
                end_y = (int)(begin_y + line_length*Math.sin(angle*Math.PI));
                // 划线
                graphics.setColor(Color.RED);
                graphics.drawLine(begin_x,begin_y,end_x,end_y);
                break;
            case elongate:
                //控制线的长度
                if (line_length < 500){
                    line_length = line_length + 10;
                    end_y = (int)(begin_y + line_length*Math.sin(angle*Math.PI));
                    // 划线
                    graphics.setColor(Color.RED);
                    graphics.drawLine(begin_x,begin_y,end_x,end_y);
                    break;
                }else {
                    lineStateBin = LineStateBin.swing;
                }
                break;
            default:

        }
        // 摇摆
        // 收回
        // 延长


    }
}
