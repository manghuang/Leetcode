package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOClient {
    public static void main(String[] args) throws IOException {

        // 1.获得一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 2.设置为非阻塞
        socketChannel.configureBlocking(false);
        // 3.connect连接到服务器,立即返回，所以是非阻塞的，需要轮询来获取结果，所以是同步的
        // 同步非阻塞
        InetSocketAddress inetSocketAddress = new InetSocketAddress(6666);
        if(!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("再次尝试获取结果......");
            }
        }
        // 4.发送数据
        System.out.println("客户端已经启动");
        String str = "NIO";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}
