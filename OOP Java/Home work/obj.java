class LightBulb {
    boolean on = false;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }

    public void check() {
        if (on)
            System.out.println("On");
        else
            System.out.println("Off");
    }
}

class Car {
    double gas = 0;
    double running = 0;
    double efficiency = 0;

    public void drive(double x) {
        running += x;
        gas = gas - (running / efficiency);
    }

    public void loadgas(double gas) {
        this.gas += gas;
    }

    public void changeEfficiency(double eff) {
        efficiency = eff;
    }

    public void checkGas() {
        System.out.printf("%.2fL", gas);
    }

    public void checkOdometer() {
        System.out.println("\nTotal: " + running);
    }
}

class BankAccount {
    double balance = 0;

    public void deposit(double x) {
        balance += x;
    }

    public void withdraw(double x) {
        balance -= x;
    }

    public void checkBalance() {
        System.out.printf("Your Balance: %.2f", balance);
    }
}

public class obj {
    public static void main(String[] args) {
        LightBulb lt = new LightBulb();
        lt.switchOn();
        lt.check();
        lt.switchOff();
        lt.check();
        System.out.println("----------");
        Car c = new Car();
        c.changeEfficiency(13);
        c.gas = 20.0;
        c.drive(20);
        c.checkGas();
        c.checkOdometer();
        System.out.println("----------");
        BankAccount ba = new BankAccount();
        ba.deposit(10200);
        ba.withdraw(3298.87);
        ba.checkBalance();
    }
}