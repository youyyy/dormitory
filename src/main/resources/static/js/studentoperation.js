$(function () {
    var modifyStudentUrl = "/updatestudent";
    var addStudentUrl="/addstudent";
    var getDormitoryListUrl = "/querydormitories";
    var getStudentBySidUrl = "/querystudentbysid/";
    var deleteStudentUrl = "/deletestudent/";
    var sid = getQueryString('sid');
    var isEdit = sid ? true : false;
    if (!isEdit) {
        getDormitoryList();
    } else {
        getDormitoryList();
        getStudentInfo(sid);
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
    function getStudentInfo(sid) {
        $.getJSON(getStudentBySidUrl + sid, function (data) {
            if (data.status == 200) {
                $("#name").val(data.data.name);
                $("#sex").val(data.data.sex);
                $("#phone").val(data.data.phone);
                $("#department").val(data.data.department);
                $("#dormitoryselect option[data-id='" +data.data.dormitory.did+"']").attr("selected","selected");
            }
        });
    };
    $("#deletestudentbt").click(function () {
        $.getJSON(deleteStudentUrl+sid,function (data) {
            if(data.status == 200){
                alert("删除成功");
            }else {
                alert('删除失败');
            }
            window.location.href="studentlist";
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

    $("#modifystudentbt").click(function () {
        var studentStr = {};
        if(isEdit){
            studentStr.sid = getQueryString('sid');
        }
        studentStr.name = $("#name").val();
        studentStr.sex = $("#sex").find('option').not(function () {
            return !this.selected;
        }).val();
        studentStr.phone = $("#phone").val();
        studentStr.department = $("#department").val();
        studentStr.dormitory = {
            did: $("#dormitoryselect").find('option').not(function () {
                return !this.selected
            }).data("id")
        };
        var formData = new FormData();
        formData.append('studentStr', JSON.stringify(studentStr));
        var url = isEdit?modifyStudentUrl:addStudentUrl;
        $.ajax({
            url: (isEdit?modifyStudentUrl:addStudentUrl),
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
                window.location.href="/studentlist";
            },
        });
    });
})