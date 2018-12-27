package Test;

import VO.LuggageVO;
import VO.TransportationVO;

import java.util.Random;
import java.util.Vector;

public class GenerateTestCase {
    Vector<TransportationVO> tpvos;

    Random random = new Random();

    public Vector<TransportationVO> GenerateCase(int tpNum) {
        String areaObj[] = {"中国大陆","日本","美国","澳新","俄罗斯","新加坡","乌兹别克斯坦","塔吉克斯坦","哈萨克斯坦","吉尔吉斯斯坦","土库曼斯坦","伊朗","巴基斯坦","阿塞拜疆","格鲁吉亚","内罗毕","迪拜","兰州","乌鲁木齐","韩国","其他国家"};
        String cabObj[] = {"头等舱","公务舱","明珠经济舱","经济舱","不占座婴儿"};
        String paTypeObj[] = {"成人","南航明珠金卡会员","天合联盟超级精英","天合联盟精英","南航明珠银卡会员","留学生","劳务","海员","移民旅客","占座婴儿","儿童"};

        for(int i = 0; i < tpNum; i++) {
            TransportationVO tpvo = new TransportationVO();
            tpvo.setPno(""+i);
            tpvo.setStart(areaObj[random.nextInt(areaObj.length)]);
            tpvo.setDestination(areaObj[random.nextInt(areaObj.length)]);
            tpvo.setCabin(cabObj[random.nextInt(cabObj.length)]);
            tpvo.setPassengerType(paTypeObj[random.nextInt(paTypeObj.length)]);
            tpvo.setTicket(1000);
            tpvo.setCost(0);

            int numLuggage = random.nextInt(4);
            for (int j = 0; j < numLuggage; j ++){
                LuggageVO lgvo = new LuggageVO();
                lgvo.setSizeA(20 + random.nextInt(40));
                lgvo.setSizeB(30 + random.nextInt(40));
                lgvo.setSizeC(50 + random.nextInt(40));
                lgvo.setWeight(20 + random.nextInt(40));
                lgvo.setTotalSize();
                tpvo.setOneLuggage(lgvo);

            }
            if(this.tpvos == null)
                this.tpvos = new Vector<TransportationVO>();
            this.tpvos.add(tpvo);
        }
        return tpvos;
    }


}
