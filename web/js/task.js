/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function addTask() {

    var taskname = $('#taskname').val();
    var startdate = $('#startdate').val();
    var enddate = $('#enddate').val();
    var priority = $('#priority').val();


    $.ajax({
        type: "POST",
        url: contexPath + "/addTask",
        data: "taskname=" + taskname + "&startdate=" + startdate + "&enddate=" + enddate + "&priority=" + priority,
        // data: "taskname=" + taskname ,


        success: function(response) {

            if (response.status == "SUCCESS") {
                taskname = "<ol>";
                for (i = 0; i < response.result.length; i++) {
                    taskname += "<br><li><b>Task Name</b> : " + response.result[i];
                    startdate += "<br><li><b>Start Date</b> : " + response.result[i];
                    enddate += "<br><li><b>End Date</b> : " + response.result[i];
                    priority += "<br><li><b>Priority</b> : " + response.result[i];
                }
                taskname += "</ol>";
                $('#info').html("Task has been added to the list successfully. " + taskname);
                $('#taskname').val('');
                $('#startdate').val('');
                $('#enddate').val('');
                $('#priority').val('');
                $('#error').hide('slow');
                $('#info').show('slow');
            } else {
                errorInfo = "";
                for (i = 0; i < response.result.length; i++) {
                    errorInfo += "<br>" + (i + 1) + ". " + response.result[i].code;
                }
                $('#error').html("Please correct following errors: " + errorInfo);
                $('#info').hide('slow');
                $('#error').show('slow');
            }
        },
        error: function(e) {
            alert('--Error-- : ' + e);
        }
    });
}


function taskList() {

    $.ajax({
        type: "POST",
        url: contexPath + "/tasklist",
        success: function(response) {

            if (response.status == "SUCCESS") {
                taskname = "<ol>";
                var mainDiv = document.createElement('div');
                for (i = 0; i < response.result.length; i++) {
                    var url = "http://www.google.co.in/";
                    var li = document.createElement('li');
                    mainDiv.appendChild(li);
                    var namDiv = document.createElement('div');
                    namDiv.innerHTML = '';
                    li.appendChild(namDiv);
                    var a = document.createElement('a');
                    a.innerHTML = response.result[i];
                    a.href = url;
                    li.appendChild(a);
                    taskname += "<br><li><b>Name</b> : " + response.result[i] + "</li>" + "<a href=" + url + ">GO Link</a>";

                }
                taskname += "</ol>";

                $('#info').html("List of Task: ");
                $('#info').append(mainDiv);
                $('#error').hide('slow');
                $('#info').show('slow');
            } else {
                errorInfo = "";
                for (i = 0; i < response.result.length; i++) {
                    errorInfo += "<br>" + (i + 1) + ". " + response.result[i].code;
                }
                $('#error').html("Please correct following errors: " + errorInfo);
                $('#info').hide('slow');
                $('#error').show('slow');
            }
        },
        error: function(e) {
            alert('Error: ' + e);
        }
    });
}
