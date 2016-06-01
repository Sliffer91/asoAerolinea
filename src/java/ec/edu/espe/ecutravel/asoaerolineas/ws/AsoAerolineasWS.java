/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.ws;

import ec.edu.espe.ecutravel.asoaerolineas.consumer.ConsumerAerolinea;
import ec.edu.espe.ecutravel.asoaerolineas.controllers.AerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.controllers.TransaccionAerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea;
import ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lichita
 */
@WebService(serviceName = "AsoAerolineasWS")
public class AsoAerolineasWS {

    @EJB
    private AerolineaController ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    ConsumerAerolinea consumerAerolinea = new ConsumerAerolinea();

    @WebMethod(operationName = "Aerolinea")
    public List<Aerolinea> Aerolinea() {
        return ejbRef.Aerolinea();
    }

    @WebMethod(operationName = "retrieveVuelo")
    public List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> retrieveVuelo(
            @WebParam(name = "idAerolinea") Integer idAerolinea,
            @WebParam(name = "inicio") String inicio,
            @WebParam(name = "fin") String fin,
            @WebParam(name = "origen") String origen,
            @WebParam(name = "destino") String destino,
            @WebParam(name = "numper") String numper) {
        List<ec.edu.espe.ecutravel.aerolinea.ws.Vuelo> temp = new ArrayList<>();
        //temp =consumerAerolinea.retrieveVuelo(inicio, fin, origen, destino, numper);
        temp = consumerAerolinea.retrieveVuelo(idAerolinea, inicio, fin, origen, destino, numper);
        return temp;
    }

    @EJB
    private TransaccionAerolineaController ejbTran;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getTransaccionAerolinea")
    public List<TransaccionAerolinea> getTransaccionAerolinea() {
        return ejbTran.getTransaccionAerolinea();
    }

//    @WebMethod(operationName = "getVuelosDisponiblesByAerolinea")
//    public List<Vuelo> getVuelosDisponiblesByAerolinea(String inicio, String fin, String origen, String destino, String numPer) {
//        
//        return aerolinea1consumer.Aerolinea1WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numPer);
//    }
    @WebMethod(operationName = "registrarPasaje")
    public Boolean registrarPasaje(
            Integer idAerolinea,
            String persona,
            String paquete,
            String numPer,
            Integer idVuelo) {
        return consumerAerolinea.registrarBoleto(idAerolinea, persona, paquete, numPer, idVuelo);
    }
}
