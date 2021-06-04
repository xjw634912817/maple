package com.maple.io.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClientDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(9090));
//        socketChannel.configureBlocking(false); // 设置非阻塞的关键
//        if (socketChannel.isConnectionPending()) {
//            socketChannel.finishConnect();
//        }
        
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("我是第一个NIO客户端哦 哈哈哈~".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        while (true) {
            byteBuffer.clear();
            int index = socketChannel.read(byteBuffer);
            if (index > 0) {
                System.out.println("我是第一个NIO客户端，收到了服务端的数据：" + new String(byteBuffer.array()));
            } else {
                System.out.println("我是第一个NIO客户端，没有收到服务端的数据...");
            }
            Thread.sleep(1000);
        }
    }
    
}
