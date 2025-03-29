package telas;

import banco.NotasDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import banco.PlannerDAO;

public class Planner extends javax.swing.JFrame {
    private Integer usuarioId;
    private DefaultListModel<String> listModelDomingo;
    private DefaultListModel<String> listModelSegunda;
    private DefaultListModel<String> listModelTerca;
    private DefaultListModel<String> listModelQuarta;
    private DefaultListModel<String> listModelQuinta;
    private DefaultListModel<String> listModelSexta;
    private DefaultListModel<String> listModelSabado;
    private PlannerDAO plannerDAO;

public Planner(Integer usuarioId) {
        this.usuarioId = usuarioId;
        plannerDAO = new PlannerDAO();
        initComponents();
        
        listModelDomingo = new DefaultListModel<>();
        listModelSegunda = new DefaultListModel<>();
        listModelTerca = new DefaultListModel<>();
        listModelQuarta = new DefaultListModel<>();
        listModelQuinta = new DefaultListModel<>();
        listModelSexta = new DefaultListModel<>();
        listModelSabado = new DefaultListModel<>();
        
        domingo.setModel(listModelDomingo);
        segunda.setModel(listModelSegunda);
        terca.setModel(listModelTerca);
        quarta.setModel(listModelQuarta);
        quinta.setModel(listModelQuinta);
        sexta.setModel(listModelSexta);
        sabado.setModel(listModelSabado);
        
        populateList(listModelDomingo, "Domingo", usuarioId);
        populateList(listModelSegunda, "Segunda", usuarioId); 
        populateList(listModelTerca, "Terca", usuarioId);
        populateList(listModelQuarta, "Quarta", usuarioId);
        populateList(listModelQuinta, "Quinta", usuarioId);
        populateList(listModelSexta, "Sexta", usuarioId);
        populateList(listModelSabado, "Sabado", usuarioId);
    }
private void populateList(DefaultListModel<String> listModel, String diaSemana, int usuarioId){
     listModel.clear(); 
        try {
            List<String> planos = plannerDAO.buscarPlanner(diaSemana, usuarioId); 
            for (String plano : planos) {
                listModel.addElement(plano); 
            }
        } 
        catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar notas", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        terca = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        fterca = new javax.swing.JTextField();
        atzterca = new javax.swing.JButton();
        dltterca = new javax.swing.JButton();
        adcterca = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        domingo = new javax.swing.JList<>();
        fdomingo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        adcdomingo = new javax.swing.JButton();
        atzdomingo = new javax.swing.JButton();
        dltdomingo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        segunda = new javax.swing.JList<>();
        fsegunda = new javax.swing.JTextField();
        adcsegunda = new javax.swing.JButton();
        dltsegunda = new javax.swing.JButton();
        atzsegunda = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        quarta = new javax.swing.JList<>();
        fquarta = new javax.swing.JTextField();
        adcquarta = new javax.swing.JButton();
        dltquarta = new javax.swing.JButton();
        atzquarta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        sabado = new javax.swing.JList<>();
        fsabado = new javax.swing.JTextField();
        adcsabado = new javax.swing.JButton();
        dltsabado = new javax.swing.JButton();
        atzsabado = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        quinta = new javax.swing.JList<>();
        fquinta = new javax.swing.JTextField();
        adcquinta = new javax.swing.JButton();
        dltquinta = new javax.swing.JButton();
        atzquinta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        sexta = new javax.swing.JList<>();
        fsexta = new javax.swing.JTextField();
        adcsexta = new javax.swing.JButton();
        dltsexta = new javax.swing.JButton();
        atzsexta = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        voltar.setBackground(new java.awt.Color(26, 26, 26));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow left-circle (2).png"))); // NOI18N
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Planner Semanal");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 204), new java.awt.Color(153, 255, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(255, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 77, 77));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jPanel3.setMaximumSize(new java.awt.Dimension(184, 413));
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Terça");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(50, 30, 80, 26);

        jScrollPane4.setBorder(null);

        terca.setBackground(new java.awt.Color(153, 77, 77));
        terca.setBorder(null);
        terca.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        terca.setForeground(new java.awt.Color(255, 255, 255));
        terca.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(terca);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(6, 80, 161, 219);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(37, 7, 105, 16);

        fterca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));
        jPanel3.add(fterca);
        fterca.setBounds(7, 317, 167, 20);

        atzterca.setBackground(new java.awt.Color(0, 51, 0));
        atzterca.setForeground(new java.awt.Color(255, 255, 255));
        atzterca.setText("Atualizar");
        atzterca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atztercaActionPerformed(evt);
            }
        });
        jPanel3.add(atzterca);
        atzterca.setBounds(6, 374, 77, 23);

        dltterca.setBackground(new java.awt.Color(102, 0, 0));
        dltterca.setForeground(new java.awt.Color(255, 255, 255));
        dltterca.setText("Excluir");
        dltterca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlttercaActionPerformed(evt);
            }
        });
        jPanel3.add(dltterca);
        dltterca.setBounds(90, 374, 84, 23);

        adcterca.setBackground(new java.awt.Color(192, 99, 99));
        adcterca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcterca.setText("Adicionar");
        adcterca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adctercaActionPerformed(evt);
            }
        });
        jPanel3.add(adcterca);
        adcterca.setBounds(7, 345, 167, 23);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 97, 180, 421));

        jPanel4.setBackground(new java.awt.Color(57, 77, 82));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 255, 204), new java.awt.Color(153, 255, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);

        domingo.setBackground(new java.awt.Color(57, 77, 82));
        domingo.setBorder(null);
        domingo.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        domingo.setForeground(new java.awt.Color(255, 255, 255));
        domingo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(domingo);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 160, 218));

        fdomingo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 255, 204), new java.awt.Color(102, 255, 204)));
        fdomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdomingoActionPerformed(evt);
            }
        });
        jPanel4.add(fdomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 318, 160, -1));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Domingo");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        adcdomingo.setBackground(new java.awt.Color(82, 132, 115));
        adcdomingo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        adcdomingo.setText("Adicionar");
        adcdomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcdomingoActionPerformed(evt);
            }
        });
        jPanel4.add(adcdomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 346, 160, -1));

        atzdomingo.setBackground(new java.awt.Color(0, 51, 0));
        atzdomingo.setForeground(new java.awt.Color(255, 255, 255));
        atzdomingo.setText("Atualizar");
        atzdomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzdomingoActionPerformed(evt);
            }
        });
        jPanel4.add(atzdomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 375, 85, -1));

        dltdomingo.setBackground(new java.awt.Color(102, 0, 0));
        dltdomingo.setForeground(new java.awt.Color(255, 255, 255));
        dltdomingo.setText("Excluir");
        dltdomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltdomingoActionPerformed(evt);
            }
        });
        jPanel4.add(dltdomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 375, 70, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jLabel12.setText("jLabel3");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 6, 105, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 97, 180, 420));

        jPanel5.setBackground(new java.awt.Color(149, 111, 63));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 102), new java.awt.Color(255, 153, 102)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segunda");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, -1));

        jScrollPane3.setBorder(null);

        segunda.setBackground(new java.awt.Color(149, 111, 63));
        segunda.setBorder(null);
        segunda.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        segunda.setForeground(new java.awt.Color(255, 255, 255));
        segunda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(segunda);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 173, 218));

        fsegunda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 102), new java.awt.Color(255, 153, 102)));
        jPanel5.add(fsegunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 316, 175, -1));

        adcsegunda.setBackground(new java.awt.Color(195, 91, 57));
        adcsegunda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcsegunda.setText("Adicionar");
        adcsegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcsegundaActionPerformed(evt);
            }
        });
        jPanel5.add(adcsegunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 344, 180, -1));

        dltsegunda.setBackground(new java.awt.Color(102, 0, 0));
        dltsegunda.setForeground(new java.awt.Color(255, 255, 255));
        dltsegunda.setText("Excluir");
        dltsegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltsegundaActionPerformed(evt);
            }
        });
        jPanel5.add(dltsegunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 373, 81, -1));

        atzsegunda.setBackground(new java.awt.Color(0, 51, 0));
        atzsegunda.setForeground(new java.awt.Color(255, 255, 255));
        atzsegunda.setText("Atualizar");
        atzsegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzsegundaActionPerformed(evt);
            }
        });
        jPanel5.add(atzsegunda, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 373, 81, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 112, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 97, -1, 421));

        jPanel6.setBackground(new java.awt.Color(68, 103, 56));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quarta");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jScrollPane5.setBorder(null);

        quarta.setBackground(new java.awt.Color(68, 103, 56));
        quarta.setBorder(null);
        quarta.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        quarta.setForeground(new java.awt.Color(255, 255, 255));
        quarta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(quarta);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 221));

        fquarta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0)));
        jPanel6.add(fquarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 316, 160, -1));

        adcquarta.setBackground(new java.awt.Color(35, 111, 35));
        adcquarta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcquarta.setText("Adicionar");
        adcquarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcquartaActionPerformed(evt);
            }
        });
        jPanel6.add(adcquarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 344, 160, -1));

        dltquarta.setBackground(new java.awt.Color(102, 0, 0));
        dltquarta.setForeground(new java.awt.Color(255, 255, 255));
        dltquarta.setText("Excluir");
        dltquarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltquartaActionPerformed(evt);
            }
        });
        jPanel6.add(dltquarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 373, 70, -1));

        atzquarta.setBackground(new java.awt.Color(0, 51, 0));
        atzquarta.setForeground(new java.awt.Color(255, 255, 255));
        atzquarta.setText("Atualizar");
        atzquarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzquartaActionPerformed(evt);
            }
        });
        jPanel6.add(atzquarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 373, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jLabel7.setText("jLabel3");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 6, 105, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 97, 170, 421));

        jPanel7.setBackground(new java.awt.Color(159, 159, 49));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sábado");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jScrollPane8.setBorder(null);

        sabado.setBackground(new java.awt.Color(159, 159, 49));
        sabado.setBorder(null);
        sabado.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        sabado.setForeground(new java.awt.Color(255, 255, 255));
        sabado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(sabado);

        jPanel7.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 165, 218));

        fsabado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));
        jPanel7.add(fsabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 318, 165, -1));

        adcsabado.setBackground(new java.awt.Color(210, 210, 98));
        adcsabado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcsabado.setText("Adicionar");
        adcsabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcsabadoActionPerformed(evt);
            }
        });
        jPanel7.add(adcsabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 346, 165, -1));

        dltsabado.setBackground(new java.awt.Color(102, 0, 0));
        dltsabado.setForeground(new java.awt.Color(255, 255, 255));
        dltsabado.setText("Excluir");
        dltsabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltsabadoActionPerformed(evt);
            }
        });
        jPanel7.add(dltsabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 375, 82, -1));

        atzsabado.setBackground(new java.awt.Color(0, 51, 0));
        atzsabado.setForeground(new java.awt.Color(255, 255, 255));
        atzsabado.setText("Atualizar");
        atzsabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzsabadoActionPerformed(evt);
            }
        });
        jPanel7.add(atzsabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 375, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 6, -1, 12));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1128, 97, -1, 421));

        jPanel8.setBackground(new java.awt.Color(125, 113, 147));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 51, 255), new java.awt.Color(204, 51, 255)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quinta");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jScrollPane6.setBorder(null);

        quinta.setBackground(new java.awt.Color(125, 113, 147));
        quinta.setBorder(null);
        quinta.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        quinta.setForeground(new java.awt.Color(255, 255, 255));
        quinta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(quinta);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, 164, 221));

        fquinta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 51, 255), new java.awt.Color(204, 51, 255)));
        jPanel8.add(fquinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 317, 170, -1));

        adcquinta.setBackground(new java.awt.Color(120, 76, 135));
        adcquinta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcquinta.setText("Adicionar");
        adcquinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcquintaActionPerformed(evt);
            }
        });
        jPanel8.add(adcquinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 345, 170, -1));

        dltquinta.setBackground(new java.awt.Color(102, 0, 0));
        dltquinta.setForeground(new java.awt.Color(255, 255, 255));
        dltquinta.setText("Excluir");
        dltquinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltquintaActionPerformed(evt);
            }
        });
        jPanel8.add(dltquinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 374, 81, -1));

        atzquinta.setBackground(new java.awt.Color(0, 51, 0));
        atzquinta.setForeground(new java.awt.Color(255, 255, 255));
        atzquinta.setText("Atualizar");
        atzquinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzquintaActionPerformed(evt);
            }
        });
        jPanel8.add(atzquinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 374, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jLabel13.setText("jLabel3");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 6, 105, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 97, -1, 421));

        jPanel9.setBackground(new java.awt.Color(112, 112, 147));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 204)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sexta");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jScrollPane7.setBorder(null);

        sexta.setBackground(new java.awt.Color(112, 112, 147));
        sexta.setBorder(null);
        sexta.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        sexta.setForeground(new java.awt.Color(255, 255, 255));
        sexta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(sexta);

        jPanel9.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 81, 160, 219));

        fsexta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 51, 153), new java.awt.Color(0, 51, 204)));
        jPanel9.add(fsexta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 318, 168, -1));

        adcsexta.setBackground(new java.awt.Color(70, 70, 125));
        adcsexta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adcsexta.setText("Adicionar");
        adcsexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adcsextaActionPerformed(evt);
            }
        });
        jPanel9.add(adcsexta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 346, 168, -1));

        dltsexta.setBackground(new java.awt.Color(102, 0, 0));
        dltsexta.setForeground(new java.awt.Color(255, 255, 255));
        dltsexta.setText("Excluir");
        dltsexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltsextaActionPerformed(evt);
            }
        });
        jPanel9.add(dltsexta, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 375, 85, -1));

        atzsexta.setBackground(new java.awt.Color(0, 51, 0));
        atzsexta.setForeground(new java.awt.Color(255, 255, 255));
        atzsexta.setText("Atualizar");
        atzsexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atzsextaActionPerformed(evt);
            }
        });
        jPanel9.add(atzsexta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 375, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Press Start 2P 1 (3).png"))); // NOI18N
        jLabel14.setText("jLabel3");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 6, 105, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(942, 97, -1, 421));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, 1299, 10));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sol 1.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lua 1.png"))); // NOI18N
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Academia-removebg-preview 1 (1).png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 0, 102), new java.awt.Color(102, 0, 102)));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cafe-removebg-preview 1 (1).png"))); // NOI18N
        jLabel17.setText("jLabel17");
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0)));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cama-removebg-preview 1 (1).png"))); // NOI18N
        jLabel18.setText("jLabel18");
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comida-removebg-preview 1 (1).png"))); // NOI18N
        jLabel19.setText("jLabel19");
        jLabel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(359, 359, 359)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(voltar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atzquintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzquintaActionPerformed
        String oldPlano = quinta.getSelectedValue();
        String newPlano = fquinta.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Quinta", usuarioId);
            fquinta.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelQuinta, "Quinta", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzquintaActionPerformed

    private void atzsextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzsextaActionPerformed
        String oldPlano = sexta.getSelectedValue();
        String newPlano = fsexta.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Sexta", usuarioId);
            fsexta.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelSexta,"Sexta", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzsextaActionPerformed
      
    private void fdomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdomingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fdomingoActionPerformed

    private void adcsegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcsegundaActionPerformed
        String plano =fsegunda.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Segunda", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelSegunda, "Segunda", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fsegunda.setText("");
    }//GEN-LAST:event_adcsegundaActionPerformed

    private void dltsegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltsegundaActionPerformed
        String selectedPlan = segunda.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Segunda", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelSegunda, "Segunda", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltsegundaActionPerformed

    private void atzsegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzsegundaActionPerformed
        String oldPlano = segunda.getSelectedValue();
        String newPlano = fsegunda.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Segunda", usuarioId);
            fsegunda.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelSegunda, "Segunda", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzsegundaActionPerformed

    private void adctercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adctercaActionPerformed
        String plano =fterca.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Terca", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelTerca, "Terca", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fterca.setText("");
    }//GEN-LAST:event_adctercaActionPerformed

    private void dlttercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlttercaActionPerformed
        String selectedPlan = terca.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Terca", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelTerca, "Terca", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dlttercaActionPerformed

    private void atztercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atztercaActionPerformed
        String oldPlano = terca.getSelectedValue();
        String newPlano = fterca.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Terca", usuarioId);
            fterca.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelTerca, "Terca", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atztercaActionPerformed

    private void adcquartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcquartaActionPerformed
         String plano =fquarta.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Quarta", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelQuarta, "Quarta", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fterca.setText("");
    }//GEN-LAST:event_adcquartaActionPerformed

    private void dltquartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltquartaActionPerformed
        String selectedPlan = quarta.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Quarta", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelQuarta, "Quarta", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltquartaActionPerformed

    private void atzquartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzquartaActionPerformed
        String oldPlano = quarta.getSelectedValue();
        String newPlano = fquarta.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Quarta", usuarioId);
            fquarta.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelQuarta, "Quarta", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzquartaActionPerformed

    private void adcquintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcquintaActionPerformed
         String plano =fquinta.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Quinta", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelQuinta, "Quinta", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fquinta.setText("");
    }//GEN-LAST:event_adcquintaActionPerformed

    private void dltquintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltquintaActionPerformed
        String selectedPlan = quinta.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Quinta", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelQuinta, "Quinta", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltquintaActionPerformed

    private void adcsextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcsextaActionPerformed
         String plano =fsexta.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Sexta", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelSexta, "Sexta", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fquinta.setText("");
    }//GEN-LAST:event_adcsextaActionPerformed

    private void dltsextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltsextaActionPerformed
        String selectedPlan = sexta.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Sexta", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelSexta,"Sexta", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltsextaActionPerformed

    private void adcsabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcsabadoActionPerformed
         String plano =fsabado.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Sabado", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelSabado, "Sabado", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fsabado.setText("");
    }//GEN-LAST:event_adcsabadoActionPerformed

    private void dltsabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltsabadoActionPerformed
        String selectedPlan = sabado.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Sabado", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelSabado, "Sabado", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltsabadoActionPerformed

    private void atzsabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzsabadoActionPerformed
        String oldPlano = sabado.getSelectedValue();
        String newPlano = fsabado.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Sabado", usuarioId);
            fsabado.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelSabado, "Sabado", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzsabadoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
       Principal p = new Principal();
        p.setUsuarioId(usuarioId);

        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
    
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void adcdomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adcdomingoActionPerformed
        String plano =fdomingo.getText().trim();
        if (plano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            plannerDAO.adicionarPlanner(plano, "Domingo", usuarioId);
            JOptionPane.showMessageDialog(this, "Plano adicionado");
            populateList(listModelDomingo, "Domingo", usuarioId);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        fdomingo.setText("");
    }//GEN-LAST:event_adcdomingoActionPerformed

    private void atzdomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atzdomingoActionPerformed
        String oldPlano = domingo.getSelectedValue();
        String newPlano = fdomingo.getText().trim();

        if (oldPlano == null || newPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um item e preencha corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            plannerDAO.atualizarPlanner(oldPlano, newPlano, "Domingo", usuarioId);
            fdomingo.setText(""); 
            JOptionPane.showMessageDialog(this, "Plano atualizado com sucesso!");
            populateList(listModelDomingo, "Domingo", usuarioId); 
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atzdomingoActionPerformed

    private void dltdomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltdomingoActionPerformed
       String selectedPlan = domingo.getSelectedValue();

        if (selectedPlan != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deletar esta tarefa?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    plannerDAO.deletarPlanner(selectedPlan, "Domingo", usuarioId);
                    JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso!");
                    populateList(listModelDomingo, "Domingo", usuarioId);
                } catch (SQLException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Banco de dados não conectado", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item para deletar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltdomingoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adcdomingo;
    private javax.swing.JButton adcquarta;
    private javax.swing.JButton adcquinta;
    private javax.swing.JButton adcsabado;
    private javax.swing.JButton adcsegunda;
    private javax.swing.JButton adcsexta;
    private javax.swing.JButton adcterca;
    private javax.swing.JButton atzdomingo;
    private javax.swing.JButton atzquarta;
    private javax.swing.JButton atzquinta;
    private javax.swing.JButton atzsabado;
    private javax.swing.JButton atzsegunda;
    private javax.swing.JButton atzsexta;
    private javax.swing.JButton atzterca;
    private javax.swing.JButton dltdomingo;
    private javax.swing.JButton dltquarta;
    private javax.swing.JButton dltquinta;
    private javax.swing.JButton dltsabado;
    private javax.swing.JButton dltsegunda;
    private javax.swing.JButton dltsexta;
    private javax.swing.JButton dltterca;
    private javax.swing.JList<String> domingo;
    private javax.swing.JTextField fdomingo;
    private javax.swing.JTextField fquarta;
    private javax.swing.JTextField fquinta;
    private javax.swing.JTextField fsabado;
    private javax.swing.JTextField fsegunda;
    private javax.swing.JTextField fsexta;
    private javax.swing.JTextField fterca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> quarta;
    private javax.swing.JList<String> quinta;
    private javax.swing.JList<String> sabado;
    private javax.swing.JList<String> segunda;
    private javax.swing.JList<String> sexta;
    private javax.swing.JList<String> terca;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
