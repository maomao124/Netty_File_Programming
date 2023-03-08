package mao.t1;

import mao.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_File_Programming
 * Package(包名): mao.t1
 * Class(类名): FileChannelGetTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/8
 * Time(创建时间)： 22:10
 * Version(版本): 1.0
 * Description(描述)： 得到FileChannel
 */

public class FileChannelGetTest
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(FileChannelGetTest.class);

    /**
     * main方法
     *
     * @param args 参数
     */
    public static void main(String[] args)
    {
        //第一种方法，通过 FileInputStream 获取
        try (FileInputStream fileInputStream = new FileInputStream("test.txt"))
        {
            FileChannel fileChannel = fileInputStream.getChannel();
            log.debug(fileChannel.toString());
            //尝试读
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();
            byte b = byteBuffer.get(2);
            log.debug(String.valueOf((char) b));
            //打印
            ByteBufferUtil.debugAll(byteBuffer);

            //尝试写
            byteBuffer.clear();
            byteBuffer.put("abc".getBytes(StandardCharsets.UTF_8));
            //打印
            ByteBufferUtil.debugAll(byteBuffer);
            try
            {
                fileChannel.write(byteBuffer);
            }
            catch (Exception e)
            {
                log.error("写入失败：", e);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //第二种方法，通过 FileInputStream 获取
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.txt"))
        {
            FileChannel fileChannel = fileOutputStream.getChannel();
            log.debug(fileChannel.toString());
            //尝试读
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            try
            {
                fileChannel.read(byteBuffer);
                byteBuffer.flip();
                byte b = byteBuffer.get(2);
                log.debug(String.valueOf((char) b));
                //打印
                ByteBufferUtil.debugAll(byteBuffer);
            }
            catch (Exception e)
            {
                log.error("读失败：", e);
            }

            //尝试写
            byteBuffer.clear();
            byteBuffer.put("abc".getBytes(StandardCharsets.UTF_8));
            //打印
            ByteBufferUtil.debugAll(byteBuffer);
            try
            {
                //切换读模式
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
            }
            catch (Exception e)
            {
                log.error("写入失败：", e);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
