/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Student;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 *
 * @author qphan
 */
public class StudentTableModel extends AbstractTableModel {

    private final StudentService studentService;

    private List<Student> list;
    private String[] cols = {"STT", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Nơi công tác", "Tình trạng"};

    public StudentTableModel() {
        studentService = new StudentServiceImpl();
        list = studentService.getAllStudents();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int index) {
        return cols[index];
    }

    @Override
    public Class<?> getColumnClass(int cindex) {
        if (cindex == 0) {
            return Integer.class;
        }
        if (cindex == 2) {
            return LocalDate.class;
        }
        if (cindex == 3) {
            return Boolean.class;
        }
        return super.getColumnClass(cindex);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object object = null;
        final Student student = list.get(row);
        switch (column) {
            case 0:
                object = student.getId();
                break;
            case 1:
                object = student.getFullname();
                break;
            case 2:
                object = student.getDateOfBirth();
                if (object == null) {
                    object = "--/--/--";
                }
                break;
            case 3:
                object = student.isGender();
                break;
            case 4:
                object = student.getPhone();
                break;
            case 5:
                object = student.getWorkplace();
                break;
            case 6:
                object = student.getStatus().getValue();
                break;
        }
        return object;
    }

}
