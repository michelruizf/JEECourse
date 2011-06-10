package br.com.spikes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSender {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket clientSocket = new DatagramSocket();
		String message = "Hello World!";
		DatagramPacket pacote = new DatagramPacket(message.getBytes(), message.length(), new InetSocketAddress("127.0.0.1", 100));
		clientSocket.send(pacote);		
	}
}
