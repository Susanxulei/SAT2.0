package Dao;

import VO.LuggageVO;
import VO.TransportationVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TransportationDAO {
	private DBConnection conn;

	public TransportationDAO() {
		conn = new DBConnection();
	}

	@SuppressWarnings({ "resource", "static-access" })
	public Vector<TransportationVO> searchTps() {
		try {
			Vector<TransportationVO> tpvos = new Vector<TransportationVO>();

			String query = "select * from t_passenger";
			Connection connection = conn.getConn();
			PreparedStatement pstatement = connection.prepareStatement(query);
			ResultSet result = pstatement.executeQuery();

			while (result.next()) {
				TransportationVO tpvo = new TransportationVO();

				tpvo.setPno(result.getString(1));
//				System.out.println(tpvo.getPno());
				tpvo.setStart(result.getString(2));
				tpvo.setDestination(result.getString(3));
				tpvo.setCabin(result.getString(4));
				tpvo.setPassengerType(result.getString(5));
				tpvo.setTicket(Integer.parseInt(result.getString(6)));
				tpvo.setCost(Integer.parseInt(result.getString(7)));



				Vector<LuggageVO> lgvos = new Vector<LuggageVO>();
				query = "select * from t_luggage where pno = " + tpvo.getPno();

				pstatement = connection.prepareStatement(query);
//				pstatement.setString(1, tpvo.getPno());

				ResultSet result1 = pstatement.executeQuery();
				while (result1.next()) {
					LuggageVO lgvo = new LuggageVO();
					lgvo.setSizeA(Integer.parseInt(result1.getString(3)));
					lgvo.setSizeB(Integer.parseInt(result1.getString(4)));
					lgvo.setSizeC(Integer.parseInt(result1.getString(5)));
					lgvo.setTotalSize(Integer.parseInt(result1.getString(6)));
					lgvo.setWeight(Integer.parseInt(result1.getString(7)));

					lgvos.add(lgvo);
				}
				tpvo.setLuggages(lgvos);

				tpvos.add(tpvo);
			}
			
			return tpvos;
		} catch (SQLException e) {
			return null;
		}
	}
}
