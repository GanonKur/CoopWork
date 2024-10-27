public class Student implements Comparable<Student>    {
    private final int groupNumber;
    private final float averageScore;
    private final String studentIdCard;

    public Student(int groupNumber, float averageScore, String studentIdCard) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentIdCard = studentIdCard;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getStudentIdCard() {
        return studentIdCard;
    }
    @Override
    public int compareTo(Student other) {

        int numberCompare = Integer.compare(this.groupNumber, other.groupNumber);
        if (numberCompare != 0) {
            return numberCompare;
        }

        int mileageCompare = Float.compare(this.averageScore, other.averageScore);
        if (mileageCompare != 0) {
            return mileageCompare;
        }

        return this.studentIdCard.compareTo(other.studentIdCard);
    }

    public static class StudentBuilder {
        private int groupNumber;
        private double averageScore;
        private String studentIdCard;

        public StudentBuilder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAverageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }


        public StudentBuilder setStudentIdCard(String studentIdCard) {
            this.studentIdCard = studentIdCard;
            return this;
        }

        public Student build() {
            if (groupNumber <= 0 || averageScore < 0 || studentIdCard == null || studentIdCard.isEmpty()) {
                throw new IllegalArgumentException("Некорректные данные для создания студента");}


                return new Student(5, 3, "миш20");
            }

        }
    }



