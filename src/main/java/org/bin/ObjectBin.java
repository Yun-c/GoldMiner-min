package org.bin;

import java.awt.*;

/**
 * @program: MyGame
 * @ClassName PaintGold
 * @description:
 * @author: Alice
 * @create: 2024-06-16 13:48
 * @Version 1.0
 **/
public class ObjectBin {

    //大小
    public int width;
    public int height;

    //起始位置
    public int x;
    public int y;

    //结束位置
    public int end_x = 0;
    public int end_y = 0;
    //图片
    public Image image;

    //是否需要移动标志位
    public boolean moveFlag = false;

    //物体质量
    public int quality;

    //物体积分
    public int count;

    //物体类型
    public ObjectName objectName;

    public void paintGold(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }

    @Override
    public String toString() {
        return "{x="+x+",y="+y+",width="+width+",height="+height+",end_x="+end_x+",end_y="+end_y+"}";
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEnd_x() {
        this.end_x = x + width;
    }

    public void setEnd_y() {
        this.end_y = y + height;
    }

    //返回一个矩形 用于判断是否重叠
    public Rectangle getObject(){
        return new Rectangle(x,y,width,height);
    }
}
