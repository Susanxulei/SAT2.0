package Test;

import BUS.Calculation;
import Dao.TransportationDAO;
import VO.LuggageVO;
import VO.TransportationVO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Vector;

//计算行李托运费用
//地区错误-1，行李错误-2，超尺寸限制-3，超重限制-4
public class CalculationTest {
	@Test(dataProvider = "tp")
	public void testByDesign(TransportationVO tpvo) {
		System.out.println("Calculation Test Data provided");
		Calculation cal = new Calculation();

		double cost = cal.Caculate(tpvo);
		System.out.println(cost);
		Assert.assertEquals(cost,tpvo.getCost());
		

	}
	@Test(dataProvider = "tpAuto")
	public void testByAuto(TransportationVO tpvo) {
		System.out.println("Calculation Test Data Auto Generated");
		System.out.println("passenger : " + tpvo.getPno() + " start : " + tpvo.getStart() + " destination : " + tpvo.getDestination());
		System.out.println("cabin : " + tpvo.getCabin() + " passengerType : " + tpvo.getPassengerType());
		System.out.println("luggages SizeA : SizeB : SizeC(cm) : Weight(kg):");

		Vector<LuggageVO> luggages = tpvo.getLuggages();
		if(luggages == null) {
			System.out.println("NULL");
		}else{
			int lugSz = luggages.size();
			for(int i = 0; i < lugSz; i++) {
				System.out.println(luggages.elementAt(i).getSizeA() + ": " + luggages.elementAt(i).getSizeB()  + ": " +  luggages.elementAt(i).getSizeC()  + ": " +  luggages.elementAt(i).getWeight());
			}
		}




		Calculation cal = new Calculation();
		double cost = cal.Caculate(tpvo);
		System.out.println("Cost/FailNO : " + cost);
		System.out.println("-----------------------------");
//		Assert.assertEquals(cost,tpvo.getCost());


	}

	@DataProvider
	public Object[][] tp() {

		TransportationDAO tpDao = new TransportationDAO();
		Vector<TransportationVO> tpvos = new Vector<TransportationVO>();

		tpvos = tpDao.searchTps();
		int sz = tpvos.size();

		Object[][] tpDatas = new Object[sz][];

		for (int i = 0; i < sz; i++) {
			tpDatas[i] = new Object[] { tpvos.elementAt(i) };
		}

		return tpDatas;
	}

	@DataProvider
	public Object[][] tpAuto() {

		GenerateTestCase gtc = new GenerateTestCase();
		Vector<TransportationVO> tpvos = gtc.GenerateCase(60);

		int sz = tpvos.size();
		Object[][] tpDatas = new Object[sz][];
		for (int i = 0; i < sz; i++) {
			tpDatas[i] = new Object[] { tpvos.elementAt(i) };
		}

		return tpDatas;



	}

}
