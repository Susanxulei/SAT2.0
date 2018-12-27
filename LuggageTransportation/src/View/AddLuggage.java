package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import VO.TransportationVO;
import VO.LuggageVO;

public class AddLuggage extends JFrame{
    AddLuggage(TransportationVO tpvo){
        init(tpvo);
        this.setTitle("添加行李");
        this.setSize(new Dimension(400,300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(TransportationVO tpvo){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel sizeALabel = new JLabel("行李-宽(cm):");
        sizeALabel.setBounds(110, 40, 75, 25);
        panel.add(sizeALabel);

        JTextField sizeAText = new JTextField(20);
        sizeAText.setBounds(190, 40, 80, 25);
        panel.add(sizeAText);

        JLabel sizeBLabel = new JLabel("行李-长(cm):");
        sizeBLabel.setBounds(110, 80, 75, 25);
        panel.add(sizeBLabel);

        JTextField sizeBText = new JTextField(20);
        sizeBText.setBounds(190, 80, 80, 25);
        panel.add(sizeBText);

        JLabel sizeCLabel = new JLabel("行李-高(cm):");
        sizeCLabel.setBounds(110, 120, 75, 25);
        panel.add(sizeCLabel);

        JTextField sizeCText = new JTextField(20);
        sizeCText.setBounds(190, 120, 80, 25);
        panel.add(sizeCText);

        JLabel weightLabel = new JLabel("行李重量(kg):");
        weightLabel.setBounds(110, 160, 75, 25);
        panel.add(weightLabel);

        JTextField weightText = new JTextField(20);
        weightText.setBounds(190, 160, 80, 25);
        panel.add(weightText);

        JButton addButton = new JButton("添加行李");
        addButton.setBounds(140, 200, 160, 25);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    LuggageVO lgvo = new LuggageVO();

                    lgvo.setSizeA(Integer.parseInt(sizeAText.getText()));
                    lgvo.setSizeB(Integer.parseInt(sizeBText.getText()));
                    lgvo.setSizeC(Integer.parseInt(sizeCText.getText()));
                    lgvo.setTotalSize();
                    lgvo.setWeight(Integer.parseInt(weightText.getText()));

                    if(lgvo.getSizeA() < 1 || lgvo.getSizeB() < 1 || lgvo.getSizeC() < 1 || lgvo.getWeight() < 1)
                        JOptionPane.showMessageDialog(null,"行李规格不合要求！");
                    else{
                        tpvo.setOneLuggage(lgvo);
                        JOptionPane.showMessageDialog(null,"成功添加一件行李！");
                    }
                }catch (Exception E){
                    JOptionPane.showMessageDialog(null,"错误的输入！");
                }

            }
        });

        this.add(panel);
        this.setVisible(true);
    }
//    public static void main(String[] args){
//        new AddLuggage();
//    }
}
