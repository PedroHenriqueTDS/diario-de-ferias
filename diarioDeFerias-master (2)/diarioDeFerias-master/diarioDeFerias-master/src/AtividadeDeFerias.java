import java.util.Objects;

public class AtividadeDeFerias {
    private String descricao;
    private String tag;
    private double nota;

    public AtividadeDeFerias(String descricao, String tag, double nota) throws Exception {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new Exception("A descrição não pode ser vazia.");
        }
        if (tag == null || tag.trim().isEmpty()) {
            throw new Exception("A tag não pode ser vazia.");
        }
        if (nota < 0 || nota > 10) {
            throw new Exception("A nota deve estar entre 0 e 10.");
        }

        this.descricao = descricao;
        this.tag = tag;
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTag() {
        return tag;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + " | Tag: " + tag + " | Nota: " + nota;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AtividadeDeFerias)) return false;
        AtividadeDeFerias outra = (AtividadeDeFerias) o;
        return Double.compare(nota, outra.nota) == 0
                && Objects.equals(descricao, outra.descricao)
                && Objects.equals(tag, outra.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, tag, nota);
    }
}
