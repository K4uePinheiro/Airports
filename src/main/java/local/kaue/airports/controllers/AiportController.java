
package local.kaue.airports.controllers;

import java.util.List;
import local.kaue.airports.entities.Airport;
import local.kaue.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */

@RestController
public class AiportController {
    
    @Autowired
    private AirportService airportService;
    
    /***
     * * Endpoint / airports/ airport
     * Retorna todos os aeroportos da base de dados
     * @return
     */
    
    @GetMapping("/airport")
    public List<Airport> findAll(){
        List<Airport> result = airportService.findAll();
        return result;
}
}