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