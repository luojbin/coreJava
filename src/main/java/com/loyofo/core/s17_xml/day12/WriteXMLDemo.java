package com.loyofo.core.s17_xml.day12;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 使用DOM写出XML文档
 * @author adminitartor
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 写出XML文档的大致步骤:
			 * 1:创建Document对象表示一个空白文档
			 * 2:向Document中添加根元素
			 * 3:按照XML设计的结构向根元素中 逐级添加子元素及数据
			 * 4:创建XMLWriter
			 * 5:使用XMLWriter将Document对象 写出以生成XML文档
			 */
			List<Emp> empList = new ArrayList<Emp>();
			empList.add(new Emp(1,"张三",22,"男",3000));
			empList.add(new Emp(2,"李四",23,"女",4000));
			empList.add(new Emp(3,"王五",24,"男",5000));
			empList.add(new Emp(4,"赵六",25,"女",6000));
			empList.add(new Emp(5,"钱七",26,"男",7000));
			
			//1
			Document document = DocumentHelper.createDocument();
		 

			// 添加指定名称的根元素，并返回根元素Element对象，只能调用一次
			Element root = document.addElement("list");
			
			/*
			 * Element提供了添加信息的相关方法:
			 * Element addElement(String name)
			 * 向当前元素中追加给定名字的子元素，并 以Element实例将其返回，便于继续操作
			 * 
			 * Element addText(String text)
			 * 向当前元素中添加文本信息。返回的还是 当前标签。
			 * 
			 * Element addAttribute(String name,String value)
			 * 向当前元素中添加指定属性。
			 */
			
			//3
			for(Emp emp : empList){
				Element empEle = root.addElement("emp");
				// 添加子节点及内容
				empEle.addElement("name").addText(emp.getName());
				empEle.addElement("age").addText(emp.getAge()+"");
				empEle.addElement("gender").addText(emp.getGender());
				empEle.addElement("salary").addText(emp.getSalary()+"");

				// 添加属性
				empEle.addAttribute("id", emp.getId()+"");
			}
			XMLWriter writer = new XMLWriter(
				new FileOutputStream("myemp.xml"),
				OutputFormat.createPrettyPrint()
			);
			writer.write(document);
			System.out.println("写出完毕!");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





