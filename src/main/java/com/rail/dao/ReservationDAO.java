package com.rail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rail.dto.ReservationVO;

import util.DBManager;

public class ReservationDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public void insertTrain(ReservationVO vo) {
		System.out.println("insertTrain 기능처리");
		String reservation_Insert = "insert into reservation values(reservation_seq.nextval,?,?,?,?,1,sysdate)";
		String reservation_Miner = "update train set train_member = train_member-? where train_seq=?";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(reservation_Insert);
			stmt.setString(1,vo.getId());
			stmt.setInt(2, vo.getTrain_seq());
			stmt.setString(3, vo.getSeat().toString());
			stmt.setInt(4, vo.getQuantity());
			stmt.executeUpdate();
			stmt.close();
			stmt = conn.prepareStatement(reservation_Miner);
			stmt.setInt(1, vo.getQuantity());
			stmt.setInt(2, vo.getTrain_seq());			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}
	
	public List<ReservationVO> AllListReservation(int seq, int useyn){
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		String sql = "select * from reservation where train_seq=? and useyn=? order by reservation_seq asc";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,seq);
			stmt.setInt(2, useyn);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ReservationVO vo = new ReservationVO();
				vo.setReservation_seq(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setTrain_seq(rs.getInt(3));
				vo.setSeat(rs.getString(4));
				vo.setQuantity(rs.getInt(5));
				vo.setUseyn(rs.getInt(6));
				vo.setDate(rs.getDate(7));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return list;
	}
	
	
	
	public List<String> AllListseat(int seq, int useyn){
		List<String> list = new ArrayList<String>();
		String sql = "select seat from reservation where train_seq=? and useyn=? order by reservation_seq asc";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,seq);
			stmt.setInt(2, useyn);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				list.add(rs.getString("seat"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return list;
	}
	public List<ReservationVO> getListReservation(String id, int useyn){
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		String sql = "select * from reservation where id=? and useyn=? and indate>sysdate-30 order by reservation_seq desc";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setInt(2, useyn);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ReservationVO vo = new ReservationVO();
				vo.setReservation_seq(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setTrain_seq(rs.getInt(3));
				vo.setSeat(rs.getString(4));
				vo.setQuantity(rs.getInt(5));
				vo.setUseyn(rs.getInt(6));
				vo.setDate(rs.getDate(7));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return list;
	}
	
	public ReservationVO getReservation(String id,int seq) {
		String sql = "select * from reservation where id=? and reservation_seq=?";
		ReservationVO vo = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setInt(2, seq);
			rs = stmt.executeQuery();
			while(rs.next()) {
				vo = new ReservationVO();
				vo.setReservation_seq(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setTrain_seq(rs.getInt(3));
				vo.setSeat(rs.getString(4));
				vo.setQuantity(rs.getInt(5));
				vo.setUseyn(rs.getInt(6));
				vo.setDate(rs.getDate(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return vo;
	}
	
	public void deleteReservation(int seq) {
		String sql = "update reservation set useyn = 0 where reservation_seq=?";
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, seq);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}



	
}
