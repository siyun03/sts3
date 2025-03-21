const article = {
	selectArticle: function(pageNum, pageSize) {
		const articleSearchForm = $("form[name='articleSearchForm']");
		articleSearchForm.find("input[name='pageNum']").val(pageNum);
		articleSearchForm.find("input[name='pageSize']").val(pageSize);
		articleSearchForm.submit();
	},
	insertArticle: function() {
		this.sendRequest("post");
	},	
	updateArticle: function() {
		this.sendRequest("put");
	},
	deleteArticle: function(aid) {
		axios.delete('/article/articles/'+aid)
		.then(response => {
			if (response.data.result>0) {
				location.href = "/article/articles";
			}
		});		
	},
	selectAttachFile: function(aid, pageType) {
		axios.get('/file/attachfiles/'+aid)
		.then(response => {
			this.printAttachFile(response.data, pageType);
		})
	},
	printAttachFile: function(data, pageType) {
		if (data.length > 0) {
			let fileListHtml = '';
			for (eachAttachFile of  data) {
				let actionLink;
				if (pageType=='getArticle') {
					actionLink = `<a href='/file/filedownload/${eachAttachFile.afid}'>[다운로드]</a>`;
				} else if (pageType=='updateArticleForm') {
					actionLink = `<a href='javascript:if(confirm("삭제하시겠습니까?")) article.deleteAttachFile("${eachAttachFile.aid}", "${eachAttachFile.afid}");'>[삭제]</a>`;
				}
				fileListHtml += `<li>${eachAttachFile.afcname} ${actionLink}</li>`;
			}
			$("#attachFiles").html(fileListHtml);
		} else {
			$("#attachFiles").html('<li>첨부파일이 없습니다</li>');
		}
	},
	deleteAttachFile : function(aid, afid) {
		axios.delete('/file/attachfiles/' + afid)
		.then(response => {
			this.selectAttachFile(aid, 'updateArticleForm');
		});
	},
	sendRequest : function(requestMethod) {
		const articleForm = $("form[name='articleForm']");
		if (!$("input[name='asubject']").val()) {
			alert('제목은 필수입력입니다!');
			asubject.focus();
			return false;
		}
		
		let sendData = {
				bid: articleForm.find("[name='bid']").val(),
				asubject: articleForm.find("[name='asubject']").val(),
				acontent: articleForm.find("[name='acontent']").val()			
		};
		
		if (requestMethod=="post") {
			sendData['mid'] = articleForm.find("[name='mid']").val(); 
		} else if (requestMethod=="put") {
			sendData['aid'] = articleForm.find("[name='aid']").val();
		}
		
		axios({
			method: requestMethod,
			url: '/article/articles', 
			data: sendData, 
			headers: {
					'Content-Type': 'application/json'
			}
		}).then(response => {
			const fileInput = document.querySelector("#fileInput");
			const formData = new FormData();
			formData.append("aid", response.data.aid);
			for (let file of fileInput.files) {
				formData.append("files", file);
			}
			axios.post(
				"/file/fileupload",
				formData,
				{
					headers: { "Content-Type": "multipart/form-data" }
				}
			);
			location.href = "/article/articles";
		});		
	}
	
};










