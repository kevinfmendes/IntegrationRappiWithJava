package model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import services.StoreInfoService;

 // Importe o serviço para obter os valores

import java.util.List;
import java.util.Map;

@Repository
public class Product {
    private final JdbcTemplate jdbcTemplate;
    private final StoreInfoService storeInfoService;

    public Product(JdbcTemplate jdbcTemplate, StoreInfoService storeInfoService) {
        this.jdbcTemplate = jdbcTemplate;
        this.storeInfoService = storeInfoService;
    }

    public List<Map<String, Object>> getAllProducts() {
        String storeCode = storeInfoService.getStoreCode();
        String segmentCode = storeInfoService.getSegmentCode();

        String sql = "SELECT DISTINCT " +
                "C.NROEMPRESA AS STORE_ID, " +
                "A.SEQPRODUTO AS ID, " +
                "B.CODACESSO AS EAN, " +
                "A.DESCREDUZIDA AS NAME, " +
                "M.MARCA AS TRADEMARK, " +
                "A.DESCCOMPLETA AS DESCRIPTION, " +
                "D.PRECOVDANORMAL AS PRICE, " +
                "CASE " +
                "WHEN D.PRECOVDAPROMOC = 0 THEN D.PRECOVDANORMAL " +
                "ELSE D.PRECOVDAPROMOC " +
                "END AS DISCOUNT_PRICE, " +
                "C.ESTQLOJA AS STOCK, " +
                "CASE " +
                "WHEN K.EMBPESAVEL = 'S' AND K.EMBALAGEM = 'UND' THEN 'WW' " +
                "WHEN K.EMBPESAVEL = 'S' THEN 'WB' " +
                "ELSE 'U' " +
                "END AS SALE_TYPE, " +
                "'' AS IS_AVAILABLE, " +
                "'' AS IMAGE_URL " +
                "FROM MAP_PRODUTO A " +
                "INNER JOIN MAP_PRODCODIGO B ON A.SEQPRODUTO = B.SEQPRODUTO " +
                "INNER JOIN MRL_PRODUTOEMPRESA C ON B.SEQPRODUTO = C.SEQPRODUTO " +
                "INNER JOIN MAXV_MGMBASEPRODSEG D ON C.SEQPRODUTO = D.SEQPRODUTO AND C.NROEMPRESA = D.NROEMPRESA " +
                "INNER JOIN MAP_FAMILIA F ON A.SEQFAMILIA = F.SEQFAMILIA " +
                "INNER JOIN MAP_MARCA M ON F.SEQMARCA = M.SEQMARCA " +
                "INNER JOIN MAP_FAMEMBALAGEM K ON F.SEQFAMILIA = K.SEQFAMILIA " +
                "WHERE B.INDUTILVENDA = 'S' " +
                "AND B.TIPCODIGO IN ('E', 'B') " +
                "AND C.NROEMPRESA = ? " +
                "AND C.ESTQLOJA > 5 " +
                "AND D.NRODIVISAO = 1 " +
                "AND D.NROSEGMENTO IN (?) " +
                "AND D.PRECOVDANORMAL > '0.00' " +
                "AND D.QTDEMBALAGEM = 1 " +
                "ORDER BY A.DESCREDUZIDA";

        return jdbcTemplate.queryForList(sql, storeCode, segmentCode);
    }

    public boolean sendFullProducts(List<Map<String, Object>> fullData) {
        // Implemente o envio dos produtos para a API Rappi aqui
        // Você pode usar bibliotecas como o HttpClient para fazer a solicitação HTTP
        // Certifique-se de configurar os cabeçalhos e o corpo da solicitação adequadamente
        return true; // Substitua pelo código real
    }

    public boolean sendDeltaProducts(List<Map<String, Object>> deltaData) {
        // Implemente o envio dos produtos delta para a API Rappi aqui
        // Você pode usar bibliotecas como o HttpClient para fazer a solicitação HTTP
        // Certifique-se de configurar os cabeçalhos e o corpo da solicitação adequadamente
        return true; // Substitua pelo código real
    }
}
