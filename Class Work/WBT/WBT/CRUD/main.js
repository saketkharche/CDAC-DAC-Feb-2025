function isValidURL(url) {
    try {
        new URL(url);
        return true;
    } catch (err) {
        return false;
    }
}

function fetchData(url, callback) {
    setTimeout(() => {
        if (isValidURL(url)) {
            const response = Response
            from
            $
            {
                url
            }
            ; //response from https://www.w3schools.com/
            callback(null, response);
        } else {
            callback("Error: URL not provided", null);
        }
    }, 2000);
}

function processData(response, callback) {
    setTimeout(() => {
        const processed = response.toUpperCase();
        callback(processed);
    }, 1000);
}

fetchData("https://www.w3schools.com/", function (error, response) {
    if (error) {
        console.log(error + " error found");
    } else {
        processData(response, function (proResult) {
            console.log("Processed Result:", proResult);
        });
    }
});