# sort\_integer\_with_java with a servlet and a junit test for that servlet

Just testing a servlet with Mockito that submits a request to a servlet that uses sort\_integer\_with_java and tests the response


-- pom.xml <br/>
dependency : sort\_integer\_with\_java\_and_servlet<br/>
dependency : javax.servlet-api (4.0.1)<br/>
dependency : junit (4.12)<br/>
dependency : mockito-all (1.10.19)<br/>

<br/>
-- SortIntegersServletTest.java <br/>
@Mock<br/>
HttpServletRequest request;<br/>
@Mock<br/>
HttpServletResponse response;<br/>

public void test() {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;when(request.getParameter(SortIntegersServlet.paramOfIntsInRequest)).thenReturn("5,6,4");<br/>
&nbsp;&nbsp;&nbsp;&nbsp;myServlet.doGet(request, response);<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String actualResult = sw.getBuffer().toString().trim();<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String expectedResult = "[4,5,6]";<br/>
&nbsp;&nbsp;&nbsp;&nbsp;assertEquals(expectedResult, actualResult);<br/>
&nbsp;&nbsp;&nbsp;&nbsp;verify(response, times(1)).setCharacterEncoding("UTF-8");<br/>
&nbsp;&nbsp;&nbsp;&nbsp;verify(response, times(1)).setContentType("application/json");<br/>
	