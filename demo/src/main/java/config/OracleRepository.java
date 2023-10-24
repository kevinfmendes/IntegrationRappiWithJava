package config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OracleRepository {
    private final JdbcTemplate jdbcTemplate;

    
    public OracleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Adicione métodos para acessar o banco de dados Oracle aqui
}
