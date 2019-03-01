/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 * 
 */

//esta clase se encarga de utilizar la plantilla de CRUD y utilizar las funciones de la clase Conection 
public class DAOPersonaImpl extends Conection implements DAOPersona {

    @Override
    //este metodo se encarga de insertar datos desde la app a la base de datos
    public void resgistrar(Persona per) throws Exception {
        try {
            this.conectar();//se conecta la BD
            /*Se hace la sentencia SQL normal y donde van los valores se ponen ?
            y se llama al metodo set(tipo e dato) que coinicde con el tipo definido en la capa logic
            se asigna un indice que indica el orden de las columnas y el respectivo valor
            */
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO PERSONA (K_NUMERO_DOC, K_TIPO_DOC, N_NOMBRE, "
                    + "N_APELLIDO, Q_TELEFONO_FIJ, Q_TELEFONO_MOV, N_PAIS, N_CIUDAD, N_BARRIO, N_DIRECCION) VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            st.setInt(1, per.getDocumento());
            st.setString(2,per.getTipo_doc());
            st.setString(3, per.getNombres());
            st.setString(4, per.getApellidos());
            st.setLong(5, per.getTelfijo());
            st.setLong(6, per.getTelmovil());
            st.setString(7, per.getPais());
            st.setString(8, per.getCiudad());
            st.setString(9, per.getBarrio());
            st.setString(10, per.getDireccion());
            
            st.executeUpdate();//guarda los cambios
        } catch (Exception e) {
            throw e;
        }finally{
          this.desconexion(); 
        }
    }
//este metodo se encarga de modificar los datos de un apersona
    @Override
    public void modificar(Persona per) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE PERSONA set N_NOMBRE = ? where id  = ?");
            st.setString(1, per.getTipo_doc());
            st.setInt(2, per.getDocumento());
            st.setString(3, per.getNombres());
            st.setString(3, per.getApellidos());
            
            st.executeUpdate();    
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconexion(); 
        }
    }
//este metdoo se encarga de eliminar los datos
    @Override
    public void eliminar(Persona per) throws Exception {
      try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE  from PERSONA  where K_NUMERO_DOC  = ?");
            st.setString(1, per.getNombres());
            st.executeUpdate();    
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconexion(); 
        }   
    }
//este metodo se encarga de listar los registros 
    @Override
    public List<Persona> listar(Persona per) throws Exception {
        List <Persona> lista = null;
         try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM PERSONA");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setDocumento(rs.getInt("id"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("Apellidos"));
                p.setBarrio(rs.getString(""));
                lista.add(p);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }finally{
        this.desconexion(); 
        }
        return lista;
      
    }
    
}
