// ID, PW, NAME, EMAIL, PHONE

const id = document.getElementById("id");
const idResult = document.getElementById("idResult");
const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pw2 = document.getElementById("pw2");
const pwResult2 = document.getElementById("pwResult");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

//----pw와 pw2가 같은 비밀번호인지 검증----

let pwCheck=true; // 같지 않으면 T, 같으면 F
pw2.addEventListener("blur", function(){
  
    let message = "비밀번호가 일치합니다.";
    if(pw.value != pw2.value){
        pwCheck = true;
        message = "비밀번호가 일치하지 않습니다.";
        pw2.value = '';
        
    }else{
        pwCheck=false;
    }
    pwResult2.innerHTML=message;
});

//---- 검증이 끝나고 pw를 수정 했을 경우----
pw.addEventListener("change", function(){
    pwCheck = true;
    pw2.value='';
    pwResult2.value='';
    pw2.focus();
});

//----pw 길이 검증----
pw.addEventListener("blur", function(){
    if(pw.value.length<8 || pw.value.length>12){
        pwResult.innerHTML='비밀번호의 글자수가 맞지 않습니다.'
        
    }
});

//----ID 입력 후 처리----
id.addEventListener("blur", function(){
    if(id.value==''){
        idResult.innerHTML = '아이디를 입력하세요';
       
    }
});

//---- 가입 버튼 클릭 했을 때----
btn.addEventListener("click", function(){
   // console.log("btn 확인")
   if(id.value==''){
    alert('아이디를 입력하세요');
    id.focus();
    return;
   }
   if(pw.value=='' || pw.value.length<8 || pw.value.length>12){
       alert('비밀번호가 정확하지 않습니다')
       pw.focus();
       return;
   }

   if(pwCheck){
       alert('비밀번호가 일치하지 않습니다.')
       pw2.focus();
       return;
   }

   if(name.value==''){
       alert('이름을 입력하세요')
       name.focus();
       return;
   }
   if(phone.value==''){
       alert('전화번호를 입력하세요');
       phone.focus();
       return;
   }
   if(email.value==''){
    alert('이메일을 입력하세요');
    email.focus();
    return;
   }

   frm.submit();

});

