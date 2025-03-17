// Interface Photosynthesis
interface Photosynthesis {
    void absorbSunlight();
}

// Interface Respiration
interface Respiration {
    void releaseOxygen();
}

// Concrete class Plant implementing multiple inheritance
class Plant implements Photosynthesis, Respiration {
    private String plantName;

    // Constructor
    public Plant(String name) {
        this.plantName = name;
    }

    // Getter
    public String getPlantName() {
        return plantName;
    }

    @Override
    public void absorbSunlight() {
        System.out.println(plantName + " is absorbing sunlight for photosynthesis.");
    }

    @Override
    public void releaseOxygen() {
        System.out.println(plantName + " is releasing oxygen through respiration.");
    }
}

// Test program
public class TestPlant {
    public static void main(String[] args) {
        Plant mangoTree = new Plant("Mango Tree");
        System.out.println("Plant Name: " + mangoTree.getPlantName());
        mangoTree.absorbSunlight();
        mangoTree.releaseOxygen();

        System.out.println();

        Plant fern = new Plant("Fern");
        System.out.println("Plant Name: " + fern.getPlantName());
        fern.absorbSunlight();
        fern.releaseOxygen();
    }
}
