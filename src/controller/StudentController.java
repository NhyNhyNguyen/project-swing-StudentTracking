/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import model.StudentTableModel;
import rerender.MiddleCellRender;
import view.sub.FrStudentAdd;

/**
 *
 * @author qphan
 */
public class StudentController {

    private JTable tbStudent;
    private JTextField tfSearch;
    private JButton btExport;
    private JButton btAdd;

    private StudentTableModel studentModel;

    public StudentController(final JTable tbStudent, final JTextField tfSearch, final JButton btExport, final JButton btAdd) {
        this.tbStudent = tbStudent;
        this.tfSearch = tfSearch;
        this.btExport = btExport;
        this.btAdd = btAdd;

        studentModel = new StudentTableModel();
    }

    public StudentController(JTextField tfStudentId, JTextField tfFullname, JDateChooser dcDateOfBirth, JTextField tfPhone, JRadioButton rdNam, JRadioButton rdNu, ButtonGroup genderGroup, JTextField tfFacebook, JTextArea taAddress, JTextArea taDesc, JTextField tfWorkplace, JLabel lbMessage) {

    }

    public void loadData() {
        tbStudent.setModel(studentModel);
        resetTable();
    }

    private void resetTable() {
        final Dimension dim = new Dimension(0, 32);
        tbStudent.getTableHeader().setPreferredSize(dim);
        tbStudent.getTableHeader().setReorderingAllowed(false);

        tbStudent.setRowHeight(26);

        tbStudent.getColumnModel().getColumn(6).setPreferredWidth(130);
        tbStudent.getColumnModel().getColumn(5).setPreferredWidth(400);
        tbStudent.getColumnModel().getColumn(4).setPreferredWidth(130);
        tbStudent.getColumnModel().getColumn(3).setPreferredWidth(65);
        tbStudent.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbStudent.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbStudent.getColumnModel().getColumn(0).setPreferredWidth(65);

        final MiddleCellRender middle = new MiddleCellRender();
        tbStudent.getColumnModel().getColumn(0).setCellRenderer(middle);
        tbStudent.getColumnModel().getColumn(1).setCellRenderer(middle);
        tbStudent.getColumnModel().getColumn(2).setCellRenderer(middle);
        tbStudent.getColumnModel().getColumn(4).setCellRenderer(middle);
        tbStudent.getColumnModel().getColumn(6).setCellRenderer(middle);
    }

    public void setEvents() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final String fSearch = tfSearch.getText().trim();

                // Provide to sorting and filtering data in table
                final TableRowSorter tableRowSorter = new TableRowSorter(tbStudent.getModel());
                tbStudent.setRowSorter(tableRowSorter);

                RowFilter<AbstractTableModel, Object> filterByName = RowFilter.regexFilter("(?i)" + fSearch);
                tableRowSorter.setRowFilter(filterByName);
            }
        });

        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                FrStudentAdd frStudentAdd = new FrStudentAdd(tbStudent);
                frStudentAdd.setVisible(true);
                frStudentAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
