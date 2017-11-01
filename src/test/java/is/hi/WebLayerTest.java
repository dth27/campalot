package is.hi;

import is.hi.controller.ShowCampController;
import is.hi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


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
@WebMvcTest(ShowCampController.class)
public class WebLayerTest {
    @Autowired
    MockMvc mockobj;

    @MockBean
    campSiteService CampsiteService;
    @MockBean
    UserService userService;
    @MockBean
    TravelPlanService travelplanService;
    @MockBean
    AlternativeService alternativeService;

    /**
     * Tests if url /listofcamps opens the jsp file allCampsites
     * @throws Exception
     */
    @Test
    public void forsidaisOk () throws Exception {
        this.mockobj.perform(get("/listofcamps"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("allCampsites"));
    }

    /**
     * Tests if url /accountInfo opens the jsp file accountInfo
     * @throws Exception
     */
    @Test
    public void accountInfoisOk () throws Exception {
        this.mockobj.perform(get("/accountInfo"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("accountInfo"));
    }

}
