package com.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDownload {
    public static void main(String[] args) throws IOException {
        //下载地址
        URL url = new URL("http://localhost:8080/ccq/security.txt");
        //获取连接
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //获取输入流
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("security.txt");
        //写到本地文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,buffer.length);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}
