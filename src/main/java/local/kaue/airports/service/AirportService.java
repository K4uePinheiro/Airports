/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.kaue.airports.service;

import java.util.List;
import local.kaue.airports.entities.Airport;
import local.kaue.airports.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service

public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll(){
   
        List<Airport> result = airportRepository.findAll();
                return result;
    }
    
}
