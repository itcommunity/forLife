<div id="add_album_form_div">
    <div id="popupContact">
        <form id="add_album_form" action="/admin/createalbum" method="post">
            <%--<button id="close" onclick ="div_hide()">--%>
            <h2>Add new album</h2>
            <hr>
                Album name:
                <input id="albumname" type="text" name="albumname" value="New album">
            <input type="button" onclick="check_album_empty()" value="Add">
            <input type="button" onclick="add_album_form_hide()" value="Cancel">
        </form>
    </div>
</div>