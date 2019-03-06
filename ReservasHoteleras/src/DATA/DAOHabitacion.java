/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Habitacion;
import LOGIC.TipoHab;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J
 */
public class DAOHabitacion implements DAO<Habitacion> {

    private final Conexion conexion;

    public DAOHabitacion() {
        conexion = Conexion.getInstance(); //se conecta la BD
    }

    @Override
    public void incluir(Habitacion t) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO Habitacion (K_NUMERO, K_IDTIPO) VALUES (?,?)");

            st.setInt(1, t.getN_hab());
            st.setString(2, t.getTipo().getIdTipHab());

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
    public void actualizar(Habitacion t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Habitacion t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Habitacion> recuperarTodos() throws Exception {
        List<Habitacion> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT H.K_NUMERO, TH.K_IDTIPO, TH.V_NOCHE, "
                    + "TH.Q_CAPACIDAD FROM Tipo_Habitacion TH, Habitacion H WHERE H.K_IDTIPO = TH.K_IDTIPO");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Habitacion p = new Habitacion();
                p.setN_hab(rs.getInt("K_NUMERO"));
                TipoHab tp = new TipoHab();
                tp.setIdTipHab(rs.getString("K_IDTIPO"));
                tp.setValorNoc(rs.getDouble("V_NOCHE"));
                tp.setCapacidad(rs.getInt("Q_CAPACIDAD"));
                p.setTipo(tp);
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
