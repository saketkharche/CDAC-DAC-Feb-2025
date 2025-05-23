// Exercise 1:
// Define a callback to convert a string to uppercase.
function toUpperCase(str) {
    return str.toUpperCase();
  }
  
  // processData takes a string and a callback function and applies the callback.
  function processData(input, callback) {
    const result = callback(input);
    console.log("Exercise 1 Output:", result);
  }
  
  // Call processData with a sample string and the toUpperCase callback.
  processData("CDAC Mumbai", toUpperCase);
  
  // ----------------------------------------------------------------------
  // Exercise 2:
  // Define forEachElement which takes an array and a callback, applying the callback to each element.
  function forEachElement(arr, callback) {
    arr.forEach((element, index) => {
      callback(element, index);
    });
  }
  
  // Call forEachElement with an anonymous callback that multiplies each element by 2 and logs the result with the index.
  const numbers = [1, 2, 3, 4, 5];
  forEachElement(numbers, (element, index) => {
    console.log(`Exercise 2 Output: Index ${index} multiplied: ${element * 2}`);
  });
  
  // ----------------------------------------------------------------------
  // Exercise 3:
  // Simulate a network request using setTimeout.
  function fetchData(url, callback) {
    console.log(`Fetching data from ${url}...`);
    setTimeout(() => {
      // Simulated response
      const response = "Simulated response data";
      console.log("Exercise 3 Output:", response);
      callback(null, response);
    }, 1000); // 1 second delay
  }
  
  // Call fetchData with a dummy URL.
  fetchData("https://www.google.com", (error, response) => {
    if (error) {
      console.error("Error fetching data:", error);
    } else {
      // You can further process the response if needed.
    }
  });
  
  // ----------------------------------------------------------------------
  // Exercise 4:
  // Modify fetchData to include error handling.
  function fetchDataWithError(url, callback) {
    console.log(`Fetching data from ${url}...`);
    setTimeout(() => {
      // Simulate error condition based on URL conditions (for example, if URL contains "error").
      if (url.includes("error")) {
        const errorMessage = "An error occurred while fetching data";
        callback(errorMessage, null);
      } else {
        const response = "Simulated successful response data";
        callback(null, response);
      }
    }, 1000);
  }
  
  // Using fetchDataWithError
  fetchDataWithError("https://www.google.com", (error, response) => {
    if (error) {
      console.error("Exercise 4 Error:", error);
    } else {
      console.log("Exercise 4 Output:", response);
    }
  });
  
  // ----------------------------------------------------------------------
  // Exercise 5:
  // Chain fetchDataWithError with processData to simulate fetching data and then processing it.
  function processFetchedData(data, callback) {
    // Simulate processing by modifying the data (e.g., appending a message).
    const processedData = data + " [processed]";
    callback(processedData);
  }
  
  // Now chain the two functions using nested callbacks.
  fetchDataWithError("https://www.google.com", (error, response) => {
    if (error) {
      console.error("Exercise 5 Error:", error);
    } else {
      processFetchedData(response, (processedResult) => {
        console.log("Exercise 5 Output:", processedResult);
      });
    }
  });
  