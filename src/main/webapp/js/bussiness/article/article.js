var date = new Date();
var month = (date.getMonth()+1);
var nowDate = date.getFullYear()+(month<10?("-0"+month):("-"+month))+((date.getDate())<10?("-0"+(date.getDate())):("-"+(date.getDate())));
var url = ctx+"/article/search";
$(function () {

    //默认
    var pageNo = $("input[name='pageNo']").val();
    var pageSize = $("input[name='pageSize']").val();
    var parameter = {
        pageNo:pageNo,
        pageSize:pageSize
    };
    searchData(url, parameter);

    //当点击全选/全不选框时，全选或者全不选全部
    $("#selectAll").click(function(event){
        var check_state = event.target.checked;
        $('input[name="items"][type="checkbox"]').each(function() {
            this.checked = check_state;
        });
    });
    $(".rowIdImput").live("click",function(event){
        var flage =  true;
        var check_state = event.target.checked;
        $(".rowIdImput").each(function() {
            if(this.checked != check_state){
                flage = false;
            }
        });
        if(flage){
            $("#selectAll")[0].checked = check_state;
        }else{
            $("#selectAll")[0].checked = false;
        }
    })  ;

    //批量删除
    $("#del").click(function () {
        var idStr = getSelectId();
        if (idStr == "") {
            jAlert('请选择要删除的记录！', '提示');
            return;
        }
        jConfirm('确定要删除记录?', '提示', function(r) {
            if( r ){
                $.ajax( {
                    dataType: "json",
                    type: "get",
                    url: ctx+"/article/delete?idStr=" + idStr,
                    success:function(data){
                        if (data.code == "200") {
                            jAlert(data.msg, '提示');
                            var pageNo = 1;
                            var pageSize = 10;
                            var parameter = {
                                pageNo:pageNo,
                                pageSize:pageSize
                            };
                            searchData(url, parameter);
                        } else {
                            jAlert(data.msg, '提示');
                        }
                    }
                }) ;
            }
        });
    });

    //批量关注 TODO
    $("#focus").click(function () {
        var idStr = getSelectId();
        if (idStr == "") {
            jAlert('请选择要删除的记录！', '提示');
            return;
        }
        jConfirm('确定要删除记录?', '提示', function(r) {
            if( r ){
                $.ajax( {
                    dataType: "json",
                    type: "get",
                    url: ctx+"/article/delete?idStr=" + idStr,
                    success:function(data){
                        if (data.code == "200") {
                            jAlert(data.msg, '提示');
                            var pageNo = 1;
                            var pageSize = 10;
                            var parameter = {
                                pageNo:pageNo,
                                pageSize:pageSize
                            };
                            searchData(url, parameter);
                        } else {
                            jAlert(data.msg, '提示');
                        }
                    }
                }) ;
            }
        });
    });

    //采集
    $("#spider").click(function () {
        $("#spider").attr('disabled',true);
        $.ajax({
            dataType: "json",
            type: "get",
            url: ctx + "/article/spider",
            success: function (data) {
                if (data.code == "200") {
                    jAlert('采集中，请稍等。', '提示');
                    var pageNo = 1;
                    var pageSize = 10;
                    var parameter = {
                        pageNo: pageNo,
                        pageSize: pageSize
                    };
                    searchData(url, parameter);
                } else {
                    jAlert('采集中，请与管理员联系。', '提示');
                }
            }
        });
    });

    //查询
    $("#submit").click(function () {
        var name = $("#name").val();
        var gender = $("#gender").val();
        var parameter = {
            name:name,
            gender:gender
        };
        searchData(url,parameter);
    });
});
function dateDiff(sDate1, sDate2) {  //sDate1和sDate2是yyyy-MM-dd格式

    var oDate1, oDate2, iDays;
    oDate1 = new Date(sDate1);
    oDate2 = new Date(sDate2);
    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
    return iDays;  //返回相差天数

}
//查询分页数据并显示到页面
function searchData(url,data){
    $.ajax( {
        dataType: "json",
        type: "post",
        url: url,
        data: data,
        success:function(page){
            var result = page.result;
            var table = '';
            try {
                for (var i=0;i<result.length;i++) {
                    table +=
                        '<tr>' +
                        '<td><input class="rowIdImput" type="checkbox" name="items" value="'+ result[i].id +'"></td>'+
                        '<td><a href="'+ result[i].fromUrl +'" target="view_window">'+ result[i].name + '</a></td>'+
                        // '<td>'+ result[i].name + '</td>'+
                        '<td>'+ result[i].fromWeb + '</td>'+
                        '<td>'+ formatDate(result[i].publishDate) + '</td>'+
                        '<td>'+ formatDate(result[i].createTime) + '</td>';
                    table +=
                        '<td><button type="button" onclick="showDetail(\''+result[i].id+'\')" class="btn btn-default btn-sm">&nbsp;详情</button></td>'+
                        '</tr>';
                }
                //添加列表数据
                $(table).appendTo($("#listTab").find("tbody").empty());

                //添加分页信息
                var pageNo = page.pageNo;
                var totalPages = page.totalPages;

                var firstPage = '<li><a href="javascript:gotoPage('+ page.startPage +');">&lt;&lt;</a></li>';
                var prePage = '<li><a href="javascript:gotoPage('+ page.prePage +');">&lt;</a></li>';
                var page1 = getPage(pageNo, totalPages);
                var nextPage = '<li><a class="page-item" href="javascript:gotoPage('+ page.nextPage +');">&gt;</a></li>';
                var endPages = '<li><a class="page-item" href="javascript:gotoPage('+ page.totalPages +');">&gt;&gt;</a></li>';
                var pageInfo = firstPage + prePage + page1 + nextPage + endPages;
                $(pageInfo).appendTo($(".pagination").empty());
                for (var i=0;i<result.length;i++) {
                    $('.rowIdImput[value='+result[i].id+']').data("datas",result[i]);
                }
            } catch (e) {
                table += '<tr><td colspan="6" align="center"><font style="font-weight: bold; color: red">无相关记录存在！</font></td></tr>';
                $(table).appendTo($("#listTab").find("tbody").empty());
            }
        }
    }) ;
}

