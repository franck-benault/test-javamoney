package net.franckbenault.javamoney;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.UnknownCurrencyException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class MainTestCase {
	
	@Nested
    @DisplayName("Tests currency unit")
    class CurrencyCode {
		
		@Test
		public void givenCurrencyCode_whenString_thanExist_usd() {
		    CurrencyUnit usd = Monetary.getCurrency("USD");
		 
		    assertNotNull(usd);
		    assertEquals(usd.getCurrencyCode(), "USD");
		    assertEquals(usd.getNumericCode(), 840);
		    assertEquals(usd.getDefaultFractionDigits(), 2);
		}
		
		@Test
		public void givenCurrencyCode_whenString_thanExist_eur() {
		    CurrencyUnit usd = Monetary.getCurrency("EUR");
		 
		    assertNotNull(usd);
		    assertEquals(usd.getCurrencyCode(), "EUR");
		    assertEquals(usd.getNumericCode(), 978);
		    assertEquals(usd.getDefaultFractionDigits(), 2);
		}
		
		@Test
		public void givenCurrencyCode_whenNoExist_thanThrowsError() {
			assertThrows(UnknownCurrencyException.class, 
					() -> Monetary.getCurrency("AAA"));
		}
		
	}



}
