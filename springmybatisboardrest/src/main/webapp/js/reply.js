const reply = {
	getReplyList : function(aid, ss_mid) {
		axios.get('/reply/replies/'+aid).then(
			response => { 
				this.printReplyList(response.data, ss_mid);			
			}
		);
	},	
	deleteReply : function (rid, aid, ss_mid) {
		axios.delete('/reply/replies/'+rid).then(
			() => this.getReplyList(aid, ss_mid)
		);
	},
	printReplyList : function(data, ss_mid) {
		if (data) {
			let ulHtml = '';
			for (eachReply of data) {
				const dateStr = `${eachReply.rregdate}`;
				const printDateStr = dayjs(dateStr, 'YYYY-MM-DD HH:mm:ss').format('HH:mm');
				ulHtml += `<li class="list-group-item">(${eachReply.mid})&nbsp;[${printDateStr}] ${eachReply.rcontent}`;
				if (ss_mid==`${eachReply.mid}`) {
					ulHtml += `&nbsp;<a href="javascript:if (confirm('삭제하시겠습니까?')) reply.deleteReply
					('${eachReply.rid}', '${eachReply.aid}', '${ss_mid}');">[삭제]</a></li>`;
				}
			}
			$('#replyList').html(ulHtml);
		}
	},
	insertReply : function(ss_mid) {
		const insertReplyBtn = document.querySelector("#insertReplyBtn");
		axios.post(
			'/reply/replies', 
			{
				rcontent: $('input[name="rcontent"]').val(),
				mid: insertReplyBtn.dataset.mid,
				aid: insertReplyBtn.dataset.aid 
			}, 
			{
				headers: {
					'Content-Type': 'application/json'
				}
			}
		).then(
			response => {
				this.getReplyList(insertReplyBtn.dataset.aid, ss_mid);
			}
		);
	}
};

$("#insertReplyBtn").on("click", e => {
	if (!$("input[name='rcontent']").val()) {
		alert('내용은 필수입력입니다!');
		$("input[name='rcontent']").focus();
		return false;
	}
	reply.insertReply(e.target.dataset.mid);
});












