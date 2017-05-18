package br.com.pcgravacao.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pcgravacao.financas.modelo.Categoria;
import br.com.pcgravacao.financas.modelo.Movimentacao;
import br.com.pcgravacao.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultados = query.getResultList();
		em.getTransaction().commit();
		em.close();
	}
}
