package org.uv.dapp02practica02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoDAO implements IDAOGeneral<EmpleadoPojo, Long> {

    @Override
    public EmpleadoPojo guardar(EmpleadoPojo pojo) {
        ConectionSQL con = ConectionSQL.getInstance();

        TransacionDB<EmpleadoPojo> t = new TransacionDB<EmpleadoPojo>(pojo) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "INSERT INTO empleados (id, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setLong(1, pojo.getClave());
                    pstm.setString(2, pojo.getNombre());
                    pstm.setString(3, pojo.getDireccion());
                    pstm.setString(4, pojo.getTelefono());

                    pstm.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, "Error al guardar el empleado", ex);
                    return false;
                }
            }
        };

        boolean res = con.execute(t);
        return res ? pojo : null;
    }

    @Override
    public EmpleadoPojo modificar(EmpleadoPojo pojo, Long id) {
        ConectionSQL con = ConectionSQL.getInstance();

        TransacionDB<EmpleadoPojo> t = new TransacionDB<EmpleadoPojo>(pojo) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "UPDATE empleados SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, pojo.getNombre());
                    pstm.setString(2, pojo.getDireccion());
                    pstm.setString(3, pojo.getTelefono());
                    pstm.setLong(4, id);

                    pstm.executeUpdate();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, "Error al modificar el empleado", ex);
                    return false;
                }
            }
        };

        boolean res = con.execute(t);
        return res ? pojo : null;
    }

    @Override
    public boolean eliminar(Long id) {
        ConectionSQL con = ConectionSQL.getInstance();

        TransacionDB<EmpleadoPojo> t = new TransacionDB<EmpleadoPojo>(null) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "DELETE FROM empleados WHERE id = ?";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setLong(1, id);

                    pstm.executeUpdate();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, "Error al eliminar el empleado", ex);
                    return false;
                }
            }
        };

        return con.execute(t);
    }

    @Override
    public EmpleadoPojo buscarById(Long id) {
        return null;
    }

    @Override
    public List<EmpleadoPojo> buscarAll() {
        return null;
    }
}