duplicateString = function(item) {
    var data = item;
    var i = 0;
    for (; i < data.length - 1;) {
        if (data[i] == data[i + 1]) {
            var left = data.substring(0, i);
            var right = data.substring(i + 2);
            var data = left.concat("", right);
            console.log(data);
            i = 0;
            continue;
        }
        i++;
    }
}