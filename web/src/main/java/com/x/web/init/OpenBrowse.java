package com.x.web.init;

import com.x.Starter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

/**
 * 启动类
 *
 * @author AD
 * @date 2021/10/8 21:29
 */
@Log4j2
@Component
public class OpenBrowse extends Starter {

    @Value("${server.port}")
    private int port;

    @Override
    public String getBrowseUrl() {
        return "http://localhost:" + port + "/api/index.html";
    }

}
