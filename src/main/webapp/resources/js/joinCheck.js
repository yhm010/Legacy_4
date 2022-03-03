const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');

checkAll.addEventListener('click', function(){

    for(c of check){
        c.checked = checkAll.checked;
    }
   // console.log("test");

});


for(ch of check){
    ch.addEventListener("click", function(){
        let final = true;

        for(c of check){
            if(!c.checked){
                final = false;
            }
        }
        // console.log(this.checked)
        checkAll.checked=final;
    });
}