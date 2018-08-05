$(function () {
    var getZsztListUrl = "/queryzszts";
    getZsztList();

    function getZsztList() {
        $.getJSON(getZsztListUrl, function (data) {
            if (data.status == 200) {
                handleZsztList(data.data);
            }
        });
    }

    function handleZsztList(data) {
        var html = '';
        data.map(function (item, index) {
            html += '<tr><td>'
                + item.zid + '</td><td>'
                + item.dormitory.building.place+
                item.dormitory.building.bname +
                item.dormitory.num + '</td><td>'
                + item.date + '</td><td>'
                + item.zt + '</td><td>'
                + goZszt(item.zid) + '</td></tr>';
        });
        $('#show-zszt').html(html);
    }

    function goZszt(id) {
        return '<a href="/zsztmodify?zid=' + id +'">进入</a>';
    }
    $("#zsztmngbt").click(function () {
        window.location.href="/zsztmodify";
    })

    $("#building").click(function(){
        window.location.href='/buildinglist';
    })
    $("#dormitory").click(function(){
        window.location.href='/dormitorylist';
    })
    $("#student").click(function(){
        window.location.href='/studentlist';
    })
})