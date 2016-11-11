/* GET DEVICES */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/devices",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* ADD A NEW DEVICE */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/devices/add",
  "method": "PUT",
  "headers": {
    "content-type": "application/x-www-form-urlencoded",
    "cache-control": "no-cache"
  },
  "data": {
    "deviceId": "jeff.bezos@amazon.com",
    "installDate": "1478743451000"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* REMOVE A DEVICE (CALL AFTER UNINSTALL) */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/devices/remove",
  "method": "POST",
  "headers": {
    "content-type": "application/x-www-form-urlencoded",
    "cache-control": "no-cache"
  },
  "data": {
    "deviceId": "jeff.bezos@amazon.com",
    "deleteDate": "1478743451023"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* ADDING A NEW MESSAGE */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/messages/add",
  "method": "POST",
  "headers": {
    "content-type": "application/x-www-form-urlencoded",
    "cache-control": "no-cache"
  },
  "data": {
    "deviceId": "jeff.bezos@amazon.com",
    "messageTime": "1478743451034",
    "content": "Whats up dude",
    "appName": "Venmo"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* GETTING DISTINCT APP NAMES (FOR A DEVICE ID) */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/messages/distinctApps/gaurav.walia@cmu.edu",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* GETTING ALL MESSAGES (FOR A DEVICE ID) | SORTED BY DESC. ORDER */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/messages/gaurav.walia@cmu.edu",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});


/* GETTING ALL MESSAGES (FOR DEVICE ID & APP NAME) | SORTED BY DESC. ORDER */
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/api/messages/gaurav.walia@cmu.edu/gmail",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache"
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
