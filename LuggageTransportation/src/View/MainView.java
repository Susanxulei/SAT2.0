package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import VO.TransportationVO;
import BUS.Calculation;

/**
 * Created by Edward on 2017/3/15.
 */
public class MainView {

    public static TransportationVO tpvo=new TransportationVO();
    public static void main(String[] args) {

        JFrame frame = new JFrame("南航行李托运费用查询");
        // Setting the width and height of frame
        frame.setBounds(400, 150, 500, 300);
        //frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        Object areaObj[] = {"中国大陆","日本","美国","澳新","俄罗斯","新加坡","乌兹别克斯坦","塔吉克斯坦","哈萨克斯坦","吉尔吉斯斯坦","土库曼斯坦","伊朗","巴基斯坦","阿塞拜疆","格鲁吉亚","内罗毕","迪拜","兰州","乌鲁木齐","韩国","其他国家"};
        Object cabObj[] = {"头等舱","公务舱","明珠经济舱","经济舱","不占座婴儿"};
        Object paTypeObj[] = {"成人","南航明珠金卡会员","天合联盟超级精英","天合联盟精英","南航明珠银卡会员","留学生","劳务","海员","移民旅客","占座婴儿","儿童"};
        tpvo.setStart(String.valueOf(areaObj[0]));
        tpvo.setDestination(String.valueOf(areaObj[0]));
        tpvo.setCabin(String.valueOf(cabObj[0]));
        tpvo.setPassengerType(String.valueOf(paTypeObj[0]));

        // 创建 JLabel
        JLabel staLabel = new JLabel("起始地:");
        staLabel.setBounds(100,20,80,25);
        panel.add(staLabel);

        JComboBox startChooser = new JComboBox(areaObj);
        startChooser.setBounds(200,20,165,25);
        panel.add(startChooser);
        startChooser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tpvo.setStart(String.valueOf(startChooser.getSelectedItem()));
            }
        });

        JLabel dstLabel = new JLabel("目的地:");
        dstLabel.setBounds(100,60,80,25);
        panel.add(dstLabel);

        JComboBox dstChooser = new JComboBox(areaObj);
        dstChooser.setBounds(200,60,165,25);
        panel.add(dstChooser);
        dstChooser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tpvo.setDestination(String.valueOf(dstChooser.getSelectedItem()));
            }
        });

        JLabel cabLabel = new JLabel("舱位类型:");
        cabLabel.setBounds(100,100,80,25);
        panel.add(cabLabel);

        JComboBox cabChooser = new JComboBox(cabObj);
        cabChooser.setBounds(200,100,165,25);
        panel.add(cabChooser);
        cabChooser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tpvo.setDestination(String.valueOf(cabChooser.getSelectedItem()));

            }
        });

        JLabel paTypeLabel = new JLabel("旅客类型:");
        paTypeLabel.setBounds(100,140,80,25);
        panel.add(paTypeLabel);

        JComboBox paTypeChooser = new JComboBox(paTypeObj);
        paTypeChooser.setBounds(200,140,165,25);
        panel.add(paTypeChooser);
        paTypeChooser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tpvo.setDestination(String.valueOf(paTypeChooser.getSelectedItem()));

            }
        });

        // 创建查询按钮
        JButton addLugButton = new JButton("添加行李");
        addLugButton.setBounds(140, 180, 160, 25);
        panel.add(addLugButton);
        addLugButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddLuggage adf = new AddLuggage(tpvo);
            }
        });

        JButton calaButton = new JButton("计算价格");
        calaButton.setBounds(140, 220, 160, 25);
        panel.add(calaButton);
        calaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calculation calculation = new Calculation();
                tpvo.setTicket(1000);
                double fare = calculation.Caculate(tpvo);
                JOptionPane.showMessageDialog(null, "行李托运费用为"+ Double.toString(fare));
            }
        });



        // 创建取消按钮
//        JButton cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(285, 160, 80, 25);
//        panel.add(cancelButton);
//        cancelButton.addActionListener(new ActionListener(){
//                                           public void actionPerformed(ActionEvent e)
//                                           {
//                                               System.exit(0);
//                                           }
//                                       }
//        );
//    }
    }
}
