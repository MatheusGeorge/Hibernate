package br.com.pcgravacao.financas.teste;

import javax.persistence.EntityManager;

import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Danilo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Economica");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		//em.persist(conta);
		conta = em.find(Conta.class, 1);
		em.remove(conta);
		conta.setBanco("Bradesco");
		em.getTransaction().commit();
		
		em.close();
		
	}
}
