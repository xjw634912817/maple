package com.maple.io.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServerDemo {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        // NIO: Channel、Buffer、Selector
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9090));
        serverSocketChannel.configureBlocking(false); // 设置非阻塞的关键
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                System.out.println("连接还没好，服务器继续等待");
                Thread.sleep(1000);
                continue;
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
            
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        }
    }

}
