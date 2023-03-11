package mao.t4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Project name(项目名称)：Netty_File_Programming
 * Package(包名): mao.t4
 * Class(类名): FilesTest3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/11
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： 创建多级目录
 */

public class FilesTest3
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("./abc/d/e/f/g/h");
        //创建多级目录
        Path directories = Files.createDirectories(path);
        System.out.println(directories);

        //再次创建
        path = Paths.get("./abc/d/e/f/g/h");
        directories = Files.createDirectories(path);
        System.out.println(directories);
    }
}
