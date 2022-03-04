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

const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

let idCheck = false; // 체크 O : T 체크 X : F
let pwCheck = false;
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;

pw.addEventListener("change", function(){
    pwCheck=false;
    pw2.value='';
    pwResult2.innerHTML='';
    pw2.focus();
});

btn.addEventListener("click", function(){
    
    if(idCheck&&pwCheck &&nameCheck && phoneCheck && emailCheck){
        frm.submit();
    }else{
        alert('필수요건을 확인 하세요');
    }
});

id.onblur=function(){
  // console.log("id blur")
  
  let v = id.value;

    if(v==''){ //v.length == 0
     // console.log('비어있다')
     idResult.innerHTML = '필수입력'
     idCheck=false;
    }else{
    console.log('비어있지 않다')
    idCheck=true;
    }
    
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
    
    let v1 = pw.value;
    let v2 = pw2.value;
    let message = "비밀번호 불일치";

    if(v1 == v2){
        message = "비밀번호 일치"
        pwCheck = true;
    }else {
        pwCheck=false;
    }
    pwResult2.innerHTML=message;
});

name.onblur=function(){
   // console.log("name blur")
    if(name.value==''){
    nameCheck=false;
}else{
    nameCheck=true;
}
};

phone.onblur=function(){
    if(phone.value==''){
    phoneCheck=false;
}else{
    phoneCheck=true;
}
};

email.onblur=function(){
    if(email.value==''){
   emailCheck=false;
}else{
    emailCheck=true;
}
};