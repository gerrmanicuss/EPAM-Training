package ua.nure.emelianov.Practice4.part3;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.nure.emelianov.Practice4.part3.Part3;

public class Part3Test {

	private static final String ENCODING = "Cp1251";

	private static final String REGEXP_FOR_INTEGER = "(^|\\s)(\\d+)(\\s|$)";
	private static final String REGEXP_FOR_DOUBLE = "(^|\\s)([\\d+]*\\.\\d+)(\\s|$)";
	private static final String REGEXP_FOR_CHAR = "(?i)(^|(?<=\\s))[a-z�-�]($|(?=\\s))";
	private static final String REGEXP_FOR_STRING = "[�-��-�a-zA-Z]{2,}";

	Part3 part3;

	@Before
	public void constructorTest() {
		part3 = new Part3("part3.txt");
	}

	@Test
	public void testTestString() {
		part3.getString();
		part3.setFileName("INCORRECT_FILENAME");
		part3.getString();
	}

	@Test
	public void testDoubleValue() {
		int counter = 0;
		String[] arr = part3.doubleValue().split(" ");
		Pattern p = Pattern.compile(REGEXP_FOR_DOUBLE);
		Matcher m = p.matcher(part3.getString());
		while (m.find()) {
			++counter;
		}
		Assert.assertEquals(counter, arr.length);
	}

	@Test
	public void testCharValue() {
		int counter = 0;
		String[] arr = part3.charValue().split(" ");
		Pattern p = Pattern.compile(REGEXP_FOR_CHAR);
		Matcher m = p.matcher(part3.getString());
		while (m.find()) {
			++counter;
		}
		Assert.assertEquals(counter, arr.length);
	}

	@Test
	public void testStringValue() {
		int counter = 0;
		String[] arr = part3.stringValue().split(" ");
		Pattern p = Pattern.compile(REGEXP_FOR_STRING);
		Matcher m = p.matcher(part3.getString());
		while (m.find()) {
			++counter;
		}
		Assert.assertEquals(counter, arr.length);
	}

	@Test
	public void testIntegerValue() {
		int counter = 0;
		String[] arr = part3.integerValue().split(" ");
		Pattern p = Pattern.compile(REGEXP_FOR_INTEGER);
		Matcher m = p.matcher(part3.getString());
		while (m.find()) {
			++counter;
		}
		Assert.assertEquals(counter, arr.length);
	}

	@Test
	public void TestInput() {
		try {
			System.setIn(new ByteArrayInputStream(
					"char\nString\nint\ndouble\nstop".getBytes(ENCODING)));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Wrong encoding in Part3Test");
		}

		part3.input();
		try {
			System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble\nfdsfds".getBytes(ENCODING)));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Wrong encoding in Part3Test");
		}
		part3.input();
		System.setIn(System.in);
	}

	@Test
	public void testMain() {
		try {
			System.setIn(new ByteArrayInputStream(
					"char\nString\nint\ndouble\nstop".getBytes(ENCODING)));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Wrong encoding in Part3Test");
		}

		Part3.main(new String[] {});
		System.setIn(System.in);
	}
}
