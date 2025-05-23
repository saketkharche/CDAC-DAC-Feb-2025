function fetchData(url, callback) {
  console.log("Fetching data from", url);
  setTimeout(() => {
    const response = `Response from ${url}`;
    callback(response);
  }, 2000);
}

fetchData("https://www.youtube.com", function (response) {
  console.log("Received:", response);
});
