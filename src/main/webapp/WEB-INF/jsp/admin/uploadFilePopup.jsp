<div id="upload_form_div">
    <div id="popupContact">
        <form action="#" id="upload_form" method="post" name="form" enctype="multipart/form-data">
            <%--<button id="close" onclick ="div_hide()">--%>
            <h2>Add photo</h2>
            <hr>
            <input id="name" name="name" placeholder="Name" type="text"><br/>
            <input id="file" type="file" name="file"><br/>
            <input type="button" onclick="check_empty()" value="Add">
            <input type="button" onclick="upload_form_hide()" value="Cancel">
        </form>
    </div>
</div>