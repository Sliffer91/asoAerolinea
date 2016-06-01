/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.dao;

import ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lichita
 */
@Stateless
public class AerolineaFacade extends AbstractFacade<Aerolinea> {

    @PersistenceContext(unitName = "AsoAerolineasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AerolineaFacade() {
        super(Aerolinea.class);
    }

    public Aerolinea retrieveAerolineaByNombre(String nombre) {
        return (Aerolinea) em.createNamedQuery("Aerolinea.findByNombre").setParameter("nombre", nombre).getResultList();
    }

    public Aerolinea retrieveAerolineaByID(Integer idAerolinea) {
        return (Aerolinea) em.createNamedQuery("Aerolinea.findByAerCodigo").setParameter("aerCodigo", idAerolinea).getResultList();
    }
}
