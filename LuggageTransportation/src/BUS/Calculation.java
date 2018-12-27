package BUS;

import VO.TransportationVO;
import VO.LuggageVO;

import java.util.Vector;

public class Calculation {
    double cost;

    int district;

    int cnum;
    int cweight;
    int maxWeight;
    int maxA, maxB, maxC, maxSize;

    int overNumPrice1, overNumPrice2;
    int overSizePrice;
    int overWeightPrice1, overWeightPrice2;

    //按起始地目的地分区域并设限
    public int JudgeDistrict(String start, String dest) {
        maxSize = 158;
        maxWeight = 32;
        if (dest.equals("中国大陆") || dest.equals("乌鲁木齐") || dest.equals("兰州")) {
            switch (start) {
                case "中国大陆":
                case "兰州":
                case "乌鲁木齐":
                    maxA = 40;
                    maxB = 60;
                    maxC = 100;
                    district = 0;
                    maxWeight = 50;
                    break;
                case "美国":
                    maxWeight = 45;
                case "日本":
                case "澳新":
                case "俄罗斯":
                case "新加坡":
                    district = 1;
                    break;
                case "乌兹别克斯坦":
                case "塔吉克斯坦":
                case "哈萨克斯坦":
                case "吉尔吉斯斯坦":
                case "土库曼斯坦":
                case "伊朗":
                case "巴基斯坦":
                case "阿塞拜疆":
                case "格鲁吉亚":
                    district = 2;
                    break;
                case "内罗毕":
                    district = 3;
                    break;
                case "迪拜":
                    if (dest.equals("兰州") || dest.equals("乌鲁木齐"))
                        district = 6;
                    else
                        district = 1;
                    break;
                case "韩国":
                    district = 5;
                    break;
                default:
                    district = 4;
            }
            return 1;
        } else if (start.equals("中国大陆") || start.equals("乌鲁木齐") || start.equals("兰州")) {
            switch (dest) {
                case "美国":
                    maxWeight = 45;
                case "日本":
                case "澳新":
                case "俄罗斯":
                    district = 1;
                    break;
                case "乌兹别克斯坦":
                case "塔吉克斯坦":
                case "哈萨克斯坦":
                case "吉尔吉斯斯坦":
                case "土库曼斯坦":
                case "伊朗":
                case "巴基斯坦":
                case "阿塞拜疆":
                case "格鲁吉亚":
                    district = 2;
                    break;
                case "内罗毕":
                    district = 3;
                    break;
                case "迪拜":
                    if (start.equals("兰州") || start.equals("乌鲁木齐"))
                        district = 6;
                default:
                    district = 4;
            }
            return 1;
        } else
            return 0;
    }

    //按区域设置免费行李规格和超出费用//100
    public void JudgeByDistrictCabin(String cabin) {
        if (cabin.equals("不占座婴儿") ) {
            cnum = 1;
            cweight = 10;
            maxSize = 115;
            return;
        }
        switch (district) {
            case 0:
                cnum += 1;
                switch (cabin) {
                    case "头等舱":
                        cweight += 40;
                        break;
                    case "公务舱":
                        cweight += 30;
                        break;
                    case "经济舱":
                    case "明珠经济舱":
                        cweight += 20;
                        break;
                }
                break;
            case 1:
            case 3:
            case 6://兰州乌鲁木齐与迪拜
                overNumPrice1 = 1000;
                overNumPrice2 = 2000;
                overSizePrice = 1000;
                if (district == 3)
                    overWeightPrice1 = 2000;
                else
                    overWeightPrice1 = 1000;
                overWeightPrice2 = 3000;
                switch (cabin) {
                    case "头等舱":
                        cnum += 3;
                        cweight += 32;
                        break;
                    case "公务舱":
                        cnum += 2;
                        cweight += 32;
                        break;
                    case "经济舱":
                    case "明珠经济舱":
                        if (district == 6) {
                            cnum += 1;
                            if (cabin.equals("经济舱"))
                                cweight += 23;
                            else
                                cweight += 32;
                        } else {
                            cnum += 2;
                            cweight += 23;
                        }
                        break;
                }
                break;
            case 2:
                overNumPrice1 = 450;
                overNumPrice2 = 1300;
                overSizePrice = 1000;
                switch (cabin) {
                    case "头等舱":
                        cnum += 3;
                        cweight += 32;
                        break;
                    case "公务舱":
                        cnum += 2;
                        cweight += 32;
                        break;
                    case "经济舱":
                    case "明珠经济舱":
                        cnum += 1;
                        cweight += 32;
                        break;

                }
                break;
            default:
                overNumPrice1 = 450;
                overNumPrice2 = 1300;
                overSizePrice = 1000;
                overWeightPrice1 = 1000;
                overWeightPrice2 = 3000;
                switch (cabin) {
                    case "头等舱":
                        cnum += 3;
                        cweight += 32;
                        break;
                    case "公务舱":
                        cnum += 3;
                        cweight += 23;
                        break;
                    case "明珠经济舱":
                    	 if (district == 5){
                    		 cnum += 1;
                             cweight += 23;
                    	 }else{
                    		 cnum += 2;
                             cweight += 23;
                    	 }
                        break;
                    case "经济舱":
                        cnum += 1;
                        cweight += 23;
                        break;
                }
        }
    }

