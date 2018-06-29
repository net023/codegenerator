<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${domainClassName}</title>
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
				$('#${domainClassName?uncap_first}Grid').datagrid( {
					fit : true,
					border : false,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : "#tb",
					url:"${resPathPrefix}${domainClassName?uncap_first}/pageQuery.action",
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
					] ],
					loadFilter:function(data){
						if(data.success){
							return data.data;
						}else{
							$.messager.alert('操作提示',data.message,'error');
						}
					}
				});
				
				//编辑窗口
				
				$("#${domainClassName?uncap_first}EditDialog").dialog({
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
								if($("#${domainClassName?uncap_first}Form").form("validate")){
									$("#${domainClassName?uncap_first}Form").form("submit",{
										success:function(data){
											data = eval('(' + data + ')');
											if(data.success){
												$("#${domainClassName?uncap_first}EditDialog").dialog("close");
												$("#${domainClassName?uncap_first}Grid").datagrid("reload");
											}else{
												$.messager.alert('操作提示',data.message,'error');
											}
										}
									});
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
							  $("#${domainClassName?uncap_first}EditDialog").dialog('close');
						  }
					  }       
					],
					onClose:function(){
						$("#${domainClassName?uncap_first}Form").form("clear");
					}
				});
				
			});
			
			function edit(rowIndex){
				$('#${domainClassName?uncap_first}Form').attr('action','${resPathPrefix}${domainClassName?uncap_first}/update');
			    var data = $('#${domainClassName?uncap_first}Grid').datagrid('getRows')[rowIndex];
			    $('#${domainClassName?uncap_first}Form').form("load",data);
			    $('#${domainClassName?uncap_first}EditDialog').dialog('open').dialog('setTitle','修改');
			}

			function del(rowIndex){
				$.messager.confirm('操作提示', '确定要删除？', function(r){
			        if (r){
			            var data = $('#${domainClassName?uncap_first}Grid').datagrid('getRows')[rowIndex];
			            $.post("${resPathPrefix}${domainClassName?uncap_first}/delete",{'id':data.id},function(data){
			            	if(data.success){
			            		$('#${domainClassName?uncap_first}Grid').datagrid('reload');
			            	}else{
			            		$.messager.alert('操作提示', data.message,'error');
			            	}
			            });
			        }
			    });
			}

			function batchDel(){
				var check = $('#${domainClassName?uncap_first}Grid').datagrid('getChecked');
		        if(check.length > 0){
		            $.messager.confirm('操作提示', '确定要删除所选配置？', function(r){
		                if (r){
		                    var configs = new Array();
		                    for(var i in check){
		                    	configs[i] = check[i].id;
		                    }
		                    $.post("${resPathPrefix}${domainClassName?uncap_first}/batchDelete",{'ids':configs.join(',')},function(data){
				            	if(data.success){
				            		$('#${domainClassName?uncap_first}Grid').datagrid('reload');
				            	}else{
				            		$.messager.alert('操作提示', data.message,'error');
				            	}
				            });
		                }
		            });
		        }
			}
			
			function add(){
				$('#${domainClassName?uncap_first}Form').attr('action','${resPathPrefix}${domainClassName?uncap_first}/save');
		        $('#${domainClassName?uncap_first}EditDialog').dialog('open').dialog("setTitle","添加");
			}
			
			function dosearch(){
				var searchObj = {};
				<#list fieldNames as field>
					if($("#query_${field}").val()){
						searchObj.${field} = $("#query_${field}").val();
					}
				</#list>
				$('#${domainClassName?uncap_first}Grid').datagrid('load',searchObj);
			}
			
		</script>
	</head>

	<body>
		<table id="${domainClassName?uncap_first}Grid"></table>
		<div id="tb" style="height:auto;">
			<div style="padding-top: 5px;">
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">新增</a>
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="batchDel()">批量删除</a>
			</div>
			<div style="margin: 5px;">
				<#list fieldNames as field>
					${field}: <input style="width:80px" id="query_${field}">
				</#list>
				<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="dosearch()">查询</a>
			</div>
		</div>
		<div id="${domainClassName?uncap_first}EditDialog">
			<form action="" method="post" id="${domainClassName?uncap_first}Form">
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