package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class alterarPragaTest {
    public static Praga praga;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void criaObjetoPraga() throws FileNotFoundException {
        praga = new Praga();
        praga = new Praga(11, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar nome praga existente")
    public void casoTesteAlterarNomePragaExistente(){
        alterarPraga.alterar(11, "nome", "novoAtributo");
        assertEquals("** Nome atualizado com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar doenças transmitidas praga existente")
    public void casoTesteAlterarDoencasPragaExistente(){
        alterarPraga.alterar(11, "doenças transmitidas", "novoAtributo");
        assertEquals("** Doenças Transimitidas atualizadas com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar tempo de vida praga existente")
    public void casoTesteAlterarTempoVidaPragaExistente(){
        alterarPraga.alterar(11, "tempo de vida", "novoAtributo");
        assertEquals("** Tempo de Vida atualizado com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar modo de combate praga existente")
    public void casoTesteAlterarCombatePragaExistente(){
        alterarPraga.alterar(11, "modos de combate", "novoAtributo");
        assertEquals("** Modo de Combate atualizado com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar praga existente com atributo invalido")
    public void casoTesteAlterarPragaExistenteAtributoInvalido(){
        alterarPraga.alterar(11, "invalido", "novoAtributo");
        assertEquals("** Opção invalida! Digite um dos nomes dos atributos.", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar praga nao existente")
    public void casoTesteAlterarPragaNaoExistente(){
        alterarPraga.alterar(200, "modos de combate", "novoAtributo");
        assertEquals("** Praga não encontrada. Liste todas para obter seus respectivos codigos.", outputStreamCaptor.toString().trim());
    }
}