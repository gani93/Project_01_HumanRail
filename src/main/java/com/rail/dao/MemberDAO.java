package com.rail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rail.dto.MemberVO;

import util.DBManager;

public class MemberDAO {

	public MemberDAO() {
		super();
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {

		return instance;

	}

	// 아이디로 회원 정보를 받아오는 메소드(로그인)
	public MemberVO getMember(String id) {

		String sql = "select * from userinfo where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO mvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPassword(rs.getString("password"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setBirth(rs.getString("birth"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setAdminnum(rs.getString("adminnum"));
				mvo.setKakao(rs.getInt("kakaoyn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	}
	//카카오 멤버 구하기
	public MemberVO getkakaoMember(String email) {

		String sql = "select * from userinfo where email=? and kakaoyn=1";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO mvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email); 
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPassword(rs.getString("password"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setBirth(rs.getString("birth"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setAdminnum(rs.getString("adminnum"));
				mvo.setKakao(rs.getInt("kakaoyn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	}

	// 회원가입
	public void insertMember(MemberVO mvo) {

		String sql = null;
		if (mvo.getKakao() ==1) {
			sql = "insert into userinfo (id,password,name,email,birth,phone,adminnum,kakaoyn) values(?,?,?,?,?,?,0,1)";
		}else {
			sql = "insert into userinfo (id,password,name,email,birth,phone,adminnum) values(?,?,?,?,?,?,0)";
		}
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPassword());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getBirth());
			pstmt.setString(6, mvo.getPhone());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 아이디 중복 확인
	public int confirmID(String id) {

		String sql = "select id from userinfo where id=?";

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1; // 아이디 있음
			} else {
				result = -1;// 아이디 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 아이디 찾기(이름,이메일로 회원 아이디 찾기)
	public String findId(String name, String email) {

		String sql = "select id from userinfo where name=? and email=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
				System.out.println(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}

	// 비밀번호 찾기(아이디, 이름이 일치하는 회원이 있는지 먼저 찾기)
	public int findPwd1(String id, String name) {

		String sql = "select * from userinfo where id=? and name=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1; // 있음
			} else {
				result = -1;// 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 비밀번호 찾기 (회원 아아디,이름과 상응하는 힌트,답변, 비밀번호를 찾고 비교하기 위함)
	public MemberVO findPwd(String id, String name) {

		String sql = "select password,email from userinfo where id=? and name=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO mvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mvo = new MemberVO();
				mvo.setPassword(rs.getString("password"));
				mvo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	}

	// 회원정보 수정
	public void updateMember(MemberVO mvo) {

		String sql = "update userinfo set name=?, password=?, email=?, birth=?, phone=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getPassword());
			pstmt.setString(3, mvo.getEmail());
			pstmt.setString(4, mvo.getBirth());
			pstmt.setString(5, mvo.getPhone());
			pstmt.setString(6, mvo.getId());
			pstmt.executeUpdate();
			System.out.println("수정완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//임시비번 업데이트
	public void updatePassword(MemberVO mvo) {

		String sql = "update userinfo set password=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getPassword());
			pstmt.setString(2, mvo.getId());
			pstmt.executeUpdate();
			System.out.println("수정완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
