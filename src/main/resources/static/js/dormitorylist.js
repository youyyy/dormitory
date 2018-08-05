$(function () {
    var getDormitoryListUrl = "/querydormitories";
    var ct;
/*    var bid = getQueryString("bid");
    isbid = bid ? true:false;
    if (!isDid) {
        getDormitoryList();
    } else {
        getStudentListByDid(did);
    }*/
    getDormitoryList();
    function getDormitoryList() {
        $.getJSON(getDormitoryListUrl, function (data) {
            if (data.status == 200) {
                handleDormitoryList(data.data);
            }
        });
    }
    function handleDormitoryList(data) {
        var html = '';
        data.map(function (item, index) {
            getDormitoryNowStudentCount(item.did);
            html += '<tr><td>'
                + goStudentList(item.did)+ '</td><td>'
                + item.building.place +
                item.building.bname + '</td><td>'
                + item.num + '</td><td>'
                + item.maxMan + '</td><td>'
                +"入住"+ct+"人"+'</td><td>'
                + goDormitory(item.did) + '</td></tr>';
        });
        $('#show-dormitory').html(html);
    }
    function goStudentList(id) {
        return '<a href="/studentlist?did=' + id +'">'+id+'</a>';
    }
    function getDormitoryNowStudentCount(did){
        $.ajaxSettings.async=false;
        $.getJSON("/querystudentcountbydid/"+did, function (data) {
            ct = data.number;
        });
    }
    function goDormitory(id) {
        return '<a href="/dormitorymodify?did=' + id +'">进入</a>';
    }
    $("#dormitorymngbt").click(function () {
        window.location.href="/dormitorymodify";
    })

    $("#building").click(function(){
        window.location.href='/buildinglist';
    })
    $("#student").click(function(){
        window.location.href='/studentlist';
    })
    $("#zszt").click(function(){
        window.location.href='/zsztlist';
    })
})