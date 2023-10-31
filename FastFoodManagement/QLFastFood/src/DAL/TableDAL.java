package DAL;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Food;
import DTO.Table;

public class TableDAL {
	private static TableDAL instance;
	private TableDAL() {}
	public static TableDAL getInstance() {
		if(instance == null) {
			instance = new TableDAL();
		}
		return instance;
	}
	public ArrayList<Table> getListTable()
	{
		ArrayList<Table> dsTable = new ArrayList<Table>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from tablefood";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Table T = new Table(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getString("Name"),
						connectSQL.getInstance().result.getBoolean("status"));
				dsTable.add(T);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsTable;
	}
}
