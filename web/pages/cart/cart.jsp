<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--		静态包含--%>
	<%@include file="../common/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗")
			})

			//内容改变事件
			$(".bookCount").change(function () {


				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookId');
				// 获取商品数量
				var count = this.value;

				if (confirm("你确定要将"+name+"商品数量修改为"+count+"吗？")){
					location.href="http://localhost:8080/MyBook/cart?action=updateCart&id="+id+"&count="+count;
				}else {
					this.value=this.defaultValue;
				}

				 // if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) { //发起请求。给服务器保存修改
				 // 	 location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+id; }
				 // else { // defaultValue 属性是表单项 Dom 对象的属性。它表示默认的 value 属性值。
				 // 	 this.value = this.defaultValue; }



			})

		})


	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--				静态包含--%>
		<%@include file="../common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="item">
			<tr>
				<td>${item.value.name}</td>
				<td>
					<input type="text" value="${item.value.count}" style="width: 80px" class="bookCount" bookId="${item.value.id}">
				</td>
				<td>${item.value.price}</td>
				<td>${item.value.totalPrice}</td>
				<td><a href="cart?action=deleteItem&id=${item.value.id}" class="deleteClass">删除</a></td>
			</tr>
			</c:forEach>

			</c:if>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">去购物</a></td>
				</tr>
			</c:if>
		</table>

		<c:if test="${not empty sessionScope.cart.items}">
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="cart?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="order?action=createOrder">去结账</a></span>
		</div>

		</c:if>
	
	</div>
	
	<%@include file="../common/footer.jsp"%>
</body>
</html>