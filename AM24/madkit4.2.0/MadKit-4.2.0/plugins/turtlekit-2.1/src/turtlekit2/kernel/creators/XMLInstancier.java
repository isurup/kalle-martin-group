package turtlekit2.kernel.creators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLInstancier {

	public static Element getRootNodeFromFile(String path){
		if(path!=null)
            try {
                FileInputStream configFile = new FileInputStream(new File(path));
                DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
                Document config =  factory.newDocumentBuilder().parse(configFile);
                return config.getDocumentElement();
            }catch(IOException e){
                System.err.println("File read error with !\n" + path);
                e.printStackTrace();
            }catch(SAXException e){
                System.err.println("Load file: Parsing error of the file !\n" + path);
                e.printStackTrace();
            }catch(Exception e){
                System.err.println("Load file error !\n" + path);
                e.printStackTrace();
            }
            return null;
	}
	
	
	
}
