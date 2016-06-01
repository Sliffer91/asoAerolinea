/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.dao;

import ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lichita
 */
@Stateless
public class TransaccionAerolineaFacade extends AbstractFacade<TransaccionAerolinea> {

    @PersistenceContext(unitName = "AsoAerolineasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionAerolineaFacade() {
        super(TransaccionAerolinea.class);
    }
    
}
