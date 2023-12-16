package JavaHandsOn.mockitoTests;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class mockArrayList {
	@Test
	public void mockListTest() {
		List<String> mocklist = mock(List.class);
		when(mocklist.size()).thenReturn(6);
		assertTrue(mocklist.size() == 5);
	}
}
