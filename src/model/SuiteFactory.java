package model;

public class SuiteFactory implements IFactory{
	
	public Software createSoftware(SoftwareCategory category) {
		switch(category) {
			case TEXT_EDITOR:
				return new TextEditor("Escriv�o", 
						SoftwareCategory.TEXT_EDITOR);
			case SPREADSHEET_EDITOR:
				return new SpreadsheetEditor("Casos de planilha",
						SoftwareCategory.SPREADSHEET_EDITOR);
			case PRESENTATION_EDITOR:
				return new PresentationEditor("Editor de apresenta��es",
						SoftwareCategory.PRESENTATION_EDITOR);
			default:
				return null;
		}
	}

}
