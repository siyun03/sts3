const member = {
	updateMember: function() {
		const updateMemberForm = $("form[name='memberForm']");	
		axios.put(
			'/member/members', 
			{
				mid: memberForm.find("[name='mid']").val(),
				mname: memberForm.find("[name='mname']").val(),
				malias: memberForm.find("[name='malias']").val(),
				memail: memberForm.find("[name='memail']").val(),
				mcp: memberForm.find("[name='mcp']").val()
			}, 
			{
				headers: {
					'Content-Type': 'application/json'
				}
			}
		).then(response => {
			if (response.data.result>0) {
				location.href = "/member/members";
			}
		});
	},
	deleteMember: function(mid) {
		axios.delete('/member/members/'+mid)
		.then(response => {
			if (response.data.result>0) {
				location.href = "/member/members";
			}
		});		
	}
	
};

$("#insertBtn").on("click", () => {
	location.href="/member/insertMemberForm";
});

const memberForm = $("form[name='memberForm']"); 
const mid = memberForm.find("input[name='mid']");
const mpass = memberForm.find("input[name='mpass']");
const mname = memberForm.find("input[name='mname']");

memberForm.on("submit", e => {
	e.preventDefault();
	if (!mid.val()) {
		alert("아이디는 필수입력입니다!");
		mid.focus();
		return false;
	}
	if (mpass.length>0 && !mpass.val()) {
		alert("비밀번호는 필수입력입니다!");
		mpass.focus();
		return false;
	}
	if (!mname.val()) {
		alert("성명은 필수입력입니다!");
		mname.focus();
		return false;
	}
	if (mpass.length>0) {
		memberForm.off("submit").submit();
	} else {
		member.updateMember();
	}
});




