$(document).ready(function(){

    if (document.getElementById("updateContact")){
        $(updateContact).click(function(){
           var item = $(this).closest("tr")   // Finds the closest row <tr>
            .attr('id')       // Retrieves the text within <td>
            window.location = "/contacts/update/" + item;
        });
    }

    if (document.getElementById("updateCoworker")){
        $(updateCoworker).click(function(){
           var item = $(this).closest("tr")   // Finds the closest row <tr>
            .attr('id')       // Retrieves the text within <td>
            window.location = "/coworkers/update/" + item;
        });
    }

     if (document.getElementById("updateFriend")){
        $(updateFriend).click(function(){
           var item = $(this).closest("tr")   // Finds the closest row <tr>
            .attr('id')       // Retrieves the text within <td>
            window.location = "/friends/update/" + item;
        });
    }
});