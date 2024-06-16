package org.main;

import org.bin.LineStateBin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.utils.Constant;
import org.utils.PaintPictures;
import org.utils.PaintLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
    //载入图片
    PaintPictures paintPictures = new PaintPictures();
    //划线
    PaintLine paintLine = new PaintLine();


    public GameFrame() throws InterruptedException {
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
                }else if (e.getButton() == MouseEvent.BUTTON3) {
                    paintLine.setLineStateBin(LineStateBin.shorten);
                }
            }
        });

        //添加关闭事件
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //重复绘制
        while (true){
            repaint();
            Thread.sleep(10);
        }

    }

    //重写绘制图片方法

    @Override
    public void paint(Graphics g) {

        paintPictures.paintImage(g);
        paintLine.paintLine(g);

    }

}
