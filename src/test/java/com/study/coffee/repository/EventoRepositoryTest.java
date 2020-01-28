// package com.study.coffee.repository;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringRunner;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;

// import java.util.Calendar;
// import java.util.Date;
// import java.util.List;

// import com.study.coffee.domain.entities.CategoriaEvento;
// import com.study.coffee.domain.entities.Evento;
// import com.study.coffee.domain.entities.StatusEvento;
// import com.study.coffee.utils.IntegrationTestConfig;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// @TestPropertySource(locations = IntegrationTestConfig.appProperties)
// @ActiveProfiles("test")
// public class EventoRepositoryTest {

//         @Autowired
//         private TestEntityManager entityManager;

//         @Autowired
//         private EventoRepository eventoRepository;

//         @Test
//         public void whenFindByIdCategoriaEvento() {

//                 // Setando dados do StatusEvento
//                 StatusEvento statusEvento = new StatusEvento();
//                 statusEvento.setIdStatusEvento(1);
//                 statusEvento.setNome("Evento tópi");

//                 // Setando dados do CategoriaEvento
//                 CategoriaEvento categoriaEvento = new CategoriaEvento();
//                 categoriaEvento.setIdCategoriaEvento(1);
//                 categoriaEvento.setNome("Backend");

//                 // brincando com data
//                 Date hoje = new Date();
//                 Calendar data = Calendar.getInstance();

//                 data.setTime(hoje);
//                 data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) + 1);

//                 // given
//                 entityManager.persist(Evento.builder().idCategoriaEvento(categoriaEvento).idStatusEvento(statusEvento)
//                                 .dataInicio(data.getTime()).dataFim(data.getTime()).descricao("Evento maneiro")
//                                 .limiteVagas(50).local("Faria um Lima").nome("evento legal").build());
//                 entityManager.persist(Evento.builder().idCategoriaEvento(categoriaEvento).idStatusEvento(statusEvento)
//                                 .dataInicio(data.getTime()).dataFim(data.getTime()).descricao("Evento maneiro")
//                                 .limiteVagas(50).local("Faria um Lima").nome("evento legal").build());

//                 Date hoje1 = new Date();
//                 Calendar data1 = Calendar.getInstance();
//                 data1.setTime(hoje1);
//                 data1.set(Calendar.DAY_OF_MONTH, data1.get(Calendar.DAY_OF_MONTH) + 2);

//                 entityManager.persist(Evento.builder().idCategoriaEvento(categoriaEvento).idStatusEvento(statusEvento)
//                                 .dataInicio(data1.getTime()).dataFim(data1.getTime()).descricao("Evento maneiro")
//                                 .limiteVagas(50).local("Faria um Lima").nome("evento legal").build());

//                 entityManager.flush();

//                 Date hoje2 = new Date();
//                 Calendar data2 = Calendar.getInstance();
//                 data2.setTime(hoje2);
//                 data2.set(Calendar.DAY_OF_MONTH, data2.get(Calendar.DAY_OF_MONTH) - 1);
//                 // when
//                 List<Evento> found = eventoRepository.filterByData(data2.getTime());
//                 // then
//                 assertNotNull(found);
//                 assertEquals(found.size(), 2);
//         }

// }