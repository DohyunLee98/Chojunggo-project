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

	public List<String> uploadImages(HttpServletRequest request, HttpServletResponse response, Writer writer)
			throws Exception {
		String uploadPath = "C:/Users/SJ02/git/group-project/src/main/webapp/image/uploadedImages";
		List<String> imageList = new ArrayList<>();

		checkDirectory(uploadPath);  
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());

		Enumeration files = multi.getFileNames();
		
		while (files.hasMoreElements()) {
			String file = (String) files.nextElement();
			String fileName = multi.getFilesystemName(file);
			String fileRealName = multi.getOriginalFileName(file);

			if (fileName != null) {
				File originFile = new File(uploadPath + "/" + fileName);
				String originFileName = originFile.getName();
				String ext = originFileName.substring(originFileName.lastIndexOf("."));
				String renamedFile = writer.getNickname() + ext;
				File tempFile = new File(uploadPath + "/" + renamedFile);

				if (!originFile.renameTo(tempFile)) {
					System.err.println("파일명 변경 실패");
				}
				imageList.add(renamedFile);
				System.out.println(renamedFile);
			} // 살려주세요....

		}

		return imageList;
	}

	public void checkDirectory(String uploadPath) {
		File uploadDir = new File(uploadPath); 
		if (!uploadDir.exists())
			uploadDir.mkdirs();  // 해당 폴더가 없을 경우 생성
	}
}
