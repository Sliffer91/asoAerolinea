/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.consumer;

import ec.edu.espe.ecutravel.asoaerolineas.controllers.AerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.controllers.TransaccionAerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea;
import ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author JuanAndresCaspi
 */
public class ConsumerAerolinea {

    @EJB
    AerolineaController aerolineaController;
    @EJB
    TransaccionAerolineaController transaccionAerolineaController;

    public List<Object> retrieveVuelo(
            String inicio,
            String fin,
            String origen,
            String destino,
            String numper) {
        List<Object> vuelos = new ArrayList();
        List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> temp2 = aerolinea1consumer.Aerolinea1WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
        for (ec.edu.espe.ecutravel.aerolinea.ws.Vuelo object : temp2) {
            if (object.getCiudadOrigen().equals(origen) && object.getCiudadDestino().equals(destino)) {
                vuelos.add(object);
            }
        }
        List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> temp3 = aerolinea2consumer.Aerolinea2WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
        for (ec.edu.espe.ecutravel.aerolinea.ws.Vuelo object : temp3) {
            if (object.getCiudadOrigen().equals(origen) && object.getCiudadDestino().equals(destino)) {
                vuelos.add(object);
            }
        }
        return vuelos;
    }

    public List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> retrieveVuelo(
            Integer idAerolinea,
            String inicio,
            String fin,
            String origen,
            String destino,
            String numper) {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea = aerolineaController.getAerolineas(idAerolinea);
        List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> vuelos = new ArrayList();
        if (aerolinea != null) {
            if (aerolinea.getNombre().toUpperCase().equals("AVIANCA")) {
                List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> tempAvianca = aerolinea2consumer.Aerolinea2WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
                for (ec.edu.espe.ecutravel.aerolinea.ws.Vuelo object : tempAvianca) {
                    if (object.getCiudadOrigen().equals(origen) && object.getCiudadDestino().equals(destino)) {
                        vuelos.add(object);
                    }
                }
            } else if (aerolinea.getNombre().toUpperCase().equals("TAME")) {
                List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> tempTame = aerolinea1consumer.Aerolinea1WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
                for (ec.edu.espe.ecutravel.aerolinea.ws.Vuelo object : tempTame) {
                    if (object.getCiudadOrigen().equals(origen) && object.getCiudadDestino().equals(destino)) {
                        vuelos.add(object);
                    }
                }
            }
        }
        return vuelos;
    }

    public Boolean registrarBoleto(
            Integer idAerolinea,
            String persona,
            String paquete,
            String numPer,
            Integer idVuelo) {
        boolean success = false;
        Aerolinea aerolinea = new Aerolinea();
        aerolinea = aerolineaController.getAerolineas(idAerolinea);
        if (aerolinea != null) {
            if (aerolinea.getNombre().toUpperCase().equals("AVIANCA")) {
                success = aerolinea2consumer.Aerolinea2WSConsumer.registrarBoleto(persona, paquete, numPer, idVuelo);

            } else if (aerolinea.getNombre().toUpperCase().equals("TAME")) {
                success = aerolinea1consumer.Aerolinea1WSConsumer.registrarBoleto(persona, paquete, numPer, idVuelo);
            }
            if (success) {
                TransaccionAerolinea transaccionAerolinea = new TransaccionAerolinea();
                transaccionAerolinea.setAerCodigo(aerolinea);
                transaccionAerolinea.setPaquete(new BigInteger(paquete));
                transaccionAerolinea.setPersona(new BigInteger(persona));
                transaccionAerolinea.setVueCodigo(BigInteger.valueOf(idVuelo));
                transaccionAerolinea.setAsiCodigo(BigInteger.ZERO);
                transaccionAerolineaController.registrarTranAerolinea(transaccionAerolinea);
            }
        }
        return success;
    }
}
