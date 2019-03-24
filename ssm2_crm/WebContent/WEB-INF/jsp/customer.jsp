<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<link rel="stylesheet" type="text/css" href="../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<div id="left">
			<form action="" method="get" class="form-inline" style="margin: 15px;" id="leftQ">
				<div  class="input-group">
					<input type="text" class="form-control"  placeholder="查询内容" name="mainQ"/>
					<div  class="input-group-addon unselectable" onclick="$('#leftQ').submit()" >
						<i class="fa fa-search" ></i>	
					</div>
				</div>
			</form>
			
			<div id="" class="mlabels tMlabels">
				<a href=""><i class="fa fa-drivers-license-o"></i>客户管理</a>
			</div>
			<div id="" class="mlabels ">
				<a href=""><i class="fa fa-server "></i>客户拜访</a>
			</div>
			<div id="" class="mlabels ">
				<a href=""><i class="fa fa-address-book-o "></i>添加客户</a>
			</div>
		</div>
		
		<div id="right">
			<div id="topName">
				<h1>客户管理</h1>
			</div>
			
			<div id="nav">
				<form action="${pageContext.request.contextPath }/customer/list.action" method="post" class="form-inline" id="mFrom">
					<div id="" class="form-group navPadding">
						<label>客户名称:</label>
						<input type="text" name="name" class="form-control" value="${cus.name }" id="name"/>
					</div>
					
					<div id="" class="form-group navPadding">
						<label>客户来源:</label>
						<select name="source" class="form-control" id="source">
							<option value="">--请选择--</option>
						</select>
					</div>
					
					<div id="" class="form-group navPadding">
						<label>所属行业:</label>
						<select name="industry" class="form-control" id="industry">
							<option value="">--请选择--</option>
						</select>
					</div>
					
					<div id="" class="form-group navPadding">
						<label>客户级别:</label>
						<select name="level" class="form-control" id="level">
							<option value="">--请选择--</option>
						</select>
					</div>
					<input type="hidden" name="pageNum" id="pageNum"/>
					<button type="button" class="btn btn-warning btn-xs" onclick="closValues()" >清空</button>
					<button type="button" class="btn btn-primary" onclick="referFrom()" >查询</button>					
				</form>
			</div>
			
			<div  class="panel panel-default">
				<div class="panel-heading">
					客户信息列表
				</div>
				<table class="table table-bordered table-hover">
					<thead>
						<th>ID</th>
						<th>客户名称</th>
						<th>客户来源</th>
						<th>客户所属行业</th>
						<th>客户级别</th>
						<th>固定电话</th>
						<th>手机</th>
						<th>操作</th>
					</thead>
					
					<tbody id="bod">
						<c:forEach items="${pageModel.list }" var="cus" >
							<tr>
								<td align="center" style="width: 45px;">${cus.id}</td>
								<td style="width: 120px;">${cus.name}</td>
								<td style="width: 120px;">${cus.source}</td>
								<td style="width: 145px;">${cus.industry}</td>
								<td style="width: 120px;">${cus.level}</td>
								<td style="width: 160px;">${cus.telephone}</td>
								<td style="width: 160px;">${cus.phone}</td>
