<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品修改</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center; }
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; width:50%; }
	td, th{ padding: 7px;font-size:18px;}
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
	input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
	select{text-indent:0px;}
	textarea{height:100px;font-size:22px;}
	
</style>

<!--引入jquery的js库-->
<script src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>修改商品信息</h2>
	<hr/>
	<form action="${pageContext.request.contextPath}/ProdUpdServlet" method="POST">
		<input type="hidden" name="id" value="${ prod.id }"/>
		<table border="1">
			<tr>
				<td width="30%">商品名称</td>
				<td>
					<input type="text" name="name" 
							value="${ prod.name }"/>
				</td>
			</tr>
			<tr>
				<td>商品种类</td>
				<script>
					/* 定义一个文档就绪事件, 在整个页面加载完之后再
						获取页面中的元素或属性 */
					window.onload = function(){
						//1.获取select元素
						var oSele = document
							.getElementsByName("category")[0];
						//2.通过select元素获取data属性值(如:家用电器)
						var category = oSele.getAttribute("data");
						alert(category);
						//3.获取所有的option选项,循环遍历,取出每一个option
						var arrOpt = oSele.getElementsByTagName("option");
						var len = arrOpt.length;
						for(var i=0;i<len;i++){
							//>>获取当前被遍历的option标签内的文本
							//>>将data属性的值和option标签内的文本进行比较
							if(category == arrOpt[i].innerHTML){
								//>>如果相等则将该选项设置为默认被选中
								arrOpt[i].setAttribute(
										"selected", true);
								return;
							}
						}
					}
				</script>
				<td>
					<select name="category" data="${ prod.category }">
						<option>手机数码</option>
						<option>电脑平板</option>
						<option>家用电器</option>
						<option>汽车用品</option>
						<option>食品饮料</option>
						<option>图书杂志</option>
						<option>服装服饰</option>
						<option>理财产品</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品单价</td>
				<td>
					<input type="text" name="price"
							value="${ prod.price }"/>
				</td>
			</tr>
			<tr>
				<td>库存数量</td>
				<td>
					<input type="text" name="pnum"
							value="${ prod.pnum }"/>
				</td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td>
					<textarea name="description">${ prod.description }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="修改商品信息" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



