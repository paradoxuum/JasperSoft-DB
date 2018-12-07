package reports;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ClientJdbcDAO;
import program.ClientRel;
import model.Client;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		ClientRel.imprimir(ClientJdbcDAO.select());
	}

}
