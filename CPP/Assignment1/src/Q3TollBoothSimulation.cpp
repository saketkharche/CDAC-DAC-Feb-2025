#include <iostream>
using namespace std;

class TollBooth {
private:
    int totalVehicles;
    double totalRevenue;

public:
    TollBooth() : totalVehicles(0), totalRevenue(0.0) {}

    void reset() {
        totalVehicles = 0;
        totalRevenue = 0.0;
        cout << "Statistics reset successfully.\n";
    }

    void vehiclePayingToll(int vehicleType, double tollAmount) {
        totalVehicles++;
        totalRevenue += tollAmount;
        cout << "Toll collected: $" << tollAmount << "\n";
    }

    int getTotalVehicles() { return totalVehicles; }
    double getTotalRevenue() { return totalRevenue; }
};

int main() {
    TollBooth booth;
    int choice;
    do {
        cout << "\n--- Toll Booth Menu ---\n"
             << "1. Add Standard Car ($2)\n2. Add Truck ($5)\n3. Add Bus ($10)\n"
             << "4. Show Total Vehicles\n5. Show Total Revenue\n"
             << "6. Reset\n7. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
        case 1: booth.vehiclePayingToll(1, 2); break;
        case 2: booth.vehiclePayingToll(2, 5); break;
        case 3: booth.vehiclePayingToll(3, 10); break;
        case 4: cout << "Total Vehicles: " << booth.getTotalVehicles() << endl; break;
        case 5: cout << "Total Revenue: $" << booth.getTotalRevenue() << endl; break;
        case 6: booth.reset(); break;
        case 7: cout << "Exiting Toll Booth...\n"; break;
        default: cout << "Invalid choice.\n";
        }
    } while (choice != 7);
    return 0;
}
