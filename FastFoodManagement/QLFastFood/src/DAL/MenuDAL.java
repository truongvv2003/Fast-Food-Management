package DAL;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Menu;

public class MenuDAL {
	private static MenuDAL instance;
	private MenuDAL() {}
	public static MenuDAL getInstance() {
		if(instance == null) {
			instance = new MenuDAL();
		}
		return instance;
	}
	public ArrayList<Menu>  getListMenu()
	{
		ArrayList<Menu> dsMenu = new ArrayList<Menu>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select f.Name, bi.count, f.price, f.price * bi.count as totalPrice from billinfo as bi, Bill as b, Food as f where bi.idBill = b.id and bi.idFood = f.id and b.status = 1";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Menu M = new Menu(connectSQL.getInstance().result.getString("Name"), connectSQL.getInstance().result.getInt("count"),
						connectSQL.getInstance().result.getFloat("Price"), connectSQL.getInstance().result.getFloat("TotalPrice"));
				dsMenu.add(M);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsMenu;
	}
}
