const fileAdd = document.getElementById("fileAdd");
const fileResult = document.getElementById("fileResult");

let count = 0;

fileAdd.addEventListener("click", function(){

//count=count+1;
count++;

if(count>5){
    alert("첨부파일은 최대 5개까지 가능합니다.")
    return ;
}

let div = document.createElement('div');  // <div></div>

let file = document.createElement("input"); // <input>
file.setAttribute("type", "file");          // <input type="file">
file.setAttribute("name", "files");         // <input type="file" name= "files">

let button = document.createElement('button') // <button></button>
button.setAttribute("type", "button");
button.innerHTML="DEL";

div.append(file);
div.append(button);

fileResult.append(div);

});
