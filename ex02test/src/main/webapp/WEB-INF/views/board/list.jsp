<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<!-- 상대 경로를 유일하게 쓰는 곳 -->
<%@include file="../includes/header.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">DataTables Advanced Tables
					<button id = "regBtn" type="button" class="btn btn-primary">Register</button>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>BNO</th>
								<th>TITLE</th>
								<th>CONTENT</th>
								<th>WRITER</th>
								<th>REGDATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dto" items="${list}">
								<tr>
									<td><c:out value="${dto.bno}" /></td>
									<td><a href='/board/get?bno=<c:out value="${dto.bno }"/>'>
											<c:out value="${dto.title}" />
									</a></td>
									<td><c:out value="${dto.content}" /></td>
									<td><c:out value="${dto.writer}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
											value="${dto.regdate }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

<div id="myModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		let result = '<c:out value="${result }"/>';
		console.log(result);
		
		checkModal(result);
		
		function checkModal(result){
			if(result === ''){}
				return;
			}
			// 수정 또는 삭제된 행이 존재
			if(result == "success"){
				$(".modal-body").html("정상적으로 처리되었습니다");
			}else if(parseInt(result) > 0){
			// 글 등록시 bno가 잘 받아진 경우
			$(".modal-body").html(parseInt(result) + "번 글이 등록 되었습니다");
			}
			
			$("#myModal").modal("show");
		}
	$("#regBtn").click(function(){
		// self : 현재 window 창, location : URL변경 -> 페이지 이동
		self.location = "/board/register";
	});
});
</script>

<%@include file="../includes/footer.jsp"%>

</body>
</html>
