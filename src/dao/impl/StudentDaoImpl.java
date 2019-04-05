/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import common.StudentStatus;
import dao.StudentDao;
import entity.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionProvider;
import jdbc.JdbcConnectionProvider;
import utils.DateUtils;

/**
 *
 * @author qphan
 */
public class StudentDaoImpl implements StudentDao {
    
    private ConnectionProvider connectionProvider;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public StudentDaoImpl() {
        this.connectionProvider = new JdbcConnectionProvider();
        conn = connectionProvider.getConnection();
    }
    
    @Override
    public List<Student> getAllStudents() {
        final List<Student> students = new ArrayList<>();
        final String sql = "SELECT * FROM student";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("STUDENT_ID"));
                student.setFullname(rs.getString("FULLNAME"));
                student.setDateOfBirth(DateUtils.convertSDateToLDate(rs.getDate("DATE_OF_BIRTH")));
                student.setGender(rs.getBoolean("GENDER"));
                student.setPhone(rs.getString("PHONE"));
                student.setWorkplace(rs.getString("WORK_PLACE"));
                student.setStatus(StudentStatus.getNameFromValue(rs.getString("STATUS")));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return students;
    }
    
}
