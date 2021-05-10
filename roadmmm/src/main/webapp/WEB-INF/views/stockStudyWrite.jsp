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
	</style>
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
					</select>
					
					<div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label"></label>
					  <textarea name = "content" class="form-control" id="exampleFormControlTextarea1" placeholder="내용" rows="20"></textarea>
					  <button type="submit" class="btn btn-dark write_btn">작성</button>
					</div>
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>