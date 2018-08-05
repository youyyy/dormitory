$(function () {
    var modifyZsztUrl = "/modifyzszt";
    var addZsztUrl="/addzszt";
    var getDormitoryListUrl = "/querydormitories";
    var getZsztByZidUrl = "/queryzsztbyzid/";
    var deleteZsztByZidUrl = "/deletezsztbyzid/";
    var zid = getQueryString('zid');
    var isEdit = zid ? true : false;
    if (!isEdit) {
        getDormitoryList();
    } else {
        getDormitoryList();
        getZsztInfo(zid);
    }
    function getDormitoryList() {
        $.getJSON(getDormitoryListUrl, function (data) {
            if (data.status == 200) {
                var tempHtml = '';
                data.data.map(function (item, index) {
                    tempHtml += '<option data-id="' + item.did + '">'
                        + item.building.place + item.building.bname +
                        item.num +
                        '</option>';
                });
                $('#dormitoryselect').html(tempHtml);
            }
        });
    };
    function getZsztInfo(zid) {
        $.getJSON(getZsztByZidUrl + zid, function (data) {
            if (data.status == 200) {
                $("#zid").val(data.data.zid);
                $("#dormitoryselect option[data-id='" +data.data.dormitory.did+"']").attr("selected","selected");
                $("#date").val(data.data.date);
                $("#zt").val(data.data.zt);
            }
        });
    };
    $("#deletezsztbt").click(function () {
        $.getJSON(deleteZsztByZidUrl+zid,function (data) {
            if(data.status == 200){
                alert("删除成功");
            }else {
                alert('删除失败');
            }
            window.location.href="zsztlist";
        });
    });

    $("#student").click(function(){
        window.location.href='/studentlist';
    });
    $("#building").click(function(){
        window.location.href='/buildinglist';
    });
    $("#dormitory").click(function(){
        window.location.href='/dormitorylist';
    });
    $("#zszt").click(function(){
        window.location.href='/zsztlist';
    });
    $("#modifyzsztbt").click(function () {
        var zsztStr = {};
        if(isEdit){
            zsztStr.zid = getQueryString('zid');
        }
        zsztStr.dormitory = {
            did: $("#dormitoryselect").find('option').not(function () {
                return !this.selected
            }).data("id")
        };
        zsztStr.date = $("#date").val();
        alert(zsztStr.date);
        zsztStr.zt = $("#zt").val();
        var formData = new FormData();
        formData.append('zsztStr', JSON.stringify(zsztStr));
        $.ajax({
            url: (isEdit?modifyZsztUrl:addZsztUrl),
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function(data){
                if(data.status == 200){
                    alert('提交成功');
                }else{
                    alert('提交失败');
                }
                window.location.href="/zsztlist";
            },
        });
    });
})