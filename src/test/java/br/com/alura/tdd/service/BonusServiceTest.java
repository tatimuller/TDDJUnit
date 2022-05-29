package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService(); //instanciando a classe a ser testada
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("25000")))); 
        
//		try {
//			service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não caiu na excption");
//		}catch (Exception e) {
//			assertEquals("Funcionário com salário maior do que R$1000,00 não pode ganhar bonificação", e.getMessage());
//		}
		
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService(); //instanciando a classe a ser testada
		BigDecimal bonus = service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("2500"))); //chama o método que recebe um funcionário. Neste caso foi instanciado o objeto direto no parâmetro e passando os parâmetros do construtor
        assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService(); //instanciando a classe a ser testada
		BigDecimal bonus = service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("10000"))); //chama o método que recebe um funcionário. Neste caso foi instanciado o objeto direto no parâmetro e passando os parâmetros do construtor
        assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
