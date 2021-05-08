/*
 * Created by JFormDesigner on Sat May 08 09:55:10 AMT 2021
 */

package GUI;

import student.Student;
import student.StudentService;

import java.awt.event.*;
import java.util.StringJoiner;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class _AboutStudentGUI extends JFrame {
    public _AboutStudentGUI(_StudentManagementGUI parentGUI) {
        this.parentGUI = parentGUI;
        this.studentService = new StudentService();
        initComponents();
    }

    private void closeAboutStudentHandler(MouseEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Full Name: ");

        //---- label2 ----
        label2.setText("Student ID: ");

        //---- label3 ----
        label3.setText("GPA: ");

        //---- label4 ----
        label4.setText("Year: ");

        //---- label5 ----
        label5.setText("Semester: ");

        //---- label6 ----
        label6.setText("Department: ");

        //---- label7 ----
        label7.setText("Current Courses: ");

        Student student = parentGUI.getList1().getSelectedValue();
        setStudentInfo(student);

        //---- button1 ----
        button1.setText("OK");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeAboutStudentHandler(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(button1)
                                                .addGap(8, 8, 8))
                                        .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void setStudentInfo(Student student) {
        label1.setText(label1.getText() + student.getName() + " " + student.getSurname());

        label2.setText(label2.getText() + student.getStudentID());

        label3.setText(label3.getText() + student.getGPA());

        label4.setText(label4.getText() + student.getYear());

        label5.setText(label5.getText() + student.getSemester());

        label6.setText(label6.getText() + student.getDepartment());

        StringJoiner sj = new StringJoiner(", ");
        student.getCurrentCourses().forEach(course -> sj.add(course.getCourseName()));

        label7.setText(label7.getText() + sj);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private _StudentManagementGUI parentGUI;
    private StudentService studentService;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
