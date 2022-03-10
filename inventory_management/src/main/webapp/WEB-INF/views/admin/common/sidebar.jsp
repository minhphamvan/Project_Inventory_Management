<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="left">
	<span class="left__icon"> <span></span> <span></span> <span></span>
	</span>

	<div class="left__content">
		<div class="left__logo">
			<a>QUẢN LÝ CỬA HÀNG</a>
		</div>
		<div class="left__profile">
			<div class="left__image">
				<a href="#"><img src="#"></a>
			</div>

			<a href="#">
				<p class="left__name">Admin</p>
			</a>
		</div>

		<ul class="left__menu">
			<li class="left__menuItem"><a class="left__title" href="#"><img
					src='<c:url value="/static/admin/assets/icon-dashboard.svg"></c:url>'
					alt="">Trang quản trị</a></li>

			<li class="left__menuItem">
				<div class="left__title">
					<img
						src='<c:url value="/static/admin/assets/icon-settings.svg"></c:url>'
						alt="">My Account<img class="left__iconDown"
						src='<c:url value="/static/admin/assets/arrow-down.svg"></c:url>'
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link" href="#">Thông tin chi tiết</a> <a
						class="left__link" href="#">Đổi mật khẩu</a>
				</div>
			</li>

			<li class="left__menuItem">
				<div class="left__title">
					<img
						src='<c:url value="/static/admin/assets/icon-edit.svg"></c:url>'
						alt="">Danh mục<img class="left__iconDown"
						src='<c:url value="/static/admin/assets/arrow-down.svg"></c:url>'
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="/Online_Store_Jsp_Servlet/admin/category/add">Thêm danh
						mục</a> <a class="left__link"
						href="/Online_Store_Jsp_Servlet/admin/category/show-all">Xem
						tất cả</a>
				</div>
			</li>

			<li class="left__menuItem">
				<div class="left__title">
					<img
						src='<c:url value="/static/admin/assets/icon-pencil.svg"></c:url>'
						alt="">Sản phẩm<img class="left__iconDown"
						src='<c:url value="/static/admin/assets/arrow-down.svg"></c:url>'
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="/Online_Store_Jsp_Servlet/admin/product/add">Thêm sản
						phẩm</a> <a class="left__link"
						href="/Online_Store_Jsp_Servlet/admin/product/show-all">Xem
						tất cả</a>
				</div>
			</li>

			<li class="left__menuItem"><a class="left__title" href="#"><img
					src='<c:url value="/static/admin/assets/icon-tag.svg"></c:url>'
					alt="">Quay lại trang chủ</a></li>

			<li class="left__menuItem"><a class="left__title" href="#"><img
					src='<c:url value="/static/admin/assets/icon-logout.svg"></c:url>'
					alt="">Đăng Xuất</a></li>
		</ul>
	</div>
</div>
