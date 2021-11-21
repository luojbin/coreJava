package com.loyofo.core.s16_io;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws Exception{
        //打开原始输入文件 D:\Java\IdeaSpace\coreJava\target\classes\1874.mflac
        FileInputStream in = new FileInputStream("D:/Java/IdeaSpace/coreJava/target/classes/1874.mflac");

        //打开目标的输出文件
        FileOutputStream out = new FileOutputStream("d:/test.flac");

        System.out.println("开始！");
        // 先写入flac 文件头
        // 0x66, 4C 0x61, 0x43, 0x00, 0x00, 0x00, 0x22,  0x12, 0x00, 0x12, 0x00, 0x00, 
        
        byte[] header = {0x66, 0x4C, 0x61, 0x43, 0x00, 0x00, 0x00, 0x22,  0x12, 0x00, 0x12, 0x00, 0x00};
        out.write(header);

        //1K byte
        //从输入流in中读取尽可能多的byte填充到缓存 buf 中，返回读取个数 1024
        byte[] buf1 = new byte[1024*8];
        byte[] buf2 = new byte[1024*8];

        int n1, n2;
        n1 = in.read(buf1);
        while((n2 = in.read(buf2))!=-1){
            out.write(buf1, 0, n1);
            if (n2 == 8192) {
                System.out.println("n2=8192");
                // 如果buf2 满了, 说明文件没结束
                // buf2 内容放到 buf1 暂存
                System.arraycopy(buf2, 0, buf1, 0, n2);
            } else {
                System.out.println("n2!=8192");
                // 如果 n2 不等于 1024, 即 buf2 不满
                // 说明buf2 是文件最后一段
                // 写入 buf2, 不含最后几位
                out.write(buf2, 0, n2-5);
            }
        }
        //关闭in，out即可
        in.close();
        out.close();
        System.out.println("成功！");
    }

    @Test
    @Disabled
    public void method2() throws IOException {
        //打开原始输入文件 D:\Java\IdeaSpace\coreJava\target\classes\1874.mflac
        FileInputStream in = new FileInputStream("D:/Java/workspace/demo-luojbin/coreJava/basic/target/classes/1877.flac");
        //打开目标的输出文件
        FileOutputStream out = new FileOutputStream("d:/test.flac");

        System.out.println("开始！");

        //1K byte
        //从输入流in中读取尽可能多的byte填充到缓存 buf 中，返回读取个数 1024
        byte[] outBuf = new byte[1024*8];

        int n1;
        // 先读一波到输出缓冲区
        while((n1 = in.read(outBuf))!=-1){
            out.write(outBuf, 0, n1);
        }
        //关闭in，out即可
        in.close();
        out.close();
        System.out.println("成功！");
    }
}
