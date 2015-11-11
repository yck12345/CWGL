package com.example.yck1.cwgl.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yck1 on 2015/11/8.
 */
public class Zc {

    /**
     * count : 1000
     * time : 2015/11/7
     * description : 员工工资
     * fs : 现金
     * fl : 员工工资
     */

   private int count;
   private String time;
   private String description;
   private String fs;
   private String fl;

    public void setCount(int count) {
        this.count = count;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public int getCount() {
        return count;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getFs() {
        return fs;
    }

    public String getFl() {
        return fl;
    }
}
