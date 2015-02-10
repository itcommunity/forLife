function updateData() {
//            var data = $("#text_data").val();
//            $.getJSON('/json/', {test: "test123"}, function (data) {
//            $.post('/json/', {value: $("#text_data").val()}, function(data) {
//            $.post('/json/', {value:"test22222"}, function(data) {
////            var jqxhr = $.getJSON('/json/', function (data) {
////                var items = [];
////
//
//                $.each(data, function (key, val) {
//                    items.push('<li id="' + key + '">' + val + '</li>');
//                    if (key == "value") {
//                        $("#message").text(val);
//                    }
//                });
//
//            });
//////                for (var i=0;i<items.length;i++){
//////                }
////
////                $('#message').html(items.join(''));
////            });
//            $.post('/json/', {data: $.("#text").text()}, function(data) {

//            });

//            var posting = $.post( '/json/', {value: $("#text_data").val()} ); // Put the results in a div
//            var jsonObj = '{"login":"' + $("#login_field").val() + '", "password":"' + $("passwd_field").val() + '"}'
    var jsonObj = {login:$("#login_field").val(), password:$("passwd_field").val()}
    var posting = $.ajax({
        url: '/json/',
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(jsonObj)
//                data: JSON.stringify({value:"test"}),
//                success: function(data){
//                    $("#message").text(data.)
//                }
    }).done(function (data) {
        $("#login").hide();
        $("#message").text(data.message);
        $("#album").show();

//        $("#message").text($.each(data.);
//        alert(jQuery.type(data));
    });
//            posting.done(function( data ) {
//                var content = data.responseText;
//                $("#message").text(content);
//            });

}

function get_left_panel_elements(){
    $.getJSON( "/elements/left_panel", function( data ) {
        for(var i=0; i<data.length; i++){
//            alert(data[i].elementId);
//                $("<li/>", {
//                "role": "presentation"
//            }).add($("<a/>",{'href':"#", "text": "test"})).appendTo("#left_panel_navs");
//            var a = $('<a/>',{
//                "href": "#",
//                "text": "test"
//            });
             var li = $('<li/>', {"role": "presentation", "text": "test"});
            $("#left_panel_navs").append(li);
        }
//        var items = [];
//        $.each( data, function(element) {
//            $.each(element, function(e_id, e_class, e_type){
//                $("<div/>").text(element.elementId).appendTo("#left_panel");
//            })
//            items.push( "<li id='" + key + "'>" + val + "</li>" );
//            $(element.elementType, {
//                "class": element.elementClass,
//                "id": element.elementId
//            }).appendTo("#left_panel");
//            var obj = JSON.parse(element);
//            alert(data[1].elementId);
//            $("#left_panel").text(obj.elementId);
//                            $("<div/>").text(obj.elementId).appendTo("#left_panel");
//        });
//        $( "<ul/>", {
//            "class": "my-new-list",
//            html: items.join( "" )
//        }).appendTo( "#left_panel" );
    });
}