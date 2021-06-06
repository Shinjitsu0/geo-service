import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;
import java.util.HashMap;
import java.util.Map;

public class MainTestByRuIP {
    @Test
    void testGetGreetingByIpRu(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        String expectedMessage = "Отправлено сообщение: Добро пожаловать";

        GeoService geoServiceRu = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceRu.byIp("172.123.12.19"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationServiceRu = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceRu.locale(Country.RUSSIA))
                .thenReturn("Отправлено сообщение: Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoServiceRu, localizationServiceRu);
        String message = messageSender.send(headers);
        Assertions.assertEquals(expectedMessage, message);
    }
}
