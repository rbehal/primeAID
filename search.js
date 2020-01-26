var ul = document.getElementById("myUL");
var li = ul.getElementsByTagName("li");
var diagnosis = [];

function searchFunction() {
    var input, filter, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    filterLength = filter.length;
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().slice(0,filterLength) == filter) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function hideSympt() {
    for (i = 0; i < li.length; i++) {
        li[i].style.display = "none";
    }
}

function checkSympt() {
    let symptList = [188, 10, 223, 984, 974, 981, 996, 147, 238, 971, 998, 104, 180, 57, 24, 284, 176, 48, 190, 233, 991, 240, 77, 239, 156, 250, 979, 192, 75, 46, 288, 107, 91, 170, 17, 31, 175, 218, 89, 978, 139, 15, 228, 94, 49, 134, 260, 108, 163, 165, 50, 79, 126, 98, 93, 53, 216, 128, 989, 207, 71, 270, 162, 244, 43, 273, 272, 151, 87, 92, 242, 287, 33, 208, 209, 219, 246, 970, 153, 83, 982, 76, 86, 164, 145, 11, 995, 214, 245, 154, 255, 1002, 125, 62, 84, 59, 110, 152, 976, 72, 186, 148, 80, 184, 9, 206, 985, 45, 122, 993, 196, 121, 149, 197, 120, 90, 70, 113, 81, 131, 262, 204, 40, 220, 39, 257, 986, 65, 73, 88, 973, 96, 21, 999, 247, 268, 194, 198, 27, 230, 193, 47, 994, 256, 146, 231, 143, 82, 992, 167, 178, 1000, 195, 35, 205, 210, 174, 263, 261, 266, 232, 235, 112, 123, 215, 85, 983, 135, 97, 177, 119, 987, 252, 202, 168, 253, 44, 136, 234, 114, 133, 1004, 63, 38, 221, 254, 200, 137, 157, 155, 142, 12, 990, 203, 251, 103, 286, 189, 109, 150, 37, 140, 118, 129, 130, 258, 172, 173, 191, 54, 78, 14, 975, 269, 1001, 60, 69, 102, 264, 29, 183, 26, 25, 124, 61, 217, 34, 241, 52, 95, 13, 64, 179, 185, 28, 138, 236, 267, 248, 249, 169, 211, 222, 243, 201, 16, 997, 1003, 980, 977, 115, 132, 988, 144, 265, 116, 160, 161, 68, 213, 166, 66, 101, 181, 972, 23, 22, 30, 187, 105, 106];
    let symptHave = [];
    for (i = 0; i < symptList.length; i++) {
        let check_id = symptList[i].toString();
        if (document.getElementById(check_id).checked == true) {
            symptHave.push(symptList[i]);
        }
    } 

    getSympt(symptHave);
    getDiag();
    console.log(diagnosis);
    triageResult();
}

function getDiag() {
    $.ajax({
        url: "http://127.0.0.1:5000/",
        async: false,
        type: "GET",
        data: {time: $(this).data('timestamp')},
        success: function(response) {
            var symptoms = JSON.parse(response);
            diagnosis = symptoms; 
        },
    });
}

function getSympt(symptoms) {
    var symptArr = symptoms;
    var dummyObj = {"obj":symptArr}
    var symptJSON = JSON.stringify(dummyObj);
    $.ajax({
        async: false,
        url: "http://127.0.0.1:5000/",
        type: "POST",
        data: symptJSON,
        datatype: "json",
        contentType: "application/json"
    });
}

function triageResult() {
    var innerHTMLString = "<table> <tr> <th> <style> text-align: center </style>Prioritised Diagnostics</th> </tr>"

    for (var i = 0; i<diagnosis.length; i++) {
        if (i == diagnosis.length - 1) {
            innerHTMLString += "<tr> <td> " + diagnosis[i] + " </td> </tr> </table>"; 
        }
        else {
            innerHTMLString += "<tr> <td> " + i + ") " + diagnosis[i] + " </td> </tr>"; 
        }
    }
    var element = document.getElementById('modalBack');
    element.innerHTML = "";
    var element2 = document.getElementById('myModal');
    element2.innerHTML = innerHTMLString;
}