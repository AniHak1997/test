package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersNotesRepository {
    private DataSource dataSource;
    public UsersNotesRepository(DataSource dataSource) { this.dataSource = dataSource; }

    public void add(String note,int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users_notes(user_notes,user_id) VALUES(?,?);");
        preparedStatement.setString(1, note);
        preparedStatement.setInt(2,id);
        int result = preparedStatement.executeUpdate();
        System.out.println(result);
        preparedStatement.close();
    }

}
