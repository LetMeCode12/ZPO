import router from '../Routers/router'
export async function setToken(token,data,callback){
     window.console.log(token);
    if(token){
        window.console.log(token);
        let account = {
            login:data.login,
            password:data.password,
            token,
            startTime: Date.now()
        }
       await localStorage.setItem("Account",JSON.stringify(account))
       await callback();
    }
    else{
       await localStorage.removeItem("Account")
    }
}

export function goHome(){
    router.push({path:"/homePage"})    
}

export function getToken(){
    return JSON.parse(localStorage.getItem("Account"))
}

export function checkAccess(){
    let token ="";
    let end = "";
    try{
    token=getToken().token;
    end=getToken().startTime;
    }catch(e){
        token=""
        end=""
    }
    if(token===""&&end===""){
        router.push({path:"/"})
    }
    let time = end + 59000
    if(Date.now()>time){
        alert("Konec tokensa")
    }
}