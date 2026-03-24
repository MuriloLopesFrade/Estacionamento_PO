import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static  Veiculo[] veiculo = new Veiculo[5];
    static int indexVeiculo;
    static Registros[] registros = new Registros[20];
    static int indexRegistro;

    public static void main(String[] args) {

        int opcao = 0;

        do {
            System.out.println("<======== Estacionamento ========>");
            System.out.println("""
                    [1] Entrada de veiculos;
                    [2] Saída de veiculos;
                    [3] Imprimir veiculos estacionados
                    [4] Imprimir receita
                    [5] Finalizar
                 
                    """);
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> registroEntrada();
                case 2 -> saidaVeiculo();
            }

        } while (opcao !=5);

    }

    private static void registroEntrada(){

        String nome;
        String marca,modelo,placa;
        long cpf;
        String horarioEntrada;

        Veiculo veiculoEncontrado = pesquisar();

        if (veiculoEncontrado == null){
            System.out.println("Nome do proprietario -->");
            nome = sc.next();
            System.out.println("Cpf do proprietario -->");
            cpf = sc.nextLong();
            System.out.println("Placa do carro -->");
            placa = sc.next().toUpperCase();
            System.out.println("Marca -->");
            marca = sc.next();
            System.out.println("Modelo -->");
            modelo = sc.next();

            Proprietario proprietario = new Proprietario(nome,cpf);
            veiculo[indexVeiculo] = new Veiculo(marca,modelo,placa,proprietario);
            indexVeiculo++;
        }else {
            System.out.println("Hora de entrada (hh:mm) -->");
            horarioEntrada = sc.next();
            registros[indexRegistro] = new Registros(veiculoEncontrado,horarioEntrada);
            indexVeiculo++;

        }

    }

    private static Veiculo pesquisar(){
        String placa;

        System.out.println("Placa para pesquisa: ");
        placa = sc.next().toUpperCase();

        for (int i = 0; i < indexVeiculo; i++) {
            if (veiculo[i].placa.equals(placa)){
                return veiculo[i];
            }
        }

        System.out.println("Veiculo não encontrado!! ");

        return null;

    }

    private static void saidaVeiculo(){}

}