package com.lanou.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dllo on 17/11/10.
 */
public class test {
    @Test
    public void test1() throws ParseException {
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = sdf.parse("2014-03-02");
        System.out.println(d2);


        if (d1.getTime()>d2.getTime()){
            System.out.println("123123");
        }
    }
    @Test
    public void test2(){
//        Date d1 = new Date();
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        return f.format(f.parse(d1));
//
//        f.format(f.parse(beginTime))
    }
}
