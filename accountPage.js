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

let coachRequestURL = "http://localhost:8090/api/coach"
let coachRequest = new XMLHttpRequest();
coachRequest.open("GET", coachRequestURL);
coachRequest.setRequestHeader('Content-type', 'application/json');
coachRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
coachRequest.responseType = "json";
coachRequest.send();

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

let currentUserType = "coach";

let currentUser = 1;

let teamId = 0;

let messageJsonString = messageRequest.response;

messageRequest.onload = function() {
    messageJsonString = messageRequest.response;
    console.log(messageJsonString);
 }

let coachJsonString = coachRequest.response;

coachRequest.onload = function(){
    userJsonString =  coachRequest.response;
    loadDescription();
}

let userJsonString = userRequest.response;

userRequest.onload = function(){
    userJsonString =  userRequest.response;
    document.getElementById("usernameTitle").innerHTML = userJsonString[currentUser*1-1].username;
    loadDescription();
}
let teamJsonString = teamRequest.response;

teamRequest.onload = function(){
    teamJsonString = teamRequest.response;
    getTeam(teamJsonString);
    console.log(teamJsonString);
 }

let playerJsonString = playerRequest.response;

playerRequest.onload = function() {
    
    playerJsonString = playerRequest.response;
    console.log(playerJsonString);
    loadTables(playerJsonString);
 }

 teamRequest.onload = function(){
    teamJsonString = teamRequest.response;
    getTeam(teamJsonString);
    console.log(teamJsonString);
 }

function getTeam(){
    for(i in teamJsonString){
        if(currentUserType == "coach"){
            if (currentUser == teamJsonString[i].coach.user.userid){
            teamId = teamJsonString[i].teamid;
            console.log(teamJsonString[i].teamid)
            console.log(teamId)
            break;
            }
        }
        else{
            for(i in playerJsonString){
                if (currentUser == playerJsonString[i].user.userid){
                    teamId = playerJsonString[i].teams[0].teamid;
                    console.log(jsonString[i].teamid)
                    console.log(teamId)
                    break;
            }
        }
    }
}
}

function loadDescription(){
    document.getElementById("dynamic-data").innerHTML = userJsonString[currentUser*1-1].description;
    console.log(userJsonString[0].userid);
}

function loadMessages(){
    messageTable = "<tr><td>Sender</td><td>Message</td><td>Accept</td>"
    for(i in messageJsonString){
            if(messageJsonString[i].userid1.userid == currentUser){
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
    if(currentUserType == "coach"){
    scheduleTable = "<tr><td>Days</td><td>Start Time</td><td>End Time</td><td>Description</td>"
        for(i in teamJsonString){
            if(teamJsonString[i].coach.user.userid == currentUser){
                scheduleTable += "<tr><td>" + teamJsonString[i].modelSchedule.days +"</td>";
                scheduleTable += "<td>" + teamJsonString[i].modelSchedule.startTime + "</td>";
                scheduleTable += "<td>" + teamJsonString[i].modelSchedule.endTime + "</td>";
                scheduleTable += "<td>" + teamJsonString[i].modelSchedule.description + "</td></tr>";
            }
        }
        document.getElementById("dynamic-data").innerHTML = scheduleTable;
    }
    else{
        scheduleTable = "<tr><td>Days</td><td>Start Time</td><td>End Time</td><td>Description</td>"
        for(i in playerJsonString){
            if(playerJsonString[i].user.userid == currentUser){
                scheduleTable += "<tr><td>" + playerJsonString[i].team[0].modelSchedule.days +"</td>";
                scheduleTable += "<td>" + playerJsonString[i].team[0].modelSchedule.startTime + "</td>";
                scheduleTable += "<td>" + playerJsonString[i].team[0].modelSchedule.endTime + "</td>";
                scheduleTable += "<td>" + playerJsonString[i].team[0].modelSchedule.description + "</td></tr>";
            }
        }
    }
}

function loadTables(jsonString){
    let i = 0;
    let offenceText = "";
    let defenceText = "";
    let specialText = "";
    console.log(teamId)
    
    offenceText += "<tr><td>Player Username</td><td>Prefered Role</td><td>Prefered Position</td><td>Remove</td>";
    for (i in jsonString){
        for(j in teamJsonString){
            if(jsonString[i].preferedRole === "Offence" && jsonString[i].teams[j].teamid == teamId){
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
            if(jsonString[i].preferedRole === "Defence" && jsonString[i].teams[j].teamid == teamId){
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
            if(jsonString[i].preferedRole === "Special" && jsonString[i].teams[j].teamid == teamId){
                specialText += "<tr><td><button class='link' value='"+jsonString[i].user.userid+"' onclick=seeUser(this.value)>" + jsonString[i].user.username + "</button></td>"
                specialText += "<td>" + jsonString[i].preferedRole + "</td>"
                specialText += "<td>" + jsonString[i].preferedPosition + "</td>"
                specialText += "<td><button id ='" +i+ "' value='"+jsonString[i].user.userid+"' onclick=sendRequestToJoin(this.value)>remove</td></tr>"        
            }
        }
    }
    document.getElementById("special").innerHTML = specialText;
}

function accept(id){
    let addMemberRequest = "http://localhost:8090/api/team/member"
    let addRequest = new XMLHttpRequest();
    addRequest.open("POST", addMemberRequest, true);
    addRequest.setRequestHeader('Content-type', 'application/json');
    addRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    addRequest.responseType = "json"

    let json = JSON.stringify({
            "id": {
                "teamid": teamId,
                "playerid": id
            },
            "playerNumber": 0
    })
    console.log(json);

    addRequest.send(json);
}


function loginUser(){

    let username = document.getElementById("inputUsername").value;
    let password = document.getElementById("inputPassword").value;
    console.log(username)
    console.log(userJsonString[0].username)
    for(i in userJsonString){
        if(username.includes(userJsonString[i].username)
        && password.includes(userJsonString[i].password)){
            alert("Login successful")
            currentUser = userJsonString[i].userid;
            console.log(currentUserType)
        }
    }
    for(i in coachJsonString){
        console.log(currentUser)
        console.log(coachJsonString[i].user.userid)
        let coachId = coachJsonString[i].user.userid;
        if(currentUser == coachId){
            currentUserType = "coach";
            console.log(currentUserType)
            teamRequest.onload();
            playerJsonString.onLoad();
            userRequest.onload();
            break;
        }
        else{
            currentUserType = "player";
            teamRequest.onload();
            playerJsonString.onLoad();
            userRequest.onload();
        }
        console.log(currentUserType)
    }
}