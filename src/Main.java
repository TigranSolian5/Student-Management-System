import GUI.StudentManagementGUI;
import GUI._StudentManagementGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse("15-01-2021"));

        _StudentManagementGUI gui = new _StudentManagementGUI();
    }
}