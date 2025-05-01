function fetchData(url, callback) {
  console.log("Fetching data from", url);
  setTimeout(() => {
    const success = Math.random() > 0.3;
    if (success) {
      const response = `Response from ${url}`;
      callback(null, response);
    } else {
      callback("Network error occurred!", null);
    }
  }, 2000);
}

// processData
function processData(data) {
  const processed = `Processed Data: ${data.toUpperCase()}`;
  console.log(processed);
}

// nested callbacks
fetchData("https://www.google.com", function (error, response) {
  if (error) {
    console.error("Error:", error);
  } else {
    processData(response);
  }
});
