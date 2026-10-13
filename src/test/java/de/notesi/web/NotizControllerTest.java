package de.notesi.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(NotizController.class)
public class NotizControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Seite unter /notiz/neu ist erreichbar")
    void getNeueNotizZeigtFormular() throws Exception {
        mvc.perform(get("/notiz/neu"))
                .andExpect(status().isOk())
                .andExpect(view().name("notizneu"))
                .andExpect(model().attributeExists("notizForm"));
    }
}

