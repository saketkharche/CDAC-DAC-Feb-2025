public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        if (username.contains(" ")) {
            return false; // No spaces allowed
        }
        if (username.length() < 5) {
            return false; // Minimum length is 5
        }
        if (!username.toLowerCase().contains("user")) {
            return false; // Must contain "user"
        }
        return true;
    }

    public static void main(String[] args) {
        String user1 = "user123";
        String user2 = "admin";
        String user3 = "User Name";

        System.out.println(isValidUsername(user1)); // Output: true
        System.out.println(isValidUsername(user2)); // Output: false
        System.out.println(isValidUsername(user3)); // Output: false
    }
}
