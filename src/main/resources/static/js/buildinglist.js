$(function () {
    var getBuildingListUrl = "/querybuildings";
    getBuildingList();
    function getBuildingList() {
        $.getJSON(getBuildingListUrl, function (data) {
            if (data.status == 200) {
                handleBuildingList(data.data);
            }
        })
    }
    function handleBuildingList(data) {
        var html = '';
        data.map(function (item, index) {
            html += '<tr><td>'
                + item.bid + '</td><td>'
                + item.place + '</td><td>'
                + item.bname + '</td><td>'
                + goBuilding(item.bid) + '</td></tr>';
        });
        $('#show-building').html(html);
    }

    function goBuilding(id) {
        return '<a href="/buildingmodify?bid=' + id +'">进入</a>';
    }
    $("#buildingmngbt").click(function () {
        window.location.href="/buildingmodify";
    })

    $("#student").click(function(){
        window.location.href="/studentlist";
    })
    $("#dormitory").click(function(){
        window.location.href="/dormitorylist";
    })
    $("#zszt").click(function(){
        window.location.href="/zsztlist";
    })
})