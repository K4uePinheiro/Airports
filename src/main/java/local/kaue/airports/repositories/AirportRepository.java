package local.kaue.airports.repositories;

import java.util.List;
import static javax.management.Query.value;
import local.kaue.airports.entities.Airport;
import local.kaue.airports.projections.AirportNearMeProjection;
import static org.apache.logging.log4j.util.Lazy.value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sesideva
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String  country);
    
    Airport findByIataCode(String iataCode);
    
    @Query(nativeQuery = true, value = """
        SELECT
            airport.id, 
            airport.name, 
            airport.city,
            airport.iatacode,
            airport.latitude,
            airport.longitude,
            airport.altitude,
            SQRT(
            power(airport.latitude - :latOrigem, 2 ) +
            power(airport.longitude - :longOrigem, 2) ) *60 * 1.852 as distanciaKM
                                        
           from AIRPORT
           order by distanciaKM
           limit 10; """
)
    List<AirportNearMeProjection> findNearMe(double latOrigem, double longOrigem);
}
