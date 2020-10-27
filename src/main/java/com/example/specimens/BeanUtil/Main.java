package com.example.specimens.BeanUtil;



import java.awt.Container;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.setName("willian");
        try{
            Object o = BeanUtils.getProperty(container,"name");
            System.out.println(o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
