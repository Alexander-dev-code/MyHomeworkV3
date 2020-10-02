import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersService implements Service<User> {
    @Override
    public Collection<User> findAll() {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("type")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during DB-query");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public User findById(int id) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("type")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during DB-query", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(User object) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, type = ? WHERE id = ?");
            statement.setString(1, object.getName());
            statement.setInt(2, object.getType());
            statement.setInt(3, object.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during DB-query", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean add(User object) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, type) VALUES (?, ?)");
            statement.setString(1, object.getName());
            statement.setInt(2, object.getType());
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during DB-query");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
