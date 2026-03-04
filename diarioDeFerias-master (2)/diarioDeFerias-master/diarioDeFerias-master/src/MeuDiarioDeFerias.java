import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeuDiarioDeFerias {
    private List<AtividadeDeFerias> atividades;

    public MeuDiarioDeFerias() {
        atividades = new ArrayList<>();
    }

    public void adicionaAtividade(String descricao, String tag, double nota) throws Exception {
        AtividadeDeFerias at = new AtividadeDeFerias(descricao, tag, nota);
        atividades.add(at);
    }

    private void verificaSeVazio() throws Exception {
        if (atividades.isEmpty()) {
            throw new Exception("O diário está vazio. Cadastre uma atividade primeiro.");
        }
    }

    public String listaAtividades() throws Exception {
        verificaSeVazio();

        String resultado = "";
        for (AtividadeDeFerias at : atividades) {
            resultado += at.toString() + "\n";
        }
        return resultado;
    }

    public String listaAtividadesOrdenadasPorNota() throws Exception {
        verificaSeVazio();

        List<AtividadeDeFerias> copia = new ArrayList<>(atividades);

        Collections.sort(copia, Comparator.comparingDouble(AtividadeDeFerias::getNota).reversed());

        String resultado = "";
        for (AtividadeDeFerias at : copia) {
            resultado += at.toString() + "\n";
        }
        return resultado;
    }

    public String pesquisaPorTag(String tag) throws Exception {
        verificaSeVazio();

        if (tag == null || tag.trim().isEmpty()) {
            throw new Exception("A tag para pesquisa não pode ser vazia.");
        }

        String resultado = "";

        for (AtividadeDeFerias at : atividades) {
            if (at.getTag().equalsIgnoreCase(tag.trim())) {
                resultado += at.toString() + "\n";
            }
        }

        if (resultado.isEmpty()) {
            throw new Exception("Nenhuma atividade encontrada com a tag informada.");
        }

        return resultado;
    }
}
