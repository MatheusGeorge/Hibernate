package br.com.pcgravacao.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.modelo.TipoMovimentacao;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteFuncaoJPQL2 {

	public static void main(String[] args) {
	
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//MovimentacaoDAO dao = new MovimentacaoDAO(em);
		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		//List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		List<Double> medias = typedQuery.getResultList();
		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}
		em.getTransaction().commit();
		em.close();
		
	}

}
