package com.shrimp.util.ftp;

import lombok.Data;

import java.util.Date;

/**
 * @description: FTP文件熟悉
 * @author: shrimp
 * @date: Created in 2020-01-11 18:45
 * @version: 1.0
 */
@Data
public class FileAttr {
    private String fileName;
    private Date ModifyTime;
    private Long size;
}
