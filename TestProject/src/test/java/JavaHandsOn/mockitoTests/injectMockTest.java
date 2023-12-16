package JavaHandsOn.mockitoTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class injectMockTest {

	@Mock
	List<String> mockedList;
	@InjectMocks
	Employee mokcedEmp;
//	@Rule
//    public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void test() {

		when(mockedList.get(0)).thenReturn("ATUL");
		when(mockedList.size()).thenReturn(1);

		assertEquals("ATUL", mockedList.get(0));
		assertEquals(1, mockedList.size());

		assertEquals("ATUL", mokcedEmp.getEmpname().get(0));
		assertEquals(1, mokcedEmp.getEmpname().size());

		/*
		 * below will give null as we have not defined the behaveour of the index 1
		 */
		mockedList.add(1, "sam");
		System.out.println(mockedList.get(1));
	}

}

class Employee {
	List<String> empname;

	public List<String> getEmpname() {
		return empname;
	}

	public void setEmpname(List<String> empname) {
		this.empname = empname;
	}

}
