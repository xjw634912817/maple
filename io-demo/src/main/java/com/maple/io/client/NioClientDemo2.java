package com.maple.io.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioClientDemo2 {

    static Selector selector;

    public static void main(String[] args) throws IOException {
        selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false); // 设置非阻塞的关键
        socketChannel.connect(new InetSocketAddress(9090));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isConnectable()) {
                    handleConnect(selectionKey);
                } else if (selectionKey.isReadable()) {
                    handleRead(selectionKey);
                }
            }
        }
    }

    private static void handleConnect(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel.isConnectionPending()) {
            socketChannel.finishConnect();
        }
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("我是NIO客户端2号，找你有点事".getBytes(StandardCharsets.UTF_8)));
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("我是NIO客户端2号，收到服务器的回复了: " + new String(byteBuffer.array()));
        socketChannel.write(ByteBuffer.wrap("开始尬聊".getBytes(StandardCharsets.UTF_8)));
        socketChannel.close();
    }
}
