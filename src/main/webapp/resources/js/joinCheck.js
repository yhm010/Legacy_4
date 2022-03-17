const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');
const rules = document.getElementById('rules');
const btn = document.getElementById('btn');

checkAll.addEventListener('click', function(){

    for(c of check){
        c.checked = checkAll.checked;
    }
   // console.log("test");

});

rules.addEventListener("click",function() {
	let final = true;
	
        for(c of check){
            if(!c.checked){
                final = false;
            }
        }
       checkAll.checked=final;
}); 

//for(ch of check){
//    ch.addEventListener("click", function(){
//        let final = true;
//
//        for(c of check){
//            if(!c.checked){
//                final = false;
//            }
//        }
//       // console.log(this.checked)
//       checkAll.checked=final;
//    }); 
//}

    btn.addEventListener("click", function(){
        // let c = true;

        // for(ch of check){
        //     if(!ch.checked){
        //         c = false;
        //     }
        // }

       // if(check[0].checked && check[1].checked && check[2].checked && check[3].checked ){
        // if(c){
        if(checkAll.checked){
        location.href="./join";
        }else{
            alert("약관 동의가 필요합니다");
        }
        //console.log("click");

    });


