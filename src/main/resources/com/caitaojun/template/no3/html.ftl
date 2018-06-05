<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${doaminClassName}</title>
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="${resPathPrefix}js/jquery-1.8.3.js"></script>
		<!-- 导入easyui类库 -->
		<link rel="stylesheet" type="text/css" href="${resPathPrefix}js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${resPathPrefix}js/easyui/themes/icon.css">
		<script type="text/javascript" src="${resPathPrefix}js/easyui/jquery.easyui.min.js"></script>
		<script src="${resPathPrefix}js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<style type="text/css">
			.opt{
				text-decoration: none;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$('#${doaminClassName?uncap_first}Grid').datagrid( {
					fit : true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : "#tb",
					url:"${resPathPrefix}${doaminClassName?uncap_first}/pageQuery.action",
					idField : 'id',
					columns : [ [
					<#list fieldNames as field>
						<#if field=='id'>
							{
								field : 'id',
								checkbox : true,
							},
						<#else>
							{
								field : '${field}',
								title : '${field}',
								width : 120,
								align : 'center'
							},
						</#if>
					</#list>
					 {
						field : 'opts',
						title : '操作',
						width : 200,
						align : 'center',
						formatter : function(value,rowData,rowIndex){
							var html = '<a class="opt" onclick="edit('+rowIndex+');" href="javascript:;" style="">修改</a>';
							html += '&nbsp-&nbsp';
							html += '<a class="opt" onclick="del('+rowIndex+');" href="javascript:;" style="">删除</a>';
							return html;
						}
					} 
					] ]
				});
				
				//编辑窗口
				
				$("#${doaminClassName?uncap_first}EditDialog").dialog({
					title:'编辑',
					modal:true,
					closed:true,
					width:600,
					height:400,
					closable:false,
					toolbar:[
						{
							id:'save',
							text:'保存',
							iconCls:'icon-save',
							handler:function(){
								alert(1);
								if($("#${doaminClassName?uncap_first}Form").form("validate")){
									$("#${doaminClassName?uncap_first}Form").submit();
									$("#${doaminClassName?uncap_first}EditDialog").dialog("close");
									$("#${doaminClassName?uncap_first}Grid").datagrid("reload");
								}else{
									$.messager.alert("请检查表单数据");
								}
							}
						}         
					],
					buttons:[
					  {
						  id:'cancel',
						  text:'取消',
						  iconCls:'icon-cancel',
						  handler:function(){
							  $("#${doaminClassName?uncap_first}EditDialog").dialog('close');
						  }
					  }       
					],
					onClose:function(){
						$("#${doaminClassName?uncap_first}Form").form("clear");
					}
				});
				
			});
			
			function edit(rowIndex){
				$('#${doaminClassName?uncap_first}Form').attr('action','${resPathPrefix}${doaminClassName?uncap_first}/update');
			    var data = $('#${doaminClassName?uncap_first}Grid').datagrid('getRows')[rowIndex];
			    $('#${doaminClassName?uncap_first}Form').form("load",data);
			    $('#${doaminClassName?uncap_first}EditDialog').dialog('open').dialog('setTitle','修改');
			}

			function del(rowIndex){
				$.messager.confirm('操作提示', '确定要删除？', function(r){
			        if (r){
			            var data = $('#${doaminClassName?uncap_first}Grid').datagrid('getRows')[rowIndex];
			            $.post("${resPathPrefix}${doaminClassName?uncap_first}/delete",{'id':data.id},function(data){
			            	if(data.success){
			            		$('#${doaminClassName?uncap_first}Grid').datagrid('reload');
			            	}else{
			            		$.messager.alert('操作提示', data.message,'error');
			            	}
			            });
			        }
			    });
			}

			function batchDel(){
				var check = $('#${doaminClassName?uncap_first}Grid').datagrid('getChecked');
		        if(check.length > 0){
		            $.messager.confirm('操作提示', '确定要删除所选配置？', function(r){
		                if (r){
		                    var configs = new Array();
		                    for(var i in check){
		                    	configs[i] = check[i].id;
		                    }
		                    $.post("${resPathPrefix}${doaminClassName?uncap_first}/batchDelete",{'ids':configs.join(',')},function(data){
				            	if(data.success){
				            		$('#${doaminClassName?uncap_first}Grid').datagrid('reload');
				            	}else{
				            		$.messager.alert('操作提示', data.message,'error');
				            	}
				            });
		                }
		            });
		        }
			}
			
			function add(){
				$('#${doaminClassName?uncap_first}Form').attr('action','${resPathPrefix}${doaminClassName?uncap_first}/save');
		        $('#${doaminClassName?uncap_first}EditDialog').dialog('open').dialog("setTitle","添加");
			}
			
			function search(){
				var searchObj = {};
				<#list fieldNames as field>
					searchObj.${field} = $("#query_${field}").val();
				</#list>
				$('#${doaminClassName?uncap_first}Grid').datagrid('load',searchObj);
			}
			
		</script>
	</head>

	<body>
		<table id="${doaminClassName?uncap_first}Grid"></table>
		<div id="tb" style="height:auto;">
			<div style="padding-top: 5px;">
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">新增</a>
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="batchDel()">批量删除</a>
			</div>
			<div style="margin: 5px;">
				<#list fieldNames as field>
					${field}: <input style="width:80px" id="query_${field}">
				</#list>
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="search()">查询</a>
			</div>
		</div>
		<div id="${doaminClassName?uncap_first}EditDialog">
			<form action="" method="post" id="${doaminClassName?uncap_first}Form">
				<input type="hidden" name="id">
				<table style="text-align: center;">
				<#list fieldNames as field>
					<tr>
						<td>
							<label>${field}</label>
						</td>
						<td>
							<input type="text" name="${field}" id="form_${field}" data-options="required:true">
						</td>
					</tr>
				</#list>
				</table>
			</form>
		</div>
	</body>
</html>