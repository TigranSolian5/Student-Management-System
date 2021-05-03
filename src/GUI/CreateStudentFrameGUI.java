/*
 * Created by JFormDesigner on Sun May 02 21:08:02 AMT 2021
 */

package GUI;

import student.Department;
import student.Student;
import student.StudentService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CreateStudentFrameGUI extends JFrame {
    private StudentManagementGUI parentGUI;

    public CreateStudentFrameGUI(StudentManagementGUI parentGUI) {
        this.parentGUI = parentGUI;
        initComponents();
    }

    private void closeCreateStudentFrame(MouseEvent e) {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void createStudent(MouseEvent e) {
        StudentService studentService = new StudentService();

        String firstName = textField1.getText();
        String lastName = textField2.getText();
        String dep = buttonGroup1.getSelection().getActionCommand();

        if (dep != null) {
            Student newStudent = studentService.addStudent(firstName, lastName, Department.valueOf(dep));
            System.out.println(newStudent.getStudentID());

            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton1.setActionCommand("CS");
        radioButton2 = new JRadioButton();
        radioButton2.setActionCommand("DS");
        radioButton3 = new JRadioButton();
        radioButton3.setActionCommand("ES");
        radioButton4 = new JRadioButton();
        radioButton4.setActionCommand("EC");
        radioButton5 = new JRadioButton();
        radioButton5.setActionCommand("BAB");
        button1 = new JButton();
        button2 = new JButton();
        buttonGroup1 = new ButtonGroup();

        //======== this ========
        setTitle("Create New Student");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("First Name:");

        //---- textField1 ----
        textField1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //---- label2 ----
        label2.setText("Last Name:");

        //---- label3 ----
        label3.setText("Department:");

        //---- radioButton1 ----
        radioButton1.setText("Computer Science");

        //---- radioButton2 ----
        radioButton2.setText("Data Science");

        //---- radioButton3 ----
        radioButton3.setText("Engineering Science");

        //---- radioButton4 ----
        radioButton4.setText("English & Communications");

        //---- radioButton5 ----
        radioButton5.setText("Business");

        //---- button1 ----
        button1.setText("Cancel");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeCreateStudentFrame(e);
            }
        });

        //---- button2 ----
        button2.setText("Create");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createStudent(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(radioButton2)
                                .addComponent(radioButton3)
                                .addComponent(radioButton4)
                                .addComponent(radioButton5)
                                .addComponent(radioButton1))
                            .addContainerGap(288, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 306, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(radioButton1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(radioButton2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioButton3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(radioButton4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(radioButton5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        buttonGroup1.add(radioButton5);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JButton button1;
    private JButton button2;
    private ButtonGroup buttonGroup1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
