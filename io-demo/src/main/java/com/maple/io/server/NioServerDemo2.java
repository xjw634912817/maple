package com.maple.io.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServerDemo2 {

    static Selector selector;

    public static void main(String[] args) throws IOException, InterruptedException {
        // NIO: Channel、Buffer、Selector
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9090));
        serverSocketChannel.configureBlocking(false); // 设置非阻塞的关键
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select(); // 这里是阻塞的
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    handleAccept(selectionKey);
                } else if (selectionKey.isReadable()) {
                    handleRead(selectionKey);
                }
            }
        }
    }

    private static void handleAccept(SelectionKey selectionKey) throws IOException {
        // 因为main方法已经调用过serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT)，所以这边处理Accept可以直接强转
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("我是NIO服务器2，欢迎光临".getBytes(StandardCharsets.UTF_8)));
        // 写完数据后要读，所以注册读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("我是NIO服务器2，有收到客户端过来的数据: " + new String(byteBuffer.array()));
        socketChannel.write(ByteBuffer.wrap("我是NIO服务器2，反手给你一个回复".getBytes(StandardCharsets.UTF_8)));
        socketChannel.close();
    }

}
