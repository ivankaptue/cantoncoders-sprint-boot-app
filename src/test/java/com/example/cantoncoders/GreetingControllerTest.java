package com.example.cantoncoders;

import com.example.cantoncoders.GreetingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class)
public class GreetingControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
    @Test
    public void givenName_thenGreetingWithName() throws Exception {

        String gettingTo = "CantonCoders";
        String expectGreetingMessage = "Hello, CantonCoders";

        this.mockMvc.perform(get("/greeting").param("name", gettingTo))
            .andExpect(status().isOk())
            .andExpect(view().name("greeting"))
            .andExpect(model().attribute("name", equalTo(gettingTo)))
            .andExpect(content().string(containsString(expectGreetingMessage)));
    }

    @Test
    public void givenNoName_thenGreetingTheWorld() throws Exception {

        String grettingTo = "World";
        String expectGreetingMessage = "Hello, World";

        this.mockMvc.perform(get("/greeting").param("name", ""))
            .andExpect(status().isOk())
            .andExpect(view().name("greeting"))
            .andExpect(model().attribute("name", equalTo(grettingTo)))
            .andExpect(content().string(containsString(expectGreetingMessage)));
    }
}
