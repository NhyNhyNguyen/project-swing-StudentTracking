/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import model.StudentModel;

/**
 *
 * @author qphan
 */
public class StudentController {

    private final JTable tbStudent;
    private JTextField tfSearch;
    private final JButton btExport;
    private final JButton btAdd;

    private final StudentModel studentModel;

    public StudentController(final JTable tbStudent, final JTextField tfSearch, final JButton btExport, final JButton btAdd) {
        this.tbStudent = tbStudent;
        this.tfSearch = tfSearch;
        this.btExport = btExport;
        this.btAdd = btAdd;

        studentModel = new StudentModel();
    }

    public void loadData() {
        tbStudent.setModel(studentModel);
        resetTable();
    }

    private void resetTable() {

        tbStudent.getTableHeader().setReorderingAllowed(false);

        final Dimension dim = new Dimension(0, 32);
        tbStudent.getTableHeader().setPreferredSize(dim);
        tbStudent.setRowHeight(26);

        tbStudent.getColumnModel().getColumn(6).setPreferredWidth(130);
        tbStudent.getColumnModel().getColumn(5).setPreferredWidth(400);
        tbStudent.getColumnModel().getColumn(4).setPreferredWidth(130);
        tbStudent.getColumnModel().getColumn(3).setPreferredWidth(65);
        tbStudent.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbStudent.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbStudent.getColumnModel().getColumn(0).setPreferredWidth(65);

        tbStudent.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setHorizontalAlignment(SwingConstants.CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });

    }

}
