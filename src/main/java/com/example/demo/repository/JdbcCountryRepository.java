package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcCountryRepository {
  
    private final JdbcTemplate jdbcTemplate;

    public JdbcCountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Country> findAll() {
        String sql = "SELECT id, country_full, country_short FROM countries ORDER BY country_full";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Country> findById(Long id) {
        String sql = "SELECT id, country_full, country_short FROM countries WHERE id = ?";
        List<Country> countries = jdbcTemplate.query(sql, rowMapper, id);
        return countries.isEmpty() ? Optional.empty() : Optional.of(countries.get(0));
    }

    public Country save(Country country) {
        if (country.getId() == null) {
            String sql = "INSERT INTO countries (country_full, country_short) VALUES (?, ?)";
            jdbcTemplate.update(sql, country.getCountryFull(), country.getCountryShort());
        } else {
            String sql = "UPDATE countries SET country_full = ?, country_short = ? WHERE id = ?";
            jdbcTemplate.update(sql, country.getCountryFull(), country.getCountryShort(), country.getId());
        }
        return country;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM countries WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM countries";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private final RowMapper<Country> rowMapper = new RowMapper<Country>() {
        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getLong("id"));
            country.setCountryFull(rs.getString("country_full"));
            country.setCountryShort(rs.getString("country_short"));
            return country;
        }
    };
}