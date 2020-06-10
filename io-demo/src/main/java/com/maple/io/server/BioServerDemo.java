package com.maple.io.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServerDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            Socket socket = serverSocket.accept();
            try (InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream()) {
                byte[] buf = new byte[1024];
                int length = inputStream.read(buf);
                if (length > 0) {
                    System.out.println("服务端接收到了请求：" + new String(buf, 0, length));
                }
                outputStream.write("你好，我是服务端，能听到我说话吗？".getBytes());
                outputStream.flush();
                Thread.sleep(10000);
            }
        }
    }

}
