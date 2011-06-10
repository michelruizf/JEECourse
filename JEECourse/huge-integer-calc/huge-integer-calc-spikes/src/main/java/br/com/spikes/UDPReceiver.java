package br.com.spikes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket serverSocket = new DatagramSocket(100);
		byte[] message = new byte[100];
		DatagramPacket pack = new DatagramPacket(message, message.length);
		
		while(true){
			serverSocket.receive(pack);
			System.out.println(new String(message, 0, pack.getLength()));
		}
	}
}
