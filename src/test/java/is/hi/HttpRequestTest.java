package is.hi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Diljá, Kristín, Sandra og Ólöf
 * (based on code from:)
 * @author Ebba Þóra Hvannberg
 *
 * @date 26. October 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Testmodule that sends URL to a test web client
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    //random port
    @LocalServerPort
    private int port;

    // Client module for integration test, uses Http API
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Function to see whether sending HttpRequest to a homepath works and
     * if the site / is retrieved.

     * @throws java.lang.Exception
     */
    @Test
    public void getIsNotEmpty() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).isNotEmpty();
    }

    /**
     * Function to see whether sending HttpRequest to a homepath works and
     * if the site /forsida is retrieved
     * @throws Exception
     */
    @Test
    public void forsidaReturnsLogin() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/forsida",
                String.class)).contains("login");
    }
}
