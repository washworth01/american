let userRequestURL = "http://localhost:8090/api/user/"
    let userRequest = new XMLHttpRequest();
    userRequest.open("GET", userRequestURL);
    userRequest.setRequestHeader('Content-type', 'application/json');
    userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    userRequest.responseType = "json";
    userRequest.send();

let userJsonString = userRequest.response;

let form = "<li><h2>Username</h2><input id='usernameLogin' type=text></li><li><h2>Password</h2><input id='passwordLogin' type=text></li>";

let formUser = "";

let userType = "";

userRequest.onload = function() {
    userJsonString = userRequest.response;
    createForm();
 }

 function createForm(){
    document.getElementById("fields").innerHTML = form;
    document.getElementById("userSpecific").innerHTML = formUser;
 }

 function loginSetup(){
    form =  "<li><h2>Username</h2><input id='usernameLogin' type=text></li><li><h2>Password</h2><input id='passwordLogin' type=text></li>"
    formUser = "";
    createForm();
 }

 function createAccountSetup(){
    form = "<li><h2>Username</h2><input id='username' type=text></li><li><h2>Password</h2><input id='password' type=text></li>"
    form += "<li><h2>Email-Address</h2><input id='email' type=text></li><li><h2>First Name</h2><input id='firstName' type=text></li>"
    form += "<li><h2>Last Name</h2><input id='lastName' type=text></li><li><h2>Date Of Birth</h2><input id='dob' type=text></li>"
    form += "<li><h2>(Optional) Description</h2><input id='description' type=text></li><li><h2>House Number</h2><input id='houseNumber' type=number></li>"
    form += "<li><h2>Address line 1</h2><input id='addressLine1' type=text></li><li><h2>(Optional) Address line 2</h2><input id='addressLine2' type=text></li>"
    form += "<li><h2>City</h2><input id='city' type=text></li><li><h2>County</h2><input id='county' type=text></li>"
    form += "<li><h2>Postcode</h2><input id='postcode' type=text></li><li><h2>Phone Number</h2><input id='phone' type=text></li>"
    form += "<button id='coach' onclick=createCoach();return false>Create Coach</button><button id='player' onclick=createPlayer(); return false;>Create Player</button>"
    createForm();
}

function createUserSpecificForm(){
    document.getElementById("userSpecific").innerHTML = formUser;
}

function createCoach(){
    formUser = "<li><h2>Training Specialisation</h2><input id='specialisation' type=text></li>";
    formUser += "<button id='coach'>Finish</button>";
    userType = "coach";
    createUserSpecificForm();
}

function createPlayer(){
    formUser = "<li><h2>Prefered Role</h2><input id='role' type=text></li><li><h2>Prefered Position</h2><input id='position' type=text></li>";
    formUser += "<button id='player'>Finish</button>";
    userType = "player";
    createUserSpecificForm();
}

function finaliseAndCreateUser(){
    for (i in userJsonString){
        if(userJsonString[i].username === document.getElementById("username").value){
            return alert("Username already in use. Please choose another"); 
        }
    }

    for (i in userJsonString){
        let contactId = "";
        if(document.getElementById("houseNumber").value === userJsonString[i].contactDetails.houseNumber
        && document.getElementById("postcode").value === userJsonString[i].contactDetails.postcode){
            contactId = userJsonString[i].contactDetails.contactDetailsId;
            if (userType = "coach"){
                let createUserRequestURL = "http://localhost:8090/api/coach"
                let userRequest = new XMLHttpRequest();
                userRequest.open("POST", createUserRequestURL, true);
                userRequest.setRequestHeader('Content-type', 'application/json');
                userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
                userRequest.responseType = "json"

                json = JSON.stringify({
                    "userid": 1,
                    "username": document.getElementById("username").value,
                    "password": document.getElementById("password").value,
                    "emailAddress": document.getElementById("emailAddress").value,
                    "firstName": document.getElementById("firstName").value,
                    "lastName": document.getElementById("lastName").value,
                    "dateOfBirth": document.getElementById("dateOfBirth").value,
                    "description": document.getElementById("description").value,
                    "contactdetails": {
                        "contactDetailsId": contactId
                    }
                })

                return userRequest.send();
            }
        }
    }

    let createContactRequestURL = "http://localhost:8090/api/contact"
    let contactRequest = new XMLHttpRequest();
    contactRequest.open("POST", createContactRequestURL, true);
    contactRequest.setRequestHeader('Content-type', 'application/json');
    contactRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    contactRequest.responseType = "json"

    let json = JSON.stringify({
        "houseNumber": document.getElementById("houseNumber").value,
        "addressLine1": document.getElementById("addressLine1").value,
        "addressLine2": document.getElementById("addressLine2").value,
        "city": document.getElementById("city").value,
        "county": document.getElementById("county").value,
        "postcode": document.getElementById("postcode").value,
        "phoneNumber": document.getElementById("phoneNumber").value,
    })
    
    contactRequest.send(json);

    if(document.getElementById("houseNumber").value === userJsonString[i].contactDetails.houseNumber
        && document.getElementById("postcode").value === userJsonString[i].contactDetails.postcode){
           contactId = userJsonString[i].contactDetailsId;
        }

    let createUserRequestURL = "http://localhost:8090/api/user"
    let userRequest = new XMLHttpRequest();
    userRequest.open("POST", createUserRequestURL, true);
    userRequest.setRequestHeader('Content-type', 'application/json');
    userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    userRequest.responseType = "json"

    json = JSON.stringify({
        "userid": 1,
        "username": document.getElementById("username").value,
        "password": document.getElementById("password").value,
        "emailAddress": document.getElementById("emailAddress").value,
        "firstName": document.getElementById("firstName").value,
        "lastName": document.getElementById("lastName").value,
        "dateOfBirth": document.getElementById("dateOfBirth").value,
        "description": document.getElementById("description").value,
        "contactdetails": {
            "contactDetailsId": contactId
        }
    })

    userRequest.send();
}


