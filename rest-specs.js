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


