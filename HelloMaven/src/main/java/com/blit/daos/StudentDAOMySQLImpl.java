package com.blit.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blit.models.Student;
import com.blit.utils.ConnectionUtil;

public class StudentDAOMySQLImpl implements StudentDAO {

    @Override
    public boolean addNewStudent(Student student) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            // Using prepared statement to avoid SQL injection.
            // ? will be replaced by values in the prepared statement.
            String sql = "INSERT INTO students "+
                "(s_name, gender, gpa ) VALUES"+
                "(?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Assign variable values.
            statement.setString(1, student.getName());
            statement.setString(2, student.getGender());
            statement.setDouble(3, student.getGpa());

            statement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }

    @Override
    public boolean updateStudentRecord(Student student) {
        return false;
    }

    @Override
    public List<Student> findAllStudents() {
        // Try with resources will auto-construct a finally block for the 
        // resource open with the try statement. Auto closes conn.
        // Anything that implements AutoCloseable.

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM students";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Student> students = new ArrayList<>();

            while(result.next()) {
                // Move cursor through the rows. Moves the cursor.
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("s_name"));
                student.setGender(result.getString("gender"));
                student.setGpa(result.getDouble("gpa"));

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findStudentById(int id) {
        return new Student();
    }
    
}
