package gui;

public class Funcoes {

	public static String removeLetrasGuid(String value){
		return ((String)value)
				.replaceAll("[�����]",	"a")
				.replaceAll("[����&]",	"e")
				.replaceAll("[����]",	"i")
				.replaceAll("[�����]",	"o")
				.replaceAll("[����]",	"u")
				.replaceAll("[�����]",	"a")
				.replaceAll("[����]",	"e")
				.replaceAll("[����]",	"i")
				.replaceAll("[�����]",	"o")
				.replaceAll("[����]",	"u")
				
								
				.replace('�',	'c')
				.replace('�',	'C')
				.replace('�',	'n')
				.replace('�',	'N')
				.replace(" ", "-");
								
				//.replaceAll("[^a-zA-Z]", " ");
	}	
	
	public static String removeHTML(String value){
		return ((String)value)
				.replace("<html>", "")
				.replace("</html>", "")
				.replace("<head>", "")
				.replace("</head>", "")
				.replace("<body>", "")
				.replace("</body>", "")
				
				
				.replaceAll("[\n\r]", "");
	}
}