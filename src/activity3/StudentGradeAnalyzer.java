package activity3;

public class StudentGradeAnalyzer {
    private int totalScore;
    private int numberOfGrades;
    private double average;
    private String gradeStatus;

    public void processGrade(int score) {
        // Definition point (d) for totalScore
        totalScore = totalScore + score;
        
        // Definition point (d) for numberOfGrades
        numberOfGrades = numberOfGrades + 1;
        
        // Computation-use (c-use) of totalScore and numberOfGrades
        average = (double) totalScore / numberOfGrades;
        
        // Predicate-use (p-use) of average
        if (average >= 90) {
            gradeStatus = "Excellent";
        } else if (average >= 80) {
            gradeStatus = "Good";
        } else if (average >= 70) {
            gradeStatus = "Satisfactory";
        } else {
            gradeStatus = "Needs Improvement";
        }
    }

    public double getAverage() {
        // Computation-use (c-use) of average
        return average;
    }

    public String getGradeStatus() {
        // Computation-use (c-use) of gradeStatus
        return gradeStatus;
    }

    public void reset() {
        // Definition points (d) for all variables
        totalScore = 0;
        numberOfGrades = 0;
        average = 0.0;
        gradeStatus = "No grades processed";
    }
} 