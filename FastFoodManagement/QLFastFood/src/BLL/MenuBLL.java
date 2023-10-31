package BLL;

import java.util.ArrayList;

import DAL.MenuDAL;
import DTO.Menu;

public class MenuBLL {
	private static MenuBLL instance;
	private MenuBLL() {}
	public static MenuBLL getInstance() {
		if(instance == null) {
			instance = new MenuBLL();
		}
		return instance;
	}
	public ArrayList<Menu>  getListMenu(){
		return MenuDAL.getInstance().getListMenu();
	}
}
