package board.service;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class RenameFile implements FileRenamePolicy{

	Writer writer;
	
	public RenameFile(Writer writer) {
		this.writer = writer;
	}

	@Override
	public File rename(File file) {
		String uploadPath = "C:/Users/SJ02/git/group-project/src/main/webapp/image/uploadedImages";
		String fileName = file.getName();
		String extension = "";
		
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex != -1) {
			extension = fileName.substring(dotIndex);
			fileName = fileName.substring(0, dotIndex);
		}
		String newFileName = "";
		for(int i = 0; i < 2; i++) {
			newFileName = i + extension;
		}
		
		File renamedFile = new File(uploadPath, newFileName);
		return renamedFile;
	}
	
}
