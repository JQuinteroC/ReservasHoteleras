/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 *
 */
//esta clase se encarga de utilizar la plantilla de CRUD y utilizar las funciones de la clase Conexion 
public class DAOPersona {

    private final Conexion conexion;

    public DAOPersona() {
        conexion = Conexion.getInstance(); //se conecta la BD
    }

    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void resgistrar(Persona per) throws Exception {
        try {
            /*Se hace la sentencia SQL normal y donde van los valores se ponen ?
            y se llama al metodo set(tipo e dato) que coinicde con el tipo definido en la capa logic
            se asigna un indice que indica el orden de las columnas y el respectivo valor
             */
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO PERSONA (K_NUMERO_DOC, K_TIPO_DOC, N_NOMBRE, "
                    + "N_APELLIDO, Q_TELEFONO_FIJ, Q_TELEFONO_MOV, N_PAIS, N_CIUDAD, N_BARRIO, N_DIRECCION) VALUES (?,?,?,?,?,?,?,?,?,?)");

            st.setString(1, per.getDocumento());
            st.setString(2, per.getTipo_doc());
            st.setString(3, per.getNombres());
            st.setString(4, per.getApellidos());
            st.setLong(5, per.getTelfijo());
            st.setLong(6, per.getTelmovil());
            st.setString(7, per.getPais());
            st.setString(8, per.getCiudad());
            st.setString(9, per.getBarrio());
            st.setString(10, per.getDireccion());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }
//este metodo se encarga de modificar los datos de un apersona

    public void modificar(Persona per) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("UPDATE PERSONA set K_NUMERO_DOC = ?, K_TIPO_DOC = ?, N_NOMBRE = ?, "
                    + "N_APELLIDO = ?, Q_TELEFONO_FIJ = ?, Q_TELEFONO_MOV = ?, N_PAIS = ?, N_CIUDAD = ?, N_BARRIO = ?, N_DIRECCION = ? WHERE K_NUMERO_DOC  = ? and K_TIPO_DOC = ?");
            st.setString(1, per.getDocumento());
            st.setString(2, per.getTipo_doc());
            st.setString(3, per.getNombres());
            st.setString(4, per.getApellidos());
            st.setLong(5, per.getTelfijo());
            st.setLong(6, per.getTelmovil());
            st.setString(7, per.getPais());
            st.setString(8, per.getCiudad());
            st.setString(9, per.getBarrio());
            st.setString(10, per.getDireccion());
            st.setString(11, per.getDocumento());
            st.setString(12, per.getTipo_doc());
            st.executeUpdate();
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }
//este metdoo se encarga de eliminar los datos

    public void eliminar(String documento, String tipoDoc) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("DELETE  from PERSONA  where K_NUMERO_DOC  = ? and K_TIPO_DOC = ?");
            st.setString(1, documento);
            st.setString(2, tipoDoc);
            st.executeUpdate();
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

//este metodo se encarga de listar los registros
    public List<Persona> listar() throws Exception {
        List<Persona> lista = null;
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM PERSONA");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setDocumento(rs.getString("K_NUMERO_DOC"));
                p.setNombres(rs.getString("N_NOMBRE"));
                p.setApellidos(rs.getString("N_APELLIDO"));
                p.setBarrio(rs.getString("N_DIRECCION"));
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
