let requestTeamsURL = "http://192.168.1.107:8090/api/team"
teamRequest.open("GET", requestTeamsURL);
teamRequest.setRequestHeader('Content-type', 'application/json');
teamRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
teamRequest.responseType = "json"
teamRequest.send();

let teamJsonString = teamRequest.responseType;

let requestUserUrl = "http://192.168.1.107:8090/api/team"
userRequest.open("GET", requestTeamsURL);
userRequest.setRequestHeader('Content-type', 'application/json');
userRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
userRequest.responseType = "json"
userRequest.send();

let userJsonString = userRequest.responseType;

onload

