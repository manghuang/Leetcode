package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        // 1. 创建ServerSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2. 创建一个Selector
        Selector selector = Selector.open();

        // 3.绑定端口6666，进行监听
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(6666));

        // 4.设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 5.将serverSocketChannel注册进selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端已经启动");
        // 6.循环
        while (true){

            // 6.1 多路复用 private native int poll0(long var1, int var3, int[] var4, int[] var5, int[] var6, long var7);
            // 阻塞的是事件通知，在事件处理阶段是异步的，所以是异步阻塞的
            // 异步阻塞
            int symbol = selector.select();
            System.out.println("发生的事件个数：" + symbol);
            // 6.2 获取关注的事件并遍历
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                // 发生的是accept事件
                if(selectionKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("channel:" + socketChannel.hashCode());
                    System.out.println("socket:" + socketChannel.socket().hashCode());
                }
                // 发生的是read事件
                else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("channel:" + socketChannel.hashCode());
                    System.out.println("socket:" + socketChannel.socket().hashCode());
                    System.out.println("内容:" + new String(byteBuffer.array()));
                }

                // 移除事件
                iterator.remove();
            }
        }

    }
}
