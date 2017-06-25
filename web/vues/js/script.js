var inputs = [];

function filterBooks() {
    // Declare variables 
    var input, filter, table, tr, td, i, filterCriteria;
    input = document.getElementById("bookSearchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("booksTable");
    tr = table.getElementsByTagName("tr");
    filterCriteria = document.getElementById("bookFilter").value;
    
    
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++){
        td = tr[i].getElementsByTagName("td")[filterCriteria];
        if (td) {
            
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        } 
    }
}

function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("booksTable");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc"; 
    /*Make a loop that will continue until
  no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /*Loop through all table rows (except the
    first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
      one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount ++; 
        } else {
            /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}
function changeModalId(id){
    var item = document.getElementsByClassName("modal fade")[0];
    item.id = "bookDetailsModal"+id;
}

function pagination(){
    var req_num_row=10;
    var $tr=jQuery('tbody tr');
    var total_num_row=$tr.length;
    var num_pages=0;
    if(total_num_row % req_num_row ==0){
        num_pages=total_num_row / req_num_row;
    }
    if(total_num_row % req_num_row >=1){
        num_pages=total_num_row / req_num_row;
        num_pages++;
        num_pages=Math.floor(num_pages++);
    }
    for(var i=1; i<=num_pages; i++){
        jQuery('#pagination').append(" "+i+" ");
    }
    $tr.each(function(i){
        jQuery(this).hide();
        if(i+1 <= req_num_row){
            $tr.eq(i).show();
        }
        
    });
    jQuery('#pagination a').click(function(e){
        e.preventDefault();
        $tr.hide();
        var page=jQuery(this).text();
        var temp=page-1;
        var start=temp*req_num_row;
        //alert(start);
        
        for(var i=0; i< req_num_row; i++){
            
            $tr.eq(start+i).show();
            
        }
    });
}

function deleteBook(bookId){
    if(confirm("Are you sure you want to delete this book ?")){  
        $.ajax({
            url : "http://localhost:8080/Library_Final/vues/deleteBook.action?bookId="+bookId,
            type : "POST",
            success : function(data) {
                if(data == "success"){
                    location.reload();
                }else{
                    alert("Couldn't delete book");
                }
            }
        });
    }
}

function updateBook(){
    var firstNameV = $("#firstName").html();
    var firstNameI = $("<input>", { val: firstNameV,type: "text",size:"30",name:"firstName", id:"bean_firstName" });
    $("#firstName").html(firstNameI);
    inputs.push(firstNameV);
    
    var editorV = $("#editor").html();
    var editorI = $("<input>", { val: editorV,type: "text",size:"30",name:"editor", id:"bean_editor"  });
    $("#editor").html(editorI);
    inputs.push(editorV);
    
    var genreV = $("#genre").html();
    var genreI = $("<input>", { val: genreV,type: "text",size:"30",name:"genre", id:"bean_genre"  });
    $("#genre").html(genreI);
    inputs.push(genreV);
    
    var languageV = $("#language").html();
    var languageI = $("<input>", { val: languageV,type: "text",size:"30" ,name:"language", id:"bean_language" });
    $("#language").html(languageI);
    inputs.push(editorV);
    
    var dateV = $("#date").html();
    var dateI = $("<input>", { val: dateV,type: "text",size:"30",name:"date", id:"bean_date"  });
    $("#date").html(dateI);
    inputs.push(dateV);
    
    var priceV = $("#price").html().substring(0, $("#price").html().length-3);
    var priceI = $("<input>", { val: priceV,type: "text",size:"30",name:"price", id:"bean_price"  });
    $("#price").html(priceI);
    inputs.push(priceV);
    
    var referenceV = $("#reference").html();
    var referenceI = $("<input>", { val: referenceV,type: "text",size:"30",name:"beanBook.reference", id:"bean_reference"  });
    $("#reference").html(referenceI);
    inputs.push(referenceV);
    
    var summaryV = $("#summary").html();
    var summaryI = $("<textarea>", { val: summaryV,type: "text",rows:"9", cols:"55",name:"summary", id:"bean_summary" });
    $("#summary").html(summaryI);
    inputs.push(summaryV);
    
    $("#closeButton").addClass("hide");
    $("#validateBookButtons").removeClass("hide");
    $("#editBookButtons").addClass("hide");
};

function cancelUpdate(){
    document.getElementById("firstName").innerHTML = inputs[0];
    document.getElementById("editor").innerHTML = inputs[1];
    document.getElementById("genre").innerHTML = inputs[2];
    document.getElementById("language").innerHTML = inputs[3];
    document.getElementById("date").innerHTML = inputs[4];
    document.getElementById("price").innerHTML = inputs[5];
    document.getElementById("reference").innerHTML = inputs[6];
    document.getElementById("summary").innerHTML = inputs[7];
     
    $("#closeButton").removeClass("hide");
    $("#validateBookButtons").addClass("hide");
    $("#editBookButtons").removeClass("hide");
}

function clearFilterInput(){
    document.getElementById("bookSearchInput").value = "";
    filterBooks();
}

function loadCreateBook() {
    $.ajax({
        url : "http://localhost:8080/Library_Final/vues/authorEditorInfo",
        type : "GET",
        success : function(data) {
            if(data){
                console.log(data);
            }
        }
    });
}

$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><a href="#" class="remove_field">Remove</a><input id="book'+x+'" type="text" name="borrowBookList['+x+'].bookName" class="typeahead form-control"/></div>'); //add input box
        }
        autocompleteInput("book"+x);
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    });
    

});
