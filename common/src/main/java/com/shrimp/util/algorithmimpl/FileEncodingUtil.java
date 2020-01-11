package com.shrimp.util.algorithmimpl;

import com.shrimp.util.CheckUtil;
import com.shrimp.util.FileUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

/**
 * @description: 文件编码相关的一些工具函数
 * @author: shrimp
 * @date: Created in 2020-01-11 18:47
 * @version: 1.0
 */
public class FileEncodingUtil {

    /**
     * @Description: 把指定文件或目录转换成指定的编码
     * @Author Shrimp
     * @date: 2020-01-11 19:10
     * @param fileName        要转换的文件
     * @param fromCharsetName 源文件的编码
     * @param toCharsetName   要转换的编码
     * @Return: void
     *
     **/
    public static void convert(String fileName, String fromCharsetName, String toCharsetName) {
        convert(new File(fileName), fromCharsetName, toCharsetName, null);
    }

    /**
     * @Description: 把指定文件或目录转换成指定的编码
     * @Author Shrimp
     * @date: 2020-01-11 19:10
     * @param file            要转换的文件或目录
     * @param fromCharsetName 源文件的编码
     * @param toCharsetName   要转换的编码
     * @Return: void
     *
     **/
    public static void convert(File file, String fromCharsetName, String toCharsetName) {
        convert(file, fromCharsetName, toCharsetName, null);
    }

    /**
     * @Description: 把指定文件或目录转换成指定的编码
     * @Author Shrimp
     * @date: 2020-01-11 19:11
     * @param fileName        要转换的文件或目录
     * @param fromCharsetName 源文件的编码
     * @param toCharsetName   要转换的编码
     * @param filter          文件名过滤器
     * @Return: void
     *
     **/
    public static void convert(String fileName, String fromCharsetName, String toCharsetName, FilenameFilter filter) {
        convert(new File(fileName), fromCharsetName, toCharsetName, filter);
    }

    /**
     * @Description: 把指定文件或目录转换成指定的编码
     * @Author Shrimp
     * @date: 2020-01-11 19:12
     * @param file            要转换的文件或目录
     * @param fromCharsetName 源文件的编码
     * @param toCharsetName   要转换的编码
     * @param filter          文件名过滤器
     * @Return: void
     *
     **/
    public static void convert(File file, String fromCharsetName, String toCharsetName, FilenameFilter filter) {
        if (file.isDirectory()) {
            List<File> list = CheckUtil.valid(filter) ? FileUtil.listFileFilter(file, filter) :
                    FileUtil.listFile(file);
            if (CheckUtil.valid(list)) {
                for (File f : list) {
                    convert(f, fromCharsetName, toCharsetName, filter);
                }
            }
        } else {
            if (filter == null || filter.accept(file.getParentFile(), file.getName())) {
                String fileContent = getFileContentFromCharset(file, fromCharsetName);
                saveFile2Charset(file, toCharsetName, fileContent);
            }
        }
    }

    /**
     * @Description: 以指定编码方式读取文件，返回文件内容
     * @Author Shrimp
     * @date: 2020-01-11 19:13
     * @param file            要转换的文件
     * @param fromCharsetName 源文件的编码
     * @Return: java.lang.String
     *
     **/
    public static String getFileContentFromCharset(File file, String fromCharsetName) {
        String str = "";
        if (!Charset.isSupported(fromCharsetName)) {
            throw new UnsupportedCharsetException(fromCharsetName);
        }
        try (InputStream inputStream = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(inputStream, fromCharsetName)
        ) {
            char[] chs = new char[(int) file.length()];
            reader.read(chs);
            str = new String(chs).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @Description: 以指定编码方式写文本文件，存在会覆盖
     * @Author Shrimp
     * @date: 2020-01-11 19:13
     * @param file          要写入的文件
     * @param toCharsetName 要转换的编码
     * @param content       文件内容
     * @Return: void
     *
     **/
    public static void saveFile2Charset(File file, String toCharsetName, String content) {
        if (!Charset.isSupported(toCharsetName)) {
            throw new UnsupportedCharsetException(toCharsetName);
        }
        try (
                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outWrite = new OutputStreamWriter(outputStream, toCharsetName)
        ) {
            outWrite.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
