package br.com.cet.vo;

public class ParametroUsuarioVo extends EstruturaVo{

	private boolean mostraAtalhosTelaInicial;
	private boolean mostraGraficoTelaInicial;
	
	
	public boolean isMostraAtalhosTelaInicial() {
		return mostraAtalhosTelaInicial;
	}
	public void setMostraAtalhosTelaInicial(boolean mostraAtalhosTelaInicial) {
		this.mostraAtalhosTelaInicial = mostraAtalhosTelaInicial;
	}
	public boolean isMostraGraficoTelaInicial() {
		return mostraGraficoTelaInicial;
	}
	public void setMostraGraficoTelaInicial(boolean mostraGraficoTelaInicial) {
		this.mostraGraficoTelaInicial = mostraGraficoTelaInicial;
	}
	
}
