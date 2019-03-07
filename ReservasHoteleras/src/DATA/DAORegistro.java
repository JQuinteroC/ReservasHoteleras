/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Habitacion;
import LOGIC.Huesped;
import LOGIC.Registro;
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
public class DAORegistro implements DAO<Registro> {

    @Override
    public void incluir(Registro t) throws Exception {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO Registro (K_ID_REG, F_INGRESO, F_SALIDA, I_REGISTRO, K_ID_RES, "
                    + "K_NUMERO_HAB VALUES (?,?,?,?,?,?)");

            st.setInt(1, t.getId_registro());
            st.setDate(2, t.getF_ingreso());
            st.setDate(3, t.getF_salida());
            st.setString(4, t.getEstado());
            st.setInt(5, t.getReserva().getId_reserva());
            st.setInt(6, t.getHabitacion().getN_hab());
            st.executeUpdate();//guarda los cambios
            st.close();

            for (Huesped h : t.getOcupantes()) {
                st = conexion.getConexion().prepareStatement("INSERT INTO Huesped_Registro (K_ID_REG, K_TIPO_DOC, "
                        + "K_NUMERO_DOC, F_ENTRADA, F_SALIDA VALUES (?,?,?,?,?)");
                st.setInt(1, t.getId_registro());
                st.setString(2, h.getTipo_doc());
                st.setString(3, h.getDocumento());
                st.setDate(4, t.getF_ingreso());
                st.setDate(5, t.getF_salida());
                st.executeUpdate();//guarda los cambios
                st.close();
            }

            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            Conexion.getInstance().desconexion();
        }

    }

    @Override
    public void actualizar(Registro t) throws Exception {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("UPDATE Registro set K_ID_REG = ?, F_INGRESO = ?, F_SALIDA = ?, "
                    + "I_REGISTRO = ?, K_ID_RES = ?, K_NUMERO_HAB = ? WHERE K_ID_REG  = ?");
            st.setInt(1, t.getId_registro());
            st.setDate(2, t.getF_ingreso());
            st.setDate(3, t.getF_salida());
            st.setString(4, t.getEstado());
            st.setInt(5, t.getReserva().getId_reserva());
            st.setInt(6, t.getHabitacion().getN_hab());
            st.setInt(7, t.getId_registro());
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
    public void eliminar(Registro t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Registro> recuperarTodos() throws Exception {
        List<Registro> lista = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM Registro");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Registro p = new Registro();
                p.setId_registro(rs.getInt("K_ID_REG"));
                p.setF_ingreso(rs.getDate("F_INGRESO"));
                p.setF_salida(rs.getDate("F_SALIDA"));
                p.setEstado(rs.getString("I_REGISTRO"));
                ArrayList<Reserva> r = (ArrayList<Reserva>) (new DAOReserva()).recuperarTodos();
                for (Reserva res : r) {
                    if (res.getId_reserva() == rs.getInt("K_ID_RES")) {
                        p.setReserva(res);
                        break;
                    }
                }
                ArrayList<Habitacion> h = (ArrayList<Habitacion>) (new DAOHabitacion()).recuperarTodos();
                for (Habitacion hab : h) {
                    if (hab.getN_hab() == rs.getInt("K_NUMERO_HAB")) {
                        p.setHabitacion(hab);
                        break;
                    }
                }
                PreparedStatement st2 = conexion.getConexion().prepareStatement("SELECT H. FROM Huesped_Registro HR, Huesped H, "
                        + "Registro R WHERE HR.K_ID_REG = H.K_ID_REG and HR.K_TIPO_DOC = H.K_TIPO_DOC and "
                        + "HR.K_NUMERO_DOC = H.K_NUMERO_DOC and H.K_ID_REG = ?");
                st2.setInt(1, p.getId_registro());
                ResultSet rs2 = st.executeQuery();
                ArrayList<Huesped> huespedes = (ArrayList<Huesped>) (new DAOHuesped()).recuperarTodos();
                ArrayList<Huesped> hu = new ArrayList<>();
                while (rs2.next()) {
                    for (Huesped hue : huespedes) {
                        if (hue.getDocumento().equals(rs2.getString("K_NUMERO_DOC")) && hue.getTipo_doc().equals(rs2.getString("K_TIPO_DOC"))) {
                            hu.add(hue);
                        }
                    }
                }
                p.setOcupantes(hu);
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
    public Registro recuperar(Registro t) throws Exception {
        return null;
    }

}
