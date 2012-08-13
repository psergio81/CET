package br.com.cet.dao;



public class Atualiza extends BaseAtualiza {


	private static final String NOME_BANCO = "ensaio";
	
	public static void main(String[] args) {
		
		Atualiza atualiza = new Atualiza();
		
		atualiza.a0001(false);
		atualiza.a0002(false);
		atualiza.a0003(false);
		atualiza.a0004(false);
		atualiza.a0005(false);
		atualiza.a0006(false);
		atualiza.a0007(false);
		
	}

	
	/**
	 * Criar tabela empresa e campos
	 */
	private void a0001(boolean rodar){

		if(!rodar){
			return;
		}
		
		String nomeTabela = "empresa";

		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_empresa", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_fantasia_empresa", 50, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cep", 10, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "endereco", 100, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "numero", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "complemento", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "bairro", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cidade", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "estado", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "telefone", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "fax", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "website", 40, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "email", 40, false);

	}
	
	/**
	 * Criar tabela marca e campos
	 */
	private void a0002(boolean rodar){

		if(!rodar){
			return;
		}
		
		String nomeTabela = "marca";

		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_marca", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_marca", 100, false);

	}

	
	/**
	 * Criar tabela marca e campos
	 */
	private void a0003(boolean rodar){

		if(!rodar){
			return;
		}
		
		String nomeTabela = "usuario";

		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_usuario", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_usuario", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_nick", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_senha", 20, false);
		executarComandoSql("Insert into usuario (cd_usuario,nm_usuario,nm_nick,nm_senha) Values(1,'ADM','adm','a')");

	}
	

	/**
	 * Criar tabela modelo e campos
	 */
	private void a0004(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "modelo";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_modelo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_modelo", 100, false);
		
	}

	/**
	 * Criar tabela ensaio e campos
	 */
	private void a0005(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "ensaio";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_ensaio", 0, false);	
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "data", 10, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_pessoa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "gru", 30, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_usuario_criador", 0, false);
		
	}

	/**
	 * Criar tabela veiculo e campos
	 */
	private void a0006(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "veiculo";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_veiculo", 100, false);
		
	}

	/**
	 * Criar tabela pessoa e campos
	 */
	private void a0007(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "pessoa";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_pessoa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_pessoa", 100, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "tipo_pessoa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cd_documento", 20, false);
		
	}
}
