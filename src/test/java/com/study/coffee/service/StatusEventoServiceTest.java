package com.study.coffee.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.study.coffee.domain.entities.StatusEvento;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.StatusEventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * StatusEventoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private StatusEventoRepository repositoryMock;

    @InjectMocks
    private StatusEventoService service;

    private final Integer idStatusEvento = 6;
    private final String nome = "Aberto para Inscrições";

    StatusEvento entity = StatusEvento.builder().idStatusEvento(idStatusEvento).nome(nome).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("StatusEvento Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_CreateStatusEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        StatusEvento model = service.findById(anyInt());
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
        StatusEvento model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado!", model);
    }

    @Test
    public void should_UpdateStatusEvento() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        StatusEvento model = service.findById(anyInt());
        model.setIdStatusEvento(anyInt());
        service.create(repositoryMock.save(model));

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado!", model);
    }

    @Test
    public void should_DeleteStatusEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        StatusEvento model = service.findById(anyInt());
        model.setIdStatusEvento(anyInt());

        Integer id = model.getIdStatusEvento();
        service.deleteStatusEvento(id);

        // then
        verify(repositoryMock, times(2)).findById(anyInt());
        assertNotNull("StatusEvento deve ser encontrado!", model);
    }

    // Dá erro de NUllPointer
    // @Test
    // public void should_ListOneItem() {
    //     List<StatusEvento> list = new ArrayList<>();
    //     list.add(entity);
    //     when(repositoryMock.findAll()).thenReturn(list);

    //     List<StatusEvento> listR = service.list();

    //     VerifyError(repositoryMock, times(2)).findAll();
    //     assertNotNull("Array não deve ser nulo", listR);
    //     assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    // }

    // private JpaRepository<StatusEvento, Integer> VerifyError(StatusEventoRepository repositoryMock2, VerificationMode times) {
    //     return null;
    // }

}