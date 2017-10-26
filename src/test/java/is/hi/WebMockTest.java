package is.hi;

import is.hi.controller.*;
import is.hi.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;


/**
 * @author Dilja
 * (largely based on code from:)
 * @author Ebba Þóra Hvannberg
 *
 * @date 26. October 2017
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 *
 * Testing class that conducts tests on the weblayer and uses WebMvcTest and
 * MOckito to test service classes
 */
@RunWith(SpringRunner.class)

@WebMvcTest(showCampController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockobj;

    @MockBean
    campSiteService CampsiteService;
    @MockBean
    UserService userService;
    @MockBean
    TravelPlanService travelplanService;
    @MockBean
    AlternativeService alternativeService;

    /**
     * Aðferð sem prófar /lifir á KennariController en með
     * erALifi() false. Ættum að fá til baka nyrKennari.html síðuna
     */
    @Test
    public void testaLifirTrue() throws Exception {
        // Látum erNafnRett() skila true
        // Notum Mockito í prófanirnar - Mockito er Framework fyrir unit testing í Java
        // http://site.mockito.org/
/*
        // Prófið ætti að takast - prófum sönnu leiðina í if-setningunni
        when(daginnService.erALifi()).thenReturn(true);
        this.mockobj.perform(get("/lifir"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .string(containsString("Nýr kennari")));*/

    }
    /**
     * Aðferð sem prófar /lifir á KennariController en með
     * erALifi() false. Ættum að fá til baka listiKennara.html síðuna
     */
    @Test
    public void testaLifirFalse() throws Exception {
/*
        // Prófið ætti að takast - prófum ósönnu leiðina í if-setningunni
        when(daginnService.erALifi()).thenReturn(false);
        this.mockobj.perform(get("/lifir")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Listi yfir kennara")));*/
    }

    /**
     * Prófið ætti að mistakast - prófum ósönnu leiðina erALifi() en berum
     * saman við rangan streng
     * @throws Exception
     */
    @Test
    public void testaLifirFalseMedRongumStreng() throws Exception {
/*
        // Prófið ætti að ekki takast - prófum ósönnu leiðina í if-setningunni
        when(daginnService.erALifi()).thenReturn(false);


        this.mockobj.perform(get("/lifir")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Nýr kennari")));
*/
    }



}