    //按乘客身份添加行李规格
    public void JudgeByPassengerType(String pgtp) {
        switch (pgtp) {
            case "南航明珠金卡会员":
            case "天合联盟超级精英":
                cnum += 1;
                cweight += 20;
                break;
            case "南航明珠银卡会员":
            case "天合联盟精英":
                cnum += 1;
                cweight += 10;
                break;
            case "留学生":
            case "劳务":
            case "海员":
            case "移民旅客":
                cnum += 1;
                break;
            default:
        }
    }

    //计算行李托运费用
    //地区错误-1，行李错误-2，超尺寸限制-3，超重限制-4
    public double Caculate(TransportationVO tp) {
        LuggageVO lugg;
        Vector<LuggageVO> luggs;
        cost = 0;
        cweight = 0;
        cnum = 0;
        if (tp.getLuggages() == null || tp.getLuggages().size() == 0)
            return cost;
        luggs = tp.getLuggages();


        JudgeByPassengerType(tp.getPassengerType());
        if (JudgeDistrict(tp.getStart(), tp.getDestination()) == 0)
            return -1;
        JudgeByDistrictCabin(tp.getCabin());

        if (district == 0) {
            if (tp.getCabin().equals("不占座婴儿")) {
                lugg = luggs.elementAt(0);
                if (lugg.checkLuggage() == 0)
                    return -2;
                if (luggs.size() > cnum || lugg.getSizeA() > maxA || lugg.getSizeB() > maxB || lugg.getSizeC() > maxC)
                    return -3;
                else if(lugg.getWeight() > cweight)
                	return -4;
                else
                    return cost;
            }
            for (int j = 0; j < luggs.size(); j++) {
                lugg = luggs.elementAt(j);
                if (lugg.checkLuggage() == 0)
                    return -2;
                // 超尺寸
                if (lugg.getSizeA() > maxA || lugg.getSizeA() > maxB || lugg.getSizeA() > maxC)
                    return -3;
                // 超重
                if (lugg.getWeight() > maxWeight)
                    return -4;

                cost += lugg.getWeight() * tp.getTicket() * 0.015;
            }
            if (cost > cweight * tp.getTicket() * 0.015)
                cost -= cweight * tp.getTicket() * 0.015;
            else
                cost = 0;

        } else {
            if (tp.getCabin().equals("不占座婴儿")) {
                lugg = luggs.elementAt(0);
                if (lugg.checkLuggage() == 0)
                    return -2;
                if (luggs.size() > cnum || lugg.getTotalSize() > maxSize)
                    return -3;
                else if(lugg.getWeight() > cweight)
                	return -4;
                else
                    return cost;

            }
            // 超件
            if (luggs.size() > cnum)
                cost = overNumPrice1 + (luggs.size() - cnum - 1) * overNumPrice2;
            for (int j = 0; j < luggs.size(); j++) {
                lugg = luggs.elementAt(j);
                if (lugg.checkLuggage() == 0)
                    return -2;
                // 超尺寸
                if (lugg.getTotalSize() > maxSize)
                    if (lugg.getTotalSize() <= 300)
                        cost += overSizePrice;
                    else
                        return -3;
                // 超重
                if (lugg.getWeight() <= maxWeight) {
                    if (lugg.getWeight() > cweight)
                        if (lugg.getWeight() <= 32)
                            cost += overWeightPrice1;
                        else
                            cost += overWeightPrice2;
                } else
                    return -4;
            }
        }
        cost = ((int) (cost * 100)) / 100;
        return cost;
    }
}
