public class Conta {
    public double Saldo = 1000;
    public String NomeCliente = "Cliente Filipe";
    private String CpfCliente = "999.999.999-99";
    private String NroConta = "9999-99";
    private String Agencia = "0000";

    public boolean Depositar(int valor){
        if(valor <= 0){
            return false;
        }
        this.Saldo += valor;
        System.out.print("Valor atual da conta: " + this.Saldo);
        return true;
    }

    public boolean Sacar(int valor){
        if(valor <= 0 || valor > this.Saldo){
            System.out.print("Saldo insuficiente" + "\n");
            return false;
        } else {
            this.Saldo -= valor;
            System.out.print("Valor atual da conta: " + this.Saldo);
            return true;
        }
    }

    public double retornaSaldo(){
        return this.Saldo;
    }

    public boolean Transferir(double valor, Conta pagador, Conta receptor){
        if(pagador.Saldo < valor || valor <= 0){
            return false;
        }

        pagador.Saldo -= valor;
        receptor.Saldo += valor;
        return true;
    }

}
