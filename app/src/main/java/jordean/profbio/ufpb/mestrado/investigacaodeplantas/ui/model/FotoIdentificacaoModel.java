package jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model;

import androidx.lifecycle.ViewModel;

public class FotoIdentificacaoModel extends ViewModel {

    public static final int SIM = 1;
    public static final int NAO = 0;
    public static final int UNDEFINED = -1;

    private int existemOrganismosDoReinoPlantae;

    private String fotoComVegetacao;

    private String motivoNaoTerOrganismos;

    private String tiposDeAtividadeAmbiente;
    private String sobreVegetacoesPassadas;

    private int existemBriofitasNoAmbiente;

    private String fotoBriofitas;

    private String pesquisaSobreBriofitas;

    private int existemPteridofitasNoAmbiente;

    private String fotoPteridofitas;
    private String fotoSoros;

    private String pesquisaSobrePteridofitas;

    private int sabeONomeDasPteridofitas;

    private String pesquisaEspeciesPteridofitas;
    private String nomePteridofitasFotografadas;

    private int existemGimnospermasNoAmbiente;

    private String fotoGimnospermas;
    private String fotoEstrobilos;

    private int existemAngiospermasNoAmbiente;

    private String fotoAngiospermas;
    private String fotoFlores;

    private int existePlantaSemGrupoIdentificado;

    private String fotoPlantaSemGrupo;
    private String caracteristicasPlantaSemGrupo;

    private String pesquisaGimnospermas;

    private String pesquisaAngiospermas;

    public String getPesquisaGimnospermas() {
        return pesquisaGimnospermas;
    }

    public void setPesquisaGimnospermas(String pesquisaGimnospermas) {
        this.pesquisaGimnospermas = pesquisaGimnospermas;
    }

    public String getPesquisaAngiospermas() {
        return pesquisaAngiospermas;
    }

    public void setPesquisaAngiospermas(String pesquisaAngiospermas) {
        this.pesquisaAngiospermas = pesquisaAngiospermas;
    }

    public int isExistemOrganismosDoReinoPlantae() {
        return existemOrganismosDoReinoPlantae;
    }

    public void setExistemOrganismosDoReinoPlantae(int existemOrganismosDoReinoPlantae) {
        this.existemOrganismosDoReinoPlantae = existemOrganismosDoReinoPlantae;
    }

    public String getFotoComVegetacao() {
        return fotoComVegetacao;
    }

    public void setFotoComVegetacao(String fotoComVegetacao) {
        this.fotoComVegetacao = fotoComVegetacao;
    }

    public String getMotivoNaoTerOrganismos() {
        return motivoNaoTerOrganismos;
    }

    public void setMotivoNaoTerOrganismos(String motivoNaoTerOrganismos) {
        this.motivoNaoTerOrganismos = motivoNaoTerOrganismos;
    }

    public String getTiposDeAtividadeAmbiente() {
        return tiposDeAtividadeAmbiente;
    }

    public void setTiposDeAtividadeAmbiente(String tiposDeAtividadeAmbiente) {
        this.tiposDeAtividadeAmbiente = tiposDeAtividadeAmbiente;
    }

    public String getSobreVegetacoesPassadas() {
        return sobreVegetacoesPassadas;
    }

    public void setSobreVegetacoesPassadas(String sobreVegetacoesPassadas) {
        this.sobreVegetacoesPassadas = sobreVegetacoesPassadas;
    }

    public int isExistemBriofitasNoAmbiente() {
        return existemBriofitasNoAmbiente;
    }

    public void setExistemBriofitasNoAmbiente(int existemBriofitasNoAmbiente) {
        this.existemBriofitasNoAmbiente = existemBriofitasNoAmbiente;
    }

    public String getFotoBriofitas() {
        return fotoBriofitas;
    }

    public void setFotoBriofitas(String fotoBriofitas) {
        this.fotoBriofitas = fotoBriofitas;
    }

    public String getPesquisaSobreBriofitas() {
        return pesquisaSobreBriofitas;
    }

    public void setPesquisaSobreBriofitas(String pesquisaSobreBriofitas) {
        this.pesquisaSobreBriofitas = pesquisaSobreBriofitas;
    }

