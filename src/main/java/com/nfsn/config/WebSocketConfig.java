package com.nfsn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Auther: atnibamaitay
 * @Date: 2022/12/11 12:4
 * @Description: 这是一个WebSocket的配置类，注入对象ServerEndpointExporter，
 *               这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
 */
@Configuration
public class WebSocketConfig {
//    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}