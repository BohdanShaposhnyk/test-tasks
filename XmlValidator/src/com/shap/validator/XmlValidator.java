package com.shap.validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by shpk on 12.01.2017.
 */
public class XmlValidator {

    static boolean validateXML(File xml, File xsd) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static int parseAndSum(File xmlFile) throws Exception {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();

        System.out.println("Root element :" + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName(Thing.TAGNAME);

        int sum = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                sum += Integer.parseInt(element.getElementsByTagName(Thing.PRICE).item(0).getTextContent());
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        File xml = new File(System.getProperty("user.dir") + "\\mydoc.xml");
        File xsd = new File(System.getProperty("user.dir") + "\\myschema.xsd");
        if (!xml.exists() || !xsd.exists()) {
            System.out.println("Files don't exist");
            return;
        }
        if (!validateXML(xml, xsd)) {
            System.out.println("XML don't match XSD");
            return;
        }

        try {
            System.out.println("Overall price: " + parseAndSum(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
