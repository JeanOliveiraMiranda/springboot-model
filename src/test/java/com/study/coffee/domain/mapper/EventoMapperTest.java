package com.study.coffee.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.study.coffee.configuration.MapperConfig;
import com.study.coffee.domain.dto.request.EventoCreateRequest;
import com.study.coffee.domain.dto.response.EventoResponse;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.domain.mapper.EventoMapper;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * ClientMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private EventoMapper mapper;

    private StatusEvento statusEvento;

    private CategoriaEvento categoriaEvento;

    private Date date = new Date();

    @Before
    public void setUp() {

        // Setando dados do StatusEvento
        this.statusEvento = new StatusEvento();
        this.statusEvento.setIdStatusEvento(1);
        this.statusEvento.setNome("Evento tópi");

        // Setando dados do CategoriaEvento
        this.categoriaEvento = new CategoriaEvento();
        this.categoriaEvento.setIdCategoriaEvento(1);
        this.categoriaEvento.setNome("Backend");
    }

    @Test
    public void shouldConvertEventoToEventoResponse() {

        Evento entity = Evento.builder().idEvento(1).idStatusEvento(statusEvento).idCategoriaEvento(categoriaEvento)
                .nome("Meetup Frontend").dataInicio(date).dataFim(date).local("Faria Lima")
                .descricao("Evento muito top pra deixar a galerinha fera").limiteVagas(50).build();
        EventoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getIdStatusEvento(), entity.getIdStatusEvento());
        assertEquals("Unexpected value found!", dto.getIdCategoriaEvento(), entity.getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
        assertEquals("Unexpected value found!", dto.getDataInicio(), entity.getDataInicio());
        assertEquals("Unexpected value found!", dto.getDataFim(), entity.getDataFim());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getLimiteVagas(), entity.getLimiteVagas());
    }

    @Test
    public void shouldConvertEventoCreateRequestToEvento() {

        EventoCreateRequest dto = EventoCreateRequest.builder().idStatusEvento(1).idCategoriaEvento(1)
                .nome("Meetup Frontend").dataInicio(date).dataFim(date).local("Faria Lima")
                .descricao("Evento muito top pra deixar a galerinha fera").limiteVagas(50).build();

        Evento entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getIdStatusEvento(), entity.getIdCategoriaEvento().getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getIdCategoriaEvento(), entity.getIdCategoriaEvento().getIdCategoriaEvento());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
        assertEquals("Unexpected value found!", dto.getDataInicio(), entity.getDataInicio());
        assertEquals("Unexpected value found!", dto.getDataFim(), entity.getDataFim());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getLimiteVagas(), entity.getLimiteVagas());
    }

}