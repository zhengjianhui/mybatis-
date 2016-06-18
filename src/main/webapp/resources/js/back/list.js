/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	// 获取form 节点 attr 修改属性
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	// 用js的方式触发submit();
	$("#mainForm").submit();
	console.log(1);
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}