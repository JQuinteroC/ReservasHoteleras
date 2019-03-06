/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Persona;
import LOGIC.TipoHab;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Holligan
 */
public class DAOTipoHab implements DAO<TipoHab> {

    private final Conexion conexion;

    public DAOTipoHab() {
        conexion = Conexion.getInstance(); //se conecta la BD
    }

    @Override
    public void incluir(TipoHab t) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO Tipo_Habitacion (K_IDTIPO, V_NOCHE, Q_CAPACIDAD) VALUES (?,?,?)");

            st.setString(1, t.getIdTipHab());
            st.setDouble(2, t.getValorNoc());
            st.setInt(3, t.getCapacidad());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

    @Override
    public void actualizar(TipoHab t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TipoHab t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoHab> recuperarTodos() throws Exception {
        List<TipoHab> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM Tipo_Habitacion");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TipoHab p = new TipoHab();
                p.setIdTipHab(rs.getString("K_IDTIPO"));
                p.setValorNoc(rs.getDouble("V_NOCHE"));
                p.setCapacidad(rs.getInt("Q_CAPACIDAD"));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
        return lista;
    }

}
