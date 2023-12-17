package JavaHandsOn.mockitoTests;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class) /* not working*/

public class mockAnnotationConcept {

	@Mock
	List<String> mocklist;

	/**
	 * below is deprecated
	 */
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void mockListTest() {
		when(mocklist.get(0)).thenReturn("ATUL KUMAR ARYA");
		assertEquals(mocklist.get(0), "ATUL KUMAR ARYA");
	}

	/**
	 * verify if the mocklist get(0) method called exactly once.
	 */
	@Test
	public void check_no_times_call_happened() {
		mocklist.add("one");
		mocklist.add("two");

		Mockito.verify(mocklist, times(2)).add(anyString()); // method was called exactly 2 times

		Mockito.verify(mocklist, atLeast(2)).add(anyString()); // method was called at least 2 times
	}

}
