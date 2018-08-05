$(function () {
    $(function () {
        var addBuildingUrl = "/addbuilding";
        var modifyBuildingUrl = "/modifybuilding";
        var getBuildingByBidUrl = "/querybuildingbyid/";
        var deleteBuildingUrl = "/deletebuilding/";
        var bid = getQueryString('bid');
        var isEdit = bid ? true : false;
        if (isEdit) {
            getBuildingInfo(bid);
        }
        function getBuildingInfo(bid) {
            $.getJSON(getBuildingByBidUrl + bid, function (data) {
                if (data.status == 200) {
                    $("#place").val(data.data.place);
                    $("#bname").val(data.data.bname);
                }
            });
        }
        $("#building").click(function () {
            window.location.href="/buildinglist";
        });
        $("#student").click(function(){
            window.location.href="/studentlist";
        });
        $("#dormitory").click(function(){
            window.location.href="/dormitorylist";
        });
        $("#zszt").click(function(){
            window.location.href="/zsztlist";
        });
        $("#modifybuildingbt").click(function () {
            var building = {};
            if (isEdit) {
                building.bid = bid;
            }
            building.place = $("#place").val();
            building.bname = $("#bname").val();
            var formData = new FormData();
            formData.append('buildingStr', JSON.stringify(building));
            $.ajax({
                url: (isEdit ? modifyBuildingUrl:addBuildingUrl),
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data.status = "200") {
                        alert('提交成功');
                    } else {
                        alert('提交失败' + data.msg);
                    }

                }
            });
        });
        $("#deletebuildingbt").click(function () {
            $.getJSON(deleteBuildingUrl + bid, function (data) {
                if (data.status == 200) {
                    alert("删除成功");
                } else {
                    alert('删除失败' + data.msg);
                }
            });
            window.location.href="/buildinglist";

        });
    })
})
