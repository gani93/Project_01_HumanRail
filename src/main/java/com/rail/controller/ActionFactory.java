package com.rail.controller;

import com.rail.controller.action.Action;
import com.rail.controller.action.IndexAction;
import com.rail.controller.action.notice.NoticeDeleteAction;
import com.rail.controller.action.notice.NoticeDetailAction;
import com.rail.controller.action.notice.NoticeInsertAction;
import com.rail.controller.action.notice.NoticeInsertFormAction;
import com.rail.controller.action.notice.NoticeListAction;
import com.rail.controller.action.notice.NoticeUpdateAction;
import com.rail.controller.action.notice.NoticeUpdateFormAction;
import com.rail.controller.action.reservation.ReservationDeletOKFormAction;
import com.rail.controller.action.reservation.ReservationDeleteAction;
import com.rail.controller.action.reservation.ReservationDeleteListFormAction;
import com.rail.controller.action.reservation.ReservationFormAction;
import com.rail.controller.action.reservation.ReservationInfoFormAction;
import com.rail.controller.action.reservation.ReservationInsertAction;
import com.rail.controller.action.reservation.ReservationListForm;
import com.rail.controller.action.train.TrainGetFormAction;
import com.rail.controller.action.train.TrainInsertAction;
import com.rail.controller.action.train.TrainInsertFormAction;
import com.rail.controller.action.train.TrainInsertOKFormAction;
import com.rail.controller.action.train.TrainSearchAction;
import com.rail.controller.action.train.TrainSearchingFormAction;
import com.rail.controller.action.travel.TravelDeleteAction;
import com.rail.controller.action.travel.TravelDetailAction;
import com.rail.controller.action.travel.TravelInsertAction;
import com.rail.controller.action.travel.TravelInsertFormAction;
import com.rail.controller.action.travel.TravelListAction;
import com.rail.controller.action.travel.TravelUpdateAction;
import com.rail.controller.action.travel.TravelUpdateFormAction;
import com.rail.controller.action.user.findIdFormAction;
import com.rail.controller.action.user.findPwdFormAction;
import com.rail.controller.action.user.idCheckFormAction;
import com.rail.controller.action.user.joinFormAction;
import com.rail.controller.action.user.joinOKAction;
import com.rail.controller.action.user.loginAction;
import com.rail.controller.action.user.loginFormAction;
import com.rail.controller.action.user.logoutAction;
import com.rail.controller.action.user.mypageFormAction;
import com.rail.controller.action.user.sendEmailAction;
import com.rail.controller.action.user.showIdFormAction;
import com.rail.controller.action.user.showPwd2Action;
import com.rail.controller.action.user.showPwdFormAction;
import com.rail.controller.action.user.updateFormAction;
import com.rail.controller.action.user.updateInfoAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	public ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("ActionFactory 요청을 받음을 확인 :" + command);

		if (command.equals("index")) {
			action = new IndexAction();
		} else if (command.equals("login_form")) { // 로그인 시작
			action = new loginFormAction();
		} else if (command.equals("login")) {
			action = new loginAction();
		} else if (command.equals("join_form")) { // 로그인 끝
			action = new joinFormAction();
		} else if (command.equals("join")) { // 회원가입 시작
			action = new joinOKAction();
		} else if (command.equals("id_check")) { // 아이디 중복확인
			action = new idCheckFormAction();
		} else if (command.equals("mypage_form")) { // 마이페이지 (회원정보)
			action = new mypageFormAction();
		} else if (command.equals("updateform")) { // 회원정보 수정 시작
			action = new updateFormAction();
		} else if (command.equals("update")) { // 회원정보 수정 끝
			action = new updateInfoAction();
		} else if (command.equals("find_id")) { // 아이디,비번 찾기 시작
			action = new findIdFormAction();
		} else if (command.equals("find_pwd")) {
			action = new findPwdFormAction();
		} else if (command.equals("show_id")) {
			action = new showIdFormAction();
		} else if (command.equals("show_pwd")) {
			action = new showPwdFormAction();
		} else if (command.equals("show_pwd2")) { // 아이디,비번 찾기 끝
			action = new showPwd2Action();
		} else if (command.equals("send_email")) { // 비밀번호 임시발송
			action = new sendEmailAction();
		} else if (command.equals("logout")) { // 로그아웃
			action = new logoutAction();
		} else if (command.equals("TrainSearchForm")) {// 기차 검색 폼
			action = new TrainSearchingFormAction();
		} else if (command.equals("TrainInsert")) {// 기차 등록
			action = new TrainInsertAction();
		} else if (command.equals("TrainInsertForm")) {// 기차 폼
			action = new TrainInsertFormAction();
		} else if (command.equals("TrainGetForm")) {// 기차 가져오는 폼
			action = new TrainGetFormAction();
		} else if (command.equals("TrainInsertOKForm")) {// 기차 인서트 ok폼
			action = new TrainInsertOKFormAction();
		} else if (command.equals("TrainSearch")) {// 기차 검색
			action = new TrainSearchAction();
		} else if (command.equals("noticelist")) {// //공지사항 시작
			action = new NoticeListAction();
		} else if (command.equals("noticeinsertform")) {
			action = new NoticeInsertFormAction();
		} else if (command.equals("noticeinsert")) {
			action = new NoticeInsertAction();
		} else if (command.equals("noticedelete")) {
			action = new NoticeDeleteAction();
		} else if (command.equals("noticedetail")) {
			action = new NoticeDetailAction();
		} else if (command.equals("noticeupdateform")) {
			action = new NoticeUpdateFormAction();
		} else if (command.equals("noticeupdate")) {
			action = new NoticeUpdateAction();//// 공지사항 끝
		} else if (command.equals("travellist")) {// 여행지 시작 211003
			action = new TravelListAction();
		} else if (command.equals("travelinsertform")) {
			action = new TravelInsertFormAction();
		} else if (command.equals("travelinsert")) {
			action = new TravelInsertAction();
		} else if (command.equals("traveldelete")) {
			action = new TravelDeleteAction();
		} else if (command.equals("traveldetail")) {
			action = new TravelDetailAction();
		} else if (command.equals("travelupdateform")) {
			action = new TravelUpdateFormAction();
		} else if (command.equals("travelupdate")) {
			action = new TravelUpdateAction();// 여행지 끝 211003
		} else if (command.equals("ReservationForm")) {// 예약 폼
			action = new ReservationFormAction();
		} else if (command.equals("ReservationInsert")) {// 예약!
			action = new ReservationInsertAction();
		} else if (command.equals("ReservationListForm")) {// 예약확인폼!!
			action = new ReservationListForm();
		} else if (command.equals("reservationUPForm")) {// 예약취소폼!
			action = new ReservationInfoFormAction();
		} else if (command.equals("reservationDelete")) {// 예약취소!
			action = new ReservationDeleteAction();
		} else if (command.equals("ReservationDeleteOKForm")) {// 예약취소화인폼!
			action = new ReservationDeletOKFormAction();
		} else if (command.equals("reservationDeleteForm")) {// 예약취소확인폼!!
			action = new ReservationDeleteListFormAction();
		}

		return action;

	}
}
