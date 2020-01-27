package com.study.coffee.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.study.coffee.domain.entities.Client;
import com.study.coffee.exception.DataNotFoundException;
import com.study.coffee.repository.ClientRepository;
import com.study.coffee.service.ClientService;

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
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ClientRepository repositoryMock;

    @InjectMocks
    private ClientService service;

    private final Integer id = 1;
    private final String name = "Some string";
    private final String phone = "987654321";

    Client entity = Client.builder().id(id).name(name).phone(phone).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Client Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_CreateClient() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());
        service.createClient(repositoryMock.save(model));

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Model não esperado!", model);
    }

    @Test
    public void should_CreateV() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    @Test
    public void should_UpdateClient() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());
        model.setId(anyInt());
        service.createClient(repositoryMock.save(model));

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    @Test
    public void should_DeleteCliente() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());
        model.setId(anyInt());

        Integer id = model.getId();
        service.delete(id);

        // then
        verify(repositoryMock, times(2)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    // @Test
    // public void should_ListOneItem() {
    //     List<Client> list = new ArrayList<>();
    //     list.add(entity);
    //     when(repositoryMock.findAll()).thenReturn(list);

    //     List<Client> listR = service.listClient();

    //     VerifyError(repositoryMock, times(2)).findAll();
    //     assertNotNull("Array não deve ser nulo", listR);
    //     assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    // }

    // private JpaRepository<Client, Integer> VerifyError(ClientRepository repositoryMock2, VerificationMode times) {
    //     return null;
    // }

}