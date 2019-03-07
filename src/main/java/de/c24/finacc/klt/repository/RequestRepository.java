package de.c24.finacc.klt.repository;

import de.c24.finacc.klt.entity.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * @author Sarkhan Rasullu
 */
@Repository
public class RequestRepository {


    /**
     * jdbc template dependency
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * save
     *
     * @return inserted request id
     */
    public long save(Request r) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into request(name, surname, age) values(?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection
                        .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, r.getFirstName());
                ps.setString(2, r.getLastName());
                ps.setInt(3, r.getAge());
                return ps;
            }
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    /**
     * getAll
     *
     * @return all requests
     */
    public List<Request> getAll() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "select * from request";
        List<Request> list = jdbcTemplate.query(query, new RowMapper<Request>() {

            @Override
            public Request mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");

                return new Request(id, name, surname, age);
            }
        });

        return list;
    }

    /**
     * delete
     *
     * @return delete
     */
    public int delete(int id) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "delete from request where id = ?";
        jdbcTemplate.update(query, id);
        return id;
    }

}
