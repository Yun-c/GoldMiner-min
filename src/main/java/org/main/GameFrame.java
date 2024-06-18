package org.main;

import org.bin.LineStateBin;
import org.bin.ObjectBin;
import org.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    // 1.先创建一个画布
    Image offScreenImage;
    //2.载入图片
    public PaintBackgroud paintBackgroud = new PaintBackgroud();
    // 3.添加积分

    //黄金
//   public PaintGold paintGold =  new PaintGold();
    //3.添加多个黄金
    public List<ObjectBin> objectList = new ArrayList<>();

    {
        //  是否可放置 对象重叠判断
        boolean overlap_flag = true;
        for (int i = 0; i < 6; i++) {
            PaintGold paintGold = new PaintGold();
            if (overlap_flag) {
                objectList.add(paintGold);
            } else {
                i--;
            }
            overlap_flag = OverlapCheck.overlap(objectList, paintGold);
        }

        for (int i = 0; i < 6; i++) {
            PaintCola paintCola = new PaintCola();
            overlap_flag = OverlapCheck.overlap(objectList, paintCola);
            if (overlap_flag) {
                objectList.add(paintCola);
            } else {
                i--;
            }
        }

        for (int i = 0; i < 3; i++) {
            PaintGold paintGold = new PaintGold(60, 60, Constant.GOLD_BIG, 20);
            overlap_flag = OverlapCheck.overlap(objectList, paintGold);
            if (overlap_flag) {
                objectList.add(paintGold);
            } else {
                i--;
            }
        }

        for (int i = 0; i < 3; i++) {
            PaintCola paintCola = new PaintCola(60, 60, Constant.COAL_BIG, 30);
            overlap_flag = OverlapCheck.overlap(objectList, paintCola);
            if (overlap_flag) {
                objectList.add(paintCola);
            } else {
                i--;
            }
        }
    }
    //4.画钩子
    public PaintHanger paintHanger = new PaintHanger();
    //5.划线
    public PaintLine paintLine = new PaintLine(this);

    //窗口设置
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
                //1.鼠标左键+线的状态是旋转
                if (e.getButton() == MouseEvent.BUTTON1 && paintLine.getLineStateBin() == LineStateBin.swing) {
                    paintLine.setLineStateBin(LineStateBin.elongate);
                    System.out.println("点击左键"+paintLine.getLineStateBin());
                }
                //鼠标右键+线的状态是抓取，使用炸弹
                if (e.getButton() == MouseEvent.BUTTON3 && paintLine.getLineStateBin() == LineStateBin.catchBack){
                       paintBackgroud.bombState = true; //炸弹可以被使用
                       paintBackgroud.bombCount --;//炸弹减少
                    System.out.println("点击右键键"+paintLine.getLineStateBin());

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

        paintBackgroud.paintImage(graphicsOffScreen);
        paintBackgroud.paintCount(graphicsOffScreen,Color.BLACK,30,120,30,"积分:",paintBackgroud.count);
        paintBackgroud.paintCount(graphicsOffScreen,Color.ORANGE,Constant.FRAME_WIDTH-100+Constant.GOLD_BOMB_WIDTH,Constant.GOLD_BOMB_HEIGHT,20,"*",paintBackgroud.bombCount);


        for (ObjectBin objectBin : objectList) {
            objectBin.paintGold(graphicsOffScreen);
        }

        try {
            paintLine.paintLine(graphicsOffScreen);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        paintHanger.paintHanger(paintLine.getEnd_x(), paintLine.getEnd_y(), graphicsOffScreen);
//        System.out.println("{"+paintLine.getEnd_x()+","+paintLine.getEnd_y()+","+paintLine.getLineStateBin()+"}"+ new SimpleDateFormat(TimeFormat.YYYY_MM_DD_HH_MM_SS.getFormat()).format(System.currentTimeMillis()));
        graphics.drawImage(offScreenImage, 0, 0, null);


    }

}
