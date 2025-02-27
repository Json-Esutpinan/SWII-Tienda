package co.edu.poli.ejemplo.servicio;

import java.sql.SQLException;
import java.util.List;

public interface CustomQuery <T> extends CrudDAO<T>{
    List<T> queryDML(String sql, Object... params) throws SQLException;
}
