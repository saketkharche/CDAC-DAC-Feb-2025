class HashcodeDemo {

    String name;
    int id;

    // Constructor to initialize the object
    HashcodeDemo(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Use `Objects.hash()` to generate a hash code based on multiple fields
        return java.util.Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "HashcodeDemo{name='" + name + "', id=" + id + "}";
    }

    public static void main(String[] args) {
        HashcodeDemo demo1 = new HashcodeDemo("John", 123);
        HashcodeDemo demo2 = new HashcodeDemo("Jane", 456);

        // Display object details
        System.out.println(demo1);
        System.out.println("Hashcode of demo1: " + demo1.hashCode());

        System.out.println(demo2);
        System.out.println("Hashcode of demo2: " + demo2.hashCode());
    }
}
