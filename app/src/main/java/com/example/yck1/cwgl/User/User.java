package com.example.yck1.cwgl.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yck1 on 2015/11/2.
 */
public class User {

    /**
     * id : 1
     * name : yck
     * password : 1234
     * money : 10000
     * all_sr : 15000
     * all_zc : 5000
     */

   private String email;
   private String password;
   private int money;
   private int all_sr;
   private int all_zc;
   private Sr[] srs;

    public int[] getSrCounts(){
        int[] counts = new int[srs.length];
        for (int i = 0; i <counts.length ; i++) {
            counts[i]=srs[i].getCount();
        }
        return counts;
    }

    public String[] getSrTimes(){
        String[] times=new String[srs.length];
        for (int i = 0; i <times.length ; i++) {
            times[i]= srs[i].getTime();
        }
        return times;
    }
    public String[] getSrDescriptions(){
        String[] descriptions=new String[srs.length];
        for (int i = 0; i <descriptions.length ; i++) {
            descriptions[i]= srs[i].getDescription();
        }
        return descriptions;
    }
    public String[] getSrFss(){
        String[] fss=new String[srs.length];
        for (int i = 0; i <fss.length ; i++) {
            fss[i]= srs[i].getFs();
        }
        return fss;
    }
    public String[] getSrFls(){
        String[] fls=new String[srs.length];
        for (int i = 0; i <fls.length ; i++) {
            fls[i]= srs[i].getFl();
        }
        return fls;
    }

    public Sr[] getSrs() {
        return srs;
    }

    public void setSrs(Sr[] srs) {
        this.srs = srs;
    }

    public Zc[] getZcs() {
        return zcs;
    }

    public void setZcs(Zc[] zcs) {
        this.zcs = zcs;
    }

    public Ht[] getHts() {
        return hts;
    }

    public void setHts(Ht[] hts) {
        this.hts = hts;
    }

   private Zc[] zcs;
    public int[] getZcCounts(){
        int[] counts = new int[zcs.length];
        for (int i = 0; i <counts.length ; i++) {
            counts[i]=zcs[i].getCount();
        }
        return counts;
    }

    public String[] getZcTimes(){
        String[] times=new String[zcs.length];
        for (int i = 0; i <times.length ; i++) {
            times[i]= zcs[i].getTime();
        }
        return times;
    }
    public String[] getZcDescriptions(){
        String[] descriptions=new String[zcs.length];
        for (int i = 0; i <descriptions.length ; i++) {
            descriptions[i]= zcs[i].getDescription();
        }
        return descriptions;
    }
    public String[] getZcFss(){
        String[] fss=new String[zcs.length];
        for (int i = 0; i <fss.length ; i++) {
            fss[i]= zcs[i].getFs();
        }
        return fss;
    }
    public String[] getZcFls(){
        String[] fls=new String[zcs.length];
        for (int i = 0; i <fls.length ; i++) {
            fls[i]= zcs[i].getFl();
        }
        return fls;
    }

   private Ht[] hts;
    public int[] getHtNumbers(){
        int[] numbers = new int[hts.length];
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i]=hts[i].getNumber();
        }
        return numbers;
    }

    public String[] getHtTimes(){
        String[] times=new String[hts.length];
        for (int i = 0; i <times.length ; i++) {
            times[i]= hts[i].getTime();
        }
        return times;
    }
    public String[] getHtDescriptions(){
        String[] descriptions=new String[hts.length];
        for (int i = 0; i <descriptions.length ; i++) {
            descriptions[i]= hts[i].getDescription();
        }
        return descriptions;
    }



    public void setEmail(String name) {
        this.email = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAll_sr(int all_sr) {
        this.all_sr = all_sr;
    }

    public void setAll_zc(int all_zc) {
        this.all_zc = all_zc;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public int getAll_sr() {
        return all_sr;
    }

    public int getAll_zc() {
        return all_zc;
    }
}
