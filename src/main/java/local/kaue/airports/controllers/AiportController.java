package local.kaue.airports.controllers;

import java.util.List;
import local.kaue.airports.DTO.AirportMinDTO;
import local.kaue.airports.entities.Airport;
import local.kaue.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */
@RestController
public class AiportController {

    @Autowired
    private AirportService airportService;

    /**
     * *
     * * Endpoint / airports/ airport Retorna todos os aeroportos da base de
     * dados
     *
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;

    }

    /**
     * endpoint /airports/city/{cityName}
     *
     * @param cityname
     * @return
     */

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if(result.isEmpty()){
            //ops... lista vazia...
            // not found devolve404
            return ResponseEntity.notFound().build();
            
        }else{
            //eba tem dados
            return ResponseEntity.ok(result);
        
        }
    }
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findCountryIgnoreCase(@PathVariable String countryName) {
       
        List<AirportMinDTO> result = airportService.findByCountry(countryName); 
        if(result.isEmpty()){
            //ops... lista vazia...
            // not found devolve404
            return ResponseEntity.notFound().build();
            
        }else{
            //eba tem dados
            //eba devolve 200
            return ResponseEntity.ok(result);
        
        }
    }
    
    

}
