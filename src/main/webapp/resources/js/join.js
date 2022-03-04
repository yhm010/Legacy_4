// 전역변수
// var 
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pwResult = document.getElementById("pwResult");
const pwResult2 = document.getElementById("pwResult2")

const id= document.getElementById("id");
const idResult = document.getElementById("idResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

let idCheck = false;
let pwCheck = false;

btn.addEventListener("click", function(){
    frm.submit();
})

id.onblur=function(){
  // console.log("id blur")
  idCheck = false;
  let v = id.value;

    if(v==''){ //v.length == 0
     // console.log('비어있다')
     idResult.innerHTML = '필수입력'
     idCheck=true;
    }//else{
    // console.log('비어있지 않다')
    // }
    
 }

pw.addEventListener("keyup", function(){
    let length = pw.value.length;
    let message = '잘못된 비번';
    if(length>=8 && length<=12){
        message = '정상 비번';
    }
    pwResult.innerHTML=message;
});

pw2.addEventListener("blur", function(){
    pwCheck = true;
    let v1 = pw.value;
    let v2 = pw2.value;
    let message = "비밀번호 불일치";

    if(v1 == v2){
        message = "비밀번호 일치"
        pwCheck = false;
    }
    pwResult2.innerHTML=message;
});