package br.com.pcgravacao.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.pcgravacao.financas.modelo.Categoria;
import br.com.pcgravacao.financas.modelo.Conta;
import br.com.pcgravacao.financas.modelo.Movimentacao;
import br.com.pcgravacao.financas.modelo.TipoMovimentacao;
import br.com.pcgravacao.financas.util.JPAUtil;

public class PopulaTesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		movimentacao2.setData(amanha);
		movimentacao2.setDescricao("Viagem a Rio");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
	}

}