function gotoPage(newPageNo){
    $("[name='pageNo']").val(newPageNo);
    var pageNo = $("input[name='pageNo']").val();
    var pageSize = $("input[name='pageSize']").val();
    var name = $("#name").val();
    var args = {
        pageNo:pageNo,
        pageSize:pageSize,
        name:name
    };
    searchData(url, args);
}

//修改
function showDetail(id) {
    var data =  $('.rowIdImput[value='+id+']').data("datas") ;
    $("input[name=id]").val(data.id);
    $("input[name=name]").val(data.name);
    $("input[name=content]").val(data.content);
    $("input[name=fromUrl]").val(data.fromUrl);
    $("input[name=fromWeb]").val(data.fromWeb);
    $("input[name=publishDate]").val(formatDate(data.publishDate));
    $("input[name=remark]").val(data.remark);
    $("#myModal").modal("show");
}

//获取已选择的ID字符串
function getSelectId(){
    var ids = '';
    $('input[name="items"][type="checkbox"]:checked').each(function() {
        if(ids == ''){
            ids = $(this).val();
        }else{
            ids = ids + ',' + $(this).val();
        }
    });
    return ids;
}

function getPage(pageNo, totalPages) {
    var page1 = "";
    if (totalPages <= 3) {
        for (var i=1; i<totalPages+1; i++) {
            page1 += '<li><a href="javascript:gotoPage('+i+');">'+ i +'</a></li>';
        }
    } else {
        if (pageNo <= 2) {
            page1  = '<li><a href="javascript:gotoPage(1);">1</a></li>' +
                '<li><a href="javascript:gotoPage(2);">2</a></li>' +
                '<li><a href="javascript:gotoPage(3);">3</a></li>';
            return page1;
        }
        var count = totalPages - pageNo;
        if (count == 0) {
            var startCount = totalPages - 2;
            var middleCount = totalPages - 1;
            page1  = '<li><a href="javascript:gotoPage('+startCount+');">'+startCount+'</a></li>' +
                '<li><a href="javascript:gotoPage('+middleCount+');">'+middleCount+'</a></li>' +
                '<li><a href="javascript:gotoPage('+totalPages+');">'+totalPages+'</a></li>';
            return page1;
        } else {
            var startCount = pageNo -1;
            var endCount = pageNo +1;
            page1 = '<li><a href="javascript:gotoPage('+startCount+');">'+startCount+'</a></li>' +
                '<li><a href="javascript:gotoPage('+pageNo+');">'+pageNo+'</a></li>' +
                '<li><a href="javascript:gotoPage('+endCount+');">'+endCount+'</a></li>';
            return page1;
        }
    }
    return page1;
}

//时间格式化
function formatDate (strTime) {
    var date = new Date(strTime);
    var month = (date.getMonth()+1);
    return date.getFullYear()+(month<10?("-0"+month):("-"+month))+((date.getDate())<10?("-0"+(date.getDate())):("-"+(date.getDate())));
}

//导出数据
function exportXml(days){
    location.href = ctx + "/article/export/" + days;
}