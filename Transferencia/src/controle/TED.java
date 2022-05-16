package controle;

import dados.Transferencia;
import entrada.FormatoException;

public class TED extends Transferir{

    private Transferencia transferencia;
    private static double valor_minimo = 5000;
    private static double valor_maximo = 10000;
    
    protected void realizar(String dados[]) throws RegraNegocioException, FormatoException{

        Transferencia transferencia = new Transferencia(dados);
        limites(transferencia.getValor_transferencia(), valor_minimo, valor_maximo);
        
        this.transferencia = transferencia;

        alterarSaldos(transferencia);

        mostrarNovoSaldo(transferencia);

    }

    public Transferencia getTransferencia() {
        return (Transferencia)transferencia.clone();
    }

}