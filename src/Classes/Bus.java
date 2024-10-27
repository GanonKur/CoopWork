package Classes;

public class Bus implements Comparable<Bus>{
    private  final int number;
    private  final String model;
    private  final int mileage;

    public Bus(int number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }
    @Override
    public int compareTo(Bus other) {
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
}
