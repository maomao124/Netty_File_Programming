package mao.t4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Project name(项目名称)：Netty_File_Programming
 * Package(包名): mao.t4
 * Class(类名): FilesTest5
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/11
 * Time(创建时间)： 22:10
 * Version(版本): 1.0
 * Description(描述)： 创建文件夹
 */

public class FilesTest5
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(FilesTest5.class);

    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        //目录的深度
        int directoryDepth = 3;
        //目录的广度
        int directoryBreadth = 3;

        System.out.print("输入目录的深度：");
        directoryDepth = input.nextInt();

        System.out.print("输入目录的广度：");
        directoryBreadth = input.nextInt();

        System.out.println();


        int[] pathNumbers = new int[directoryDepth];

        int pow = (int) Math.pow(directoryBreadth, directoryDepth);
        log.info("pow:" + pow);
        for (int i = 0; i < pow; i++)
        {
            for (int j = 0; j < directoryDepth; j++)
            {
                int s = i;
                for (int k = 0; k < j; k++)
                {
                    s = s / directoryBreadth;
                }
                pathNumbers[pathNumbers.length - 1 - j] = s % directoryBreadth;
            }
            String pathString = toPath(pathNumbers);
            log.debug(pathString);
            Path path = Paths.get(pathString);
            Path directories = Files.createDirectories(path);
            //log.debug(directories.toString());
        }

        log.info("一共创建" + pow + "次");

    }


    private static String toPath(int[] pathNumbers)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".");
        for (int pathNumber : pathNumbers)
        {
            stringBuilder.append("/").append(pathNumber);
        }
        return stringBuilder.toString();
    }
}
