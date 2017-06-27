$(document).ready(function() {
    $("ul.formattedList li:odd").addClass("oddItem");
    $("ul.formattedList li:even").addClass("evenItem");
    
    $("#myUL").listnav({
    initLetter: '',        // filter the list to a specific letter on init ('a'-'z', '-' [numbers 0-9], '_' [other])
    includeAll: true,      // Include the ALL button
    incudeOther: false,    // Include a '...' option to filter non-english characters by
    includeNums: false,     // Include a '0-9' option to filter by
    flagDisabled: true,    // Add a class of 'ln-disabled' to nav items with no content to show
    removeDisabled: false, // Remove those 'ln-disabled' nav items (flagDisabled must be set to true for this to function)
    noMatchText: 'No matching entries', // set custom text for nav items with no content to show
    showCounts: true,      // Show the number of list items that match that letter above the mouse
    cookieName: null,      // Set this to a string to remember the last clicked navigation item requires jQuery Cookie Plugin ('myCookieName')
    onClick: null,         // Set a function that fires when you click a nav item. see Demo 5
    prefixes: [],          // Set an array of prefixes that should be counted for the prefix and the first word after the prefix ex: ['the', 'a', 'my']
    filterSelector: ''     // Set the filter to a CSS selector rather than the first text letter for each item
    });
});

function myFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
   
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].parentNode.style.display = "";
        } else {
            li[i].parentNode.style.display = "none";
            
        }
    }
  
}