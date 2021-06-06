import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class TestLocalizationService {
    @Test
    void testGetTextByCountry(){
        //given:
        String expectedLocale = "Добро пожаловать";

        //when:
        LocalizationService localizationService = new LocalizationServiceImpl();
        String locale = localizationService.locale(Country.RUSSIA);

        //then:
        Assertions.assertEquals(expectedLocale, locale);
    }
}
