package Classes;

public class Student implements Comparable<Student>{
    private  int groupNumber;
    private  float averageScore;
    private   int studentIdCard;

    public Student(int groupNumber, float averageScore, int studentIdCard) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentIdCard = studentIdCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "groupNumber='" + groupNumber + '\'' +
                ", averageScore='" + averageScore + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                '}';
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

        return Integer.compare(this.studentIdCard,other.studentIdCard);
    }
}
