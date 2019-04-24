package model;

import java.util.Scanner;

public abstract class Software {
	private String name;
	private SoftwareCategory category;
	
	public Software(String name, SoftwareCategory category) {
		super();
		this.name = name;
		this.setCategory(category);
	}

	public File createFile() throws Exception {
		//Reading inputs from the keyboard to instantiate the file  
		String name, path, email,printingAuth, copyAuth;
		
		Scanner keyboardInput = new Scanner(System.in);
		
		System.out.print("Name: ");
		name = keyboardInput.nextLine();
		System.out.print("Path: ");
		path = keyboardInput.nextLine(); 
		System.out.print("Email: ");
		email = keyboardInput.nextLine();
		System.out.print("Authorize printing? ");
		printingAuth = keyboardInput.nextLine();
		System.out.print("Authorize copy? ");
		copyAuth = keyboardInput.nextLine();
		
		keyboardInput.close();
		
		File newFile = 
				new File.FileBuilder(name, path)
				.withEmail(email)
				.denyPrinting(printingAuth)
				.denyCopy(copyAuth)
				.build();
		
		return newFile;
	}
	
	
	public void run() {
		System.out.println("Running " + this.getName());
		//this.createFile();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SoftwareCategory getCategory() {
		return category;
	}

	public void setCategory(SoftwareCategory category) {
		this.category = category;
	}
}
