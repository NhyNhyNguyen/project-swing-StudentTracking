/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentStatus;
import entity.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author qphan
 */
public class StudentModel extends AbstractTableModel {

    private List<Student> list;
    private String[] cols = {"STT", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Nơi công tác", "Tình trạng"};

    public StudentModel() {
        this.list = new ArrayList<>();

        // mock data
        list.add(new Student(0, "Lê Văn Tèo", true, LocalDate.now(), "1234567890", "nothing@gmail.com", "https://www.facebook.com/qphan259", "Software Engineer at mgm technology partners Vietnam", "", "Ở nhà", StudentStatus.INPROGRESS));
        list.add(new Student(1, "Lê Văn Hoàng", true, LocalDate.now(), "1234567890", "nothing@gmail.com", "https://www.facebook.com/qphan259", "Software Engineer at mgm technology partners Vietnam", "", "Trường ĐH BK Đà Nẵng", StudentStatus.INPROGRESS));
        list.add(new Student(2, "Lê Văn Phong", false, LocalDate.now(), "1234567890", "nothing@gmail.com", "https://www.facebook.com/qphan259", "Software Engineer at mgm technology partners Vietnam", "", "Trường ĐH SP Đà Nẵng", StudentStatus.WAITING));
        list.add(new Student(3, "Lê Văn Thần", true, LocalDate.now(), "1234567890", "nothing@gmail.com", "https://www.facebook.com/qphan259", "Software Engineer at mgm technology partners Vietnam", "", "Trường ĐH BK Đà Nẵng", StudentStatus.INPROGRESS));
        list.add(new Student(4, "Lê Văn Gió", false, LocalDate.now(), "1234567890", "nothing@gmail.com", "https://www.facebook.com/qphan259", "Software Engineer at mgm technology partners Vietnam", "", "Trường ĐH SP Đà Nẵng", StudentStatus.WAITING));
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
