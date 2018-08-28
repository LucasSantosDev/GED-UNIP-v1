package br.com.unip.ged.test;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.unip.ged.models.User;
import br.com.unip.ged.utils.Utils;

public class Teste {

	public static void main(String[] args) {

		File file = new File("‪C:\\Users\\Lucas\\Downloads\\Perfil.jpg");
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		User user = new User();
		user.setName("Admin");
		user.setEmail("admin@ged.com.br");
		user.setPassword(Utils.md5("123"));
		user.setImage(bFile);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ged_v1");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
