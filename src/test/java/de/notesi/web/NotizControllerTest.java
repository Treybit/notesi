package de.notesi.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    @DisplayName("Die Seite unter '/' (Startseite) ist erreichbar")
    void getStartseite() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Die Seite unter '/notiz/neu' ist erreichbar")
    void getNeueNotizZeigtFormular() throws Exception {
        mvc.perform(get("/notiz/neu"))
                .andExpect(status().isOk())
                .andExpect(view().name("notizneu"))
                .andExpect(model().attributeExists("notizForm"));
    }

    @Test
    @DisplayName("Die Seite unter '/notiz/neu' wird beim POST weitergelietet auf die Index Seite")
    void speichernSollAufStartseiteWeiterleiten() throws Exception {
        mvc.perform(post("/notiz/neu"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}

