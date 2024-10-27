package Classes;

public class Bus implements Comparable<Bus> {
    private final int number;
    private final String model;
    private final int mileage;

    public Bus(int number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Bus other) {
        // Сортировка сначала по номеру автобуса, потом по пробегу, затем по модели
        int numberCompare = Integer.compare(this.number, other.number);
        if (numberCompare != 0) {
            return numberCompare;
        }

        int mileageCompare = Integer.compare(this.mileage, other.mileage);
        if (mileageCompare != 0) {
            return mileageCompare;
        }

        return this.model.compareTo(other.model);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", mileage='" + mileage + '\'' +
                '}';
    }

    public  static class BusBuilder {
        private int number;
        private String model;
        private int mileage;

        public  BusBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(number, model, mileage);
        }

    }
}

