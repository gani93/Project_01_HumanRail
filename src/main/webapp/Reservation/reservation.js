

function reservationCheck()  {
  // 선택된 목록 가져오기
  const query = 'input[name="seat"]:checked';
  const selectedElements = 
      document.querySelectorAll(query);
  
  // 선택된 목록의 갯수 세기
  const selectedElementsCnt =
        selectedElements.length;
  
  if(selectedElementsCnt==0){
	alert("좌석을 선택해주세요.");
		return false;
}else {
		return true;
	}
}

