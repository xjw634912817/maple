package com.maple.io.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServiceUpgradeDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(new Handler(socket));
        }
    }

    static class Handler implements Runnable {

        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream()) {
                byte[] buf = new byte[1024];
                int length = inputStream.read(buf);
                if (length > 0) {
                    System.out.println("服务端接收到了请求：" + new String(buf, 0, length));
                }
                outputStream.write("你好，我是升级版服务端2，多线程处理的哦，能听到我说话吗？".getBytes());
                outputStream.flush();
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
