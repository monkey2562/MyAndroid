package com.mk.myandroid.project.filebrowser;

import java.io.File;

public class EFile {
	public EFile(File file) {
		this.file = file;
	}
	
	private File file;
	
	public File getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		if(getFile() ==null){
			return "";
		}
		return String.format("%s%s", getFile().isDirectory()?"[DIR]":"[File]",getFile().getName());
	}
}
