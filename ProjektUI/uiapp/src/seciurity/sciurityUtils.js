import router from '../Routers/router';
import Axios from 'axios';
export async function setToken(token,data,callback){
    if(token){
        let account = {
            login:data.login,
            password:data.password,
            token:token.slice(0,token.length-5),
            admin:(token.slice(token.length-5,token.length)==='ADMIN'?true:false),
            startTime: Date.now()
        }
       await localStorage.setItem("Account",JSON.stringify(account))
       await callback();
    }
    else{
       alert("Błędne hasło lub login")
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
    let time = end + 59000
    if(token===""&&end===""||Date.now()>time){
        localStorage.removeItem("Account")
        router.push({path:"/"})
    }else{
        updateToken()
    }
}

export function logout(){
    localStorage.removeItem("Account")
    router.push({path:"/"})
}

export async function login(Login,Password){
    let _data={
        login:Login,
        password:Password
      }
      let respones =await Axios.post("http://localhost:8080/logIn",_data);
      let data = await respones.data;
      await setToken(data,_data,goHome)  
}

export async function updateToken(){
    let account = {
        login:getToken().login,
        password:getToken().password,
        token:getToken().token,
        admin:getToken().admin,
        startTime: Date.now()
    }
        const headers = new Headers();
        headers.append('Content-Type', 'application/json')

        const myInit={
            method:'POST',
            headers,
            mode:"cors",
            cashe:"default",
            body:JSON.stringify(account)
        }

        const request = new Request("http://localhost:8080/logIn",myInit)
        
        const response = await fetch(request);

        const data = await response.text()

        if(!data){
            window.console.error("Błąd polączenia lub przedawniony  token")
            localStorage.removeItem("Account")
            router.push({path:"/"})
        }else{
            localStorage.setItem("Account",JSON.stringify(account))
            let _data={
                login:account.login,
                password:account.password
              }
              let respones =await Axios.post("http://localhost:8080/logIn",_data);
              let data = await respones.data;
              await setToken(data,_data) 
        }      
}

export async function getData(patch){

    const headers = new Headers();

    headers.set('Authorization' , `Bearer ${getToken().token}`)
    
    window.console.log(headers.get('Authorization'))

    const myInit={
        method:'GET',
        headers,
        mode:"cors"
    }

    const request = new Request(patch,myInit);

    window.console.log("request",request)
    
    let response = await fetch(request);
    
    if(!response.ok){
        window.console.log("Nie ma OK")
    }
    
    window.console.log("response",response)

    const data = await response.json();
    window.console.log("data:",data);
    return data;
}

export async function setData(payload){

    const headers = new Headers();

    headers.set('Authorization' , `Bearer ${getToken().token}`)
    headers.set('Content-Type' , 'application/json')
    
    window.console.log(headers.get('Authorization'))

    const myInit={
        method:payload.type? payload.type:'POST',
        headers,
        mode:"cors",
        body:JSON.stringify(payload.data)
    }

    const request = new Request(payload.patch,myInit);

    window.console.log("request",request)
    
    let response = await fetch(request);
    
    if(!response.ok){
        window.console.log("Nie ma OK")
    }
    
    window.console.log("response",response)

    const data = await response.json();
    window.console.log("data:",data);
    //return data;
}

export async function deleteData(payload){

    const headers = new Headers();

    headers.set('Authorization' , `Bearer ${getToken().token}`)
    headers.set('Content-Type' , 'application/json')
    
    window.console.log(headers.get('Authorization'))

    const myInit={
        method:'DELETE',
        headers,
        mode:"cors",
        body:JSON.stringify(payload.data)
    }

    const request = new Request(payload.patch,myInit);

    window.console.log("request",request)
    
    let response = await fetch(request);
    
    if(!response.ok){
        window.console.log("Nie ma OK")
    }
    
    window.console.log("response",response)

    const data = await response.json();
    window.console.log("data:",data);
    //return data;
}