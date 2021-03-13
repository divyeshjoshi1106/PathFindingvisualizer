$(document).ready(function() {
    $('#generate').click(function() {
        $.ajax({
        url: "/generate",
        success: function(data) {
            console.log(data);
            graph = JSON.parse(data);
        }});
    });
});

var algorithm = null;
var speed = null;
var graph = null;

function setAlgorithm(id) {
    algorithm = id;
}

function setSpeed(id) {
    algorithm = id;
}

