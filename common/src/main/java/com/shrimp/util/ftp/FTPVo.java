package com.shrimp.util.ftp;

import lombok.Data;

/**
 * @description: 用于包装FTP的相关的信息
 * @author: shrimp
 * @date: Created in 2020-01-11 18:45
 * @version: 1.0
 */
@Data
public class FTPVo {
    private String hostName;
    private int port;
    private String username;
    private String password;
    private String remoteDir;
    private String localDir;
    private String remoteEncoding;
    private boolean passiveMode;
}
