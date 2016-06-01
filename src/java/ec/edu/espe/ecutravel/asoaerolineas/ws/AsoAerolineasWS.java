/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.asoaerolineas.ws;


import aerolinea1consumer.Aerolinea1WSConsumer;
import ec.edu.espe.ecutrave.aerolineal.ws.Vuelo;
import ec.edu.espe.ecutravel.asoaerolineas.controllers.AerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.controllers.TransaccionAerolineaController;
import ec.edu.espe.ecutravel.asoaerolineas.entities.Aerolinea;
import ec.edu.espe.ecutravel.asoaerolineas.entities.TransaccionAerolinea;
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

    @WebMethod(operationName = "Aerolinea")
    public List<Aerolinea> Aerolinea() {
        return ejbRef.Aerolinea();
    }
    
//    @WebMethod(operationName = "retrieveVuelo")
//    public List<Object> retrieveVuelo(
//            @WebParam(name = "idAerolinea") Integer idAerolinea,
//            @WebParam(name = "inicio") String inicio,
//            @WebParam(name = "fin") String fin,
//            @WebParam(name = "origen") String origen,
//            @WebParam(name = "destino") String destino,
//            @WebParam(name = "numper") String numper) {
//        
//        List<aerolinea1consumer.Vuelo> temp = null;
//        List<aerolinea2consumer.Vuelo> temp2 = null;
//        
//        List<Object> temp3 = null;
//        
//        temp =aerolinea1consumer.Aerolinea1WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
//        for (aerolinea1consumer.Vuelo object : temp) {
//            if (object.getCiudadOrigen().equals(origen)&& object.getCiudadDestino().equals(destino)){
//                temp3.add(object);
//            }
//        }
//        temp2 = aerolinea2consumer.Aerolinea2WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numper);
//        for (aerolinea2consumer.Vuelo object : temp2) {
//            if (object.getCiudadOrigen().equals(origen)&& object.getCiudadDestino().equals(destino)){
//                temp3.add(object);
//            }
//        }
//        return temp3;
//    }
//    
    
    @EJB
    private TransaccionAerolineaController ejbTran;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getTransaccionAerolinea")
    public List<TransaccionAerolinea> getTransaccionAerolinea() {
        return ejbTran.getTransaccionAerolinea();
    }
    
    @WebMethod(operationName = "getVuelosDisponiblesByAerolinea")
    public List<Vuelo> getVuelosDisponiblesByAerolinea(String inicio, String fin, String origen, String destino, String numPer) {
        
        return aerolinea1consumer.Aerolinea1WSConsumer.retrieveVuelosByPara(inicio, fin, origen, destino, numPer);
    }
    
    

}
