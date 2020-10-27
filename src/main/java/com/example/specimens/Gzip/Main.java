package com.example.specimens.Gzip;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.setName("yyyyy");
        container.setUuid("317t3721ha");
        String compreesString = GzipUtil.compressContainer(container);
        System.out.println(compreesString);
        System.out.println(GzipUtil.uncompress(compreesString));
    }
}
