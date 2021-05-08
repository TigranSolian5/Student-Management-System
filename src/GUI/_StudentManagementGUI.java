/*
 * Created by JFormDesigner on Thu Apr 29 17:57:23 AMT 2021
 */

package GUI;

import course.Course;
import course.CourseService;
import student.Student;
import student.StudentService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class _StudentManagementGUI extends JFrame {
    public _StudentManagementGUI() {
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        initComponents();
    }

    private void createStudentHandler(MouseEvent e) {
        EventQueue.invokeLater(() -> {
            _CreateStudentFrameGUI createStudentFrameGUI = new _CreateStudentFrameGUI(this);
            createStudentFrameGUI.setVisible(true);
            createStudentFrameGUI.pack();
        });
    }

    private void aboutHandler(MouseEvent e) {
        EventQueue.invokeLater(() -> {
            _AboutStudentGUI aboutStudentGUI = new _AboutStudentGUI(this);
            aboutStudentGUI.setVisible(true);
            aboutStudentGUI.pack();
        });
    }

    private void deleteStudentHandler(MouseEvent e) {
        Student student = list1.getSelectedValue();

        studentService.deleteStudent(student);
        demoList1.removeElement(student);
    }

    private void createCourseHandler(MouseEvent e) {
        EventQueue.invokeLater(() -> {
            _CreateCourseFrameGUI createCourseFrameGUI = new _CreateCourseFrameGUI(this);
            createCourseFrameGUI.setVisible(true);
            createCourseFrameGUI.pack();
        });
    }

    private void addStudentsHandler(MouseEvent e) {
        EventQueue.invokeLater(() -> {
            _EnrollStudentsCourseGUI enrollStudentsCourseGUI = new _EnrollStudentsCourseGUI(this);
            enrollStudentsCourseGUI.setVisible(true);
            enrollStudentsCourseGUI.pack();
        });
    }

    private void deleteCourseHandler(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();

        demoList1 = studentService.getAllStudents();
        list1 = new JList<>(demoList1);
        button1 = new JButton();
        aboutButton = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();

        demoList2 = courseService.getAllCourses();
        list2 = new JList<>(demoList2);
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setVisible(true);
        setForeground(UIManager.getColor("Panel.background"));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(LineBorder.createBlackLineBorder());
            {
                scrollPane1.setBackground(new Color(102, 102, 102));
                scrollPane1.setViewportView(list1);
            }

            //---- button1 ----
            button1.setText("Create Student");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    createStudentHandler(e);
                }
            });

            aboutButton.setText("About");
            aboutButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aboutHandler(e);
                }
            });

            //---- button2 ----
            button2.setText("Delete Student");
            button2.setForeground(UIManager.getColor("Button.foreground"));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    deleteStudentHandler(e);
                }
            });

            //---- label1 ----
            label1.setText("Students");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setBackground(UIManager.getColor("Label.background"));
            label1.setForeground(new Color(31, 31, 31));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                    .addComponent(aboutButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(scrollPane1))
                                    .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(aboutButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(LineBorder.createBlackLineBorder());

            //---- label2 ----
            label2.setText("Courses");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setBackground(UIManager.getColor("Label.background"));
            label2.setForeground(new Color(45, 45, 45));

            //======== scrollPane2 ========
            {
                scrollPane2.setBackground(new Color(102, 102, 102));
                scrollPane2.setViewportView(list2);
            }

            //---- button3 ----
            button3.setText("Create");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    createCourseHandler(e);
                }
            });

            //---- button4 ----
            button4.setText("Assign Students");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addStudentsHandler(e);
                }
            });

            //---- button5 ----
            button5.setText("Delete");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    deleteCourseHandler(e);
                }
            });

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(button4, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(button5, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(button3)
                                            .addComponent(button4)
                                            .addComponent(button5))
                                    .addContainerGap(7, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public DefaultListModel<Student> getStudentDemoList() {
        return demoList1;
    }

    public DefaultListModel<Course> getCourseDemoList() {
        return demoList2;
    }

    public JList<Student> getList1() {
        return list1;
    }

    public JList<Course> getList2() {
        return list2;
    }

    public void setList1(DefaultListModel<Student> demoList1) {
        list1.setModel(demoList1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private StudentService studentService;
    private CourseService courseService;
    private JPanel panel1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private DefaultListModel<Student> demoList1;
    private DefaultListModel<Course> demoList2;
    private JList<Student> list1;
    private JButton button1;
    private JButton aboutButton;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList<Course> list2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
