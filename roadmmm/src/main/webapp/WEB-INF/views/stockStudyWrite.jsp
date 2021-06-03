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
	
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	
	<!--  썸머노트 -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
  	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
  	
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
					  <textarea name = "content" class="form-control" id="exampleFormControlTextarea1" placeholder="내용" rows="20"></textarea>
					  <button type="submit" class="btn btn-dark write_btn">작성</button>
					</div>
				</form>
				
				<div class="container">
				  <textarea class="summernote" name="editordata"></textarea>    
				</div>
				
				<script>
				$('.summernote').summernote({
					  // 에디터 높이
					  height: 500,
					  // 에디터 한글 설정
					  lang: "ko-KR",
					  // 에디터에 커서 이동 (input창의 autofocus라고 생각하시면 됩니다.)
					  focus : true,
					  toolbar: [
						    // 글꼴 설정
						    ['fontname', ['fontname']],
						    // 글자 크기 설정
						    ['fontsize', ['fontsize']],
						    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
						    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
						    // 글자색
						    ['color', ['forecolor','color']],
						    // 표만들기
						    ['table', ['table']],
						    // 글머리 기호, 번호매기기, 문단정렬
						    ['para', ['ul', 'ol', 'paragraph']],
						    // 줄간격
						    ['height', ['height']],
						    // 그림첨부, 링크만들기, 동영상첨부
						    ['insert',['picture','link','video']],
						    // 코드보기, 확대해서보기, 도움말
						    ['view', ['codeview','fullscreen', 'help']]
						  ],
						  // 추가한 글꼴
						fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
						 // 추가한 폰트사이즈
						fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
						
					});
				</script>
				
			</div>
			
		</div>
	</div>
	
	
</body>
</html>