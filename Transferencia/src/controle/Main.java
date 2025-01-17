package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import entrada.Arquivo;
import entrada.FormatoException;

public class Main {
    public static void main(String[] args) throws IOException{

        try{
        String[] dados = new String[11];  
        
        //lê o arquivo e armazena os dados no array dados
        dados = Arquivo.ler(args);
        
        //nos métodos "realizar", valida e armazena os dados e também realiza a transferência.
        if(dados[2].equals("PIX")){
            PIX transferencia = new PIX();
            transferencia.realizar(dados);
        }

        else if(dados[2].equals("TED")){
            TED transferencia = new TED();
            transferencia.realizar(dados);
        }

        else if(dados[2].equals("DOC")){
            DOC transferencia = new DOC();
            transferencia.realizar(dados);
        }
        else{
            throw new FormatoException("o formato do tipo_transferencia está incorreto");
        }
        
    }
    catch(FileNotFoundException e){
        System.out.println("O arquivo de entrada não pôde ser encontrado.");
    }
    //catch abaixo para erros de formato na entrada
    catch(FormatoException e){
        System.out.println("Sua transferência não foi completada pois " + e.getMessage());
    }
    //catch abaixo para excecoes de regra de negocio. Ex: acima do limite para a transferencia escolhida
    catch(RegraNegocioException e){
        System.out.println("Sua transferência não foi completada pois " + e.getMessage());
    }
        
    }

}
