package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.service.Board;
import board.service.BoardContent;
import board.service.BoardDetail;
import board.service.Photo;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.auth.service.User2;

public class BoardDAO {

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public int insertBoard(Connection con, Board board) {
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("insert into board (user_id, user_nickname, trade_status) values (?, ?, '판매 중')");
			ps.setString(1, board.getUser2().getId());
			ps.setString(2, board.getUser2().getNickname());
			int insertedCount = ps.executeUpdate();

			if (insertedCount > 0) {
				stmt = con.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from board");
				if (rs.next()) {
					int boardNum = rs.getInt(1);
					return boardNum;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
		}
		return -1;

	}

	public void insertBoardContent(Connection con, BoardContent boardContent) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into board_content (board_num, user_id, content, product_condition, delivery_fee) values (?, ?, ?, ?, ?)");
			ps.setInt(1, boardContent.getBoardNum());
			ps.setString(2, boardContent.getId());
			ps.setString(3, boardContent.getContent());
			ps.setString(4, boardContent.getProductCondition());
			ps.setInt(5, boardContent.getDeliveryFee());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}

	}

	public void insertBoardDetail(Connection con, BoardDetail boardDetail) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into board_detail (board_num, title, category, price, location, created_date, thumb_name) values (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, boardDetail.getBoardNum());
			ps.setString(2, boardDetail.getTitle());
			ps.setString(3, boardDetail.getCategory());
			ps.setInt(4, boardDetail.getPrice());
			ps.setString(5, boardDetail.getLocation());
			ps.setTimestamp(6, toTimestamp(boardDetail.getCreatedDate()));
			ps.setString(7, boardDetail.getThumbName());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}

	}

	public void insertPhoto(Connection con, Photo photos) {
		PreparedStatement ps = null;
		try {
			for (int i = 0; i < photos.getImageName().size(); i++) {
				ps = con.prepareStatement("insert into photo (board_num, image_name) values (?, ?)");
				ps.setInt(1, photos.getBoardNum());
				ps.setString(2, photos.getImageName().get(i));
				ps.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}
	}

	public Board selectBoard(Connection con, int boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Board board = null;
		try {
			ps = con.prepareStatement("select * from board where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				board = new Board(boardNum, new User2(rs.getString("user_id"), rs.getString("user_nickname")),
						rs.getString("trade_status"));

				return board;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public BoardContent selectContent(Connection con, int boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardContent content = null;
		try {
			ps = con.prepareStatement("select * from board_content where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				String productCondition = convertProductCondtion(rs.getString("product_condition"));
				content = new BoardContent(boardNum, rs.getString("user_id"), rs.getString("content"),
						productCondition, rs.getInt("delivery_fee"));
				return content;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	private String convertProductCondtion(String selected) {
		String productCondition = null;
		if(selected.equals("new")) productCondition="새 상품";
		if(selected.equals("no-wear")) productCondition="사용감 없음";
		if(selected.equals("slight-wear")) productCondition="사용감 적음";
		if(selected.equals("visible-wear")) productCondition="사용감 많음";
		if(selected.equals("damaged")) productCondition="고장/파손 상품";
		return productCondition;
	}

	public BoardDetail selectDetail(Connection con, Integer boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDetail detail = null;
		try {
			ps = con.prepareStatement("select * from board_detail where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				String category = convertCategory(rs.getString("category"));
				detail = new BoardDetail(boardNum, rs.getString("title"), rs.getInt("price"), rs.getInt("likes_cnt"),
						category, rs.getString("location"), toDate(rs.getTimestamp("created_date")),
						rs.getString("thumb_name"));
				return detail;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	private String convertCategory(String selected) {
		String category = null;
		if(selected.equals("digital")) category="디지털";
		if(selected.equals("furniture")) category="가구";
		if(selected.equals("clothes")) category="의류";
		if(selected.equals("appliance")) category="가전제품";
		if(selected.equals("kitchen")) category="주방용품";
		if(selected.equals("leisure")) category="스포츠/레저";
		if(selected.equals("beauty")) category="뷰티";
		if(selected.equals("etc")) category="기타";
		return category;
	}

	public Photo selectPhoto(Connection con, int boardNum) throws SQLException {
		List<String> imageList = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Photo photo = null;
		try {
			ps = con.prepareStatement("select * from photo where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				imageList.add(rs.getString("image_name"));
			}
			photo = new Photo(boardNum, imageList);
			return photo;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public void insertRecentBoard(Connection con, Board board) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into recent_board (board_num, user_id) values (?, ?)");
			ps.setInt(1, board.getBoardNum());
			ps.setString(2, board.getUser2().getId());
			ps.executeUpdate();
		} finally {
			JdbcUtil.close(ps);
		}
	}

	public List<BoardDetail> selectAllDetail(Connection con) throws SQLException {
		List<BoardDetail> boardList = new ArrayList<BoardDetail>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from board_detail");
			rs = ps.executeQuery();
			while (rs.next()) {
				boardList.add(new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
						rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
						toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name")));
			}
			return boardList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public List<Integer> selectRecentBoard(Connection con, User2 user) throws SQLException {
		List<Integer> boardNumList = new ArrayList<Integer>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select board_num from recent_board where user_id = ? order by board_num desc");
			ps.setString(1, user.getId());
			rs = ps.executeQuery();

			while (rs.next()) {
				boardNumList.add(rs.getInt("board_num"));
			}

			return boardNumList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public List<BoardDetail> selectDetailById(Connection con, List<Integer> boardNumList) throws SQLException {
		List<BoardDetail> boardList = new ArrayList<BoardDetail>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			for (int i = 0; i < boardNumList.size(); i++) {
				ps = con.prepareStatement("select * from board_detail where board_num = ?");
				ps.setInt(1, boardNumList.get(i));
				rs = ps.executeQuery();

				if (rs.next()) {
					boardList.add(new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
							rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
							toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name")));
				}
			}
			return boardList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public int selectCount(Connection con) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from board_detail");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<BoardDetail> select(Connection con, int startRow, int size, String category, String sort) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		category = removeAllWhitespace(category);
		try {
			String query = makeQuery(category, sort);
			int parametersCNT = countParameters(query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(parametersCNT, size);
			pstmt.setInt(parametersCNT-1, startRow);
			if(category == null || category.length()==0 || category.equals("all")) {	}
			else {
				pstmt.setString(parametersCNT-2, category);
			}
			rs = pstmt.executeQuery();
			List<BoardDetail> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBoardDetail(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

    private String removeAllWhitespace(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+", "");
    }
	private String makeQuery(String category, String sort) {
		String query = "select * from board_detail";
		if(category == null || category.length()==0|| category.equals("all")) {	}
		else {
			query += " where category = ?";
		}
		
		if(sort == null) {
			query += " order by board_num desc";
		}else {
			query += sort;
		}
		query += " limit ?, ?";
		return query;
	}
	
	private int countParameters(String sql) {
        int count = 0;
        for (char c : sql.toCharArray()) {
            if (c == '?') {
                count++;
            }
        }
        return count;
    }
	
	private BoardDetail convertBoardDetail(ResultSet rs) throws SQLException {
		return new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
				rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
				toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name"));
	}

	public int selectBoardNum() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("select max(board_num) from board;");
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
			JdbcUtil.close(con);
		}
		return 0;
	}

	 private String searchQuery(String category, String sort, String searchWord) {
	        String query = "select * from board_detail where board_num=(select board_num from board_detail where title like %searchWord% or content like %searchWord%)";

	        if(category == null || category.equals("all")) {    }
	        else {
	            query += " category = ?";
	        }

	        if(sort == null) {
	            query += " order by board_num desc";
	        }else {
	            query += sort;
	        }
	        query += " limit ?, ?";

	        return query;
	    }



	    public List<BoardDetail> search(Connection con, int startRow, int size, String category, String sort, String searchWord) throws SQLException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {

	            String query = searchQuery(category, sort, searchWord);

	            int parametersCNT = countParameters(query);
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(parametersCNT, size);
	            pstmt.setInt(parametersCNT-1, startRow);

	            if(category == null  || category.equals("all")) {    }
	            else {
	                pstmt.setString(parametersCNT-2, category);
	            }

	            rs = pstmt.executeQuery();
	            List<BoardDetail> result = new ArrayList<>();
	            while (rs.next()) {
	                result.add(convertBoardDetail(rs));
	            }
	            return result;
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
	    }
}