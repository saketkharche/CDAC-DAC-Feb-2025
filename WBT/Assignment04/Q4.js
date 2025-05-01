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

// Using fetchData with a callback to handle response or error
fetchData("https://http.cat/404", function (error, response) {
  if (error) {
    console.error("Error:", error);
  } else {
    console.log("Success:", response);
  }
});
