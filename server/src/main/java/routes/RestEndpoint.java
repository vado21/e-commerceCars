/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

/**
 *
 * @author ricardocazares
 */
public interface RestEndpoint {

    Object index();

    Object delete(String id);

    Object index(String id);
}
