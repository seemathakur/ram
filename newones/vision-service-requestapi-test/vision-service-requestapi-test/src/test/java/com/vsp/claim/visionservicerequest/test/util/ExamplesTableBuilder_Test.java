package com.vsp.claim.visionservicerequest.test.util;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Test;

import com.vsp.claim.visionservicerequest.test.util.ExamplesTableBuilder;

public class ExamplesTableBuilder_Test {

	@Test
	public void ArrayConstructorTest()
	{
		String[][] str = new String[3][2];
		
		str[0][0] = "col1";
		str[1][0] = "col2";
		str[2][0] = "col3";
		
		str[0][1] = "value1";
		str[1][1] = "value2";
		str[2][1] = "value3";
		
		ExamplesTableBuilder build = new ExamplesTableBuilder(str);
		ExamplesTable table = build.build();
		
		
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("value2", table.getRow(0).get("col2"));
		assertEquals("value3", table.getRow(0).get("col3"));
		
	}
	
	@Test
	public void testAddRowAndColumn() {
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		builder.addValue("col1", "v1");
		builder.addValue("col2", "v2");
		builder.addValue("col3", "v3");

		ExamplesTable table = builder.build();
		
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("value2", table.getRow(0).get("col2"));
		assertEquals("value3", table.getRow(0).get("col3"));
		assertEquals("v1", table.getRow(1).get("col1"));
		assertEquals("v2", table.getRow(1).get("col2"));
		assertEquals("v3", table.getRow(1).get("col3"));
	}
	
	@Test
	public void testAddRowAndColumnBlank() {
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col3","value3");
		ExamplesTable table = builder.build();
		
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("", table.getRow(0).get("col2"));
		assertEquals("value3", table.getRow(0).get("col3"));
	}
	
	@Test
	public void testAddMultipleheaders()
	{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		String[] headers = new String[]{"col1","col2","col3"};
		builder.addHeaders(headers);
		
		builder.addValue("col1","value1");
		builder.addValue("col3","value3");
		ExamplesTable table = builder.build();
		
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("", table.getRow(0).get("col2"));
		assertEquals("value3", table.getRow(0).get("col3"));
	}
	
	
	@Test
	public void removeHeaderTest()
	{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		
		builder.removeHeader("col2");
		ExamplesTable table = builder.build();
		
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col3", table.getHeaders().get(1));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("value3", table.getRow(0).get("col3"));
		
	}
	
	//TESTING REMOVES VALUES KEEPS HEADER INTEGRITY and that "" appears for empty spot
	@Test
	public void removeValuesTest()
	{
	
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		builder.addValue("col1", "v1");
		builder.addValue("col2", "v2");
		builder.addValue("col3", "v3");
		
		builder.removeValue("col3", "value3");

		ExamplesTable table = builder.build();
		
		//System.out.println(table.getRow(0));
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("value2", table.getRow(0).get("col2"));
		assertEquals("v3", table.getRow(0).get("col3"));
		
		assertEquals("v1", table.getRow(1).get("col1"));
		assertEquals("v2", table.getRow(1).get("col2"));
		assertEquals("", table.getRow(1).get("col3"));
	}
	
	@Test
	public void testingClear()
	{
	
	ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		
		builder.removeHeader("col2");
		
		builder.clear();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		builder.addValue("col1", "v1");
		builder.addValue("col2", "v2");
		builder.addValue("col3", "v3");
		
		builder.removeValue("col3", "value3");

		ExamplesTable table = builder.build();
		
		//System.out.println(table.getRow(0));
		assertEquals("col1", table.getHeaders().get(0));
		assertEquals("col2", table.getHeaders().get(1));
		assertEquals("col3", table.getHeaders().get(2));
		
		assertEquals("value1", table.getRow(0).get("col1"));
		assertEquals("value2", table.getRow(0).get("col2"));
		assertEquals("v3", table.getRow(0).get("col3"));
		assertEquals("v1", table.getRow(1).get("col1"));
		assertEquals("v2", table.getRow(1).get("col2"));
		

	}
	
	@Test
	public void testingMultipleBuild()
	{
		//TESTING MULTIPLE BUILDS, HOLDING INTEGRETIY THROUGHOUT. FIRST BUILD STANDARD
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		ExamplesTable table = builder.build();
		
		
		//ADDING NEW ROW AFTER BUILD AND REMOVAL OF HEADER
		builder.addValue("col1", "v1");
		builder.addValue("col2", "v2");
		builder.addValue("col3", "v3");
		builder.removeHeader("col2");
		
		table = builder.build();
		assertEquals("col1",table.getHeaders().get(0));
		assertEquals("col3",table.getHeaders().get(1));
		
		//System.out.print(table.getRow(0));
		assertEquals("value1",table.getRow(0).get("col1"));
		assertEquals("value3",table.getRow(0).get("col3"));
		assertEquals("v1",table.getRow(1).get("col1"));
		assertEquals("v3",table.getRow(1).get("col3"));
		
		
		//ADDING NEW HEADER + NEW VALUE
		builder.addValue("col4", "value4");
		table = builder.build();
		
		assertEquals("col1",table.getHeaders().get(0));
		assertEquals("col3",table.getHeaders().get(1));
		assertEquals("col4",table.getHeaders().get(2));
		
		assertEquals("value1",table.getRow(0).get("col1"));
		assertEquals("value3",table.getRow(0).get("col3"));
		assertEquals("value4",table.getRow(0).get("col4"));
		assertEquals("v1",table.getRow(1).get("col1"));
		assertEquals("v3",table.getRow(1).get("col3"));
		assertEquals("",table.getRow(1).get("col4"));
		

	}
	
