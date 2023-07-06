package devandroid.maruzam.appgaseta.apoio;

public class UtilGasEta {
/*

    public void metodoEstatico(){}
    public static void metodoNaoEstatico(){}
    public static String mensagem (){
        return "Qualquer mensagem..";

    }
*/
    public static String calcularMelhorOpcao(double gasolina, double etanol){
        // preço gasolina: R$ 5,12 preço etanol; R$ 3,99
        // preço ideal = gasolina * 0,70 = R$ 3,548

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal){
            mensagemDeRetorno = "Abastecer com Etanol";
        }else {
            mensagemDeRetorno = "Abastecer com Gasolina";
        }
        return mensagemDeRetorno;

    }

}




