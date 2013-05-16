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