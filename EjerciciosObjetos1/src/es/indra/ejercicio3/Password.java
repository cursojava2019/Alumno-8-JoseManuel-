package es.indra.ejercicio3;

public class Password {
	protected Integer longitud;
	protected String pass;
	public Password(Integer longitud, String pass) {
		super();
		this.longitud = new Integer(8);
		this.pass = pass;
	}
	public Password(Integer longitud) {
		super();
		this.pass=generarPass(longitud);
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	public String getPass() {
		return pass;
	}
	public String generarPass(Integer longitud) {
		String pass="",numPass="";
		String lMayus="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String lMinus="abcdefghijklmnñopqrstuvwxyz";
		numPass=devolverNum(longitud);
		pass+= Character.toString(devolverLetra(lMayus));
		pass+= Character.toString(devolverLetra(lMayus));
		pass+= numPass;
		pass+= Character.toString(devolverLetra(lMinus));
		return pass;
	}
	protected String devolverNum(Integer longitud) {
		String numPass = "";
		int num=0;
		for(int i=0;i<longitud;i++) {
			num=Integer.valueOf((int) Math.floor((Math.random()*longitud)+1));
			numPass += Integer.toString(num);
		}
		return numPass;
	}
	protected char devolverLetra(String letras) {
		char letra;
		letra = letras.charAt((int) (Math.random() * 23) + 1);
		return letra;
	}

	public boolean esFuerte(String pass) {
		boolean esFuerte=false;
		char[] caracteres = pass.toCharArray();
		int contMayus=0,conMinus=0,conNum=0;
		 for(int i=0; i<pass.length();i++) { 
		      if(Character.isUpperCase(caracteres[i])){
		    	  contMayus++;
		      }else if(Character.isLowerCase(caracteres[i])){
		    	  conMinus++;
		      }else if(Character.isDigit(caracteres[i])) {
		    	  conNum++;
		    	  
		      }
		}
		if(conMinus>=1 && contMayus>=2 && conNum>=5) {
			esFuerte=true;
		}else {
			System.out.println("Cantidad Mayusculas "+contMayus);
			System.out.println("Cantidad Minusculas "+conMinus);
			System.out.println("Cantidad Numeros "+conNum);
			esFuerte=false;
		}
		return esFuerte;
	}
	
}
