class Q7Largest_of_Three_Numbers {
    public static void main(String[] args) {

        int firstNumber = 12;

        int secondNumber = 45;

        int thirdNumber = 22;

        int largestNumber = firstNumber;

        if (secondNumber > largestNumber) {
            largestNumber = secondNumber;
        }

        if (thirdNumber > largestNumber) {
            largestNumber = thirdNumber;
        }

        System.out.println("The largest number is " + largestNumber + ".");

    }
}
