public class Permutation {
    static void displays(String str, String res) {
        if (str.length() == 0) {//3
            System.out.println(res + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // B
            String ros = str.substring(0, i) + str.substring(i + 1); // C
            displays(ros,res+ch);                                      // C, AB
        }//ros bc res A 1
        //ros c res A+B ab
        //ros - res A+b+c Abc
        //null ABC
    }
    public static void main(String[] args) {
        String s = "ABC";
        displays(s, "");


    }
}
