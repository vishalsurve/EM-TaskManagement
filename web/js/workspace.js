/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function doAjaxPost() {
    // get the form values  
    var workspacename = $('#workspacename').val();

    $.ajax({
        type: "POST",
        url: contexPath + "/addworkspace",
        data: "workspacename=" + workspacename,
        success: function(response) {
            // we have the response 
            if (response.status == "SUCCESS") {
                workspacename = "<ol>";
                for (i = 0; i < response.result.length; i++) {
                    workspacename += "<br><li><b>Name</b> : " + response.result[i];
                }
                workspacename += "</ol>";
                $('#info').html("User has been added to the list successfully. " + workspacename);
                $('#workspacname').val('');
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




function showList() {

    $.ajax({
        type: "POST",
        url: contexPath + "/workspacelist",
        success: function(response) {
            // we have the response 


            if (response.status == "SUCCESS") {
                workspacename = "<ol>";
                var mainDiv = document.createElement('div');
                for (i = 0; i < response.result.length; i++) {
//                    var url = "http://www.google.co.in/";

                    var url = "workspacename/" + response.result[i];
                    var li = document.createElement('li');
                    mainDiv.appendChild(li);
                    var namDiv = document.createElement('div');
                    namDiv.innerHTML = '';
                    li.appendChild(namDiv);
                    var a = document.createElement('a');
                    a.innerHTML = response.result[i];
                    a.href = url;
                    li.appendChild(a);
//                    workspacename += "<br><li><b>Name</b> : " + response.result[i] + "</li>" + "<a href=" + url + ">GO Link</a>";
                }
                workspacename += "</ol>";
                $('#info').html("List of WorkSpace: ");
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