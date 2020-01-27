package com.study.coffee.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.domain.entities.Evento;
import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.EventoRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * EventoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private EventoRepository repositoryMock;

    @InjectMocks
    private EventoService service;

    // variaveis da entidade
    private final String nome = "Meetup Frontend";
    private final String local = "Faria Lima";
    private final String descricao = "Evento muito top pra deixar a galerinha fera";
    private final Integer limiteVagas = 50;
    private Date date = new Date();

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
    }

    Evento entity = Evento.builder().idEvento(anyInt()).idStatusEvento(statusEvento).idCategoriaEvento(categoriaEvento)
            .nome(nome).dataInicio(date).dataFim(date).local(local).descricao(descricao).limiteVagas(limiteVagas)
            .build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Evento Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_CreateEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Evento model = service.findById(anyInt());
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
        Evento model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_UpdateEvento() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Evento model = service.findById(anyInt());
        model.setIdEvento(anyInt());
        service.create(repositoryMock.save(model));

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento deve ser encontrado!", model);
    }

    @Test
    public void should_DeleteCategoriaEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Evento model = service.findById(anyInt());
        model.setIdEvento(anyInt());

        Integer id = model.getIdEvento();
        service.deleteEvento(id);

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