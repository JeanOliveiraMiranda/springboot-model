package com.study.coffee.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.study.coffee.configuration.MapperConfig;
import com.study.coffee.domain.dto.request.ParticipacaoCreateRequest;
import com.study.coffee.domain.dto.response.ParticipacaoResponse;
import com.study.coffee.domain.entities.Participacao;
import com.study.coffee.domain.mapper.ParticipacaoMapper;
import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.StatusEvento;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClientMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private ParticipacaoMapper mapper;

    private Evento evento;

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

        // Setando dados do Evento
        this.evento = new Evento();
        this.evento.setIdEvento(1);
        this.evento.setIdCategoriaEvento(this.categoriaEvento);
        this.evento.setIdStatusEvento(this.statusEvento);
        this.evento.setNome("Evento maneiro");
        this.evento.setDataInicio(this.date);
        this.evento.setDataFim(this.date);
        this.evento.setLocal("Faria Lima");
        this.evento.setDescricao("Evento para deixar a galerinha fera");
        this.evento.setLimiteVagas(50);
    }

    @Test
    public void shouldConvertParticipacaoToParticipacaoResponse() {

        Participacao entity = Participacao.builder().idParticipacao(1).idEvento(evento).login("jean.miranda")
                .flag((short) 1).nota(10).comentario("Muito tópi o evento, quero ir dnv").build();
        ParticipacaoResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getIdParticipacao(), entity.getIdParticipacao());
        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento());
        assertEquals("Unexpected value found!", dto.getLogin(), entity.getLogin());
        assertEquals("Unexpected value found!", dto.getFlag(), entity.getFlag());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
    }

    @Test
    public void shouldConverParticipacaoCreateRequestToParticipacao() {

        ParticipacaoCreateRequest dto = ParticipacaoCreateRequest.builder().idEvento(1).login("jean.miranda")
                .flag((short) 1).nota(10).comentario("Muito tópi").build();

        Participacao entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getIdEvento(), entity.getIdEvento().getIdEvento());
        assertEquals("Unexpected value found!", dto.getLogin(), entity.getLogin());
        assertEquals("Unexpected value found!", dto.getFlag(), entity.getFlag());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
    }

}