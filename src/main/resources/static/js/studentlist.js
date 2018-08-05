$(function () {
    var getStudentListUrl = "/querystudents";
    var getStudentListByDidUrl = "/querystudentbydid/";
    var did = getQueryString("did");
    isDid = did ? true:false;
    if (!isDid) {
        getStudentList();
    } else {
        getStudentListByDid(did);
    }

    function getStudentList() {
        $.getJSON(getStudentListUrl, function (data) {
            if (data.status == 200) {
                handleStudentList(data.data);
            }
        });
    }
    function getStudentListByDid() {
        $.getJSON(getStudentListByDidUrl+did, function (data) {
            if (data.status == 200) {
                handleStudentList(data.data);
            }
        });
    }

    function handleStudentList(data) {
        var html = '';
        data.map(function (item, index) {
            html += '<tr><td>'
                + item.sid + '</td><td>'
                + item.name + '</td><td>'
                + item.sex + '</td><td>'
                + item.phone + '</td><td>'
                + item.department + '</td><td>'
                + item.dormitory.did + '</td><td>'
                + item.dormitory.building.place +
                item.dormitory.building.bname +
                item.dormitory.num + '</td><td>'
                + goStudent(item.sid) + '</td></tr>';
        });
        $('#show-student').html(html);
    }

    function goStudent(id) {
        return '<a href="/studentmodify?sid=' + id +'">进入</a>';
    }
    $("#studentmngbt").click(function () {
        window.location.href="/studentmodify";
    })

    $("#building").click(function(){
        window.location.href='/buildinglist';
    })
    $("#dormitory").click(function(){
        window.location.href='/dormitorylist';
    })
    $("#zszt").click(function(){
        window.location.href='/zsztlist';
    })
})