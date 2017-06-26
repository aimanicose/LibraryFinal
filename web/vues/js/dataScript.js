var autocompleteInput = function (field) {
   $.ajax({
        url : "http://localhost:8080/Library_Final/vues/getData.action",
        type : "GET",
        success : function(data) {
            if(data){
                data = JSON.parse(data);
                var books = [];
                data.forEach(function(item){
                    books.push(item.bookName);
                });
               
                $( "#"+field ).autocomplete({
                  source: books
                });
            }
        }
    }); 
};

var booksInOutStore = function (inBook,outBook) {
    $.ajax({
        url : "http://localhost:8080/Library_Final/vues/booksNumber.action",
        type : "GET",
        success : function(data) {
            if(data){
                data = JSON.parse(data);
               
                $("#"+inBook).text(data[0]);
                $("#"+outBook).text(data[1]);
            }
        }
    }); 
};