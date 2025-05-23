import java.util.Calendar;

public class Q4GoodMorningMessage {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);

        if (hour < 12) {
            System.out.println("Good morning!");
        } else if (hour < 17) {
            System.out.println("Good afternoon!");
        } else {
            System.out.println("Good evening!");
        }
    }
}
