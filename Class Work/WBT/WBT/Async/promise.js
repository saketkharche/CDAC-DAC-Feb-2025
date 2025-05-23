// Function to calculate the square
function calculateSquare(number) {
    return new Promise((resolve, reject) => {
        if (typeof number === 'number') {
            resolve(number * number);
        } else {
            reject('Input must be a number');
        }
    });
}

// Function to calculate the factorial
function calculateFactorial(number) {
    return new Promise((resolve, reject) => {
        if (typeof number === 'number' && number >= 0) {
            let factorial = 1;
            for (let i = 1; i <= number; i++) {
                factorial *= i;
            }
            resolve(factorial);
        } else {
            reject('Input must be a non-negative number');
        }
    });
}

// Function to calculate the cube
function calculateCube(number) {
    return new Promise((resolve, reject) => {
        if (typeof number === 'number') {
            resolve(number * number * number);
        } else {
            reject('Input must be a number');
        }
    });
}

// Example usage
const number = 5;

calculateSquare(number)
    .then((square) => {
        console.log(`Square of ${number}: ${square}`);
        return calculateFactorial(number);
    })
    .then((factorial) => {
        console.log(`Factorial of ${number}: ${factorial}`);
        return calculateCube(number);
    })
    .then((cube) => {
        console.log(`Cube of ${number}: ${cube}`);
    })
    .catch((error) => {
        console.error(error);
    });