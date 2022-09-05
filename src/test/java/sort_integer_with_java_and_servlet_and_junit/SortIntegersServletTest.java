package sort_integer_with_java_and_servlet_and_junit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import sort_integer_with_java_and_servlet.SortIntegersServlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SortIntegersServletTest {
	
	@Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void test() {
		try {
		when(request.getParameter(SortIntegersServlet.paramOfIntsInRequest)).thenReturn("5,6,4");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);
        SortIntegersServlet myServlet =new SortIntegersServlet();
        myServlet.doGet(request, response);
        String actualResult = sw.getBuffer().toString().trim();
        String expectedResult = "[4,5,6]";
        assertEquals(expectedResult, actualResult);
        verify(response, times(1)).setCharacterEncoding("UTF-8");
        verify(response, times(1)).setContentType("application/json");
		} catch(Exception e) {
			fail("exception thrown in test");
		}
	}
}
