$(function () {
    var modifyDormitoryUrl = "/modifydormitory";
    var addDormitoryUrl="/adddormitory";
    var getBuildingListUrl = "/querybuildings";
    var getDormitoryByDidUrl = "/querydormitorybyid/";
    var deleteDormitoryUrl = "/deletedormitory/";
    var did = getQueryString('did');
    var isEdit = did ? true : false;
    if (!isEdit) {
        getBuildingList();
    } else {
        getBuildingList();
        getDormitoryInfo(did);
    }
    function getBuildingList() {
        $.getJSON(getBuildingListUrl, function (data) {
            if (data.status == 200) {
                var tempHtml = '';
                data.data.map(function (item, index) {
                    tempHtml += '<option data-id="' + item.bid + '">'
                        + item.place + item.bname + '</option>';
                });
                $('#buildingselect').html(tempHtml);
            }
        });
    };
    function getDormitoryInfo(sid) {
        $.getJSON(getDormitoryByDidUrl + sid, function (data) {
            if (data.status == 200) {
                $("#buildingselect option[data-id='" +data.data.building.bid+"']").attr("selected","selected");
                $("#num").val(data.data.num);
                $("#max_man").val(data.data.maxMan);
            }
        });
    };
    $("#deletedormitorybt").click(function () {
        $.getJSON(deleteDormitoryUrl+did,function (data) {
            if(data.status == 200){
                alert("删除成功");
            }else {
                alert('删除失败');
            }
            window.location.href="dormitorylist";
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

    $("#modifydormitorybt").click(function () {
        var dormitoryStr = {};
        if(isEdit){
            dormitoryStr.did = getQueryString('did');
        }
        dormitoryStr.building = {
            bid: $("#buildingselect").find('option').not(function () {
                return !this.selected
            }).data("id")
        };
        dormitoryStr.num = $("#num").val();
        dormitoryStr.maxMan = $("#max_man").val();

        var formData = new FormData();
        formData.append('dormitoryStr', JSON.stringify(dormitoryStr));
        $.ajax({
            url: (isEdit?modifyDormitoryUrl:addDormitoryUrl),
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
                window.location.href="/dormitorylist";
            },
        });
    });
})