package JavaHandsOn.mockitoTests;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

 

public class mockitoTests {

	
	@Test
	public void testMock() {
		myServiceProvider obj=Mockito.mock(myServiceProvider.class);
		Mockito.when(obj.add(2, 4)).thenReturn(70);
		assertEquals(70, obj.add(2, 4));
		
	}
}
