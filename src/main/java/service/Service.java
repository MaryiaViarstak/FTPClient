package service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Service {
	
	private static final String DIRECTORY = "Download/";
	
	public Service() {
		
	}
	
	public  void printHelp() {
		System.out.println("------list - print directory content");
		System.out.println("------cd - go into folders");
		System.out.println("------parent - go to parent directory");
		System.out.println("------download - download file from current directory");
		System.out.println("------exit - exit");
	}
	
	public  FTPFile[] getDirectoryList(FTPClient client) {
		FTPFile[] files = null;
		try {
			files = client.listFiles();
			if (files.length != 0) {
				for(FTPFile file : files) {
					if (file.isDirectory()) {
						System.out.println("Directory:" + "[" + file.getName() + "]");
					} else {
						System.out.println("File:" + file.getName());
					}
				}
			} else {
				System.out.println("Directory is empty!");
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		return files;	
	}
	
	public  void changeDirectory(FTPClient client, String directory) {
		try {
			if (client.changeWorkingDirectory(directory)) {
				System.out.println("You are in directory " + directory + ".");
			} else {
				System.out.println("There are not such directory!");
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	public  void retrieveParentDirectory(FTPClient client) {
		try {
			client.changeToParentDirectory();
			System.out.println("You are in a parent directory now.");
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}
	
	public  void downloadFile(FTPClient client, String file) {
		try {
			FTPFile[] files = client.listFiles(file);
			if (files.length != 0) {
				File path = new File(DIRECTORY + file);
			    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
			    boolean success = client.retrieveFile(file, outputStream);
			    outputStream.close();
			    if (success) {
			    	System.out.println("File " + file + " has been downloaded successfully into folder " + DIRECTORY);
			    } else {
			        System.out.println("File " + file + " has not been downloaded.");
			    } 
			} else {
				System.out.println("There isn't such file!");
			}
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}
}
