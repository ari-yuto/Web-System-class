package db;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppearMain {
	void insert(int number, int shicode) {
		AppearDAO appearDAO = new AppearDAO();
		boolean success = appearDAO.insert(number, shicode);
		System.out.println(success);
	}
	
	void delete(int id) {
		AppearDAO appearDAO = new AppearDAO();
		boolean success = appearDAO.delete(id);
		System.out.println(success);
	}
	
	void all() {
		AppearDAO appearDAO = new AppearDAO();
		List<Appear> list = AppearDAO.findAll();
		for (Appear p: list) {
			int id = p.getId();
			int number = p.getNumber();
			String name = p.getName();
			String ken = p.getKen();
			String shi = p.getShi();
			Date date = p.getDate();
			Time time = p.getTime();
			System.out.printf("%3d %3d %-10s %-10s %-10s %-10s %-10s\n",
					id, number, name, ken, shi, date, time);
		}
	}
	
	public static void main(String args[]) {
		AppearMain main = new AppearMain();
		//main.insert(6, 12206);
		//main.delete(5);
		main.all();
	}
	
}