/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import LOGIC.Persona;
import java.util.List;

/**
 *
 * @author Andrés
 */
public interface DAOPersona {
    public void  resgistrar(Persona per) throws Exception;
    public void  modificar(Persona per) throws Exception;
    public void  eliminar(Persona per) throws Exception;
    public List<Persona>  listar(Persona per) throws Exception;
}
