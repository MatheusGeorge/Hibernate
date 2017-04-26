package br.com.pcgravacao.financas.teste;

import javax.persistence.EntityManager;

import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 1);
		conta.setTitular("João");
		conta.setAgencia("456");
		System.out.println(conta.getTitular());
		em.getTransaction().commit();
		em.close();

		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		conta.setTitular("Matheus");
		em2.merge(conta);
		em2.getTransaction().commit();
		em2.close();
	}

}
