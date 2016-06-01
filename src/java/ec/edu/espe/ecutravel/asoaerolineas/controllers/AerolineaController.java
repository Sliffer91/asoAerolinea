/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.controllers;

import ec.edu.espe.ecutravel.asoaerolineas.dao.AerolineaFacade;
import ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lichita
 */
@Stateless
public class AerolineaController {

    @EJB
    private AerolineaFacade facade;

    public List<Aerolinea> Aerolinea() {
        return facade.findAll();
    }

    public Aerolinea getAerolineas(String nombre) {
        return facade.retrieveAerolineaByNombre(nombre);
    }

    public Aerolinea getAerolineas(Integer idAerolinea) {
        return facade.retrieveAerolineaByID(idAerolinea);
    }

}
