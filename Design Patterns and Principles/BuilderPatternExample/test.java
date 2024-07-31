public class Computer {
    private String CPU;
    private String GPU;
    private String RAM;
    private String storage;
    private boolean isBluetoothEnabled;
    private boolean isWiFiEnabled;

    // Private constructor to enforce the use of the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.GPU = builder.GPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWiFiEnabled = builder.isWiFiEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isWiFiEnabled=" + isWiFiEnabled +
                '}';
    }

    // Static inner Builder class
    public static class Builder {
        private String CPU;
        private String GPU;
        private String RAM;
        private String storage;
        private boolean isBluetoothEnabled;
        private boolean isWiFiEnabled;

        // Required parameter
        public Builder(String CPU) {
            this.CPU = CPU;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Builder setWiFiEnabled(boolean isWiFiEnabled) {
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class test {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println(basicComputer);

        // Create a high-end computer with optional features
        Computer highEndComputer = new Computer.Builder("Intel i9")
                .setGPU("NVIDIA RTX 3080")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setBluetoothEnabled(true)
                .setWiFiEnabled(true)
                .build();
        System.out.println(highEndComputer);
    }
}

