package Classes;

public class Student implements Comparable<Student>    {
    private final int groupNumber;
    private final float averageScore;
    private final int studentIdCard;

    public Student(int groupNumber, float averageScore, int studentIdCard) {
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

    public int getStudentIdCard() {
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

        return Integer.compare(this.studentIdCard, other.studentIdCard);
    }
    @Override
    public String toString() {
        return "Student{" +
                "groupNumber='" + groupNumber + '\'' +
                ", averageScore='" + averageScore + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private int groupNumber;
        private float averageScore;
        private int studentIdCard;

        public StudentBuilder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAverageScore(float averageScore) {
            this.averageScore = averageScore;
            return this;
        }


        public StudentBuilder setStudentIdCard(int studentIdCard) {
            this.studentIdCard = studentIdCard;
            return this;
        }

        public Student build() {
            if (groupNumber <= 0 || averageScore < 0  ) {
                throw new IllegalArgumentException("Некорректные данные для создания студента");}


                return new Student(groupNumber, averageScore, studentIdCard);
            }

        }
    }



