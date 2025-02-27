class Q5StudentPassFail {
    public static void main(String[] args) {
        int subject1 = 50; // Example grade for subject 1
        int subject2 = 30; // Example grade for subject 2
        int subject3 = 45; // Example grade for subject 3

        int failCount = 0;

        if (subject1 <= 40)
            failCount++;
        if (subject2 <= 40)
            failCount++;
        if (subject3 <= 40)
            failCount++;

        if (failCount == 0) {
            System.out.println("Student passes");
        } else {
            System.out.println("Student fails in " + failCount + " subjects");
        }
    }
}
