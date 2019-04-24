package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class File implements Cloneable, FileServices{
	private String name, path, email;
	private Date date;
	private Boolean printingAuth, copyAuth;
	
	// Private constructor
	//private File() {} 
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Byte[] read() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public File copy() {
		try {
			return (File) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	//Builder
	public static class FileBuilder implements IBuilder<File> {
		File file = new File();
					
		public FileBuilder(String name, String path) throws Exception {
			
			if (name.isEmpty() || path.isEmpty()) throw 
				new IllegalArgumentException("Parametros invalidos");
			file.name = name;
			file.path = path;
			file.date = new GregorianCalendar().getTime();
			//Standard: printable and copyable
			file.printingAuth = true;
			file.copyAuth = true;
		}

		public FileBuilder withEmail(String email) {
			this.file.email = email;
			return this;
		}
		
		public FileBuilder denyCopy(String yesNo) 
		{	
			if (yesNo.toLowerCase().equals("no")) {
				this.file.copyAuth = false;
			}
			return this;
		}
		
		public FileBuilder denyPrinting(String yesNo) {
			if (yesNo.toLowerCase().equals("no")) {
				this.file.printingAuth = false;
			}
			return this;
		}

		@Override
		public File build() {
			return file;
		}
		
	}
	
	//Getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getPrintingAuth() {
		return printingAuth;
	}

	public void setPrintingAuth(Boolean printingAuth) {
		this.printingAuth = printingAuth;
	}

	public Boolean getCopyAuth() {
		return copyAuth;
	}

	public void setCopyAuth(Boolean copyAuth) {
		this.copyAuth = copyAuth;
	}
	
	
	@Override
	public String toString() {
		return "File [name=" + name + ", path=" + path + ", email=" + email + ", date=" + date + ", printingAuth="
				+ printingAuth + ", copyAuth=" + copyAuth + "]";
	}
	
}
