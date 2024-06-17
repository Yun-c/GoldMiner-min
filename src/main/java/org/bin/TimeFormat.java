package org.bin;

/**
 * @program: MyGame
 * @ClassName TimeFormat
 * @description:
 * @author: Alice
 * @create: 2024-06-17 10:28
 * @Version 1.0
 **/
public enum TimeFormat {


    HH_MM_SS("HH:mm:ss"),
    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");

    private String format;

    TimeFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
