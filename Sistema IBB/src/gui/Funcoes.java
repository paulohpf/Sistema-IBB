package gui;

public class Funcoes {

	public static String removeLetrasGuid(String value){
		return ((String)value)
				.replaceAll("[ãâàáä]",	"a")
				.replaceAll("[êèéë&]",	"e")
				.replaceAll("[îìíï]",	"i")
				.replaceAll("[õôòóö]",	"o")
				.replaceAll("[ûúùü]",	"u")
				.replaceAll("[ÃÂÀÁÄ]",	"a")
				.replaceAll("[ÊÈÉË]",	"e")
				.replaceAll("[ÎÌÍÏ]",	"i")
				.replaceAll("[ÕÔÒÓÖ]",	"o")
				.replaceAll("[ÛÙÚÜ]",	"u")
				
								
				.replace('ç',	'c')
				.replace('Ç',	'C')
				.replace('ñ',	'n')
				.replace('Ñ',	'N')
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