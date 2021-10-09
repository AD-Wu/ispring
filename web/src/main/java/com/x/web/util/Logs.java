package com.x.web.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 日志工具类
 *
 * @author AD
 * @date 2021/10/8 21:33
 */
@Component
public class Logs {
    
    public Logger getLog() {
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        String className = traces[2].getClassName();
        for (StackTraceElement trace : traces) {
            System.out.println(trace.getClassName());
        }
        Logger logger = LogManager.getLogger(className);
        return logger;
    }
    
}
