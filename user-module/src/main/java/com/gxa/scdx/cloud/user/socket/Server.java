package com.gxa.scdx.cloud.user.socket;

import com.gxa.scdx.cloud.user.service.impl.ProcessDataServiceImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Server
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */

@DependsOn("testController")
@Component
public class Server {

    public Server(ProcessDataServiceImpl processDataService) throws IOException {
        //指定端口
        Integer port = 9999;
        //注册服务端的socket对象
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("socket服务注册成功");
        System.out.println("等待客户端连接……");

        new Thread(new Runnable() {

            @Override
            public void run(){
                while (true){
                    //监听-阻塞
                    Socket accept = null;
                    try {
                        accept = serverSocket.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //创建并启动线程
//            new ServerThread(accept).start();
                    //System.out.println(accept);
                    new ServerThread(accept, processDataService).start();
                }
            }
        }).start();

    }

}