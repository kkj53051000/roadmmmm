<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로드밀</title>
	<style>
		.main_wrap{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			
			margin-top: 50px;
		}
		.main_top{
			width: 90%;
			
			display: flex;
			flex-direction: row;
		}
		.main_imgs{
			margin-left: 50px;
			width: 1000px;
		}
		
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div class = "main_wrap">
	
		<div class = "main_top">
			<div>
				<%@ include file="common/navList.jsp" %>
			</div>
			
			<div class="main_imgs">
				<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img class="d-block w-100" src="static/img/nysegirl.jpg" alt="First slide">
				    </div>
				    <div class="carousel-item">
				      <img class="d-block w-100" src="static/img/nysegirl.jpg" alt="Second slide">
				    </div>
				    <div class="carousel-item">
				      <img class="d-block w-100" src="static/img/nysegirl.jpg" alt="Third slide">
				    </div>
				  </div>
				</div>
			</div>
			
		</div>
		
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$('.carousel').carousel()
	</script>
	
	
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>


</body>
</html>