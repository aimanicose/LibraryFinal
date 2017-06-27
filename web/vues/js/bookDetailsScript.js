var inputs = [];

function changeModalId(id){
    var item = document.getElementsByClassName("modal fade")[0];
    item.id = "bookDetailsModal"+id;
}

function deleteBook(bookId){
    if(confirm("Are you sure you want to delete this book ?")){  
        $.ajax({
            url : "http://localhost:8080/Library_Final/vues/deleteBook.action?bookId="+bookId,
            type : "POST",
            success : function(data) {
                if(data === "success"){
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