package test;
import java.util.List;

import dao.BcDAO;
import model.Bc;

public class BcDAOTest {
	public static void main(String[] args) {
		BcDAO dao = new BcDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Bc> cardList2 = dao.select(new Bc("", "田", "県"));
		for (Bc card : cardList2) {
			System.out.println("NUMBER：" + card.getNumber());
			System.out.println("Name：" + card.getName());
			System.out.println("ADDRESS：" + card.getAddress());
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Bc insRec = new Bc("0006", "山本六郎", "東京都港区");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Bc> cardList3 = dao.select(insRec);
			for (Bc card : cardList3) {
				System.out.println("NUMBER：" + card.getNumber());
				System.out.println("Name：" + card.getName());
				System.out.println("ADDRESS：" + card.getAddress());
				System.out.println();
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Bc upRec = new Bc("0006", "山本更太郎", "埼玉県春日部市");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Bc> cardList4 = dao.select(upRec);
			for (Bc card : cardList4) {
				System.out.println("NUMBER：" + card.getNumber());
				System.out.println("Name：" + card.getName());
				System.out.println("ADDRESS：" + card.getAddress());
				System.out.println();
			}
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("0006")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}
