package tests;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@AllArgsConstructor
@RunWith(value = Parameterized.class)
public class EmployerPageLinkCheckTest extends BaseTest {

    private String sectionName;
    private String expectedTitle;

    @Parameterized.Parameters(name = "{index}: check link for section - {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"OM BLOCKET JOBB", "Rekrytera med Blocket Jobb"},
                        {"PRODUKTER & PRISER", "Vårt produktutbud"},
                        {"REFERENSKUNDER", "Referenser"},
                        {"TIPS & RÅD", "Så skriver du en bättre platsannons"},
                        {"Q & A", "Publicera annons"},
                        {"KONTAKTA OSS", "Kontakta oss på Blocket Jobb!"}
                }
        );
    }

    @Test
    public void checkLinkIsCorrectTest() throws Exception {
        String url = "";
        String selector = "";
        switch (sectionName) {
            case "OM BLOCKET JOBB":
                url = "https://jobb.blocket.se/rekrytering";
                selector = "#recruit > div:nth-child(1) > h1";
                break;
            case "PRODUKTER & PRISER":
                url = "https://jobb.blocket.se/rekrytering/produkter_och_priser";
                selector = "#products > div:nth-child(1) > h1";
                break;
            case "REFERENSKUNDER":
                url = "https://jobb.blocket.se/rekrytering/referenskunder";
                selector = "#modules > h2";
                break;
            case "TIPS & RÅD":
                url = "https://jobb.blocket.se/rekrytering/tips_och_rad";
                selector = "#tips > div.row > div:nth-child(1) > h1";
                break;
            case "Q & A":
                url = "https://jobb.blocket.se/rekrytering/fragar_och_svar";
                selector = "#questions > div:nth-child(1) > div.title > h1";
                break;
            case "KONTAKTA OSS":
                url = "https://jobb.blocket.se/rekrytering/kontakta_oss";
                selector = "#modules > h2";
                break;
            default:
        }
        goTo(url);
        assertThat(el(selector).text().equalsIgnoreCase(expectedTitle));
    }


}
