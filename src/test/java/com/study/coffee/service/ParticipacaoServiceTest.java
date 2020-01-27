package com.study.coffee.service;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.Participacao;
import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.CategoriaEventoRepository;
import com.study.coffee.repository.EventoRepository;
import com.study.coffee.repository.ParticipacaoRepository;
import com.study.coffee.repository.StatusEventoRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ParticipacaoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ParticipacaoRepository repositoryMock;

    @InjectMocks
    private ParticipacaoService service;

    // variaveis da entidade
    private final Integer idParticipacao = 1;
    private final String login = "jean.miranda";
    private final String comentario = "muito tópi o role";
    private final Short flag = 1;
    private final Integer nota = 10;
    private Date date = new Date();

    private Evento evento;
    private StatusEvento statusEvento;
    private CategoriaEvento categoriaEvento;

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

    Participacao entity = Participacao.builder().idParticipacao(idParticipacao).idEvento(evento).login(login)
            .comentario(comentario).flag(flag).nota(nota).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Participacao Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_CreateParticipacao() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Participacao model = service.findById(anyInt());
        service.create(repositoryMock.save(model));

        // // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Model não esperado!", model);
    }

    @Test
    public void should_CreateV() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Participacao model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Participacao deve ser encontrado!", model);
    }

    @Test
    public void should_UpdateEvento() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Participacao model = service.findById(anyInt());
        model.setIdParticipacao(anyInt());
        service.create(repositoryMock.save(model));

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Participacao deve ser encontrado!", model);
    }

    @Test
    public void should_DeleteCategoriaEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Participacao model = service.findById(anyInt());
        model.setIdParticipacao(anyInt());

        Integer id = model.getIdParticipacao();
        service.deleteParticipacao(id);

        // then
        verify(repositoryMock, times(2)).findById(anyInt());
        assertNotNull("CategoriaEvento deve ser encontrado!", model);
    }

    // Dá erro de NUllPointer
    // @Test
    // public void should_ListOneItem() {
    // List<StatusEvento> list = new ArrayList<>();
    // list.add(entity);
    // when(repositoryMock.findAll()).thenReturn(list);

    // List<StatusEvento> listR = service.list();

    // VerifyError(repositoryMock, times(2)).findAll();
    // assertNotNull("Array não deve ser nulo", listR);
    // assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    // }

    // private JpaRepository<StatusEvento, Integer>
    // VerifyError(StatusEventoRepository repositoryMock2, VerificationMode times) {
    // return null;
    // }

}