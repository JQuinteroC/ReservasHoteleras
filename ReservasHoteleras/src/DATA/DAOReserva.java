/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Habitacion;
import LOGIC.Persona;
import LOGIC.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J
 */
public class DAOReserva implements DAO<Reserva> {

    //este metodo se encarga de insertar datos desde la app a la base de datos en la tabla reserva
    @Override
    public void incluir(Reserva reserva) throws Exception {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO RESERVA (K_ID_RES, F_INICIO, F_RESERVA, Q_DIAS, Q_OCUPANTES, "
                    + "I_RESERVA, K_NUMERO_HAB, K_TIPO_DOC, K_NUMERO_DOC) VALUES (?,?,?,?,?,?,?,?,?)");

            st.setInt(1, reserva.getId_reserva());
            st.setDate(2, reserva.getF_inicio());
            st.setDate(3, reserva.getF_reserva());
            st.setInt(4, reserva.getDias());
            st.setInt(5, reserva.getOcupantes());
            st.setString(6, reserva.getEstado());
            st.setInt(7, reserva.getHabitacion().getN_hab());
            st.setString(8, reserva.getPersona().getTipo_doc());
            st.setString(9, reserva.getPersona().getDocumento());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            Conexion.getInstance().desconexion();
        }
    }

    //este metodo se encarga de eliminar los datos de la reserva
    @Override
    public void eliminar(Reserva reserva) throws Exception {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("DELETE  from RESERVA  where K_ID_RES  = ?");
            st.setInt(1, reserva.getId_reserva());
            st.executeUpdate();
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            Conexion.getInstance().desconexion();
        }
    }

    @Override
    public void actualizar(Reserva t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> recuperarTodos() throws Exception {
        List<Reserva> lista = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM RESERVA");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId_reserva(rs.getInt("K_ID_RES"));
                r.setF_inicio(rs.getDate("F_INICIO"));
                r.setF_reserva(rs.getDate("F_RESERVA"));
                r.setDias(rs.getInt("Q_DIAS"));
                r.setOcupantes(rs.getInt("Q_OCUPANTES"));
                r.setEstado(rs.getString("I_RESERVA"));
                ArrayList<Persona> p = (ArrayList<Persona>) (new DAOPersona()).recuperarTodos();
                for (Persona per : p) {
                    if (per.getDocumento().equals(rs.getString("K_NUMERO_DOC")) && per.getTipo_doc().equals(rs.getString("K_TIPO_DOC"))) {
                        r.setPersona(per);
                        break;
                    }
                }
                ArrayList<Habitacion> h = (ArrayList<Habitacion>) (new DAOHabitacion()).recuperarTodos();
                for (Habitacion hab : h) {
                    if (hab.getN_hab() == rs.getInt("K_NUMERO_HAB")) {
                        r.setHabitacion(hab);
                        break;
                    }
                }
                lista.add(r);
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
    public Reserva recuperar(Reserva t) throws Exception {
        return null;
    }

}
