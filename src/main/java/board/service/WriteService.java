package board.service;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import com.oreilly.servlet.MultipartRequest;

import board.dao.BoardDAO;
import board.model.WriteRequest;
import jdbc.connection.ConnectionProvider;

public class WriteService {

	String uploadPath;
	List<String> imageList;
	BoardDAO boardDAO = new BoardDAO();

	public List<String> uploadImages(MultipartRequest multi, Writer writer, String path) throws Exception {
		imageList = new ArrayList<>();
		uploadPath = path;

		checkDirectory(uploadPath);

		Enumeration files = multi.getFileNames();

		imageList = renameImage(multi, files); // 이미지 이름 변경

		return imageList;
	}

	
	private List<String> renameImage(MultipartRequest multi, Enumeration files) {
		while (files.hasMoreElements()) {
			String file = (String) files.nextElement();
			String fileName = multi.getFilesystemName(file);

			if (fileName != null) {
				File originFile = new File(uploadPath + "/" + fileName);
				String originFileName = originFile.getName();
				String ext = originFileName.substring(originFileName.lastIndexOf("."));
				String renamedFile = System.currentTimeMillis() + ext;
				File tempFile = new File(uploadPath + "/" + renamedFile);

				if (!originFile.renameTo(tempFile)) {
					System.err.println("파일명 변경 실패");
				}
				imageList.add(renamedFile);
			}

		}
		return imageList;
	}

	private void checkDirectory(String uploadPath) {
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdirs(); // 해당 폴더가 없을 경우 생성
	}

	public int insertContent(WriteRequest writeRequest) throws Exception {
		Board board = new Board(null, writeRequest.getWriter(), writeRequest.getContent());
		try (Connection con = ConnectionProvider.getConnection()) {
			int boardNum = boardDAO.insertBoard(con, board);
			
			BoardContent boardContent = toBoardContent(boardNum, writeRequest);
			BoardDetail boardDetail = toBoardDetail(boardNum, writeRequest);
			Photo photo = new Photo(boardNum, imageList);
			
			boardDAO.insertBoardContent(con, boardContent);
			boardDAO.insertBoardDetail(con, boardDetail);
			boardDAO.insertPhoto(con, photo);
			
			return boardNum;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	private BoardDetail toBoardDetail(int boardNum, WriteRequest writeRequest) {
		BoardDetail boardDetail = 
				new BoardDetail(boardNum, writeRequest.getTitle(), writeRequest.getPrice(), 0, writeRequest.getCategory(), writeRequest.getLocation(), new Date(), writeRequest.getImgNames().get(0));
		return boardDetail;
	}

	public BoardContent toBoardContent(int boardNum, WriteRequest writeRequest) {
		BoardContent boardContent = new BoardContent(boardNum, writeRequest.getWriter().getId(),
				writeRequest.getContent(), writeRequest.getProductCondition(), writeRequest.getDeliveryFee());
		return boardContent;
	}
}
