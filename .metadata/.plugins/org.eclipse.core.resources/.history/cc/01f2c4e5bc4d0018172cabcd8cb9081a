package qxjc.peszp.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class WriteXml {    /** 
     * @Decription TODO sax方法创建一个xml文档 
     */  
    public int saxCreateXml(String zjhm,String base64,String userId ){ 
    	int i = 0;
        //1、创建一个SAXTransformerFactory一个对象  
    	BaseDao bd = new BaseDao();
    	PhotoDao pd = new PhotoDao();
		String date = pd.findDate("yyyy/MM/dd");
    	String filepath = bd.findFileIp("4");
    	String ywUrl = filepath+bd.findFileIp("8")+ userId+System.getProperty("file.separator")+ date+System.getProperty("file.separator");
    	String ywname = zjhm+".xml";
        SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();  
        OutputStream in =null;  
        try {  
            //2、通过SAXTransformerFactory创建一个TransformerHandler对象  
            TransformerHandler handler = sf.newTransformerHandler();  
            //3、通过TransformerHandler对象获取Transformer对象(用于设置xml输出的样式和头）  
            Transformer transformer = handler.getTransformer();    
            //设置编码格式，显式的显示在<?xml version="1.0" ?>中  
            transformer.setOutputProperty(OutputKeys.ENCODING, "GBK");  
            //设置换行  
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            //文件输出  
            File file =new File(ywUrl);
            File file2 =new File(ywUrl+ywname);
            //确保file是存在的  
            if (!file.exists()) {
    			file.mkdirs();
    		}
            if(!file2.exists()){  
                if(!file2.createNewFile()){  
                    throw new FileNotFoundException("文件创建失败！");  
                }  
            }  
            //4、创建输出流OutputStream对象  
            in = new FileOutputStream(file2);  
            //5、创建流Result对象  
            Result result = new StreamResult(in);  
            //6、关联result，此时有了生成元素的方法（handler提供的方法）和装元素的容器（result对象）  
            handler.setResult(result);  
            //打开文档  
            handler.startDocument();  
            //属性设置  
            AttributesImpl attr = new AttributesImpl();  
            //开始创建元素  
            handler.startElement("", "", "root", attr); 
            attr.clear();
            handler.startElement("", "", "drvphoto", attr);
            attr.clear();
            handler.startElement("", "", "sfzmhm", attr);
            handler.characters(zjhm.toCharArray(), 0, zjhm.toCharArray().length);
            handler.endElement("", "", "sfzmhm");
            handler.startElement("", "", "zp", attr);
            handler.characters(base64.toCharArray(), 0, base64.toCharArray().length);
            handler.endElement("", "", "message");
            handler.endElement("", "", "drvphoto");
            handler.endElement("", "", "root");  
            //关闭文档  
            handler.endDocument(); 
            i = 1;
        } catch (TransformerConfigurationException e) {  
            e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }   finally{  
                try {   
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
        }  
           
        return i;
    }  
//    public static void main(String[] args) {
//    	WriteXml w = new WriteXml();
//    	w.saxCreateXml("6102515891","asdfasdfdsaf");
//	}

}
