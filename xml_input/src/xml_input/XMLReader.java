package xml_input;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
    public static void main(String[] args) throws Exception {
    	/*factory builder documentの3ステップを用意する*/
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/persons.xml");
        
        /*Element をgetDocumentElementでdocumentから取得する*/
        Element root = document.getDocumentElement();
        
        System.out.println("Node: " + root.getNodeName());
        System.out.println("name: " + root.getAttribute("name"));
        
        System.out.println("==============================");
        
        
        /*getChildNodesで子ノードを取得し、リストで受け取る*/
        NodeList personsNodeList = root.getChildNodes();
        System.out.println("personsNodeList=" + personsNodeList.getLength());
        for(int i = 0; i < personsNodeList.getLength(); i++) {
            Node personNode = personsNodeList.item(i);
            
            /*ノードのタイプを確認する*/
            if(personNode.getNodeType() == Node.ELEMENT_NODE) {
            	/*エレメントのタイプと一致した場合に、ノードをエレメントにキャストする。*/
                Element personElement = (Element)personNode;
                if(personElement.getNodeName().equals("person")) {
                    System.out.println("[" + personElement.getAttribute("name") + "]");
                    
                    /*elementからchildのノードを取得し、リストとして受け取る*/
                    NodeList personChildrenNodeList = personElement.getChildNodes();
                    for(int j = 0; j < personChildrenNodeList.getLength(); j++) {
                        Node node = personChildrenNodeList.item(j);
                        /*nodeの中にはエレメント以外のテキストも入っているので、それを除外してあげる。*/
                        if(node.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(node.getNodeName() + ": " + node.getTextContent());
                        }
                    }
                }
            }
            
            
        }
        
        System.out.println("==============================");
    }
}
