package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.TacografoVo;

public class TacografoDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(){
		
		return getProximoCodigo("tacografo", "cd_tacografo");
		
	}
	
	public TacografoVo getTacografoPeloCodigo(TacografoVo tacografoVo){
		return getTacografo(tacografoVo,1);
	}

	private TacografoVo getTacografo(TacografoVo tacografoVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	    	
	    	
		    qry.append(	"SELECT rowid, cd_tacografo, cd_marca, cd_modelo, serie FROM tacografo " );
		    qry.append(	"where cd_tacografo = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoTacografo()));
		    
		    rs = ps.executeQuery();  
		    
		    tacografoVo = null;
	    	
		    if (rs.next()) {  
		    	tacografoVo = new TacografoVo();
		    	
		    	tacografoVo.setRowid(rs.getString("rowid"));
		    	tacografoVo.setCodigoTacografo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_tacografo"))));
		    	tacografoVo.setCodigoMarca(String.valueOf(rs.getInt("cd_marca")));
		    	tacografoVo.setCodigoModelo(String.valueOf(rs.getInt("cd_modelo")));
		    	tacografoVo.setCodigoSerie(rs.getString("serie"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return tacografoVo;
	}
	
	public List<TacografoVo> getListaTacografos(TacografoVo tacografoVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<TacografoVo> tacografosList = null;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" SELECT t.rowid, t.cd_tacografo, t.cd_marca, t.cd_modelo, serie, ma.nm_marca nome_marca, mo.nm_modelo nome_modelo ");
		    qry.append(" FROM tacografo t, marca ma, modelo mo");
		    qry.append(" where t.cd_marca = ma.cd_marca and ");
		    qry.append(" t.cd_modelo = mo.cd_modelo ");
		
		    if(filtrar){
		    	qry.append(" WHERE serie like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	
		    	
		    }
		    
		    rs = ps.executeQuery();  
		  
		    tacografosList = new ArrayList<TacografoVo>();
		    
		    while (rs.next()) {  
		    	tacografoVo = new TacografoVo();
		    	
		    	tacografoVo.setRowid(rs.getString("rowid"));
		    	tacografoVo.setCodigoTacografo(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, UtConverte.stringToInteiro(rs.getString("cd_tacografo"))));
		    	tacografoVo.setCodigoMarca(String.valueOf(rs.getInt("cd_marca")));
		    	tacografoVo.setNomeMarca(rs.getString("nome_marca"));
		    	tacografoVo.setCodigoModelo(String.valueOf(rs.getInt("cd_modelo")));
		    	tacografoVo.setNomeModelo(rs.getString("nome_modelo"));
		    	tacografoVo.setCodigoSerie(rs.getString("serie"));
		    	
		    	
		    	tacografosList.add(tacografoVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return tacografosList;
	}

	
	public List<TacografoVo> getListaTacografosNaoAssociados(TacografoVo tacografoVo){
		
		Connection connection = null;
		ResultSet rs = null;  
		PreparedStatement ps = null;  
		StringBuilder qry = new StringBuilder(); 
		List<TacografoVo> tacografosList = null;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" SELECT rowid, cd_tacografo, cd_marca, cd_modelo, serie FROM tacografo ");
			qry.append(" WHERE cd_tacografo not in ( select distinct cd_tacografo ");
			qry.append(" from veiculo_tacografo ");
			qry.append(" where cd_veiculo = ? ");
			qry.append(" and dt_inicio is not null and dt_fim is null ) ");
			
			ps = connection.prepareStatement(qry.toString());
			
			ps.setInt(1, UtConverte.stringToInteiro(tacografoVo.getCodigoTacografo()));
			
			rs = ps.executeQuery();  
			
			tacografosList = new ArrayList<TacografoVo>();
			
			while (rs.next()) {  
				tacografoVo = new TacografoVo();
				
				tacografoVo.setRowid(rs.getString("rowid"));
				tacografoVo.setCodigoTacografo(rs.getString("cd_tacografo"));
				tacografoVo.setCodigoMarca(String.valueOf(rs.getInt("cd_marca")));
				tacografoVo.setCodigoModelo(String.valueOf(rs.getInt("cd_modelo")));
				tacografoVo.setCodigoSerie(rs.getString("serie"));
				
				tacografosList.add(tacografoVo);
			}  
			
		}catch (Exception e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps, rs);
		} 
		
		return tacografosList;
	}
	
	public void insertTacografos(TacografoVo tacografoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO tacografo ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_tacografo, ");
		    qry.append(" cd_marca, ");
		    qry.append(" cd_modelo, ");
		    qry.append(" serie ) ");
		    
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoTacografo()));
		    ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoMarca()));
		    ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoModelo()));
		    ps.setString(i++, tacografoVo.getCodigoSerie());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updateTacografos(TacografoVo tacografoVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE tacografo set ");
			qry.append(" cd_marca = ?, ");
			qry.append(" cd_modelo = ?, ");
			qry.append(" serie = ? ");
			qry.append(" WHERE cd_tacografo = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoMarca()));
			ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoModelo()));
			ps.setString(i++, tacografoVo.getCodigoSerie());

			ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoTacografo()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteTacografo(TacografoVo tacografoVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM tacografo WHERE cd_tacografo = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(tacografoVo.getCodigoTacografo()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
