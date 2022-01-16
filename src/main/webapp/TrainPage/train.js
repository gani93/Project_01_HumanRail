function ChangeMemeberSelect() {
	
	var x = document.getElementById("Train_sub");
	if (x=="무궁화") {
		x = "100";
	} else if (x.equals("새마을")) {
		x = "150"
	} else if (x.equals("KTX")) {
		x = "300";
	}
	document.getElementById("Train_member").innerHTML = +x;
}

function insertCheck(){
	if(document.form.Train_sub.value==""){
		form.Train_sub.focus();
		alert("열차종류를 선택 하세요");
	}else if(document.form.Train_id.value == "") {
		form.Train_id.focus();
		alert("열차 번호를 입력하세요.");
	}else if(document.form.Train_member.value == "") {
		form.Train_member.focus();
		alert("인원수를 선택하세요.");
	}else if(document.form.Train_start_time.value == "") {
		form.Train_start_time.focus();
		alert("시간을 선택하세요.");
	}else if(document.form.Train_end_time.value == "") {
		form.Train_end_time.focus();
		alert("시간을 선택하세요.");
	}else if(document.form.Train_start_place.value == "") {
		form.Train_start_place.focus();
		alert("출발역을 입력하세요.");
	}else if(document.form.Train_end_place.value == "") {
		form.Train_end_place.focus();
		alert("도착역을 입력하세요.");
	}else if(document.form.Train_form.value == "") {
		form.Train_form.focus();
		alert("타는곳을 입력하세요.");
	}else if(document.form.Train_date.value == "") {
		form.Train_date.focus();
		alert("출발일을 입력하세요.");
	}else if(document.form.Train_money.value == "") {
		form.Train_money.focus();
		alert("금액을 입력하세요.");
	}else {
		document.form.action = "RailServlet?command=TrainInsert";
		document.form.submit();
		
		
		
	}
	
}
function frmsubmit(){
	self.close();
	return true;
}
function openWindowPop(url,name){
	window.name = "InsertForm"
	var options='top = 200,left=140,width=500,height=600,status=no,menubar=no,toolbar=no,resizable=no';
	window.open(url,name,options);
}