// Validating Empty Field
function check_empty() {
    if (document.getElementById('file').value == "") {
        alert("Add file!");
    } else {
        document.getElementById('upload_form').submit();
//        alert("Added!!!");
    }
}

function upload_submit(){
    document.getElementById('upload_form').submit();
}
//Function To Display Popup
//function div_show() {
//    document.getElementById('upload_form_div').style.display = "block";
//}
function upload_form_show(upload_url) {
    document.getElementById('upload_form').action=upload_url;
    document.getElementById('upload_form_div').style.display = "block";
}
//Function to Hide Popup
//function div_hide(){
//    document.getElementById('upload_form_div').style.display = "none";
//}
function upload_form_hide(){
    document.getElementById('upload_form_div').style.display = "none";
}