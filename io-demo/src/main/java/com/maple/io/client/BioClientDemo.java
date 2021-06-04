package com.maple.io.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BioClientDemo {

    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
        Socket socket = new Socket("127.0.0.1", 9090);
        try (OutputStream outputStream = socket.getOutputStream(); InputStream inputStream = socket.getInputStream()) {
            outputStream.write("我是客户端，我来了！".getBytes());
            outputStream.flush();
            
            byte[] buf = new byte[1024];
            int length = inputStream.read(buf);
            if (length > 0) {
                System.out.println("客户端接收到了请求：" + new String(buf, 0, length));
            }
        }

    }

}
