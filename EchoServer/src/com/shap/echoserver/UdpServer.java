package com.shap.echoserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class UdpServer implements Runnable {

    private DatagramSocket serverSocket;
    private byte[] receiveData = new byte[1024];

    public UdpServer() throws SocketException {
        this.serverSocket = new DatagramSocket(3535);
    }

    @Override
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(packet);
                new Thread(new Responder(serverSocket, packet)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Responder implements Runnable {

        DatagramSocket socket = null;
        DatagramPacket packet = null;

        public Responder(DatagramSocket socket, DatagramPacket packet) {
            this.socket = socket;
            this.packet = packet;
        }

        @Override
        public void run() {

            String username = new String(packet.getData());
            String responseString = "Hello, " + username;
            byte[] sendData = responseString.getBytes();
            DatagramPacket response = new DatagramPacket(sendData, sendData.length, packet.getAddress(),
                    packet.getPort());
            try {
                socket.send(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
