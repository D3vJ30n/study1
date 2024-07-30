import java.util. *;
import java.text.SimpleDateFormat;

class Plant {
    String name;
    int wateringFrequency;
    Date lastWatered;
    String type;
    String sunlight;

    public Plant(String name, int wateringFrequency, String type, String sunlight) {
        this.name = name;
        this.wateringFrequency = wateringFrequency;
        this.lastWatered = new Date();
        this.type = type;
        this.sunlight = sunlight;
    }

    public boolean needsWatering() {
        Date now = new Date();
        long diff = now.getTime() - lastWatered.getTime();
        long daysDiff = diff / (24 * 60 * 60 * 1000);
        return daysDiff >= wateringFrequency;
    }

    public void water() {
        lastWatered = new Date();
    }

    public String getStatus() {
        return needsWatering()
            ? "Needs water!"
            : "Doing well";
    }
}

public class Practice {
    List<Plant> plants = new ArrayList<>();
    Scanner scanner = new Scanner(System. in);

    // ANSI 색상 코드
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public Practice() {
        // 미리 정의된 식물들을 추가합니다.
        addPlant("Ficus", 7, "Tree", "Bright indirect");
        addPlant("Orchid", 10, "Flowering", "Medium indirect");
        addPlant("Cactus", 14, "Succulent", "Direct sunlight");
        addPlant("Spider Plant", 5, "Hanging", "Low to bright indirect");
        addPlant("Snake Plant", 14, "Succulent", "Low to bright indirect");
    }

    public void addPlant(
        String name,
        int wateringFrequency,
        String type,
        String sunlight
    ) {
        plants.add(new Plant(name, wateringFrequency, type, sunlight));
    }

    public void displayPlants() {
        System
            .out
            .println(
                "\n" + GREEN + "🪴 Your Plant Collection 🪴" + RESET
            );
        System
            .out
            .println(
                YELLOW + "----------------------------------------------" + RESET
            );
        System
            .out
            .printf(
                CYAN + "%-15s | %-10s | %-15s | %-12s | %s\n" + RESET,
                "Name",
                "Type",
                "Sunlight",
                "Status",
                "Last Watered"
            );
        System
            .out
            .println(
                YELLOW + "----------------------------------------------" + RESET
            );
        for (Plant plant : plants) {
            System
                .out
                .printf(
                    PURPLE + "%-15s" + RESET + " | " + BLUE + "%-10s" + RESET + " | " + GREEN + "%-" +
                            "15s" + RESET + " | " + YELLOW + "%-12s" + RESET + " | " + CYAN + "%s\n" +
                            RESET,
                    plant.name,
                    plant.type,
                    plant.sunlight,
                    plant.getStatus(),
                    new SimpleDateFormat("yyyy-MM-dd").format(plant.lastWatered)
                );
        }
        System
            .out
            .println(
                YELLOW + "----------------------------------------------" + RESET
            );
    }

    public void waterPlant(String name) {
        for (Plant plant : plants) {
            if (plant.name.equalsIgnoreCase(name)) {
                plant.water();
                System
                    .out
                    .println(
                        "\n" + BLUE + "💧 " + plant.name + " has been watered." + RESET
                    );
                return;
            }
        }
        System
            .out
            .println("\n" + YELLOW + "❌ Plant not found: " + name + RESET);
    }

    public void displayLogo() {
        System
            .out
            .println(
                GREEN + "    ____  __          __     ____                \n   / __ \\/ /___ __" +
                "___/ /_   / __ \\____ __________\n  / /_/ / / __ `/ __  / /  / /_/ / __ `/ ___" +
                "/ __ \\\n / ____/ / /_/ / /_/ / /  / ____/ /_/ / /  / / / /\n/_/   /_/\\__,_/" +
                "\\__,_/_/  /_/    \\__,_/_/  /_/ /_/ \n                                       " +
                "           " + RESET
            );
    }

    public void run() {
        displayLogo();
        System
            .out
            .println(CYAN + "\nWelcome to Plant Care App!" + RESET);
        System
            .out
            .println(
                PURPLE + "We've added some common plants for you to start with.\n" + RESET
            );

        while (true) {
            System
                .out
                .println(GREEN + "\n🌿 Main Menu 🌿" + RESET);
            System
                .out
                .println(YELLOW + "1. " + RESET + "View all plants");
            System
                .out
                .println(YELLOW + "2. " + RESET + "Water a plant");
            System
                .out
                .println(YELLOW + "3. " + RESET + "Add a new plant");
            System
                .out
                .println(YELLOW + "4. " + RESET + "Exit");
            System
                .out
                .print(CYAN + "Choose an option: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayPlants();
                    break;
                case 2:
                    System
                        .out
                        .print(PURPLE + "Enter plant name to water: " + RESET);
                    String plantToWater = scanner.nextLine();
                    waterPlant(plantToWater);
                    break;
                case 3:
                    System
                        .out
                        .print(PURPLE + "Enter plant name: " + RESET);
                    String name = scanner.nextLine();
                    System
                        .out
                        .print(
                            PURPLE + "Enter watering frequency (in days): " + RESET
                        );
                    int frequency = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System
                        .out
                        .print(PURPLE + "Enter plant type: " + RESET);
                    String type = scanner.nextLine();
                    System
                        .out
                        .print(PURPLE + "Enter sunlight needs: " + RESET);
                    String sunlight = scanner.nextLine();
                    addPlant(name, frequency, type, sunlight);
                    System
                        .out
                        .println(
                            GREEN + "\n🌱 " + name + " has been added to your plant list." + RESET
                        );
                    break;
                case 4:
                    System
                        .out
                        .println(
                            CYAN + "\nThank you for using Plant Care App! Goodbye! 👋" + RESET
                        );
                    return;
                default:
                    System
                        .out
                        .println(
                            YELLOW + "Invalid option. Please try again." + RESET
                        );
            }
        }
    }

    public static void main(String[] args) {
        new Practice().run();
    }
}