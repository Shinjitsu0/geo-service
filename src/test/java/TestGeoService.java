import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class TestGeoService {
    @Test
    void testGetLocationByIP(){
        //given:
        GeoService geoService = new GeoServiceImpl();
        Location expectedLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        //when:
        Location location = geoService.byIp("172.");

        //then:
        Assertions.assertEquals(expectedLocation.getCountry(), location.getCountry() );
    }
}
