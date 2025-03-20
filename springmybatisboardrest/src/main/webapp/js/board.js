const board = {
	getBoardList: function(bid) {
		axios.get('/board/boardsJson').then(
			response => {
				this.printBoardList(response.data, bid);			
			}
		);		
	},
	printBoardList: function(data, bid) {
		if (data) {
			let selectHtml = '';
			let selected = '';
			for (brd of data) {
				if (`${brd.bid}`==bid) {
					selected = "selected";
				} else {
					selected = "";
				}
				selectHtml += `<option value='${brd.bid}' ${selected}>${brd.bname}</option>`;
			}
			$("select[name='bid']").append(selectHtml);
		}
	},
	updateBoard: function() {
		const boardForm = $("form[name='boardForm']");	
		axios.put(
			'/board/boards', 
			{
				bid: boardForm.find("[name='bid']").val(),
				bname: boardForm.find("[name='bname']").val()
			}, 
			{
				headers: {
					'Content-Type': 'application/json'
				}
			}
		).then(response => {
			if (response.data.result>0) {
				location.href = "/board/boards";
			}
		});
	}
	
};

const boardForm = $("form[name='boardForm']");
const bid = boardForm.find("input[name='bid']");
const bname = boardForm.find("input[name='bname']");
boardForm.on("submit", e => {
	e.preventDefault();
	if (!bname.val()) {
		alert("게시판명은 필수입력입니다!");
		bname.focus();
		return false;
	} else {
		if (bid.val()) {
			board.updateBoard();	
		} else {
			boardForm.off("submit").submit();
		}
	}
});












