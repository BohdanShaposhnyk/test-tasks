package com.shap.echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class UdpClient {

    private static final int serverPort = 3535;

    public static void main(String[] args) {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String username = null;
        InetAddress serverAddress = null;
        DatagramSocket clientSocket = null;
        System.out.println("Enter your name: ");

        try {
            username = userInput.readLine();
            clientSocket = new DatagramSocket();
            serverAddress = InetAddress.getByName("localhost");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] receiveData = new byte[1024];
        byte[] sendData = username.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        try {
            clientSocket.send(sendPacket);
            clientSocket.receive(receivePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String answer = new String(receivePacket.getData());
        System.out.println("Reply: " + answer);
        clientSocket.close();

    }

}
