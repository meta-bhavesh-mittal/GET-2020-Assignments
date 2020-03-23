repeatify = function(string, number) {
    var str = "";
    while (number != 0) {
        str += string;
        number--;
    }
    console.log(str);
}