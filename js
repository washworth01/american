let userCoachrequestURL = "http://localhost:8090/api/coach"
let userCoachRequest = new XMLHttpRequest();
userCoachRequest.open("GET", userCoachrequestURL);
userCoachRequest.setRequestHeader('Content-type', 'application/json');
userCoachRequest.setRequestHeader('Access-Control-Allow-Origin', '*');
userCoachRequest.responseType = "json";
userCoachRequest.send();

let coachJsonString = userCoachRequest.response;
console.log(coachJsonString)
