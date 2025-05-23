package Day04;


public class Permutation {
    static void displays(String str, String res) {
        if (str.length() == 0) {
            System.out.println(res + "");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            displays(ros,res+ch);

        }
    }
    public static void main(String[] args) {
        String s = "ABC";
        displays(s, "");


    }
}
