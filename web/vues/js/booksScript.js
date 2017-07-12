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

function clearFilterInput(){
    document.getElementById("bookSearchInput").value = "";
    filterBooks();
}

function addGenre() {
    var genreID = document.getElementById("genreId").value;
    var genreName = document.getElementById("genreName").value;
    $.ajax({
        url : "http://localhost:8080/Library_Final/vues/addGenre.action?beanGenre.genreID="+genreID+"&beanGenre.genreName="+genreName,
        type : "POST",
        success : function(data) {
            if(data){
                $('#genreModal').modal('hide');
            }
        }
    });
}

function addEditor() {
    var editorID = document.getElementById("editorId").value;
    var editorName = document.getElementById("editorName").value;
    var editorAddress = document.getElementById("editorAddress").value;
     
    $.ajax({
        url : "http://localhost:8080/Library_Final/vues/addEditor.action?beanEditor.editorID="+editorID+"&beanEditor.editorName="+editorName+"&beanEditor.editorAddress="+editorAddress,
        type : "POST",
        success : function(data) {
            if(data){
                $('#editorModal').modal('hide');
            }
        }
    });
}

jQuery(function($) {
    //initiate dataTables plugin
    var myTable = $('#books-table').DataTable({});
     $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

    new $.fn.dataTable.Buttons( myTable, {
        buttons: [            
            {
                "extend": "csv",
                "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                "className": "btn btn-white btn-primary btn-bold"
            },
            {
                "extend": "excel",
                "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                "className": "btn btn-white btn-primary btn-bold"
            },
            {
                "extend": "pdf",
                "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                "className": "btn btn-white btn-primary btn-bold"
            },
            {
                "extend": "print",
                "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                "className": "btn btn-white btn-primary btn-bold",
                autoPrint: true
            }		  
        ]
    });
    myTable.buttons().container().appendTo( $('.tableTools-container') );
});