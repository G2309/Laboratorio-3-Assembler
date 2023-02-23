/**
 * 
 */

/**
 * @author Gustavo Cruz
 * @author Javier Chen
 */
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
	
	
	public static void main(String[] args) throws UnknownHostException {
		Scanner s = new Scanner(System.in);
		boolean b = true;
		while (b == true) {
			System.out.println("Ingrese un numero de 8 bits: ");
			String binario = s.nextLine();
			if (binario.length() <= 8) {
				System.out.println("\n\tComplemento uno: " + complementoUno(binario));
				System.out.println("\n\tComplemento dos: " + complementoDos(complementoUno(binario), binario));
				b = false;
				
			} else {
				System.out.println("\n\t**** Por favor ingrese un numero de 8 bits, intente nuevamente ****");
			} 
		}
			System.out.println("\n\tIngrese un numero hexadecimal a decimal: (No afecta el uso de mayusculas)");
			String hexnum = s.nextLine();
			System.out.println("\n\tHexadecimal a decimal: " + HexaDec(hexnum));
			System.out.println("\n\tIngrese un numero decimal a hexadecimal: ");
			String decnum = s.nextLine();
			System.out.println("\n\tDecimal a hexadecimal: " + DecHexaDec(decnum));
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("\n\tIP: " + ip);
	}
	
	public static String complementoUno(String binario) {
		int bin = binario.length();
		String complemento = "";
		for(int i =0; i<bin;i++) {
			complemento += (binario.charAt(i) == '0') ? '1':'0';
		}
		return complemento;
	}
	
	public static String complementoDos(String complemento, String binario) {
		int bin = binario.length();
		char[] ch = new char[bin];
		boolean b = false;
		for(int i = bin-1;i>=0;i--)
		{
			if(b) 
			{
				if(complemento.charAt(i) == '0') 
				{
					ch[i]='1';
				}else {
					ch[i]='0';
				}
			}else {
				ch[i] = complemento.charAt(i);
				if(complemento.charAt(i) == '1') 
				{
					b = true;
				}
			}
		}	
		return new String (ch);
	}
	
	public static int HexaDec(String hexnum) 
	{
		int decimal = Integer.parseInt(hexnum,16);
		return decimal;
	}
			
	public static String DecHexaDec(String decnum)
	{
		int hexadecimal = Integer.parseInt(decnum);
		String hex = Integer.toHexString(hexadecimal);
		return hex;
	}
	
}