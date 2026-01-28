package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(containsString("Address Manager")));
    }
    
    @Test
    public void testAddressesPage() throws Exception {
        mockMvc.perform(get("/addresses"))
            .andExpect(status().isOk())
            .andExpect(view().name("addresses"))
            .andExpect(content().string(containsString("Управление адресами")));
    }
    
    @Test
    public void testGeoDataPage() throws Exception {
        mockMvc.perform(get("/geodata"))
            .andExpect(status().isOk())
            .andExpect(view().name("geodata"))
            .andExpect(content().string(containsString("Географические данные")));
    }
}