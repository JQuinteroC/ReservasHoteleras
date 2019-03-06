/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.util.List;

/**
 *
 * @author @param <T>
 */
public interface DAO<T> {

    void incluir(T t) throws Exception;

    void actualizar(T t) throws Exception;

    void eliminar(T t) throws Exception;

    List<T> recuperarTodos() throws Exception;
}
