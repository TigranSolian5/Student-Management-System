package student.gpa;

import exceptions.InvalidArgumentException;

public class GPAService {
    public enum GPAType {
        LETTER,
        PERCENT,
        FOUR
    }

    public static String getLetterValue(int percentValue) {
        if (percentValue < 0 || percentValue > 100) {
            throw new InvalidArgumentException("Invalid Value for GPA");
        }

        if (percentValue >= 97)
            return "A+";
        else if (percentValue >= 93)
            return "A";
        else if (percentValue >= 89)
            return "A-";
        else if (percentValue >= 86)
            return "B+";
        else if (percentValue >= 82)
            return "B";
        else if (percentValue >= 79)
            return "B-";
        else if (percentValue >= 76)
            return "C+";
        else if (percentValue >= 72)
            return "C";
        else if (percentValue >= 69)
            return "C-";
        else if (percentValue >= 66)
            return "D+";
        else if (percentValue >= 62)
            return "D";
        else if (percentValue >= 60)
            return "D-";
        else
            return "F";
    }
}
