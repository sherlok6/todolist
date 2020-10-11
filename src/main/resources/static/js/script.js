// Create a "close" button and append it to each list item
var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

function getXmlHttp() {
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function update(variable) {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('PUT','/todolist');
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("map="+encodeURIComponent(variable));
    }

function deleted(variable) {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('DELETE', '/todolist', true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("task=" + encodeURIComponent(variable));
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var j;
for (j = 0; j < close.length; j++) {
    close[j].onclick = function () {
        var div = this.parentElement;
        deleted(div.innerText.substring(0, div.innerText.length - 2));
        div.remove();
    }
}

// Add a "checked" symbol when clicking on a list item
var list = document.querySelector('ul');
if (list != null) {
    list.addEventListener('click', function (ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
        }
    }, false);
}

//create map status
function collect() {
    var map = new Map();
    var l = "<span class=\"close\">×</span>";
    var LIST = document.getElementsByTagName("li");
    var r;
    for (r = 0; r < LIST.length; r++) {
        var el = LIST.item(r);
        if (el.className === "") {
            map.set(el.innerHTML.substring(0, el.innerHTML.length - l.length), "none");
        }
        if (el.className === "checked") {
            map.set(el.innerHTML.substring(0, el.innerHTML.length - l.length), "check");
        }
    }
    let obj = JSON.stringify(Object.fromEntries(map));
    console.log(obj);
    update(obj);
}

// Create a new list item when clicking on the "Add" button
let inputValue;

function newElement() {
    inputValue = document.getElementById("myInput").value;
    var span = document.createElement("span");
    var li = document.createElement("li");
    var t = document.createTextNode(inputValue);
    li.appendChild(t);
    span.appendChild(li);
    if (inputValue === '') {
        alert("You must write something!");
    } else {
        document.getElementById("myUL").append(span);
    }
    document.getElementById("myInput").value = "";

    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    li.appendChild(span);
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            deleted(div.innerText.substring(0, div.innerText.length - 2));
            div.remove();
        }
    }
}


function save() {
    var xmlhttp = getXmlHttp();
    xmlhttp.open('POST', '/todolist', true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("task=" + encodeURIComponent(inputValue));
}