    public int isExistemPteridofitasNoAmbiente() {
        return existemPteridofitasNoAmbiente;
    }

    public void setExistemPteridofitasNoAmbiente(int existemPteridofitasNoAmbiente) {
        this.existemPteridofitasNoAmbiente = existemPteridofitasNoAmbiente;
    }

    public String getFotoPteridofitas() {
        return fotoPteridofitas;
    }

    public void setFotoPteridofitas(String fotoPteridofitas) {
        this.fotoPteridofitas = fotoPteridofitas;
    }

    public String getFotoSoros() {
        return fotoSoros;
    }

    public void setFotoSoros(String fotoSoros) {
        this.fotoSoros = fotoSoros;
    }

    public String getPesquisaSobrePteridofitas() {
        return pesquisaSobrePteridofitas;
    }

    public void setPesquisaSobrePteridofitas(String pesquisaSobrePteridofitas) {
        this.pesquisaSobrePteridofitas = pesquisaSobrePteridofitas;
    }

    public int isSabeONomeDasPteridofitas() {
        return sabeONomeDasPteridofitas;
    }

    public void setSabeONomeDasPteridofitas(int sabeONomeDasPteridofitas) {
        this.sabeONomeDasPteridofitas = sabeONomeDasPteridofitas;
    }

    public String getPesquisaEspeciesPteridofitas() {
        return pesquisaEspeciesPteridofitas;
    }

    public void setPesquisaEspeciesPteridofitas(String pesquisaEspeciesPteridofitas) {
        this.pesquisaEspeciesPteridofitas = pesquisaEspeciesPteridofitas;
    }

    public String getNomePteridofitasFotografadas() {
        return nomePteridofitasFotografadas;
    }

    public void setNomePteridofitasFotografadas(String nomePteridofitasFotografadas) {
        this.nomePteridofitasFotografadas = nomePteridofitasFotografadas;
    }

    public int isExistemGimnospermasNoAmbiente() {
        return existemGimnospermasNoAmbiente;
    }

    public void setExistemGimnospermasNoAmbiente(int existemGimnospermasNoAmbiente) {
        this.existemGimnospermasNoAmbiente = existemGimnospermasNoAmbiente;
    }

    public String getFotoGimnospermas() {
        return fotoGimnospermas;
    }

    public void setFotoGimnospermas(String fotoGimnospermas) {
        this.fotoGimnospermas = fotoGimnospermas;
    }

    public String getFotoEstrobilos() {
        return fotoEstrobilos;
    }

    public void setFotoEstrobilos(String fotoEstrobilos) {
        this.fotoEstrobilos = fotoEstrobilos;
    }

    public int isExistemAngiospermasNoAmbiente() {
        return existemAngiospermasNoAmbiente;
    }

    public void setExistemAngiospermasNoAmbiente(int existemAngiospermasNoAmbiente) {
        this.existemAngiospermasNoAmbiente = existemAngiospermasNoAmbiente;
    }

    public String getFotoAngiospermas() {
        return fotoAngiospermas;
    }

    public void setFotoAngiospermas(String fotoAngiospermas) {
        this.fotoAngiospermas = fotoAngiospermas;
    }

    public String getFotoFlores() {
        return fotoFlores;
    }

    public void setFotoFlores(String fotoFlores) {
        this.fotoFlores = fotoFlores;
    }

    public int isExistePlantaSemGrupoIdentificado() {
        return existePlantaSemGrupoIdentificado;
    }

    public void setExistePlantaSemGrupoIdentificado(int existePlantaSemGrupoIdentificado) {
        this.existePlantaSemGrupoIdentificado = existePlantaSemGrupoIdentificado;
    }

    public String getFotoPlantaSemGrupo() {
        return fotoPlantaSemGrupo;
    }

    public void setFotoPlantaSemGrupo(String fotoPlantaSemGrupo) {
        this.fotoPlantaSemGrupo = fotoPlantaSemGrupo;
    }

    public String getCaracteristicasPlantaSemGrupo() {
        return caracteristicasPlantaSemGrupo;
    }

    public void setCaracteristicasPlantaSemGrupo(String caracteristicasPlantaSemGrupo) {
        this.caracteristicasPlantaSemGrupo = caracteristicasPlantaSemGrupo;
    }

}
