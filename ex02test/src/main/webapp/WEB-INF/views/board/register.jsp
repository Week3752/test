<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Modify/Delete</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					DataTables Advanced Tables
					<button id="regBtn" type="button" class="btn btn-primary">Register</button>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
				<form action="/board/register" method="post">
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" >
					</div>
					<div class="form-group">
						<label>Content</label>
						<input class="form-control" name="content">
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer">
					</div>
					<button type="button" class="btn btn-success"><a href="/board/list">List</a></button>
					<button type="submit" class="btn btn-submit"	></button>				
					</from>
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

<%@include file="../includes/footer.jsp"%>