import java.util.Scanner;

public class DiarioDeFerias {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MeuDiarioDeFerias diario = new MeuDiarioDeFerias();

        boolean executando = true;

        while (executando) {
            System.out.println("\n=== MEU DIÁRIO DE FÉRIAS ===");
            System.out.println("1. Adicionar nova atividade");
            System.out.println("2. Listar todas as atividades");
            System.out.println("3. Listar atividades ordenadas pela nota");
            System.out.println("4. Pesquisar atividades por tag");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(sc.nextLine());

                if (opcao == 1) {
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Tag: ");
                    String tag = sc.nextLine();

                    System.out.print("Nota (0 a 10): ");
                    double nota = Double.parseDouble(sc.nextLine());

                    diario.adicionaAtividade(descricao, tag, nota);
                    System.out.println("Atividade adicionada com sucesso!");

                } else if (opcao == 2) {
                    System.out.println("\n--- Todas as atividades ---");
                    System.out.println(diario.listaAtividades());

                } else if (opcao == 3) {
                    System.out.println("\n--- Atividades ordenadas por nota ---");
                    System.out.println(diario.listaAtividadesOrdenadasPorNota());

                } else if (opcao == 4) {
                    System.out.print("Digite a tag para pesquisa: ");
                    String tagPesquisa = sc.nextLine();
                    System.out.println("\n--- Resultado da pesquisa ---");
                    System.out.println(diario.pesquisaPorTag(tagPesquisa));

                } else if (opcao == 5) {
                    System.out.println("Saindo do programa... Até mais!");
                    executando = false;

                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: você digitou um valor inválido.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}
