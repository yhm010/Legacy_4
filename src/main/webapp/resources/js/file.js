const fileAdd = document.getElementById("fileAdd");
const fileResult = document.getElementById("fileResult");
const del = document.getElementsByClassName("del");

let count = 0;
let num=0; // id용도

fileAdd.addEventListener("click", function(){

    // count++;
    // if(count>4){
    //     alert("첨부파일은 최대 5개까지 가능합니다.")
    //     count--;
    //     return ;
    // }

    // count++;
    // if(count>5){
    //     alert("첨부파일은 최대 5개까지 가능합니다.")
    //     count=5;
    //     return ;
    // }
    
    if(count>4){
        alert("첨부파일은 최대 5개까지 가능합니다.")
        return ;
    }

    //count=count+1;
    count++;
    

let div = document.createElement('div');  // <div></div>
div.setAttribute("id", "del"+num);

let file = document.createElement("input"); // <input>
file.setAttribute("type", "file");          // <input type="file">
file.setAttribute("name", "files");         // <input type="file" name= "files">

let button = document.createElement('button') // <button></button>
button.setAttribute("type", "button");
button.className="del";
button.setAttribute("data-num", "del"+num);
button.innerHTML="DEL";

div.append(file);
div.append(button);

fileResult.append(div);

num++;

});


fileResult.addEventListener("click", function(event){
    let cn = event.target;
    

    if(cn.classList.contains('del')){
       let delNum = cn.getAttribute("data-num");
       document.getElementById(delNum).remove();
       count--;
    }

});

//------------------------------------------------
//콘솔에 각각의 fileNum 출력
const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
const files = document.querySelector("#files");

files.addEventListener("click", function(event){
    if(event.target.classList.contains("fileDeleteBtn")){

        let check = confirm("삭제시 복구가 불가능합니다. 정말 삭제 하시겠습니까?")

        if (!check){
            return;
        }

        let fileNum = event.target.getAttribute("data-fileNum");

        //ajax 파라미터 : fileNum 메서드형식 :  POST URL : fileDelete, Controller : fileDelete

        let xhttp = new XMLHttpRequest();
        
        xhttp.open("POST", "./fileDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum="+fileNum);

        //응답 처리
        xhttp.onreadystatechange = function(){
            if(this.readyState == 4 && this.status == 200){
                console.log(this.responseText);
                let result = this.responseText.trim();
                if(result == '1'){
                    console.log("file 삭제");
                    event.target.parentNode.remove();
                }else{
                   
                 }
            }
        }
       
    }

})