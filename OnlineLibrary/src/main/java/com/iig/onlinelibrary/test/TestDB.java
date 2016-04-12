package com.iig.onlinelibrary.test;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.iig.onlinelibrary.crud.Service;
import com.iig.onlinelibrary.model.Group;
import com.iig.onlinelibrary.model.User;

public class TestDB {
	public static void main(String[] args) {

		// Rights r3 = new Rights();
		// Rights r1 = new Rights();
		//
		// Service<Rights> service = new Service<Rights>(new Rights());
		//
		// // Сохраняем все авто
		// service.create(r3);
		// service.create(r1);
		// // Получаем все авто с БД
		// List<Rights> rs = service.getAll();
		//
		// // Выводим полученый список авто
		// for (Rights c : rs) {
		// System.out.println(c);
		// }
		addUsers();
	}

	private static void addUsers() {

		Service<Group> gService = new Service<Group>(new Group());

		User r3 = new User();
		r3.setName("KittoRyu");
		r3.setHexPassword(DigestUtils.md5Hex("TT022299"));
		r3.setGroup(gService.read(1));

		User r1 = new User();
		r1.setName("SoUser");
		r1.setHexPassword(DigestUtils.md5Hex("muchsecurity"));
		r1.setGroup(gService.read(2));

		Service<User> uService = new Service<User>(new User());

		uService.create(r3);
		uService.create(r1);

		List<User> rs = uService.getAll();

		for (User c : rs) {
			System.out.println(c);
		}
	}
}
