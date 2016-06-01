/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.controllers;

import ec.edu.espe.ecutravel.asoaerolineas.dao.TransaccionAerolineaFacade;
import ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lichita
 */
@Stateless
public class TransaccionAerolineaController {

    @EJB
    private TransaccionAerolineaFacade facade;

    public List<TransaccionAerolinea> getTransaccionAerolinea() {
        return facade.findAll();
    }

    public void registrarTranAerolinea(TransaccionAerolinea transaccionAerolinea) {
        facade.create(transaccionAerolinea);
    }
}
