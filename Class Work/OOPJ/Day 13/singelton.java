class singelton {
    private singelton() {

    }
    private static singelton reference;
    public static singelton getInstance() {
        if (reference == null)
            reference =new singelton();
        return reference;

    }
}
class Program{
    public static void main(String[] args) {
        singelton s1 = singelton.getInstance();
        singelton s2 = singelton.getInstance();
    }
}