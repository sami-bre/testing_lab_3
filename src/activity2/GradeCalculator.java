package sample;

public class GradeCalculator {
    public String calculateGrade(int score, boolean isExtraCredit) {
        String grade;
        
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else {
            grade = "F";
        }
        
        if (isExtraCredit && score < 90) {
            grade += "+";
        }
        
        return grade;
    }
} 