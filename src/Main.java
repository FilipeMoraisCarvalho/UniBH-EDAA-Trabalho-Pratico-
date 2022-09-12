import java.util.Scanner;
import java.io.IOException;

public class Main{
    private static final Scanner Input = new Scanner(System.in);
    private static Conta ContaAtiva = new Conta();

    public static void main(String[] args) {
        while(true){
            IniciarOperacao();
        }
    }
    private static void IniciarOperacao(){
        final String apresentacao = "Olá, "+ ContaAtiva.NomeCliente + " seja bem-vindo(a) ";
        final String operacaoDepositar = "1 - Depositar valor";
        final String operacaoRetirar = "2 - Sacar valor";
        final String operacaoSaldo = "3 - Exibir saldo";
        final String operacaoTransferir = "4 - Tranferir valor";

        System.out.println("\n"+
                String.format(
                        "%s\n%s\n%s\n%s\n%s\n",
                        apresentacao,
                        operacaoDepositar,
                        operacaoRetirar,
                        operacaoSaldo,
                        operacaoTransferir
                )
        );
        System.out.print("Escolha uma das operações e pressione ENTER: ");

        int operacaoSelecionada = Input.nextInt();
        GerenciaOperacoes(operacaoSelecionada);
    }
    private static void GerenciaOperacoes(int operacaoSelecionada){
        switch(operacaoSelecionada) {
            case 1 -> Depositar();
            case 2 -> Sacar();
            case 3 -> SaldoConta();
            case 4 -> Transferir();
            default -> System.out.println("Operação inserida inválida.");
        }
    }
    private static RetornoFuncoes Depositar(){
        System.out.print("Digite o valor a ser depositado: ");
        int valor = Input.nextInt();
        boolean deposito = ContaAtiva.Depositar(valor);

        if(deposito){
            return new RetornoFuncoes(true);
        } else{
            return new RetornoFuncoes(false);
        }
    }

    private static RetornoFuncoes Sacar(){
        System.out.print("Digite o valor a ser sacado: ");
        int valor = Input.nextInt();
        boolean saque = ContaAtiva.Sacar(valor);

        if(saque){
            return new RetornoFuncoes(true);
        } else {
            return new RetornoFuncoes(false);
        }
    }

    private static void SaldoConta(){
        System.out.print("Valor atual da conta: " + ContaAtiva.retornaSaldo());
    }

    private static RetornoFuncoes Transferir(){
        var contaATransferir = new Conta();
        System.out.print("Digite o valor a ser transferido: ");
        double valor = Input.nextDouble();
        boolean transferencia = ContaAtiva.Transferir(valor, ContaAtiva, contaATransferir);

        if(transferencia){
            System.out.print("Valor atual da conta ativa: " + ContaAtiva.retornaSaldo());
            return new RetornoFuncoes(true);
        } else {
            return new RetornoFuncoes(false);
        }
    }
}