package com.example.specimens.Gzip;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String compressContainer(Container container) {
        if(container == null){
            return null;
        }
        String containerStr = objectMapper.writeValueAsString(container);
        return compress(containerStr);
    }

    @SneakyThrows
    public static Container uncompressContainer(String containerStr) {
        if(StringUtils.isEmpty(containerStr)){
            return null;
        }
        String uncompressStr = uncompress(containerStr);
        return objectMapper.readValue(uncompressStr, Container.class);
    }

    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
            gzip.close();
            return out.toString(StandardCharsets.ISO_8859_1.name());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String uncompress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(str
                    .getBytes(StandardCharsets.ISO_8859_1));
            GZIPInputStream gunzip;
            gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer))>= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
