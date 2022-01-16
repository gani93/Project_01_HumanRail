package com.rail.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rail.dto.ReservationVO;
import com.rail.dto.TrainVO;

import util.DBManager;

public class TrainDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private final String Train_INSERT = "insert into train values(?,?,?,?,?,?,?,?,?,?,train_seq.nextval,?)";
	private final String Train_LIST = "select * from train where train_date>=? order by train_date ASC";
	private final String Train_DELETE = "delete train where train_seq=?";
	private final String Train_Get = "select * from train where train_seq=?";
	private final String Train_Place_LIST_START = "select DISTINCT train_start_place from train order by train_start_place asc";
	private final String Train_Place_LIST_END = "select DISTINCT train_end_place from train order by train_end_place asc";

	public void updateTrain(int seq, int member) {
		String Train_update = "update train set train_member=train_member+? where train_seq = ?";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_update);
			stmt.setInt(1, member);
			stmt.setInt(2, seq);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}

	public void insertTrain(TrainVO vo) {
		System.out.println("insertTrain 기능처리");

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_INSERT);
			stmt.setString(1, vo.getTrain_sub());
			stmt.setString(2, vo.getTrain_id());
			stmt.setInt(3, vo.getTrain_member());
			stmt.setInt(4, vo.getTrain_start_time());
			stmt.setInt(5, vo.getTrain_end_time());
			stmt.setString(6, vo.getTrain_start_place());
			stmt.setString(7, vo.getTrain_end_place());
			stmt.setInt(8, vo.getTrain_form());
			stmt.setString(9, vo.getTrain_date());
			stmt.setInt(10, vo.getTrain_money());
			stmt.setInt(11, vo.getTrain_member());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}

	public List<TrainVO> getTrainList(String Train_date) {
		System.out.println("getTrainList 기능처리");
		List<TrainVO> trainList = new ArrayList<TrainVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_LIST);
			stmt.setString(1, Train_date);
			rs = stmt.executeQuery();

			while (rs.next()) {
				TrainVO vo = new TrainVO();
				vo.setTrain_sub(rs.getString(1));
				vo.setTrain_id(rs.getString(2));
				vo.setTrain_member(rs.getInt(3));
				vo.setTrain_start_time(rs.getInt(4));
				vo.setTrain_end_time(rs.getInt(5));
				vo.setTrain_start_place(rs.getString(6));
				vo.setTrain_end_place(rs.getString(7));
				vo.setTrain_form(rs.getInt(8));
				vo.setTrain_date(rs.getString(9));
				vo.setTrain_money(rs.getInt(10));
				vo.setTrain_seq(rs.getInt(11));
				trainList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return trainList;
	}

	public TrainVO getTrainListReservation(ReservationVO rVO) {
		System.out.println("getTrainListReservation 기능처리");
		String sql = "select * from train where train_seq=?";
		TrainVO vo = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rVO.getTrain_seq());
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new TrainVO();
				vo.setTrain_sub(rs.getString(1));
				vo.setTrain_id(rs.getString(2));
				vo.setTrain_member(rs.getInt(3));
				vo.setTrain_start_time(rs.getInt(4));
				vo.setTrain_end_time(rs.getInt(5));
				vo.setTrain_start_place(rs.getString(6));
				vo.setTrain_end_place(rs.getString(7));
				vo.setTrain_form(rs.getInt(8));
				vo.setTrain_date(rs.getString(9));
				vo.setTrain_money(rs.getInt(10));
				vo.setTrain_seq(rs.getInt(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return vo;
	}

	public void deleteTrain(int seq) {
		System.out.println("deleteTrain 기능처리");

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_DELETE);
			stmt.setInt(1, seq);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}

	public TrainVO getTrain(int seq) {
		System.out.println("getTrain 기능처리");
		TrainVO vo = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_Get);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new TrainVO();
				vo.setTrain_sub(rs.getString(1));
				vo.setTrain_id(rs.getString(2));
				vo.setTrain_member(rs.getInt(3));
				vo.setTrain_start_time(rs.getInt(4));
				vo.setTrain_end_time(rs.getInt(5));
				vo.setTrain_start_place(rs.getString(6));
				vo.setTrain_end_place(rs.getString(7));
				vo.setTrain_form(rs.getInt(8));
				vo.setTrain_date(rs.getString(9));
				vo.setTrain_money(rs.getInt(10));
				vo.setTrain_seq(rs.getInt(11));
				vo.setTrain_total_member(rs.getInt(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return vo;
	}

	public List<TrainVO> getTrainListDate(String date) {
		System.out.println("searchTrainList 기능처리");
		List<TrainVO> trainList = new ArrayList<TrainVO>();
		String LIST = null;
		LIST = "select * from train where train_date>=? order by train_date ASC";
		try {

			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(LIST);

			stmt.setString(1, date);
			rs = stmt.executeQuery();

			while (rs.next()) {
				TrainVO tvo = new TrainVO();
				tvo.setTrain_sub(rs.getString(1));
				tvo.setTrain_id(rs.getString(2));
				tvo.setTrain_member(rs.getInt(3));
				tvo.setTrain_start_time(rs.getInt(4));
				tvo.setTrain_end_time(rs.getInt(5));
				tvo.setTrain_start_place(rs.getString(6));
				tvo.setTrain_end_place(rs.getString(7));
				tvo.setTrain_form(rs.getInt(8));
				tvo.setTrain_date(rs.getString(9));
				tvo.setTrain_money(rs.getInt(10));
				tvo.setTrain_seq(rs.getInt(11));
				trainList.add(tvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return trainList;
	}

	public List<TrainVO> searchTrainList(TrainVO vo) {
		System.out.println("searchTrainList 기능처리");
		List<TrainVO> trainList = new ArrayList<TrainVO>();
		String LIST = null;

		try {
			conn = DBManager.getConnection();
			if (vo.getTrain_start_place().equals("total")) {
				LIST = "select * from train where train_end_place=? and train_date>=? order by train_date asc";
				stmt = conn.prepareStatement(LIST);
				stmt.setString(1, vo.getTrain_end_place());
				stmt.setString(2, vo.getTrain_date());
			} else if (vo.getTrain_end_place().equals("total")) {
				LIST = "select * from train where train_start_place=? and train_date>=? order by train_date asc";
				stmt = conn.prepareStatement(LIST);
				stmt.setString(1, vo.getTrain_start_place());
				stmt.setString(2, vo.getTrain_date());
			} else {
				LIST = "select * from train where train_start_place=? and train_end_place=? and train_date>=? order by train_date asc";
				stmt = conn.prepareStatement(LIST);
				stmt.setString(1, vo.getTrain_start_place());
				stmt.setString(2, vo.getTrain_end_place());
				stmt.setString(3, vo.getTrain_date());
			}
			rs = stmt.executeQuery();

			while (rs.next()) {
				TrainVO tvo = new TrainVO();
				tvo.setTrain_sub(rs.getString(1));
				tvo.setTrain_id(rs.getString(2));
				tvo.setTrain_member(rs.getInt(3));
				tvo.setTrain_start_time(rs.getInt(4));
				tvo.setTrain_end_time(rs.getInt(5));
				tvo.setTrain_start_place(rs.getString(6));
				tvo.setTrain_end_place(rs.getString(7));
				tvo.setTrain_form(rs.getInt(8));
				tvo.setTrain_date(rs.getString(9));
				tvo.setTrain_money(rs.getInt(10));
				tvo.setTrain_seq(rs.getInt(11));
				trainList.add(tvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return trainList;
	}

	public List<TrainVO> getStartPlaceList() {
		System.out.println("getStartPlaceList 기능처리");

		List<TrainVO> train_Start_List = new ArrayList<TrainVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_Place_LIST_START);
			rs = stmt.executeQuery();

			while (rs.next()) {
				TrainVO vo = new TrainVO();
				vo.setTrain_start_place(rs.getString(1));
				train_Start_List.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return train_Start_List;
	}

	public List<TrainVO> getEndPlaceList() {
		System.out.println("getEndPlaceList 기능처리");

		List<TrainVO> train_End_List = new ArrayList<TrainVO>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(Train_Place_LIST_END);
			rs = stmt.executeQuery();

			while (rs.next()) {
				TrainVO vo = new TrainVO();
				vo.setTrain_end_place(rs.getString(1));
				train_End_List.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return train_End_List;
	}
}
