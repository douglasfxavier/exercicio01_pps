package main;

import java.util.Scanner;

import model.File;
import model.Software;
import model.SoftwareCategory;
import model.Suite;
import model.SuiteFactory;

public class Client {

	public static void main(String[] args) {
		
		
		SuiteFactory suiteFactory = new SuiteFactory();
		Suite mySuite = new Suite("Office");
		
		////////////////////////////////////////////////////////////////
		// Creating and adding all software applications onto mySuite //
		////////////////////////////////////////////////////////////////
		
		for (SoftwareCategory sc: SoftwareCategory.values()){
			mySuite.addSoftware(suiteFactory
					.createSoftware(sc));
		}		
		////////////////////////////////////////////
		// Menu to choose the software/app to run //
		////////////////////////////////////////////
		
		System.out.println(
				"Aplicativos da Suite:\n"
				+ "(1) Editor de textos\n"
				+ "(2) Editor de planilhas\n"
				+ "(3) Editor de apresentações\n"
				+ "Digite o número do app que deseja executar:");
		
		Scanner keyboardInput = new Scanner(System.in);
		String inputCategory = keyboardInput.nextLine();
		
		
		/////////////////////////////////
		// Running the software chosen //
		////////////////////////////////
		
		Software software;
		switch (inputCategory) {
		case "1":
			software = mySuite.getAppByCategory(
					SoftwareCategory.TEXT_EDITOR);
			break;
		case "2":
			software = mySuite.getAppByCategory(
					SoftwareCategory.SPREADSHEET_EDITOR);
			break;
		case "3":
			software = mySuite.getAppByCategory(
					SoftwareCategory.PRESENTATION_EDITOR);
			break;
		default:
			software = null;
			break;
		}
		
		software.run();
		
		
		/////////////////////////////////////////////
		// Reading keyboard input to create a file //
		/////////////////////////////////////////////
				
		String name, path, email,printingAuth, copyAuth;
		
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
		
		try {
			File newFile = 
					new File.FileBuilder(name, path)
					.withEmail(email)
					.denyPrinting(printingAuth)
					.denyCopy(copyAuth)
					.build();

			///////////////////////////////////
			// Printing the data of the file //
			///////////////////////////////////
			
			System.out.println(newFile);
			
			//////////////////////
			// Copying the file //
			//////////////////////
			
			File fileCopy = newFile.copy();
			fileCopy.setName(String.format("Copy of %s", newFile.getName()));
			System.out.println(fileCopy);
		}
		catch (Exception e) {
			//System.out.println(e);
			if (e.getClass().equals(NullPointerException.class)) {
				System.out.println("Ponteiro invalido");
			}else if (e.getClass().equals(IllegalArgumentException.class)) {
				System.out.println(e.getMessage());
			}
		}
	}

}
