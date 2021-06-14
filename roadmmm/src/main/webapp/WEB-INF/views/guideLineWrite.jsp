<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>가이드라인 작성</title>
	<style>
		.glw_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.glw_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.glw_input{
			width: 1000px;		
		}
		.write_btn{
			margin-top: 30px;
		}
		.glw_top{
			height: 100px;
			
			margin-bottom: 20px;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		.glw_top_logo{
			width: 300px;
			
			padding: 10px;
			
			
			
			color: white;
			background-color: black;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		#editorr{
			height: 500px;
		}
	</style>

	 <!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<link href="static/summernote/summernote-lite.css" rel="stylesheet">
	<script src="static/summernote/summernote-lite.js"></script>
  	
  	<script src="static/summernote/summernote-ko-KR.js"></script>
	
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="glw_wrap">
		
		<div class="glw_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			
			<div class="glw_input">
				
				<div class="glw_top">
					<div class="glw_top_logo">
						<h1>가이드라인 작성</h1>
					</div>
				</div>
			
				<form action="/glprocess" method="POST" enctype="multipart/form-data">
					<input name = "title"class="form-control form-control-lg" type="text" placeholder="제목" aria-label=".form-control-lg example">
					<br/>
					<h3>타이틀 이미지</h3><input name="titleImg" type="file"/>
					<br/>
					<select name="sector" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
					  <option selected>분류를 선택해주세요.</option>
					  <option value="STOCK">주식</option>
					  <option value="TERM">용어</option>
					  <option value="CHART">차트</option>
					  <option value="INCIDENT">사건</option>
					</select>
					
					<div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label"></label>
					  <textarea id="summernote" name="content"></textarea>
					  <button type="submit" class="btn btn-dark write_btn">작성</button>
					</div>
				</form>
				<!-- 
				<form  method="post">
				  <textarea id="summernote" name="editordata"></textarea>
				</form>
				 -->
				
				  <script>
     				$('#summernote').summernote({
			        placeholder: 'Hello stand alone ui',
			        tabsize: 2,
			        height: 500,
			        toolbar: [
			          ['fontsize', ['fontsize']],
			          ['style', ['style']],
			          ['font', ['bold', 'underline', 'clear']],
			          ['color', ['color']],
			          ['para', ['ul', 'ol', 'paragraph']],
			          ['table', ['table']],
			          ['insert', ['link', 'picture', 'video']],
			          ['view', ['fullscreen', 'codeview', 'help']]
			        ],
			        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
     				
     				callbacks : { 
     	            	onImageUpload : function(files, editor, welEditable) {
     	            // 파일 업로드(다중업로드를 위해 반복문 사용)
     	            for (var i = files.length - 1; i >= 0; i--) {
     	            uploadSummernoteImageFile(files[i],
  					this);
     	            		}
     	            	}
     	            }
			      });
     				
     				function uploadSummernoteImageFile(file, el) {
     					data = new FormData();
     					data.append("file", file);
     					$.ajax({
     						data : data,
     						type : "POST",
     						url : "/boardimagesupload",
     						contentType : false,
     						enctype : 'multipart/form-data',
     						processData : false,
     						
     						success : function(data) {
     							console.log(data.url);
     							console.log(data.responseCode);
     							
     							setTimeout(function() {
     								$(el).summernote('editor.insertImage', data.url);
     							}, 4000);
     						}     						
     					});
     				}
			    </script>
				
			</div>
			
		</div>
	</div>
	
	
</body>
</html>