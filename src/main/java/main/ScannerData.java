package main;

import java.util.Scanner;

public class ScannerData {
	
	private static final String LOGIN = "anonymous";
	
	private static final String PASSWORD = "123";

	public String getServer() {
		String server = "";
		System.out.println("Hello! On which FTP Server do you want to go?");
		Scanner scanServer = new Scanner(System.in);
		server = scanServer.nextLine();
		return server;
	}
	
	public String getLogin() {
		String login = "";
		System.out.println("Enter the login");
		Scanner scanLogin = new Scanner(System.in);
		login = scanLogin.nextLine();
		if (login.equals("")) {
			login = LOGIN;
		}
		return login;
	}
	
	public String getPassword() {
		String password = "";
		System.out.println("Enter the password");
		Scanner scanPassword = new Scanner(System.in);
		password = scanPassword.nextLine();
		if (password.equals("")) {
			password = PASSWORD;
		}
		return password;
	}
	
	public String[] getArray() {
		Scanner scanCommand = new Scanner(System.in);
		String line = scanCommand.nextLine();
		String[] commands = line.split("\\s+");
		return commands;
	} 
	
}
