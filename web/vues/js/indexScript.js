$(document).ready(function() {
    //Inititliazing books in and out store
    booksInOutStore("booksInStore","booksOutStore");
    
    //Initializing autocomplete
    autocompleteInput("book1");
    
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            
            $(wrapper).append('<div><a href="#" class="remove_field">Remove</a><input id="book'+x+'" type="text" name="borrowBookList['+x+'].bookName" class="typeahead form-control"/></div>'); //add input box
        x++; //text box increment
        }
        autocompleteInput("book"+x);
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); 
        $(this).parent('div').remove(); 
        x--;
    });
    
    $('#datepicker').datepicker({
        format: "dd/mm/yyyy",
        autoclose: true
    });
    
    getNotificationsList();
});


function getNotificationsList(){
    $.ajax({
        url : "http://localhost:8080/Library_Final/vues/notifications.action",
        type : "GET",
        success : function(data) {
            if(data){
                data = JSON.parse(data);
                var notifs = "";
                
                if(data.length === 0){
                    notifs = notifs + "<li><a><span class=\"glyphicon glyphicon-info-sign text-success\" ></span> No notifications to display </a></li>"
                }else{
                    data.forEach(function(item,index){
                        notifs = notifs + "<li><a><span class=\"glyphicon glyphicon-info-sign text-danger\" ></span>"+item+"</a></li>"
                    });
                }
                    
                document.getElementById("notificationsNumber").innerHTML = data.length;
                document.getElementById("notificationsBord").innerHTML = notifs;
            }
        }
    });
}
