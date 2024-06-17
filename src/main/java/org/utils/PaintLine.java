package org.utils;

import org.bin.LineStateBin;
import org.bin.ObjectBin;
import org.bin.TimeFormat;
import org.main.GameFrame;

import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * @program: MyGame
 * @ClassName PaintLine
 * @description:
 * @author: Alice
 * @create: 2024-06-16 10:47
 * @Version 1.0
 **/
public class PaintLine {

    int begin_x = Constant.FRAME_WIDTH/2;
    public int end_x = 100;
    int begin_y = 100;
    public int end_y = 400;
//    PaintHanger paintHanger = new PaintHanger();
    //线长
    double line_length = Constant.MIN_LENGTH_LINE;
    //角度 x轴向右  y轴向下  垂直部分为PI/2 90度
    double angle = 0.5;
    //方向  当angle转到了边界，开始反向
    int line_boundary = 1;
    //线的状态 延长 收回 摇摆 静止
    LineStateBin lineStateBin = LineStateBin.swing;


    GameFrame gameFrame;

    public PaintLine(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }

    public  void setLineStateBin(LineStateBin lineStateBin) {
       this.lineStateBin = lineStateBin;
    }

    public int getEnd_x() {
        return end_x;
    }

    public int getEnd_y() {
        return end_y;
    }

    public LineStateBin getLineStateBin() {
        return lineStateBin;
    }

    //碰撞检测 多个金块就要循环检测
    void collisionDetection(){
        if (lineStateBin != LineStateBin.catchBack){
            // 如果 已经是抓取状态,就不在进行碰撞检测了
            for (ObjectBin objectBin : this.gameFrame.objectList) {
                if (end_x > objectBin.x && end_x < objectBin.end_x && end_y > objectBin.y && end_y < objectBin.end_y){
//                    System.out.println(objectBin.toString()+"p_end_x="+end_x+"p_end_y"+end_y);
                    objectBin.moveFlag = true;
                    lineStateBin = LineStateBin.catchBack;
                }
            }

        }

    }

    public void lines(Graphics  graphics){
        end_x = (int)(begin_x + line_length*Math.cos(angle*Math.PI));
        end_y = (int)(begin_y + line_length*Math.sin(angle*Math.PI));
        // 划线
        graphics.setColor(Color.RED);
        graphics.drawLine(begin_x,begin_y,end_x-1,end_y-1);
        graphics.drawLine(begin_x,begin_y,end_x,end_y);
        graphics.drawLine(begin_x,begin_y,end_x+1,end_y+1);
//        paintHanger.paintHanger(end_x,end_y,graphics);
    }

    public void paintLine(Graphics graphics) throws InterruptedException {
       //done 回收完成后碰撞检测仍然是碰撞,金块对象的坐标未发送变化
//        System.out.println("drawing line"+lineStateBin);
        collisionDetection();
//        System.out.println("当前lineStateBin："+lineStateBin+"，linelength:"+line_length +new SimpleDateFormat(TimeFormat.YYYY_MM_DD_HH_MM_SS.getFormat()).format(System.currentTimeMillis()));
        switch (lineStateBin){
            case swing:
                // angle 有可能超过平面，处理方式 if处理，强制缩小范围，但是理论上是可以允许平行抓取的
                if (angle < 0.1){
                    line_boundary = 1;
                }else if (angle > 0.9){
                    line_boundary = -1;
                }
                angle = angle + 0.005*line_boundary;
                lines(graphics);
                if (line_length == Constant.MAX_LENGTH_LINE){
                    lineStateBin = LineStateBin.shorten;
                }
                break;
            case elongate:
                //控制线的长度
                if (line_length < Constant.MAX_LENGTH_LINE){
                    line_length = line_length + 1;
                    lines(graphics);
                    break;
                }else {
                    lineStateBin = LineStateBin.swing;
                }
                break;
            case shorten:
                if (line_length > Constant.MIN_LENGTH_LINE){
                    line_length = line_length - 1;
                    lines(graphics);
                    break;
                }else {
                    lineStateBin = LineStateBin.swing;
                }
            case catchBack:
                int sleep_time = 1; //通过延时刷新 打到拉去速度的效果
                if (line_length >= Constant.MIN_LENGTH_LINE){
                    line_length = line_length - 1;
                    lines(graphics);
                    //移动金块
                    for (ObjectBin objectBin : this.gameFrame.objectList) {
                        if (objectBin.moveFlag){
                            sleep_time = objectBin.quality;
                            //修改对象的x坐标和y坐标
                            objectBin.setX(end_x - objectBin.width/2);
                            objectBin.setY(end_y - objectBin.height/2);
                            //修改对象的结束x和结束y
                            objectBin.setEnd_x();
                            objectBin.setEnd_y();
//                            System.out.println("拉取坐标变化"+objectBin.toString());
                            if (line_length <= Constant.MIN_LENGTH_LINE){
                                //回收金块
                                objectBin.setY(end_y - 250);
                                //修改对象的结束x和结束y
                                objectBin.setEnd_x();
                                objectBin.setEnd_y();
                                this.gameFrame.paintBackgroud.count += objectBin.count;
                                objectBin.moveFlag = false;
                                lineStateBin = LineStateBin.swing;
//                                System.out.println("金块回收完成！！！！"+lineStateBin+objectBin.toString()+"p_end_x="+end_x+"p_end_y"+end_y);
                            }
                        }
                    }
                }
                Thread.sleep(sleep_time);
                break;
            default:
                lines(graphics);
                break;
        }

    }
}
