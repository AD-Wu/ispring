package com.x;

import java.awt.Desktop;
import java.net.URI;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动类
 *
 * @author AD
 * @date 2021/10/8 21:29
 */
@Log4j2
public abstract class Starter implements CommandLineRunner {

    static {
        // Desktop.getDesktop(); 防止报错
        System.setProperty("java.awt.headless", "false");
    }

    @Value("${server.port}")
    private int port;

    /**
     * 打开浏览器
     *
     * @param args
     *
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // "http://localhost:" + port + "/api/index.html";
        String url = getBrowseUrl();
        try {
            // 创建一个URI实例
            URI uri = URI.create(url);
            // 获取当前系统桌面扩展
            Desktop desktop = Desktop.getDesktop();
            // 判断系统桌面是否支持要执行的功能
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // 获取系统默认浏览器打开链接
                desktop.browse(uri);
                log.info("打开路径:{}", url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public abstract String getBrowseUrl();
}
