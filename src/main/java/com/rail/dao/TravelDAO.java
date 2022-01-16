package com.rail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rail.dto.TravelVO;

import util.DBManager;

public class TravelDAO {
	private TravelDAO() {
	}
	
	private static TravelDAO instance =  new TravelDAO();
	
	public static TravelDAO getInstance() {
		return instance;
	}
	
	public ArrayList<TravelVO> selectAllTravel(int page, int limit,String searchCondition,String searchKeyword) {
		System.out.println("selectAllTravel()실행");
		System.out.println("=====page====="+page);
		System.out.println("=====searchCondition======="+searchCondition);
		System.out.println("=====searchKeyword========="+searchKeyword);
//		String sql = "select rnum, A.* from (select rownum rnum ,B.* from ( select * FROM travel order by seq desc ) B ) A where rnum >= ? and rnum <= ?";
		String sql_t = "select rnum, A.* from (select rownum rnum ,B.* from ( select * FROM travel where title like '%'|| ? ||'%' order by seq desc ) B ) A where rnum >= ? and rnum <= ?";
		String sql_c = "select rnum, A.* from (select rownum rnum ,B.* from ( select * FROM travel where content like '%'|| ? ||'%' order by seq desc ) B ) A where rnum >= ? and rnum <= ?";
		int startrow = (page - 1) * 10 + 1; //읽기 시작할 rownum
		int endrow = startrow + limit - 1;	//읽을 마지막 rownum
		ArrayList<TravelVO> list = new ArrayList<TravelVO>();
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, startrow);
//			pstmt.setInt(2, endrow);
//			rs= pstmt.executeQuery();
			if (searchCondition.equals("TITLE")) {
				pstmt = conn.prepareStatement(sql_t);
				pstmt.setString(1, searchKeyword);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				rs= pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql_c);
				pstmt.setString(1, searchKeyword);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				rs= pstmt.executeQuery();
			}
			while(rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setSeq(rs.getInt("SEQ"));
				System.out.println("----------------" + vo.getSeq());
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setWrite_date(rs.getDate("WRITE_DATE"));
				vo.setPictureUrl(rs.getString("PICTUREURL"));
				vo.setCnt(rs.getInt("CNT"));
				list.add(vo);
				System.out.println("----------------" + vo.getSeq());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<TravelVO> selectAllTravel2(int page, int limit,String searchCondition,String searchKeyword) {
		System.out.println("selectAllTravel()실행");
		String sql_t = "select rnum, A.* from (select rownum rnum ,B.* from ( select * FROM travel where title like '%'|| ? ||'%' order by seq desc ) B ) A where rnum >= ? and rnum <= ?";
		String sql_c = "select rnum, A.* from (select rownum rnum ,B.* from ( select * FROM travel where content like '%'|| ? ||'%' order by seq desc ) B ) A where rnum >= ? and rnum <= ?";
		int startrow = (page - 1) * 10 + 1; //읽기 시작할 rownum
		int endrow = startrow + limit - 1;	//읽을 마지막 rownum
		ArrayList<TravelVO> list = new ArrayList<TravelVO>();
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			if (searchCondition.equals("TITLE")) {
				pstmt = conn.prepareStatement(sql_t);
				pstmt.setString(1, searchKeyword);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				rs= pstmt.executeQuery();
			} else if (searchCondition.equals("CONTENT")) {
				pstmt = conn.prepareStatement(sql_c);
				pstmt.setString(1, searchKeyword);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
				rs= pstmt.executeQuery();
			}
			while(rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setSeq(rs.getInt("SEQ"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setWrite_date(rs.getDate("WRITE_DATE"));
				vo.setCnt(rs.getInt("CNT"));
				vo.setPictureUrl(rs.getString("pictureUrl"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public void insertTravel(TravelVO vo) {
		String sql = "insert into travel(seq, title, content, writer, pictureUrl) values (travel_seq.nextval, ?, ?, ?)";
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getPictureUrl());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public TravelVO selectOneTravelBySeq(String seq) {
		String sql = "select * from travel where seq = ?";
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TravelVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new TravelVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWrite_date(rs.getDate("write_date"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setPictureUrl(rs.getString("pictureUrl"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	public void updateTravel(TravelVO vo) {
		String sql = "update travel set title = ?, content = ?, writer = ? , pictureUrl = ? where seq = ?";	
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());	
			pstmt.setString(4, vo.getPictureUrl());
			pstmt.setInt(5, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deleteTravel(String seq) {
		String sql = "delete travel where seq = ?";
				
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	//등록된 글의 총 개수
	public int getListCount(String searchCondition,String searchKeyword) {
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "select count(*) from travel";
		String sql_t = "select count(*) from (select rownum rnum ,B.* from ( select * FROM travel where title like '%'|| ? ||'%' order by seq desc ) B )";
		String sql_c = "select count(*) from (select rownum rnum ,B.* from ( select * FROM travel where content like '%'|| ? ||'%' order by seq desc ) B )";
		int count = 10;
		//System.out.println("====================="+searchCondition);
		//System.out.println("====================="+searchKeyword);
		try {
			conn = DBManager.getConnection();
			if (searchCondition.equals("TITLE")) {
				pstmt = conn.prepareStatement(sql_t);
				pstmt.setString(1, searchKeyword);
				rs= pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql_c);
				pstmt.setString(1, searchKeyword);
				rs= pstmt.executeQuery();
			}
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
			while(rs.next()) {
				count  =  rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	//조회수 업데이트
		public void setReadCountUpdate(String seq) {
			String sql="update travel set cnt = cnt + 1 where seq="+seq;  
			Connection  conn = null;
			PreparedStatement pstmt = null;
			try{ 
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate(); 
			} catch(SQLException e){ 
				e.printStackTrace();
			} finally{ 
				DBManager.close(conn, pstmt);
			} 
		}
	}