	//TESTING THE BUILDERS STRING GENERATION
	@Test
	public void getBuildStringInConsoleForm()
	{
		ExamplesTableBuilder builder = new ExamplesTableBuilder();
		
		builder.addHeader("col1");
		builder.addHeader("col2");
		builder.addHeader("col3");
		
		builder.addValue("col1","value1");
		builder.addValue("col2","value2");
		builder.addValue("col3","value3");
		builder.addValue("col1", "v1");
		builder.addValue("col2", "v2");
		builder.addValue("col3", "v3");
		builder.removeValue("col2","value2");
		
		//System.out.println(builder.getBuildString());
		assertEquals("|col1|col2|col3|\r\n|value1|v2|value3|\r\n|v1||v3|", builder.getBuildString());
	}
	
	@Test
	public void UltimateTest()
	{
		ExamplesTableBuilder b = new ExamplesTableBuilder();
		b.addHeader("h1");
		ExamplesTable table = b.build();
		
		assertEquals(table.getRowCount(),1);
		
		assertEquals("h1", table.getHeaders().get(0));
		assertEquals(table.getRowCount(),1);
		assertEquals(table.getRow(0).get("h1"),"");
		assertEquals(table.getHeaders().size(),1);
		
		b.addValue("h1", "v1");
		boolean work = b.addHeader("h1");
		
		table = b.build();
		
		assertEquals("h1", table.getHeaders().get(0));
		assertEquals(table.getRowCount(),1);
		assertEquals(table.getRow(0).get("h1"),"v1");
		assertEquals(table.getHeaders().size(),1);
		assertEquals(work,false);
		
		String[] headers= new String[]{"h1","h2","h3","h4","h5"};
		b.addValue("h1", "v2");
		b.addHeaders(headers);
		
		table = b.build();
		
		assertEquals(table.getRowCount(),2);
		
		assertEquals(table.getHeaders().size() , 5);
		assertEquals(table.getRow(0).get("h1"),"v1");
		assertEquals(table.getRow(0).get("h2"),"");
		assertEquals(table.getRow(0).get("h3"),"");
		assertEquals(table.getRow(0).get("h4"),"");
		assertEquals(table.getRow(0).get("h5"),"");
		
		assertEquals(table.getRow(1).get("h1"),"v2");
		assertEquals(table.getRow(1).get("h2"),"");
		assertEquals(table.getRow(1).get("h3"),"");
		assertEquals(table.getRow(1).get("h4"),"");
		assertEquals(table.getRow(1).get("h5"),"");
		
		b.addValue("h2", "");
		b.addValue("h2", "v2");
		b.addValue("h2", "v3");
		
		table = b.build();
		
		assertEquals(table.getRowCount(),3);
		
		assertEquals(table.getHeaders().size() , 5);
		assertEquals(table.getRow(0).get("h1"),"v1");
		assertEquals(table.getRow(0).get("h2"),"");
		assertEquals(table.getRow(0).get("h3"),"");
		assertEquals(table.getRow(0).get("h4"),"");
		assertEquals(table.getRow(0).get("h5"),"");
		
		assertEquals(table.getRow(1).get("h1"),"v2");
		assertEquals(table.getRow(1).get("h2"),"v2");
		assertEquals(table.getRow(1).get("h3"),"");
		assertEquals(table.getRow(1).get("h4"),"");
		assertEquals(table.getRow(1).get("h5"),"");
		
		
		assertEquals(table.getRow(2).get("h1"),"");
		assertEquals(table.getRow(2).get("h2"),"v3");
		assertEquals(table.getRow(2).get("h3"),"");
		assertEquals(table.getRow(2).get("h4"),"");
		assertEquals(table.getRow(2).get("h5"),"");

		b.removeValue("h2","v3");
		table = b.build();
		
		assertEquals(table.getHeaders().size() , 5);
		assertEquals(table.getRow(0).get("h1"),"v1");
		assertEquals(table.getRow(0).get("h2"),"");
		assertEquals(table.getRow(0).get("h3"),"");
		assertEquals(table.getRow(0).get("h4"),"");
		assertEquals(table.getRow(0).get("h5"),"");
		
		assertEquals(table.getRow(1).get("h1"),"v2");
		assertEquals(table.getRow(1).get("h2"),"v2");
		assertEquals(table.getRow(1).get("h3"),"");
		assertEquals(table.getRow(1).get("h4"),"");
		assertEquals(table.getRow(1).get("h5"),"");
		
		assertEquals(table.getRowCount(),2);
		
	}

}
