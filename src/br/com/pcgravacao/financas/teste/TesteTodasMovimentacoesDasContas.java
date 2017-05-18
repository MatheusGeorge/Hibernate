package br.com.pcgravacao.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDasContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();


		em.getTransaction().begin();
		
		String jpql = "Select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		List<Conta> todasAsContas = query.getResultList();
		for (Conta conta : todasAsContas) {
			System.out.println("Titular " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}

		em.getTransaction().commit();
		em.close();
	}

}
