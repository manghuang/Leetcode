package io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bio {

    public static void main(String[] args) throws Exception{

        // 1.创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 2.创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("serverSocket监听的地址和端口号：" + serverSocket.getInetAddress() + "  " + serverSocket.getLocalPort());
        System.out.println("服务器启动了......");
        // 3. 循环监听
        while (true){
            // 3.1 阻塞,监听连接事件
            // 同步阻塞
            final Socket socket = serverSocket.accept();
            System.out.println("连接到的远程地址和端口（客户端）：" + socket.getInetAddress() + "  " + socket.getPort());
            System.out.println("本地地址和端口（服务器）：" + socket.getLocalAddress() +"  " + socket.getLocalPort());

            // 3.2 为每一个一个连接开启一个线程
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] bytes = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        while (true){
                            int read = inputStream.read(bytes);  // 阻塞
                            if(read != -1){
                                System.out.println(new String(bytes, 0, read));
                            }else {
                                break; // 不会执行
                            }
                        }
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
