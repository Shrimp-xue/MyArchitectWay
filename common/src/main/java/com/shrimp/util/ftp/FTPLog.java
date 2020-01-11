package com.shrimp.util.ftp;

import com.shrimp.util.DateUtil;
import lombok.Data;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-11 18:41
 * @version: 1.0
 */
@Data
public class FTPLog {
    private String host;
    private String operation;
    private int ReplyCode;
    private String localFile;
    private String remoteFile;
    private String ReplyCodeDesc;
    private String createTime = DateUtil.currentDateTime();
}
