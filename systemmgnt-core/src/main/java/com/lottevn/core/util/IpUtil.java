package com.lottevn.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
    public static String getLocalIp() {
        String ip = "";

        InetAddress local;
        try {
            local = InetAddress.getLocalHost();
            ip = local.getHostAddress();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

        return ip;
    }

    //client ip 조회
    public static String getClientIP(HttpServletRequest request) {

        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
