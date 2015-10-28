package com.common.tool;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by C2-41 on 15-10-28.
 */
public class PrintInfoThread extends Thread{
    private HttpServletResponse response;
    public PrintInfoThread(HttpServletResponse response){
        this.response=response;
    }
    public void run(){
        try{
        String information="you have got a message";
        PrintWriter writer= response.getWriter();
            // 由于浏览器原因（FireFox、IE有这个问题，Chrome正常），接收到的数据不会立即输出到页面上。这里首先输入长度大于1024的字符串。
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 1024; i++) {
                sb.append('a');
            }
            writer.println("<!-- " + sb.toString() + " -->"); // 注意加上HTML注释
            writer.flush();
        for(int i=0,max=information.length();i<max;i++){
            writer.print(information.substring(i,i+1));
            writer.flush();
            sleep(1000);
        }
        writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
