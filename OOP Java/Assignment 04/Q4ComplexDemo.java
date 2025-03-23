class Complex {
    double real, imaginary;

    Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    }

    Complex multiply(Complex c) {
        return new Complex(
                this.real * c.real - this.imaginary * c.imaginary,
                this.real * c.imaginary + this.imaginary * c.real);
    }

    void display() {
        System.out.println(real + " + " + imaginary + "i");
    }
}

public class Q4ComplexDemo {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(4, -2);

        Complex sum = c1.add(c2);
        Complex product = c1.multiply(c2);

        System.out.print("Sum: ");
        sum.display();
        System.out.print("Product: ");
        product.display();
    }
}
