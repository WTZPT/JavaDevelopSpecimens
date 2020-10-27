package com.example.specimens.BeanUtil;

import com.example.specimens.BeanUtil.Container;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.setName("willian");
        try{
            Object o = BeanUtils.getProperty(container,"name");
            System.out.println(o);
            BeanUtils.setProperty(container,"name","yyyyyyy");
            System.out.println(container.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
