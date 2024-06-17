package org.utils;

import org.bin.ObjectBin;

import java.util.List;

/**
 * @program: MyGame
 * @ClassName OverlapCheck
 * @description:
 * @author: Alice
 * @create: 2024-06-17 14:38
 * @Version 1.0
 **/
public class OverlapCheck {

    public static boolean overlap(List<ObjectBin> objectList, ObjectBin b) {

        for (ObjectBin objectBin : objectList) {
            boolean overlap_flag = objectBin.getObject().intersects(b.getObject());
            if (overlap_flag) {
                return false;
            }
        }
       return true;
    }
}
