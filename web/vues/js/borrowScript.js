jQuery.extend( jQuery.fn.dataTableExt.oSort, {
"date-uk-pre": function ( a ) {
    var ukDatea = a.split('/');
    return (ukDatea[2] + ukDatea[1] + ukDatea[0]) * 1;
},

"date-uk-asc": function ( a, b ) {
    return ((a < b) ? -1 : ((a > b) ? 1 : 0));
},

"date-uk-desc": function ( a, b ) {
    return ((a < b) ? 1 : ((a > b) ? -1 : 0));
}
} );

jQuery(function($) {
    //initiate dataTables plugin
    var myTable = $('#dynamic-table').DataTable({
        "aoColumns": [
            null,
            null,
            null,
            { "sType": "date-uk" },
            { "sType": "date-uk" },
            null, 
            null,
            null
        ]
    });

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

var dataArray = [];

function edit_row(no)
{
    document.getElementById("editRow"+no).style.display="none";
    document.getElementById("saveRow"+no).style.display="";
    document.getElementById("cancelRow"+no).style.display="";

    var dateSortie=document.getElementById("sortie"+no);
    var statut=document.getElementById("statut"+no);

    var dateSortie_data=dateSortie.innerHTML;
    var statut_data=statut.childNodes[0].innerHTML;

    dataArray[no]={dateSortie: dateSortie_data,statut: statut_data};
    
    dateSortie.innerHTML="<input type='text' id='dateOut"+no+"' value='"+dateSortie_data+"'>";
    
    if(statut_data === "IN"){
        statut.innerHTML="<select id='status"+no+"'><option value=\"IN\" selected>IN</option><option value=\"OUT\">OUT</option></select>";
    }else{
        statut.innerHTML="<select id='status"+no+"'><option value=\"IN\">IN</option><option value=\"OUT\" selected>OUT</option></select>";
 
    }
    
}

function cancel_row(no){
    document.getElementById("editRow"+no).style.display="";
    document.getElementById("saveRow"+no).style.display="none";
    document.getElementById("cancelRow"+no).style.display="none";
    
    document.getElementById("sortie"+no).innerHTML = dataArray[no].dateSortie;
    if(dataArray[no].statut === "IN"){
       document.getElementById("statut"+no).innerHTML = "<span class=\"label label-sm label-success\">"+dataArray[no].statut+"</span>"; 
    }else{
        document.getElementById("statut"+no).innerHTML = "<span class=\"label label-sm label-warning\">"+dataArray[no].statut+"</span>";  
    }
    
}

function save_row(no,ref)
{
    var dateOut_val=document.getElementById("dateOut"+no).value;
    var staus_val=document.getElementById("status"+no).value;

    if(confirm("Are you sure you want to edit this borrow ?")){  
        $.ajax({
            url : "http://localhost:8080/Library_Final/vues/updateBorrow.action?borrowReference="+ref+"&returnDate="+dateOut_val+"&newStatus="+staus_val,
            type : "POST",
            success : function(data) {
                if(data === "success"){
                    //location.reload();
                    document.getElementById("sortie"+no).innerHTML=dateOut_val;
                    if(staus_val === "IN"){
                        document.getElementById("statut"+no).innerHTML = "<span class=\"label label-sm label-success\">"+staus_val+"</span>"; 
                     }else{
                         document.getElementById("statut"+no).innerHTML = "<span class=\"label label-sm label-warning\">"+staus_val+"</span>";  
                     }

                     document.getElementById("editRow"+no).style.display="";
                     document.getElementById("saveRow"+no).style.display="none";
                     document.getElementById("cancelRow"+no).style.display="none";
                }else{
                    alert("Couldn't delete book");
                    cancel_row(no);
                }
            }
        });
    }

}