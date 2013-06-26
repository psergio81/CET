package br.com.cet.dao;



public class Atualiza extends BaseAtualiza {


	private static final String NOME_BANCO = "postodee_ensaio";
	
	public static void main(String[] args) {
		
		Atualiza atualiza = new Atualiza();
		
		atualiza.a0001(true);
		atualiza.a0002(true);
		atualiza.a0003(true);
		atualiza.a0004(true);
		atualiza.a0005(true);
		atualiza.a0006(true);
		atualiza.a0007(true);
		atualiza.a0008(true);
		atualiza.a0009(true);
		atualiza.a0010(true);
		atualiza.a0011(true);
		atualiza.a0012(true);
		atualiza.a0013(true);
		atualiza.a0014(true);
		
		
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
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cnpj", 20, false);
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

		executarComandoSql("insert into empresa(cd_empresa, nm_empresa ) values(1, 'Empresa Principal ADM')");
		
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
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
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
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_senha", 32, false);
		executarComandoSql("Insert into usuario (cd_usuario,cd_empresa, nm_usuario,nm_nick,nm_senha) Values(1,1,'Paulo Sérgio','adm','0cc175b9c0f1b6a831c399e269772661')");
		executarComandoSql("Insert into usuario (cd_usuario,cd_empresa, nm_usuario,nm_nick,nm_senha) Values(2,1,'Michell Sarno','michellsarno','e12e4454a59552dc66625fbc7bc48977')");
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
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
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
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);	
		criarCampo(TipoCampo.DATA, NOME_BANCO, nomeTabela, "data", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "hora_inicio", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "hora_fim", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_pessoa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "gru", 30, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "tipo_servico", 0, false);
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
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_pessoa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "placa", 100, false);
		
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
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_pessoa", 100, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "tipo_pessoa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cd_documento", 20, false);
		
	}

	/**
	 * Criar tabela tacografo e campos
	 */
	private void a0008(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "tacografo";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_tacografo", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_marca", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_modelo", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "serie", 30, false);
		
	}

	private void a0009(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "veiculo_tacografo";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo_tacografo", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_tacografo", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "dt_inicio", 10, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "hr_inicio", 10, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "dt_fim", 10, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "hr_fim", 10, false);
		
	}

	private void a0010(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "programa";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_programa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_programa", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_programa_menu", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_programa_action", 100, false);
		
	}
	
	/**
	 * Criar tabela log
	 */
	private void a0011(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "log";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_programa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_usuario", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_log", 0, false);
		criarCampo(TipoCampo.DATA, NOME_BANCO, nomeTabela, "dt_log", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "hr_log", 0, false);
		
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "ip_log", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "acao_log", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "ds_log", 500, false);
		
	}

	/**
	 * Criar tabela parametro_usuario
	 */
	private void a0012(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "parametro_usuario";
		
		executarComandoSql("drop table "+nomeTabela);
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_usuario", 0, false);
		criarCampo(TipoCampo.BOOLEAN, NOME_BANCO, nomeTabela, "ic_mostra_atalhos", 0, false);
		criarCampo(TipoCampo.BOOLEAN, NOME_BANCO, nomeTabela, "ic_mostra_grafico", 0, false);
		
		executarComandoSql("Insert into parametro_usuario (cd_empresa, cd_usuario, ic_mostra_grafico, ic_mostra_atalhos) Values(1,1,1,1)");
		executarComandoSql("Insert into parametro_usuario (cd_empresa, cd_usuario, ic_mostra_grafico, ic_mostra_atalhos) Values(1,2,1,1)");
		
		
		
	}

	/**
	 * Criar tabela Agendamento
	 */
	private void a0013(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "agendamento";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_agendamento", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_pessoa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_veiculo", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_servico", 0, false);
		criarCampo(TipoCampo.DATA, NOME_BANCO, nomeTabela, "data", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "hora", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "gru", 30, false);
		
	}

	
	/**
	 * Criar tabela Consulta GRU
	 */
	private void a0014(boolean rodar){
		
		if(!rodar){
			return;
		}
		
		String nomeTabela = "consulta_gru";
		
		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_gru", 0, false);
		criarCampo(TipoCampo.DATA, NOME_BANCO, nomeTabela, "data", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "hora", 0, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "status", 0, false);
		
	}
}
