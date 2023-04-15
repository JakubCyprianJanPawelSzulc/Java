import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> grades = new ArrayList<Double>();

    public void addGrade(double grade) {
        if (grade < 2 || grade > 5) {
            return;
        }
        else{
            grades.add(grade);
        }
    }

    public double getAverage() {
        double sum = 0;
        if (grades.isEmpty()) {
            return 0;
        }
        else{
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }

    public double getHighest() {
        double highest = 0;
        if (grades.isEmpty()){
            return 0;
        }
        else{
            for (double grade : grades) {
                if (grade > highest) {
                    highest = grade;
                }
            }
            return highest;
        }
    }

    public double getLowest() {
        double lowest = 7;
        if (grades.isEmpty()){
            return 0;
        }
        else{
            for (double grade : grades) {
                if (grade < lowest) {
                    lowest = grade;
                }
            }
            return lowest;
        }
    }
}
