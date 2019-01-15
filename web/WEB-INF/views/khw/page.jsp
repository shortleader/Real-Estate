<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Page Content -->
<div class="page">
	<div class="container">

		<!-- Page Heading -->
		<h1 class="my-4">
			<!-- Page Heading <small>Secondary Text</small> -->
		</h1>

		<div class="row">
			<c:forEach var="item" items="${list}">
				<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
					<div class="card h-100">
						<a href="#" onclick="getContent('${item.url}')"><img
							class="card-img-top" src="${item.img}" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">${item.title}</a>
							</h4>
							<p class="card-text">${item.content}
								<b>${item.writing}</b>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</div>
<!-- /.container -->