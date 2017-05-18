package br.com.pcgravacao.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.modelo.TipoMovimentacao;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteFuncaoJPQL {

	public static void main(String[] args) {
		
		//soma
		/*
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" +  " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		BigDecimal soma =  (BigDecimal) query.getSingleResult();
		System.out.println("A soma é: " + soma);
		
		em.getTransaction().commit();
		em.close();*/
		
		//média
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" +  " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		Double media =  (Double) query.getSingleResult();
		System.out.println("A média é: " + media);
		
		// buscar o maior gasto Query query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta");
		// buscar a quantidade de movimentacoes de uma conta Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		
		em.getTransaction().commit();
		em.close();
	}

}
