package controller;



import org.apache.commons.net.ftp.FTPClient;

import service.Client;
import service.Service;

public class Controller {
	
	private String[] commands = null;
	
	public Controller(String[] commands) {
		this.commands = commands;
	}
	
	public void chooseCommand(FTPClient client) {
		Service service = new Service();
		String parameter = "";
		switch (commands[0]) {
			case "help":
				service.printHelp();
			break;
			
			case "list": 
				service.getDirectoryList(client);
			break;
			
			case "cd":
				parameter = getParameter(commands);
				if (parameter != null) {
					service.changeDirectory(client, parameter);
				} else {
					System.out.println("Enter directory!");
				}
			break;
			
			case "parent":
				service.retrieveParentDirectory(client);
			break;
			
			case "download":
				parameter = getParameter(commands);
				if (!parameter.equals("")) {
					service.downloadFile(client, parameter);
				} else {
					System.out.println("Enter file!");
				}
			break; 
			
			case "exit":
				Client.disconnectServer();
				System.exit(0);
			default: 
				System.out.println("There isn't such commamd! Use help to see the list of commands!");
			break;
		}		
	}
	
	private String getParameter(String[] commands) {
		String parameter = "";
		if (commands.length > 1) {
			parameter = commands[1];
		}
		return parameter;	
	}	
}
