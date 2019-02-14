let playerRequestURL = "http://localhost:8090/api/player"
let playerRequest = new XMLHttpRequest();
playerRequest.open("GET", playerRequestURL);
playerRequest.setRequestHeader('Content-type', 'application/json');
playerRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
playerRequest.responseType = "json";
playerRequest.send();

let userCoachrequestURL = "http://localhost:8090/api/coach"
let userCoachRequest = new XMLHttpRequest();
userCoachRequest.open("GET", userCoachrequestURL);
userCoachRequest.setRequestHeader('Content-type', 'application/json');
userCoachRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
userCoachRequest.responseType = "json";
userCoachRequest.send();

let coachJsonString = userCoachRequest.response;

let userType = 1;
let table = "";
let pageText = "";
let page = 1;
let baseTable = "";

playerRequest.onload = function() {
   let playerJsonString = playerRequest.response;
   baseTable = playerJsonString;
   loadTable(baseTable);
}

userCoachRequest.onload = function() {
    coachJsonString = userCoachRequest.response;
}

function loadTable(newTable){
    console.log(userType)
    let counter = 0;
    let i = 0;
    table = newTable;
    if (page == 1){
        i = 0;
    }
    else{
        i = page*20;
    }
    console.log(userType)
    if (userType == 1){
        pageText = "";
        document.getElementById("searchTable").innerHTML = pageText;
        pageText = "<tr><td>Player Username</td><td>Prefered Role</td><td>Prefered Position</td><td>Description</td><td>Message</td>";
        for (i in table){
            pageText += "<tr><td><button class='link' value='"+table[i].user.userid+"' onclick=seeUser(this.value)>" + table[i].user.username + "</button></td>"
            pageText += "<td>" + table[i].preferedRole + "</td>"
            pageText += "<td>" + table[i].preferedPosition + "</td>"
            pageText += "<td>" + table[i].user.description+ "</td>"
            pageText += "<td><button id ='" +i+ "' value='"+table[i].user.userid+"' onclick=sendRequestToJoin(this.value)>message</td></tr>"
            if(counter == 20){
                break
            }
        }
        document.getElementById("searchTable").innerHTML = pageText;
    }
    else{
        pageText = "";
        document.getElementById("searchTable").innerHTML = pageText;
        pageText = "<tr><td>Coach Username</td><td>Training Specialisation</td><td>Description</td><td>Message</td>";
        for (i in table){
            pageText += "<tr><td><button class='link' value='"+table[i].user.userid+"' onclick=seeUser(this.value)>" + table[i].user.username + "</button></td>"
            pageText += "<td>" + table[i].trainingSpecialisation + "</td>"
            pageText += "<td>" + table[i].user.description+ "</td>"
            pageText += "<td><button id ='" +i+ "' value='"+table[i].user.userid+"' onclick=sendRequestToJoin(this.value)>remove</td></tr>"
            if(counter == 20){
                break
            }
        }
        document.getElementById("searchTable").innerHTML = pageText;
    }
}

function changeUserType(user){

    userType = user;
    if(user == 1){
        jsonString = playerJsonString;
    }
    else{
        jsonString = coachJsonString;
        console.log(userType)
    }

    pageText = "";
    page = 1;
    baseTable = jsonString;
    console.log(jsonString);
    console.log(userType);
    loadTable(baseTable);
}

function searchRequest(){
    
}
    
function findByRole(testval){
    console.log(testval);
    let dropdown=testval;
    pageText = "";
    table = baseTable;
	let roleTable = [];
    let counter = 0;
    if (dropdown === "All"){
        loadTable(baseTable);
    }
    else{
        for (i in table){
            console.log("Inside Loop");
            if (dropdown === table[i].preferedRole){
                roleTable[counter] = table[i];
                counter++;
                }
            }
        if (counter == 0){
            pageText = "Sorry! We couldn't find what you were looking for."
        }
        loadTable(roleTable);
    }
}

function findByPosition(){
    let input = document.getElementById("playerPositionFilter").value;
	pageText = "";
	let positionTable = [];
    let counter = 0;
    for (i in table){
        if (table[i].preferedPosition.includes(input)){
			positionTable[counter] = table[i];
			counter++;
			}
        }
	if (counter == 0){
        pageText = "Sorry! We couldn't find what you were looking for."
        document.getElementById("searchTable").innerHTML = pageText;
    }
    else{
        loadTable(positionTable);
    }
}

function seeUser(id){

    console.log("run button")

    pageText = "";
    document.getElementById("searchTable").innerHTML = pageText;
    
    let userRequestURL = "http://localhost:8090/api/user/"+id;
    let userRequest = new XMLHttpRequest();
    userRequest.open("GET", userRequestURL);
    userRequest.setRequestHeader('Content-type', 'application/json');
    userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    userRequest.responseType = "json";
    userRequest.send();
    
    let userJsonString = userRequest.response;

    userRequest.onload = function() {
        userJsonString = userRequest.response;
    }
    
    pageText = userJsonString;
    console.log(userJsonString);
    console.log(pageText)
}

function sendRequestToJoin(id){
    console.log("ID:" + id);

    let sendMessageRequest = "http://localhost:8090/api/message"
    let messageRequest = new XMLHttpRequest();
    messageRequest.open("POST", sendMessageRequest, true);
    messageRequest.setRequestHeader('Content-type', 'application/json');
    messageRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
    messageRequest.responseType = "json"

    let json = JSON.stringify({
        "userid": {
        	"userid": 1
        },
        "userid1": {
        	"userid": id
        },
        "message": "Hi there"
 })

    console.log(json);

    messageRequest.send(json);
}