<!-- 								<td><input type="text" name="xx" class="form-control" value="ss" id="xx"/></td> -->
								<td align="center">
									<a href="#" class="btn btn-primary btn-xs edit" onclick="editCustomer(${cus.id})">修改</a>
									<a href="#" class="btn btn-danger btn-xs" onclick="deleteCustomer(${cus.id})">删除</a>
								</td>
							</tr>						
						</c:forEach>
					</tbody>
				</table>
				
			</div>
			
			<div id="page-wrapper">
				<ul class="pagination unselectable" >
					<li>
						<c:if test="${pageModel.currentPageNum == 1 }"><a>&laquo;</a></c:if>
						<c:if test="${pageModel.currentPageNum != 1 }"><a onclick="referFrom(${pageModel.currentPageNum -1})">&laquo;</a></c:if>
					</li>
					
					<c:forEach begin="${pageModel.startPage }" end="${pageModel.endPage}" var="i">
						<c:if test="${pageModel.currentPageNum == i }">
							<li class="active"><a >${i}</a></li>
						</c:if>
						<c:if test="${pageModel.currentPageNum != i }">
							<li><a onclick="referFrom(${i})">${i}</a></li>
						</c:if>
					</c:forEach>
					
					<li>
						<c:if test="${pageModel.currentPageNum == pageModel.totalPageNum }"><a>&raquo;</a></c:if>
						<c:if test="${pageModel.currentPageNum != pageModel.totalPageNum }"><a onclick="referFrom(${pageModel.currentPageNum +1})">&raquo;</a></c:if>
					</li>	
				</ul>	
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">

	//删除
	function deleteCustomer(id){
		var flag = confirm("是否确认删除");				
		if(flag){
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/customer/delete.action?id="+id,
				success:function(data){
					alert("删除成功")
					// 刷新
					referFrom(${pageModel.currentPageNum})					
				}
			})
			
			//window.location.href = "${pageContext.request.contextPath}/customer/delete.action?id="+id;
		}
	}
	//提交查询请求
	function referFrom(pageNum = 1) {
		$("#pageNum").val(pageNum)
 		$("#mFrom").submit()	
	}
	//清空查询按钮值
	function closValues(){
		$("#name").val("")
		$("#source").val("")
		$("#industry").val("")
		$("#level").val("")
	}
	
	$(function(){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/dict/source.action",
			dataTpye:"json",
			success:function(data){
				$(data).each(function(index,Dict){
					$("#source").append("<option value="+Dict.code+">"+Dict.code+"</option>");				
				})
				$("#source").val("${cus.source}");
			}
		});
		
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/dict/industry.action",
			dataTpye:"json",
			success:function(data){
				$(data).each(function(index,Dict){
					$("#industry").append("<option value="+Dict.code+">"+Dict.code+"</option>");					
				})
				$("#industry").val("${cus.industry}");
			}
		});
		
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/dict/level.action",
			dataTpye:"json",
			success:function(data){
				$(data).each(function(index,Dict){
					$("#level").append("<option value="+Dict.code+">"+Dict.code+"</option>");					
				})
				$("#level").val("${cus.level}");
			}
		});
		
		$(".edit").on("click",function(){
			d = $(this).parent().parent().children()
			$(d).each(function(index,data){
				if(index == 1){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<input type="text" name="name" id="editName" value="'+value+'" />')
				}else if(index == 5){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<input type="text" name="telephone" id="editTelephone" value="'+value+'" />')
				}else if(index == 6){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<input type="text" name="phone" id="editPhone" value="'+value+'" />')
				}else if(index == 0){
					value = $(data).html()
					$(data).append('<input type="hidden" name="id" id="editId" value="'+value+'" />')
				}else if(index == 2){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<select name="source" id="editSource" value="'+value+'"><option value="电话推销">电话推销</option><option value="广告推销">广告推销</option></select>')
				}else if(index == 3){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<select name="industry" id="editIndustry" value="'+value+'"><option value="电子商务">电子商务</option><option value="软件技术">软件技术</option></select>')
				}else if(index == 4){
					$(data).css("padding",0)
					value = $(data).html()
					$(data).html('<select name="level" id="editLevel" value="'+value+'"><option value="普通客户">普通客户</option><option value="高级用户">高级用户</option><option value="无效用户">无效用户</option></select>')
				}else if(index == 7){
					$(data).html('<a href="#" id="y" class="btn btn-success btn-xs"  >确认</a><a href="#" id="n" class="btn btn-warning btn-xs" ">取消</a>')
				}			
			})
			$("#y").click(function(){
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/customer/edit.action",
					data:{
						id:$("#editId").val(),
						name:$("#editName").val(),
						source:$("#editSource").val(),
						industry:$("#editIndustry").val(),
						level:$("#editLevel").val(),
						telephone:$("#editTelephone").val(),
						phone:$("#editPhone").val()
					},
					success:function(data){
						referFrom(${pageModel.currentPageNum})
					}
				});
			})
			$("#n").click(function(){
				referFrom(${pageModel.currentPageNum})
			})
		
		})
	})
</script>

</html>