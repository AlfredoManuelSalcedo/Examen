package Hash;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalcularHash {

	public static void main(String[] args) {
		try {
			FileOutputStream fileout = new FileOutputStream("QUIJOTE_HASH.DAT");
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String datos = "En un lugar de la Mancha de cuyo nombre no quiero acordarme\n"
					+"no ha mucho tiempo que vivia un hidalgo de los de lanza en\n"
					+"astillero, adarga antigua, rocín flaco y galgo corredor. Una olla\n"
					+"de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos\n"
					+"los sabados, lentejas los viernes, algún palomino de añadidura\n"
					+"los domingos, consumían las tres partes de su hacienda. El resto della"
					+"concluian sayo de velarte, calzas de velludo para las fiestas con"
					+"sus pantuflos de lo mismo, y los dias de entresemana se honraba con su"
					+"vellorí de lo más fino";
			byte dataBytes[]=datos.getBytes();
			md.update(dataBytes); //TEXTO A RESUMIR
			byte resumen[]= md.digest();//SE CALCULA EL RESUMEN
			dataOS.writeObject(datos);//SE ESCRIBEN LOS DATOS
			dataOS.writeObject(resumen);//SE ESCRIBE EL RESUMEN
			dataOS.close();
			fileout.close();
			System.out.println("Datos:"+ datos);
			System.out.println("\nResumen SHA-256 del Quijote creado con exito");
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}