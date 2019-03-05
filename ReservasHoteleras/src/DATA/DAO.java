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
public interface DAO {

    public void resgistrar() throws Exception;

    public void modificar() throws Exception;

    public void eliminar() throws Exception;

    public List<Persona> listar() throws Exception;
}
