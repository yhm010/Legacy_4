const but = document.getElementById("but");
const title = document.getElementById("title");
const writer = document.getElementById("writer")

let titleCheck = false;
let writerCheck = false;

but.addEventListener("click", function(){
    console.log("but");
});

title.addEventListener("click", function(){
    console.log("title");
});

writer.addEventListener("click", function(){
    console.log("writer");
})

