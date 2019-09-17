package jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model;

import androidx.lifecycle.ViewModel;

public class ChaveIdentificacaoModel extends ViewModel {

    private int plantaEscolhida;

    private String respostaPergunta1;
    private String respostaPergunta2;
    private String respostaPergunta3;
    private String respostaPergunta4;
    private String respostaPergunta5;

    private String resultado;

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }


    public String getRespostaPergunta1() {
        return respostaPergunta1;
    }

    public void setRespostaPergunta1(String respostaPergunta1) {
        this.respostaPergunta1 = respostaPergunta1;
    }

    public String getRespostaPergunta2() {
        return respostaPergunta2;
    }

    public void setRespostaPergunta2(String respostaPergunta2) {
        this.respostaPergunta2 = respostaPergunta2;
    }

    public String getRespostaPergunta3() {
        return respostaPergunta3;
    }

    public void setRespostaPergunta3(String respostaPergunta3) {
        this.respostaPergunta3 = respostaPergunta3;
    }

    public String getRespostaPergunta4() {
        return respostaPergunta4;
    }

    public void setRespostaPergunta4(String respostaPergunta4) {
        this.respostaPergunta4 = respostaPergunta4;
    }

    public String getRespostaPergunta5() {
        return respostaPergunta5;
    }

    public void setRespostaPergunta5(String respostaPergunta5) {
        this.respostaPergunta5 = respostaPergunta5;
    }

    public int getPlantaEscolhida() {
        return plantaEscolhida;
    }

    public void setPlantaEscolhida(int plantaEscolhida) {
        this.plantaEscolhida = plantaEscolhida;
    }

}
