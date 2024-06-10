package board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;

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
			ps = con.prepareStatement(
					"insert into board (user_id, user_nickname, title, trade_status) values (?, ?, ?, '판매 중')");
			ps.setString(1, board.getWriter().getId());
			ps.setString(2, board.getWriter().getNickname());
			ps.setString(3, board.getTitle());
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
					"insert into board_detail (board_num, category, price, location, created_date, thumb_name) values (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, boardDetail.getBoardNum());
			ps.setString(2, boardDetail.getCategory());
			ps.setInt(3, boardDetail.getPrice());
			ps.setString(4, boardDetail.getLocation());
			ps.setTimestamp(5, toTimestamp(boardDetail.getCreatedDate()));
			ps.setString(6, boardDetail.getThumbName());
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
				ps = con.prepareStatement("insert into photo (board_num, original_name) values (?, ?)");
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
				board = new Board(boardNum, new Writer(rs.getString("user_id"), rs.getString("user_nickname")),
						rs.getString("title"), rs.getString("trade_status"));

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
				content = new BoardContent(boardNum, rs.getString("user_id"), rs.getString("content"),
						rs.getString("product_condition"), rs.getInt("delivery_fee"));
				return content;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public BoardDetail selectDetail(Connection con, int boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDetail detail = null;
		try {
			ps = con.prepareStatement("select * from board_detail where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				detail = new BoardDetail(boardNum, rs.getInt("price"), rs.getInt("likes_cnt"), rs.getString("category"),
						rs.getString("location"), toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name"));
				return detail;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
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
				imageList.add(rs.getString("original_name"));
			}
			photo = new Photo(boardNum, imageList);
			return photo;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public void insertRecentBoard(Connection con, Board board) throws SQLException{
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into recent_board (board_num, user_id) values (?, ?)");
			ps.setInt(1, board.getBoardNum());
			ps.setString(1, board.getWriter().getId());
			ps.executeQuery();
		} finally {
			JdbcUtil.close(ps);
		}
	}
}
