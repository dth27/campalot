package is.hi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

/**
 * @author Dilja
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
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockobj;

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á /nyrKennari
     * og fá til baka nyrKennari.html síðuna sem inniheldur strenginn Karl
     */
    @Test
    public void forsidaisOk() throws Exception{
        this.mockobj.perform(get("/forsida"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Log in")));
    }

    @Test
    public void getInfoReturnsCamp() throws Exception{
        this.mockobj.perform(get("/newTravelPlan"))
                .andDo(print()).andExpect(status().isOk());
    }
}
