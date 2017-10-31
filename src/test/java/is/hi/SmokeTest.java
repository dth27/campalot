package is.hi;

import is.hi.controller.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Diljá, Kristín, Sandra og Ólöf
 * (based on code from:)
 * @author Ebba Þóra Hvannberg
 *
 * @date 26. October 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Testing module that preforms tests without needing a server
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    @Autowired
    showCampController campcontroller;

    /**
     *Asserts that an object of campcontroller is made
     */
    @Test
    public void contextLoads() {
        assertThat(campcontroller).isNotNull();
    }

}
