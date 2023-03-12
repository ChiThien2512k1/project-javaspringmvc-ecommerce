<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${categorys }">
						<li><a href="<c:url value="/san-pham/${item.id }"/>"><span
								class="icon-circle-blank"></span> ${item.name }</a></li>
					</c:forEach>

					<li><a class="totalInCart" href="cart.html"><strong>Đã
								Mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPriceCart}" />
									₫</span>
						</strong></a></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			

			
			

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">User</li>
			</ul>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Create a new account</h5>
						<form:form action="dang-ky" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail </label>
								<div class="controls">
									<form:input type="email" class="span3" path="user"
										placeholder="Enter your email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password
								</label>
								<div class="controls">
									<form:input type="password" class="span3" path="password"
										placeholder="Enter your password" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Username </label>
								<div class="controls">
									<form:input type="text" class="span3" path="display_name"
										placeholder="Enter your username" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Address </label>
								<div class="controls">
									<form:input type="text" class="span3" path="address"
										placeholder="Enter your address" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn block">Register</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Sign in</h5>
						<h1>${statusLogin}</h1>
						<form:form action="dang-nhap" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input type="email" class="span3" path="user"
										placeholder="Enter your email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password</label>
								<div class="controls">
									<form:input type="password" class="span3" path="password"
										placeholder="Enter your password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Sign in</button>
									<a href="#">Forget password?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
