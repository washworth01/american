let userGetRequestURL = "http://localhost:8090/api/user"
    let userRequest = new XMLHttpRequest();
    userRequest.open("GET", userGetRequestURL);
    userRequest.setRequestHeader('Content-type', 'application/json');
    userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    userRequest.responseType = "json";
    userRequest.send();

    let userJsonString = userRequest.response;

    userRequest.onload = function(){
        userJsonString = userRequest.response;
        console.log(userJsonString[0].username);
    }

let contactRequestURL = "http://localhost:8090/api/contact"
let contactRequest = new XMLHttpRequest();
contactRequest.open("GET", contactRequestURL);
contactRequest.setRequestHeader('Content-type', 'application/json');
contactRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
contactRequest.responseType = "json";
contactRequest.send();

let contactJsonString = contactRequest.response;

contactRequest.onload = function(){
    contactJsonString = contactRequest.response;
}

let form =  "<h2>Username<input id='usernameLogin' class='inputBox' type=text></h2><h2>Password<input id='passwordLogin' class='inputBox' type=text></h2>"

let formUser = "";

let userType = "";

 function createForm(){
    document.getElementById("fields").innerHTML = form;
    document.getElementById("userSpecific").innerHTML = formUser;
 }

 function loginSetup(){
    form =  "<h2>Username<input id='usernameLogin' class='inputBox' type=text></h2>"
    form += "<h2>Password<input id='passwordLogin' class='inputBox' type=text></h2>"
    form += "<button id='loginButton' type=button onclick=login();>Submit</button>"
    formUser = "";
    createForm();
 }

 function createAccountSetup(){
    form = "<h2>Username<input id='username' class='inputBox' type=text/></h2>"
    form += "<h2>Password<input id='password' class='inputBox' type='password'/></h2>"
    form += "<h2>Email-Address<input id='email' class='inputBox' type=text/></h2>"
    form += "<h2>First Name<input id='firstName' class='inputBox' type=text/></h2>"
    form += "<h2>Last Name<input id='lastName' class='inputBox' type=text/></h2>"
    form += "<h2>Date Of Birth<input id='dob' class='inputBox' type=text/></h2>"
    form += "<h2>(Optional) Description<input id='description' class='inputBox' type=text/></h2>"
    form += "<h2>House Number<input id='houseNumber' class='inputBox' type=number/></h2>"
    form += "<h2>Address line 1<input id='addressLine1' class='inputBox' type=text/></h2>"
    form += "<h2>(Optional) Address line 2<input id='addressLine2' class='inputBox' type=text/></h2>"
    form += "<h2>City<input id='city' class='inputBox' type=text/></h2>"
    form += "<h2>County<input id='county' class='inputBox' type=text/></h2>"
    form += "<h2>Postcode<input id='postcode' class='inputBox' type=text/></h2>"
    form += "<h2>Phone Number<input id='phone' class='inputBox' type=text/></h2>"
    form += "<button id='coach' type=button onclick=createCoach();return false;>Create Coach</button><button id='player' type=button onclick=createPlayer(); return false;>Create Player</button>"
    createForm();
}

function createUserSpecificForm(){
    document.getElementById("userSpecific").innerHTML = formUser;
}

function createCoach(){
    formUser = "<h2>Training Specialisation<input id='specialisation' class='inputBox' type=text></h2>";
    formUser += "<button id='coach' type=button onclick=finaliseAndCreateUser();return false>Finish</button>";
    userType = "coach";
    createUserSpecificForm();
}

function createPlayer(){
    formUser = "<h2>Prefered Role<input id='role' class='inputBox' type=text></h2>"
    formUser += "<h2>Prefered Position<input id='position' class='inputBox' type=text><h2>";
    formUser += "<button id='player' type=button onclick=finaliseAndCreateUser();>Finish</button>";
    userType = "player";
    createUserSpecificForm();
}

