/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Huesped;
import LOGIC.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J
 */
public class DAOHuesped implements DAO<Huesped> {

    private final Conexion conexion;

    public DAOHuesped() {
        conexion = Conexion.getInstance(); //se conecta la BD
    }

    @Override
    public void incluir(Huesped t) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO Huesped (K_TIPO_DOC, K_NUMERO_DOC, F_NACIMIENTO) VALUES (?,?,?)");

            st.setString(1, t.getTipo_doc());
            st.setString(2, t.getDocumento());
            st.setDate(3, t.getF_nacimiento());

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
    public void actualizar(Huesped t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Huesped t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Huesped> recuperarTodos() throws Exception {
        List<Huesped> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM Huesped");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Huesped h = new Huesped();
                h.setF_nacimiento(rs.getDate("F_NACIMIENTO"));
                ArrayList<Persona> p = (ArrayList<Persona>) (new DAOPersona()).recuperarTodos();
                for (Persona per : p) {
                    if (per.getDocumento().equals(rs.getString("K_NUMERO_DOC")) && per.getTipo_doc().equals(rs.getString("K_TIPO_DOC"))) {
                        h.setApellidos(per.getApellidos());
                        h.setBarrio(per.getBarrio());
                        h.setCiudad(per.getCiudad());
                        h.setDireccion(per.getDireccion());
                        h.setNombres(per.getNombres());
                        h.setPais(per.getPais());
                        h.setTelfijo(per.getTelfijo());
                        h.setTelmovil(per.getTelmovil());
                        break;
                    }
                }
                lista.add(h);
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
