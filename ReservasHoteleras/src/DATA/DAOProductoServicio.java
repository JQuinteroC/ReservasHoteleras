/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Producto_Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J
 */
public class DAOProductoServicio implements DAO<Producto_Servicio> {

    @Override
    public void incluir(Producto_Servicio t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Producto_Servicio t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Producto_Servicio t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto_Servicio> recuperarTodos() throws Exception {
        List<Producto_Servicio> lista = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM Producto");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto_Servicio p = new Producto_Servicio();
                p.setId_producto(rs.getInt("K_ID_PRO"));
                p.setNombre(rs.getString("N_NOMBRE"));
                p.setDescripcion(rs.getString("N_DESCRIPCION"));
                p.setTipo(rs.getString("I_TIPO"));
                p.setPrecio_unidad(rs.getDouble("V_COSTO"));
                p.setExistencias(rs.getInt("Q_EXISTENCIAS"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            //Conexion.getInstance().desconexion();
        }
        return lista;
    }

    @Override
    public Producto_Servicio recuperar(Producto_Servicio t) throws Exception {
        return null;
    }

}