function finaliseAndCreateUser(){
    let i =0;
    if(document.getElementById("username").value === "" || document.getElementById("password").value === "" || document.getElementById("email").value === "" 
    || document.getElementById("firstName").value === ""  || document.getElementById("lastName").value === ""  || document.getElementById("dob").value === "" 
    || document.getElementById("houseNumber").value === ""  || document.getElementById("addressLine1").value === ""  || document.getElementById("city").value === "" 
    || document.getElementById("county").value === ""  || document.getElementById("postcode").value === ""  || document.getElementById("phone").value === "" ){
        return alert("Form not completed")
    }
    newUsername = document.getElementById("username").value;
    for (i in userJsonString){
        if(newUsername.includes(userJsonString[i].username)){
            return alert("That username is already taken, please enter a new one");
        }
    }


    newHouseNumber = document.getElementById("houseNumber").value
    newPostcode = document.getElementById("postcode").value;

    console.log(contactJsonString[0].houseNumber)
    console.log(newHouseNumber)
    console.log(newPostcode)
    console.log(contactJsonString[0].postcode)

    let contactId = "";

    for(i in contactJsonString){
        if(newHouseNumber.includes(contactJsonString[i].houseNumber) && newPostcode.includes(contactJsonString[i].postcode)){
            contactId = contactJsonString[i].contactDetailsId; break;
        }
        else{
                let contactPostRequestURL = "http://localhost:8090/api/contact"
                let contactPostRequest = new XMLHttpRequest();
                contactPostRequest.open("POST", contactPostRequestURL, true);
                contactPostRequest.setRequestHeader('Content-type', 'application/json');
                contactPostRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
                contactPostRequest.responseType = "json";
                
                newContact = JSON.stringify({
                    "houseNumber": document.getElementById("houseNumber").value,
                    "addressLine1": document.getElementById("addressLine1").value,
                    "addressLine2": document.getElementById("addressLine2").value,
                    "city": document.getElementById("city").value,
                    "county": document.getElementById("county").value,
                    "postcode": document.getElementById("postcode").value,
                    "phoneNumber": document.getElementById("phone").value,
                })
                
                contactPostRequest.send(newContact);
                

                arrayLength = contactJsonString.length;
                
                contactId = arrayLength+1;
                break;
        }
    }

    let userPostRequestURL = "http://localhost:8090/api/user"
    let userPostRequest = new XMLHttpRequest();
    userPostRequest.open("POST", userPostRequestURL, true);
    userPostRequest.setRequestHeader('Content-type', 'application/json');
    userPostRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    userPostRequest.responseType = "json";

    newUser = JSON.stringify({
        "username":document.getElementById("username").value,
        "password": document.getElementById("password").value,
        "emailAddress": document.getElementById("email").value,
        "firstName": document.getElementById("firstName").value,
        "lastName": document.getElementById("lastName").value,
        "dateOfBirth": document.getElementById("dob").value,
        "description": document.getElementById("description").value,
        "contactdetails": {
            "contactDetailsId": contactId
        }
    })

    userPostRequest.send(newUser);

    arrayLength = userJsonString.length;

    let userId = "";
    userId = arrayLength+1;

    console.log(userId)
    console.log(contactId)

    
    if(userType == "coach"){
        let coachPostRequestURL = "http://localhost:8090/api/coach"
        let coachPostRequest = new XMLHttpRequest();
        coachPostRequest.open("POST", coachPostRequestURL);
        coachPostRequest.setRequestHeader('Content-type', 'application/json');
        coachPostRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
        coachPostRequest.responseType = "json";

        console.log(document.getElementById("specialisation").value)

        newCoach = JSON.stringify({
        "user": {
            "userid": userId
                },
        "trainingSpecialisation": document.getElementById("specialisation").value
        })

        coachPostRequest.send(newCoach);
    }
    else{
        let playerRequestURL = "http://localhost:8090/api/player"
        let playerRequest = new XMLHttpRequest();
        playerRequest.open("POST", playerRequestURL);
        playerRequest.setRequestHeader('Content-type', 'application/json');
        playerRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
        playerRequest.responseType = "json";

        newPlayer = JSON.stringify({
            "user": {
                "userid": userId.toString()
            },
            "preferedRole": document.getElementById("role").value,
            "preferedPosition": document.getElementById("position").value
        })

        playerRequest.send(newPlayer);
    }
}

function login(){
    let username = document.getElementById("usernameLogin").value;
    let password = document.getElementById("passwordLogin").value;
    console.loh
    for(i in userJsonString){
        if(username.includes(userJsonString[i].username)
        && password.includes(userJsonString[i].password)){
            alert("Login successful")
        }
    }
}
