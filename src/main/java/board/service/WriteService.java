package board.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteService {

	public List<String> uploadImages(HttpServletRequest request, HttpServletResponse response, Writer writer) throws Exception {
		String uploadPath = "C:/Users/SJ02/git/group-project/src/main/webapp/image/uploadedImages";
		List<String> imageList = new ArrayList<>();
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		RenameFile renamedFile = new RenameFile(writer);
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
//		while(files.hasMoreElements()) {
//			String file = (String) files.nextElement();
//			String fileName = multi.getFilesystemName(file);
//			String realFileName = multi.getOriginalFileName(fileName);
//			System.out.println(fileName);
//			imageList.add(realFileName);
//		}
		
		return imageList;
	}
	
	
}
