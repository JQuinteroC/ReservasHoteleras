/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Habitacion;
import LOGIC.Huesped;
import LOGIC.Persona;
import LOGIC.Registro;
import LOGIC.Reserva;
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
public class DAOHotel {

    private final Conexion conexion;

    public DAOHotel() {
        conexion = Conexion.getInstance(); //se conecta la BD
    }

    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void resgistrarPersona(Persona per) throws Exception {
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
//este metodo se encarga de modificarPersona los datos de un apersona

    public void modificarPersona(Persona per) throws Exception {
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
//este metdoo se encarga de eliminarPersona los datos

    public void eliminarPersona(String documento, String tipoDoc) throws Exception {
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

    //este metodo se encarga de listar los registros de la tabla persona
    public List<Persona> listarPersona() throws Exception {
        List<Persona> lista = new ArrayList<>();
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

    //este metodo se encarga de insertar datos desde la app a la base de datos en la tabla reserva
    public void resgistrarReserva(Reserva reserva, Persona persona, Habitacion habitacion) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO RESERVA (K_ID_RES, F_INICIO, F_RESERVA, Q_DIAS, Q_OCUPANTES, "
                    + "I_RESERVA, K_NUMERO_HAB, K_TIPO_DOC, K_NUMERO_DOC) VALUES (?,?,?,?,?,?,?,?,?)");

            st.setInt(1, reserva.getId_reserva());
            st.setDate(2, reserva.getF_inicio());
            st.setDate(3, reserva.getF_reserva());
            st.setInt(4, reserva.getDias());
            st.setInt(5, reserva.getOcupantes());
            st.setString(6, reserva.getEstado());
            st.setInt(7, habitacion.getN_hab());
            st.setString(8, persona.getTipo_doc());
            st.setString(9, persona.getDocumento());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

    //este metodo se encarga de eliminar los datos de la reserva
    public void eliminarReserva(int idRes) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("DELETE  from RESERVA  where K_ID_RES  = ?");
            st.setInt(1, idRes);
            st.executeUpdate();
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void resgistrarHuesped(Huesped huesped) throws Exception {
        try {
            /*Se hace la sentencia SQL normal y donde van los valores se ponen ?
            y se llama al metodo set(tipo e dato) que coinicde con el tipo definido en la capa logic
            se asigna un indice que indica el orden de las columnas y el respectivo valor
             */
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO HUESPED (K_NUMERO_DOC, K_TIPO_DOC, F_NACIMIENTO"
                    + " VALUES (?,?,?)");

            st.setString(1, huesped.getDocumento());
            st.setString(2, huesped.getTipo_doc());
            st.setDate(3, huesped.getF_nacimiento());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

    //este metdoo se encarga de eliminar los datos
    public void eliminarHuesped(String documento, String tipoDoc) throws Exception {
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("DELETE  from HUESPED  where K_NUMERO_DOC  = ? and K_TIPO_DOC = ?");
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

    //este metodo se encarga de listar los registros de la tabla persona
    public List<Persona> listarHuesped() throws Exception {
        List<Persona> lista = new ArrayList<>();
        try {
            PreparedStatement st = conexion.getConexion().prepareStatement("SELECT * FROM PERSONA P, HUESPED H "
                    + "WHERE P.K_NUMERO_DOC = H.K_NUMERO_DOC and P.K_TIPO_DOC = H.K_TIPO_DOC");
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

    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void resgistrarRegistro(Registro registro, Reserva reserva, Habitacion habitacion) throws Exception {
        try {
            /*Se hace la sentencia SQL normal y donde van los valores se ponen ?
            y se llama al metodo set(tipo e dato) que coinicde con el tipo definido en la capa logic
            se asigna un indice que indica el orden de las columnas y el respectivo valor
             */
            PreparedStatement st = conexion.getConexion().prepareStatement("INSERT INTO REGISTRO (K_ID_REG, F_INGRESO, "
                    + "F_SALIDA, I_REGISTRO, K_ID_RES, K_NUMERO_HAB VALUES (?,?,?,?,?,?)");

            st.setInt(1, registro.getId_registro());
            st.setDate(2, registro.getF_ingreso());
            st.setDate(3, registro.getF_salida());
            st.setString(4, registro.getEstado());
            st.setInt(5, reserva.getId_reserva());
            st.setInt(6, habitacion.getN_hab());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void modificarRegistro(Registro registro, Reserva reserva, Habitacion habitacion) throws Exception {
        try {
            /*Se hace la sentencia SQL normal y donde van los valores se ponen ?
            y se llama al metodo set(tipo e dato) que coinicde con el tipo definido en la capa logic
            se asigna un indice que indica el orden de las columnas y el respectivo valor
             */
            PreparedStatement st = conexion.getConexion().prepareStatement("UPDATE REGISTRO set K_ID_REG = ?, F_INGRESO = ?, "
                    + "F_SALIDA = ?, I_REGISTRO = ?, K_ID_RES = ?, K_NUMERO_HAB = ? WHERE K_ID_REG = ?");

            st.setInt(1, registro.getId_registro());
            st.setDate(2, registro.getF_ingreso());
            st.setDate(3, registro.getF_salida());
            st.setString(4, registro.getEstado());
            st.setInt(5, reserva.getId_reserva());
            st.setInt(6, habitacion.getN_hab());
            st.setInt(7, registro.getId_registro());

            st.executeUpdate();//guarda los cambios
            st.close();
            conexion.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            conexion.desconexion();
        }
    }

}
