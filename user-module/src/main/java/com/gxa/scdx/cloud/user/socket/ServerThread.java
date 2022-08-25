package com.gxa.scdx.cloud.user.socket;


import com.gxa.scdx.cloud.user.service.impl.ProcessDataServiceImpl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;


import static jdk.nashorn.internal.objects.NativeString.substring;


/**
 * Server
 *
 * @author 王研博
 * @version 1.0
 * @since 2021-06-25 11:06:08
 */


public class ServerThread extends Thread{

    /**
     * socket连接对象
     */
    private Socket socket;

    private InputStreamReader inputStreamReader;

    public ServerThread()
    {

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private ProcessDataServiceImpl processDataServiceImpl;
//
    public ServerThread(Socket socket, ProcessDataServiceImpl processDataService){
        this.processDataServiceImpl = processDataService;
        this.socket = socket;
    }
//
//    public ServerThread2(Socket socket, ProcessDataService processDataService){
//        this.socket = socket;
//        this.processDataService = processDataService;
//    }


    @Override
    public void run() {
        try {
            //获取客户端信息
            InetAddress inetAddress = socket.getInetAddress();
            //ip地址
            String ip = inetAddress.getHostAddress();
            System.out.println("客户端："+ip+"连接成功");
            //输入流包装
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            //接受客户端消息
            String msg = getData(inputStreamReader);
            Integer deviceid = Integer.valueOf(substring(msg,0,1));
            Integer option = Integer.valueOf(substring(msg,1,2));
            msg = substring(msg,2);
            //处理数据
            System.out.println(msg);
            processDataServiceImpl.process(option,msg,deviceid);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeResources(inputStreamReader, socket);
        }

    }

    /**
     * 获取输入数据的方法
     * @param inputStreamReader
     * @return String
     */
    private String getData(InputStreamReader inputStreamReader) throws IOException{

        char[] chars = new char[1024];

        //读取的量
        int read;

        //循环 拼接 使用StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        while ((read = inputStreamReader.read(chars)) != -1){
            System.out.println(read + "个字符");
            stringBuilder.append(new String(chars,0,read));
        }

        return stringBuilder.toString();
    }

    /**
     * 清空资源
     * @param inputStreamReader
     * @param socket
     */
    private void closeResources(InputStreamReader inputStreamReader, Socket socket){

        try {
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
