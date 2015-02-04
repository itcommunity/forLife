<form method="POST" action="/admin/upload/<%out.print(request.getAttribute("albumId"));%>" enctype="multipart/form-data">
    Name: <input type="text" name="name" value="text"><br />
    <input type="file" name="file" value="Add"><br />
    <input type="submit" value="Upload">
</form>