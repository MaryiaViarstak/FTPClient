package main;

import org.apache.commons.net.ftp.FTPClient;

import controller.Controller;
import service.Client;

public class MainClass {
	
	private static String login = "";
	
	private static String password = "";
	
	private static String server = "";
	

	public static void main(String[] args) {
		try {
			ScannerData scanner = new ScannerData();
			server = scanner.getServer();
			login = scanner.getLogin();
			password = scanner.getPassword();
			FTPClient client = Client.connectServer(server, login, password);
			if (client.isConnected()) {
				while (true) {
					String[] commands = scanner.getArray();
					Controller controller = new Controller(commands);
					controller.chooseCommand(client);
				}
			}
		} catch (Exception e) {
			System.out.println("Message " + e.getMessage());
		}
		

	}

}
