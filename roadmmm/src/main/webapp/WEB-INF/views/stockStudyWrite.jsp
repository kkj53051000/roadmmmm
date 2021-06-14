<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주식 정보 작성</title>
	<style>
		.ssw_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.ssw_main{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.ssw_input{
			width: 1000px;		
		}
		.write_btn{
			margin-top: 30px;
		}
		.ssw_top{
			height: 100px;
			
			margin-bottom: 20px;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
		.ssw_top_logo{
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
	<!-- <script src="https://cdn.ckeditor.com/ckeditor5/27.1.0/classic/ckeditor.js"></script>
	<script src="static/ckeditor5/ckeditor.js"></script> -->
	
	<!--
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	 -->
	 
	 <!--  썸머노트
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
  	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
	 -->
	 
	 <!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- include summernote css/js 
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	-->
	
	<link href="static/summernote/summernote-lite.css" rel="stylesheet">
	<script src="static/summernote/summernote-lite.js"></script>
  	
  	<script src="static/summernote/summernote-ko-KR.js"></script>
	
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="ssw_wrap">
		
		<div class="ssw_main">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			
			<div class="ssw_input">
				
				<div class="ssw_top">
					<div class="ssw_top_logo">
						<h1>주식공부 작성</h1>
					</div>
				</div>
			
				<form action="/stockstudyprocess" method="POST">
					<input name = "title"class="form-control form-control-lg" type="text" placeholder="제목" aria-label=".form-control-lg example">
					<br/>
					<select name = "tag" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
					  <option selected>분류를 선택해주세요.</option>
					  <option value="STOCK">주식</option>
					  <option value="TERM">용어</option>
					  <option value="CHART">차트</option>
					  <option value="INCIDENT">사건</option>
					</select>
					
					<div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label"></label>
					  <!-- <textarea name = "content" class="form-control" id="exampleFormControlTextarea1" placeholder="내용" rows="20"></textarea>  -->
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