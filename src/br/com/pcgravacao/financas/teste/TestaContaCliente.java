package br.com.pcgravacao.financas.teste;

import javax.persistence.EntityManager;

import br.com.pcgravacao.financas.modelo.Cliente;
import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua fulano 123");
		cliente.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
