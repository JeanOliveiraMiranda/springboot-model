package com.study.coffee.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.study.coffee.domain.entities.CategoriaEvento;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.CategoriaEventoRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * CategoriaEventoServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private CategoriaEventoRepository repositoryMock;

    @InjectMocks
    private CategoriaEventoService service;

    private final Integer idCategoriaEvento = 1;
    private final String nome = "Backend";

    CategoriaEvento entity = CategoriaEvento.builder().idCategoriaEvento(idCategoriaEvento).nome(nome).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("CategoriaEvento Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_CreateCategoriaEvento() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        CategoriaEvento model = service.findById(anyInt());
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
        CategoriaEvento model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("CategoriaEvento deve ser encontrado!", model);
    }

    @Test
    public void should_UpdateCategoriaEvento() {

    // given
    when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

    // when
    CategoriaEvento model = service.findById(anyInt());
    model.setIdCategoriaEvento(anyInt());
    service.create(repositoryMock.save(model));

    // then
    verify(repositoryMock, times(1)).findById(anyInt());
    assertNotNull("StatusEvento deve ser encontrado!", model);
    }

    @Test
    public void should_DeleteCategoriaEvento() {
    // given
    when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

    // when
    CategoriaEvento model = service.findById(anyInt());
    model.setIdCategoriaEvento(anyInt());

    Integer id = model.getIdCategoriaEvento();
    service.deleteCategoriaEvento(id);

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