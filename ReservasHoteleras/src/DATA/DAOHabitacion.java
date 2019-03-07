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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author J
 */
public class DAOHabitacion implements DAO<Habitacion> {

    @Override
    public void incluir(Habitacion t) throws Exception {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO Habitacion (K_NUMERO, K_IDTIPO) VALUES (?,?)");

            st.setInt(1, t.getN_hab());
            st.setString(2, t.getTipo().getIdTipHab());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            Conexion.getInstance().desconexion();
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
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT H.K_NUMERO, TH.K_IDTIPO, TH.V_NOCHE, "
                    + "TH.Q_CAPACIDAD FROM Tipo_Habitacion TH, Habitacion H WHERE H.K_IDTIPO = TH.K_IDTIPO");
//            "SELECT h.k_numero as Habitación_Numero, h.k_idtipo as Tipo_Habitación ,"
//                    + " t.q_capacidad as Capacidad, t.v_noche as Valor_Noche" + "FROM habitacion h, tipo_habitacion t" +
//                    "where h.k_numero NOT IN (SELECT h.k_numero FROM habitacion h, registro rg" + "WHERE rg.f_salida BETWEEN sysdate AND '16/03/2019' AND rg.k_numero_hab = h.k_numero)" +
//                    "AND h.k_numero NOT IN(SELECT h.k_numero FROM habitacion h, reserva rs " + "WHERE rs.f_inicio BETWEEN sysdate AND '16/03/2019' AND rs.k_numero_hab = h.k_numero)" +
//                    "AND t.k_idtipo = h.k_idtipo;");
            //este select como posible opcion para mostrar en habitacionesdisponibles la tabla
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
            Conexion.getInstance().desconexion();
        }
        return lista;
    }

    @Override
    public Habitacion recuperar(Habitacion t) throws Exception {
        return null;
    }

    public List<Habitacion> recuperarDisponible(java.sql.Date fechaIni, java.sql.Date fechaFin) throws Exception {
        List<Habitacion> lista = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT h.k_numero , h.k_idtipo , t.q_capacidad, t.v_noche FROM habitacion h, tipo_habitacion t where h.k_numero NOT IN (SELECT h.k_numero FROM habitacion h, registro rg  WHERE rg.f_salida BETWEEN ? AND ? AND rg.k_numero_hab = h.k_numero) AND h.k_numero NOT IN(SELECT h.k_numero FROM habitacion h, reserva rs WHERE rs.f_inicio BETWEEN ? AND ? AND rs.k_numero_hab = h.k_numero) AND t.k_idtipo = h.k_idtipo");
            st.setDate(1, fechaIni);
            st.setDate(2, fechaFin);
            st.setDate(3, fechaIni);
            st.setDate(4, fechaFin);
            //este select como posible opcion para mostrar en habitacionesdisponibles la tabla
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
            Conexion.getInstance().desconexion();
        }
        return lista;
    }

}
