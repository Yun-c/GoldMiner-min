package org.main;

import org.bin.LineStateBin;
import org.bin.ObjectBin;
import org.bin.TimeFormat;
import org.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @program: MyGame
 * @ClassName GameFrame
 * @description:
 * @author: Alice
 * @create: 2024-06-15 16:29
 * @Version 1.0
 **/
public class GameFrame extends JFrame {
    //    Logger logger = LoggerFactory.getLogger("GameFrame");
    // 先创建一个画布
    Image offScreenImage;
    //载入图片
    public PaintPictures paintPictures = new PaintPictures();
    //黄金
//   public PaintGold paintGold =  new PaintGold();
    //多个黄金
   public List<ObjectBin> objectList = new ArrayList<>();
    {
        for (int i = 0; i < 6; i++) {

            objectList.add(new PaintGold());
            objectList.add(new PaintCola());
        }
    }
    //画钩子
    public PaintHanger paintHanger = new PaintHanger();
    //划线
    public PaintLine paintLine = new PaintLine(this);

    public void lunch() throws InterruptedException {
        //窗口是否可见
        setVisible(true);

        setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);

        setTitle(Constant.FRAME_TITLE);

        setLocation(Constant.FRAME_POSITION_X, Constant.FRAME_POSITION_Y);

        //窗口大小不可改变
        setResizable(false);


        //添加鼠标事件控制参数
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    paintLine.setLineStateBin(LineStateBin.elongate);
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    paintLine.setLineStateBin(LineStateBin.shorten);
                } else {
                    paintLine.setLineStateBin(LineStateBin.stillness);
                }
            }
        });

        //添加关闭事件
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //重复绘制
        while (true) {
            repaint();
            Thread.sleep(10);
        }

    }

    //重写绘制图片方法

    @Override
    public void paint(Graphics graphics) {

        offScreenImage = this.createImage(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        Graphics graphicsOffScreen = offScreenImage.getGraphics();

        paintPictures.paintImage(graphicsOffScreen);
        try {
            paintLine.paintLine(graphicsOffScreen);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (ObjectBin objectBin : objectList) {
            objectBin.paintGold(graphicsOffScreen);
        }
        paintHanger.paintHanger(paintLine.getEnd_x(), paintLine.getEnd_y(), graphicsOffScreen);
//        System.out.println("{"+paintLine.getEnd_x()+","+paintLine.getEnd_y()+","+paintLine.getLineStateBin()+"}"+ new SimpleDateFormat(TimeFormat.YYYY_MM_DD_HH_MM_SS.getFormat()).format(System.currentTimeMillis()));
        graphics.drawImage(offScreenImage, 0, 0, null);


    }

}
