// Callback function
function toUpperCase(str) {
  return str.toUpperCase();
}

function processData(str, callback) {
  const result = callback(str);
  console.log("Uppercased:", result);
}

processData("saket m kharche pgdac", toUpperCase);
