// Validating Empty Field
function check_album_empty() {
    if (document.getElementById('albumname').value == "") {
        alert("Fill album name");
    } else {
        document.getElementById('add_album_form').submit();
//        alert("Added!!!");
    }
}

//Function To Display Popup
//function div_show() {
//    document.getElementById('upload_form_div').style.display = "block";
//}
function add_album_form_show() {
    document.getElementById('add_album_form_div').style.display = "block";
}
//Function to Hide Popup
//function div_hide(){
//    document.getElementById('upload_form_div').style.display = "none";
//}
function add_album_form_hide(){
    document.getElementById('add_album_form_div').style.display = "none";
}