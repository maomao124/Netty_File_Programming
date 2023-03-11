package mao.t4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Project name(项目名称)：Netty_File_Programming
 * Package(包名): mao.t4
 * Class(类名): FilesTest4
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/11
 * Time(创建时间)： 22:02
 * Version(版本): 1.0
 * Description(描述)： 拷贝文件
 */

public class FilesTest4
{
    public static void main(String[] args) throws InterruptedException
    {
        Path path1 = Paths.get("./test.txt");
        Path path2 = Paths.get("./test2.txt");

        try
        {
            //拷贝文件
            Path path = Files.copy(path1, path2);
            System.out.println(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            //再次尝试拷贝文件，如果文件已存在，会抛异常 FileAlreadyExistsException
            Files.copy(path1, path2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Thread.sleep(100);

        try
        {
            //拷贝文件
            Path path = Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件覆盖成功");
            System.out.println(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
