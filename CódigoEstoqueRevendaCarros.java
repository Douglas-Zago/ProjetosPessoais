package IndicadorFinal;

import java.util.Scanner;

public class AtividadeIndicadorFinal {

    private static String[] carros = new String[50];
    private static int qtdCarros = 0;

    public static void main(String[] args) {
        cadastrarPrimeirosCarros();
        perguntarCadastroMaisCarros();
        listaDeCarros();
        pesquisarCarros();
    }

    private static void cadastrarPrimeirosCarros() {
        for (int nomeCarros = 0; nomeCarros < 6; nomeCarros++) {
            System.out.println("Informe o nome de um carro: ");
            carros[qtdCarros] = new Scanner(System.in).nextLine();
            qtdCarros++;
        }
    }

    private static void perguntarCadastroMaisCarros() {
        //System.out.println("Você deseja continuar cadastrando carros?");
        //String continuar = new Scanner(System.in).nextLine();
        String resposta = "";
        if (true) {
            while (true) {
                // System.out.println("Informe um novo carro: ");
                String maisCarros = "";

                System.out.println("Você gostaria de cadastrar mais carros? ('sim' ou 'nao')");
                resposta = new Scanner(System.in).nextLine();

                if (resposta.equalsIgnoreCase("sim")) {
                    System.out.println("Informe um novo carro: ");
                    maisCarros = new Scanner(System.in).nextLine();
                } else {
                    System.out.println("---------------------------------");
                    System.out.println("Cadastros concluídos com sucesso!");
                    break;
                }

                if (qtdCarros < carros.length) {
                    carros[qtdCarros] = maisCarros;
                    qtdCarros++;
                } else {
                    System.out.println("Limite de cadastro de carros atingido.");
                    break;
                }
            }
        } else if (resposta.equalsIgnoreCase("nao")) {
            System.out.println("--------------------------------");
            System.out.println("Cadastros concluídos com sucesso!");

        } else {
            System.out.println("Resposta inválida.(Continuando...)");
        }
    }

    private static void listaDeCarros() {
        System.out.println();
        System.out.println("Lista de carros: ");
        for (int i = 0; i < qtdCarros; i++) {
            System.out.println("Carro " + (i + 1) + " = " + carros[i]);
        }
        System.out.println();
    }

    private static void pesquisarCarros() {
        while (true) {
            System.out.println("Qual carro deseja?:");
            String carroPesquisa = new Scanner(System.in).nextLine();
            boolean carroEncontrado = false;
            int indiceCarro = -1;

            for (int i = 0; i < qtdCarros; i++) {
                if (carros[i].equalsIgnoreCase(carroPesquisa)) {
                    carroEncontrado = true;
                    indiceCarro = i;
                    break;
                }
            }
            if (carroEncontrado) {
                realizarCompraCarro(carroPesquisa, indiceCarro);
                break;
            } else {
                System.out.println("-------------------------------");
                System.out.println("Carro não existente no estoque.");
            }
            System.out.println("Você quer procurar mais carros no estoque ou deseja sair?");
            System.out.println("Digite 'sim' para procurar mais carros ou 'sair' para encerrar a busca.");
            String continuarPesquisa = new Scanner(System.in).nextLine();

            if (continuarPesquisa.equalsIgnoreCase("sair")) {
                System.out.println();
                System.out.println("Busca encerrada!");
                break;
            }
        }
    }

    private static void realizarCompraCarro(String carroPesquisa, int indiceCarro) {
        System.out.println("---------------------------");
        System.out.println("Carro existente no estoque.");
        System.out.println();
        System.out.println("Deseja comprar este carro? ('sim' ou 'nao')");
        String desejaComprar = new Scanner(System.in).nextLine();

        if (desejaComprar.equalsIgnoreCase("sim")) {
            System.out.println("Você vai dar algum carro na troca? ('sim' ou 'nao')");
            String carroEmTroca = new Scanner(System.in).nextLine();

            if (carroEmTroca.equalsIgnoreCase("sim")) {
                System.out.println("Informe o nome do carro que vai dar em troca:");
                String carroTroca = new Scanner(System.in).nextLine();
                carros[indiceCarro] = carroTroca;
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Troca realizada com sucesso. Carro " + carroPesquisa + " foi trocado pelo carro " + carroTroca + ".");
                System.out.println("---------------------------------------------------------------------");
                listaDeCarros();
                System.out.println("Busca encerrada!");
            } else {
                System.out.println();
                System.out.println("Carro " + carroPesquisa + " vendido com sucesso.");
                removerCarroDoEstoque(indiceCarro);
                listaDeCarros();
                System.out.println("Busca encerrada!");
            }
        }

    }

    private static void removerCarroDoEstoque(int indiceCarro) {
        for (int i = indiceCarro; i < qtdCarros - 1; i++) {
            carros[i] = carros[i + 1];//coloca o carro vendido na ultima posicao
        }
        carros[qtdCarros - 1] = null; //faz com que o carro que foi vendido seja retirado do array
        qtdCarros--;            //null é para o espaço ficar vazio e evitar que haja duplicaçoes
    }
}
