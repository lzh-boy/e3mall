<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	 <a class="easyui-linkbutton" onclick="importItems()">一键导入商品数据到索引库</a>
</div>
<script type="text/javascript">
	function importItems() {
		$.post("/tb/item/import",null,function(data){
			if(data.status == 200){
				$.messager.alert('提示','导入索引库成功！','info');
			} else {
				$.messager.alert('提示','导入索引库失败！','warning');
			}
		});
	}
</script>