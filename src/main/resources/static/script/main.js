$(document).ready(function() {
    $('#generate').click(function() {
        $.ajax({
        url: "/generate",
        success: function(result) {
            alert(result)
        }});
    });
});

var algorithm = null;
var speed = null;

function setAlgorithm(id) {
    algorithm = id;
}

function setSpeed(id) {
    algorithm = id;
}

