<%@ page import="local.photoalbums.domain.Album" %>
<%@ page import="local.photoalbums.domain.Photo" %>

<%Iterable<Album> albums = (Iterable) request.getAttribute("albums");%>
<%if (albums != null) {%>
<table>
    <%for (Album album : albums) {%>
    <tr>
        <td>
            <%if (album != null) {%>
            <div id="admin_album">
                <table>
                    <tr>
                        <td>
                            <h3><%out.print(album.getName());%></h3>
                        </td>
                        <td>
                            <button id="button"
                                    class="btn btn-success"
                                    onclick="upload_form_show('/admin/upload/<%out.print(album.getId());%>')">Upload
                            </button>
                        </td>
                        <td>
                            <table>
                                <tr>
                                    <%for (Photo photo : album.getPhotos()) {%>
                                    <td>
                                        <img height="100px"
                                             onclick="show_photo('/static/photo/<%out.print(photo.getId());%>')"
                                             src="/static/photo/<%out.print(photo.getId());%>"/>
                                    </td>
                                    <%}%>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
            <%}%>

        </td>
    </tr>
    <%}%>
</table>
<%}%>

