function show_photo(src) {
    document.getElementById("photo_element_show").src=src;
    document.getElementById('show_photo_div').style.display = "block";
}
function hide_photo(){
    document.getElementById('show_photo_div').style.display = "none";
}