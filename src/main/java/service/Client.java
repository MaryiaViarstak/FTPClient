package service;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class Client {
	
	private static  FTPClient client = new FTPClient();
	
	private Client() {
		
	}
	
	public static FTPClient connectServer(String server, String login, String password) {
			try {
				client.connect(server);
				client.login(login, password);
				if (client.isConnected()) {
					System.out.println("The connection to the server is successful! Use help to see the list of commands!");
				} else {
					System.out.println("The connection is closed temporarily! Try again later, please.");				
				}
			} catch (Exception e) {
				System.out.println("You server is incorrect!");
			}
			return client;
	}
	
	public static void disconnectServer() {
		try {
			client.disconnect();
			System.out.println("Server is disconnect!");
		} catch (IOException e) {
			System.out.println("Server isn't disconnect!");
		}
	}
}
