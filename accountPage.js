let userRequestURL = "http://localhost:8090/api/user"
let userRequest = new XMLHttpRequest();
userRequest.open("GET", userRequestURL);
userRequest.setRequestHeader('Content-type', 'application/json');
userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
userRequest.responseType = "json";
userRequest.send();

let playerRequestURL = "http://localhost:8090/api/player"
let playerRequest = new XMLHttpRequest();
playerRequest.open("GET", playerRequestURL);
playerRequest.setRequestHeader('Content-type', 'application/json');
playerRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
playerRequest.responseType = "json";
playerRequest.send();

let teamRequestURL = "http://localhost:8090/api/team"
let teamRequest = new XMLHttpRequest();
teamRequest.open("GET", teamRequestURL);
teamRequest.setRequestHeader('Content-type', 'application/json');
teamRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
teamRequest.responseType = "json";
teamRequest.send();

let messageRequestURL = "http://localhost:8090/api/message"
let messageRequest = new XMLHttpRequest();
messageRequest.open("GET", messageRequestURL);
messageRequest.setRequestHeader('Content-type', 'application/json');
messageRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
messageRequest.responseType = "json";
messageRequest.send();

let messageJsonString = messageRequest.response;

messageRequest.onload = function() {
    messageJsonString = messageRequest.response;
    console.log(messageJsonString);
 }

let userJsonString = userRequest.response;

userRequest.onload = function(){
    userJsonString =  userRequest.response;
    document.getElementById("usernameTitle").innerHTML = userJsonString[0].username;
    loadDescription();
}
playerRequest.onload = function() {
    let playerJsonString = playerRequest.response;
    console.log(playerJsonString);
    loadTables(playerJsonString);
 }
 let teamJsonString = teamRequest.response;

 teamRequest.onload = function(){
    teamJsonString = teamRequest.response;
    console.log(teamJsonString);
 }

function loadDescription(){
    document.getElementById("dynamic-data").innerHTML = userJsonString[0].description;
    console.log(userJsonString[0].userid);
}

function loadMessages(){
    messageTable = "<tr><td>Sender</td><td>Message</td><td>Accept</td>"
    for(i in messageJsonString){
            if(messageJsonString[i].userid1.userid == userJsonString[0].userid){
                console.log(userJsonString[0].userid)
                console.log(messageJsonString[i].userid.userid1)
                messageTable += "<tr><td><button class='link' value='"+messageJsonString[i].userid.username+"' onclick=seeUser(this.value)>" + messageJsonString[i].userid.username + "</button></td>"
                messageTable += "<td>" + messageJsonString[i].message + "</td>"
                messageTable += "<td><button id ='"+i+"' value='"+messageJsonString[i].userid.userid+"' onclick=accept(this.value)>Accept</td></tr>"        
        }
    }   
    document.getElementById("dynamic-data").innerHTML = messageTable;
}

function loadSchedule(){
    scheduleTable = "<tr><td>Days</td><td>Start Time</td><td>End Time</td><td>Description</td>"
        for(i in teamJsonString){
            if(teamJsonString[i].coach.user.userid === userJsonString[0].userid){
                scheduleTable += "<td>" + teamJsonString[i] +"</td>";
                scheduleTable += "<td>" + teamJsonString[i].message + "</td>";
                scheduleTable += "<td>" + teamJsonString[i].message + "</td>";
                scheduleTable += "<td>" + teamJsonString[i].message + "</td>";
            }
        }
}

function loadTables(jsonString){
    let i = 0;
    let offenceText = "";
    let defenceText = "";
    let specialText = "";
    
    offenceText += "<tr><td>Player Username</td><td>Prefered Role</td><td>Prefered Position</td><td>Remove</td>";
    for (i in jsonString){
        for(j in teamJsonString){
            if(jsonString[i].preferedRole === "Offence" && jsonString[i].teams[j].teamid == teamJsonString[0].teamid){
                offenceText += "<tr><td><button class='link' value='"+jsonString[i].user.userid+"' onclick=seeUser(this.value)>" + jsonString[i].user.username + "</button></td>"
                offenceText += "<td>" + jsonString[i].preferedRole + "</td>"
                offenceText += "<td>" + jsonString[i].preferedPosition + "</td>"
                offenceText += "<td><button id ='" +i+ "' value='"+jsonString[i].user.userid+"' onclick=sendRequestToJoin(this.value)>remove</td></tr>"        
            }
        }
    }
    document.getElementById("offence").innerHTML = offenceText;
    defenceText += "<tr><td>Player Username</td><td>Prefered Role</td><td>Prefered Position</td><td>Remove</td>"
    for (i in jsonString){
        for(j in teamJsonString){
            if(jsonString[i].preferedRole === "Defence" && jsonString[i].teams[j].teamid == teamJsonString[0].teamid){
                defenceText += "<tr><td><button class='link' value='"+jsonString[i].user.userid+"' onclick=seeUser(this.value)>" + jsonString[i].user.username + "</button></td>"
                defenceText += "<td>" + jsonString[i].preferedRole + "</td>"
                defenceText += "<td>" + jsonString[i].preferedPosition + "</td>"
                defenceText += "<td><button id ='" +i+ "' value='"+jsonString[i].user.userid+"' onclick=sendRequestToJoin(this.value)>remove</td></tr>"        
            }
        }
    }
    document.getElementById("defence").innerHTML = defenceText;
    specialText += "<tr><td>Player Username</td><td>Prefered Role</td><td>Prefered Position</td><td>Remove</td>"
    for (i in jsonString){
        for(j in teamJsonString){
            if(jsonString[i].preferedRole === "Special" && jsonString[i].teams[j].teamid == teamJsonString[0].teamid){
                specialText += "<tr><td><button class='link' value='"+jsonString[i].user.userid+"' onclick=seeUser(this.value)>" + jsonString[i].user.username + "</button></td>"
                specialText += "<td>" + jsonString[i].preferedRole + "</td>"
                specialText += "<td>" + jsonString[i].preferedPosition + "</td>"
                specialText += "<td><button id ='" +i+ "' value='"+jsonString[i].user.userid+"' onclick=sendRequestToJoin(this.value)>remove</td></tr>"        
            }
        }
    }
    document.getElementById("special").innerHTML = specialText;
}