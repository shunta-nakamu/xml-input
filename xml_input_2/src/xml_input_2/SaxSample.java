package xml_input_2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxSample extends DefaultHandler {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

		SAXParserFactory spfactory = SAXParserFactory.newInstance();

		SAXParser parser = spfactory.newSAXParser();

		parser.parse(new File("xml/sample.xml"), new SaxSample());
	}

	// start Document
	public void startDocument() {
		System.out.println("ドキュメント開始");
	}

	// start Element
	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		System.out.println("要素開始:" + qName);
	}

	// Text
	public void characters(char[] ch, int offset, int length) {

		System.out.println("テキストデータ：" + new String(ch, offset, length));
	}

	// End Element
	public void endElement(String uri, String localName, String qName) {

		System.out.println("要素終了:" + qName);
	}

	// End of Document
	public void endDocument() {
		System.out.println("ドキュメント終了");
	}

}