package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {
	
	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
	
	@Test
	void messageCodesResolverObejct() {
		String[] messageCodes =  codesResolver.resolveMessageCodes("required", "item");
		
		//for(String messageCode : messageCodes) {
		//	System.out.println("messageCode = " + messageCode);
		//}
		
		Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
	}

	@Test
	void messageCodeResolverField() {
		String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
		
		for(String messageCode : messageCodes) {
			System.out.println("messageCode = " + messageCode);
		}
		
	}
}
