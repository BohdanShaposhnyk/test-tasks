package com.shap.echoserver;

import java.net.SocketException;

/**
 * Created by shpk on 12.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
            new Thread(new UdpServer()).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
