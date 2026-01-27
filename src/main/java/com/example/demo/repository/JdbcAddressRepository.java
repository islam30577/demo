package com.example.demo.repository;

import com.example.demo.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcAddressRepository {
 
    private final JdbcTemplate jdbcTemplate;

    public JdbcAddressRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Address> rowMapper = new RowMapper<Address>() {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setId(rs.getLong("id"));
            address.setPerson(rs.getString("person"));
            address.setCityId(rs.getLong("city_id"));
            address.setStreet(rs.getString("street"));
            address.setBuilding(rs.getString("building"));
            address.setOffice(rs.getString("office"));
            return address;
        }
    };


    public List<Address> findAll() {
        String sql = "SELECT id, person, city_id, street, building, office FROM addresses ORDER BY person";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Address> findById(Long id) {
        String sql = "SELECT id, person, city_id, street, building, office FROM addresses WHERE id = ?";
        List<Address> addresses = jdbcTemplate.query(sql, rowMapper, id);
        return addresses.isEmpty() ? Optional.empty() : Optional.of(addresses.get(0));
    }

    public Address save(Address address) {
        if (address.getId() == null) {
            String sql = "INSERT INTO addresses (person, city_id, street, building, office) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, 
                address.getPerson(), 
                address.getCityId(), 
                address.getStreet(), 
                address.getBuilding(), 
                address.getOffice());
        } else {
            String sql = "UPDATE addresses SET person = ?, city_id = ?, street = ?, building = ?, office = ? WHERE id = ?";
            jdbcTemplate.update(sql, 
                address.getPerson(), 
                address.getCityId(), 
                address.getStreet(), 
                address.getBuilding(), 
                address.getOffice(), 
                address.getId());
        }
        return address;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM addresses WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Address> findByPersonContaining(String person) {
        String sql = "SELECT id, person, city_id, street, building, office FROM addresses WHERE person LIKE ? ORDER BY person";
        return jdbcTemplate.query(sql, rowMapper, "%" + person + "%");
    }
}