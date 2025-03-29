package telas;
import banco.CalendarioDAO;
import dados.Compromisso;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Calendário extends javax.swing.JFrame {
    private int anoAtual;
    private int mesAtual;
    private JButton[] botoesDias;
    private CalendarioDAO calendarioDAO;
    private DefaultListModel<String> listModel;
    private int usuarioId;

    public Calendário(int usuarioId) {
        this.usuarioId = usuarioId;
        
        initComponents();
        LocalDate hoje = LocalDate.now();
        
        anoAtual = hoje.getYear();
        mesAtual = hoje.getMonthValue() - 1;
        
        inicializarBotoes();
        calendarioDAO = new CalendarioDAO();
        listModel = new DefaultListModel<>();
        
        atualizarCalendario(mesAno);
    }
    private void inicializarBotoes() {
    botoesDias = new JButton[] {
        
        jButton8, jButton9, jButton10, jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, 
        jButton17, jButton18, jButton19,   jButton20, jButton21, jButton22, jButton23, jButton24, jButton25,  
        jButton26, jButton27,  jButton28, jButton29,  jButton30, jButton31, jButton32, jButton33, jButton34,
        jButton35, jButton36,  jButton37, jButton38, jButton39, jButton40, jButton41, jButton42,
        jButton43, jButton44, jButton45,  jButton46, jButton47, jButton48
            
    };
    }
    
     private void atualizarCalendario(JLabel mesAno) {
        mesAno.setText(String.format("%s %d", getNomeMes(mesAtual), anoAtual));

        LocalDate primeiroDiaMes = LocalDate.of(anoAtual, mesAtual + 1, 1);
        int primeiroDiaSemana = primeiroDiaMes.getDayOfWeek().getValue() % 7; 
        int diasNoMes = primeiroDiaMes.lengthOfMonth();
        Color corCompromisso = new Color(255,102,102);
        
        for (JButton botao : botoesDias) {
            botao.setBackground(null); 
            botao.setText("");
            botao.setEnabled(false); 
        }

        for (int i = 0; i < botoesDias.length; i++) {
            JButton botao = botoesDias[i];

            if (i >= primeiroDiaSemana && (i - primeiroDiaSemana) < diasNoMes) {
                int dia = i - primeiroDiaSemana + 1;
                botao.setText(String.valueOf(dia));
                botao.setEnabled(true);
                LocalDate data = LocalDate.of(anoAtual, mesAtual + 1, dia);
                
                
                if (!calendarioDAO.buscarCompromissosPorData(data, usuarioId).isEmpty()) {
                    botao.setBackground(corCompromisso); 
                } 
                for (ActionListener al : botao.getActionListeners()) {
                    botao.removeActionListener(al);
                }
                
                botao.addActionListener(e -> {
                String[] opcoes = {"Visualizar", "Adicionar"};
                int escolha = JOptionPane.showOptionDialog(this, "Escolha uma opção:", "Opções de Compromisso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
    
                if (escolha == 0) { 
                    visualizarCompromissos(data);
                } else if (escolha == 1) { 
                    String descricao = JOptionPane.showInputDialog(this, "Digite a descrição do compromisso:");
                    if (descricao != null && !descricao.trim().isEmpty()) {
                    Compromisso compromisso = new Compromisso(data, descricao);
                    calendarioDAO.adicionarCompromisso(compromisso, usuarioId);
                    atualizarCalendario(mesAno);
                    atualizarListaCompromissos(data); 
                } else {
                    JOptionPane.showMessageDialog(this, "Descrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});

            }
        }
    }
     
    private void visualizarCompromissos(LocalDate data) {
        List<Compromisso> compromissos = calendarioDAO.buscarCompromissosPorData(data, usuarioId);
        
        if (compromissos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum compromisso encontrado para esta data.", "Compromissos", JOptionPane.INFORMATION_MESSAGE);
            return;
        } 
        String[] opcoesCompromissos = new String[compromissos.size()];
        for (int i = 0; i < compromissos.size(); i++) {
            opcoesCompromissos[i] = compromissos.get(i).getDescricao();
        }
        String compromissoSelecionado = (String) JOptionPane.showInputDialog(this, "Escolha um compromisso para editar ou excluir:", "Compromissos", JOptionPane.PLAIN_MESSAGE, null, opcoesCompromissos, opcoesCompromissos[0]);
        if (compromissoSelecionado != null) {
            Compromisso compromisso = compromissos.stream() .filter(c -> c.getDescricao().equals(compromissoSelecionado)) .findFirst().orElse(null);
            if (compromisso != null) {
                editarOuExcluirCompromisso(compromisso); 
            }
        }
    }
    
    private void editarOuExcluirCompromisso(Compromisso compromisso) {
        String[] opcoes = {"Editar", "Excluir", "Cancelar"};
        
        int escolha = JOptionPane.showOptionDialog(this, "Escolha uma opção:", "Editar/Excluir Compromisso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            String novaDescricao = JOptionPane.showInputDialog(this, "Digite a nova descrição:", compromisso.getDescricao());
            if (novaDescricao != null && !novaDescricao.trim().isEmpty()) { 
                compromisso.setDescricao(novaDescricao);
                calendarioDAO.atualizarCompromisso(compromisso, usuarioId);
                atualizarCalendario(mesAno);
                atualizarListaCompromissos(compromisso.getData());
            }
        } else if (escolha == 1) {
            calendarioDAO.apagarCompromisso(compromisso.getId(), usuarioId);
            atualizarCalendario(mesAno);
            atualizarListaCompromissos(compromisso.getData());
        }
    }    
    
    private void atualizarListaCompromissos(LocalDate data) { 
        List<Compromisso> compromissos = calendarioDAO.buscarCompromissosPorData(data, usuarioId);
        listModel.clear();
        for (Compromisso compromisso : compromissos) {
            listModel.addElement(compromisso.getDescricao());
        }
    }
    private String getNomeMes(int mes) {
        String[] nomesMeses = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        return nomesMeses[mes];
    }             
                    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdicionarCompromissoDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanelCalendario = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        mesAno = new javax.swing.JLabel();
        prox = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome do compromisso:");

        jButton50.setBackground(new java.awt.Color(255, 102, 51));
        jButton50.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jButton50.setText("Adicionar");
        jButton50.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel2.setText("Compromissos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jButton51.setBackground(new java.awt.Color(153, 255, 153));
        jButton51.setText("Atualizar");
        jButton51.setBorder(null);

        jButton52.setBackground(new java.awt.Color(255, 51, 51));
        jButton52.setText("Deletar");
        jButton52.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout AdicionarCompromissoDialogLayout = new javax.swing.GroupLayout(AdicionarCompromissoDialog.getContentPane());
        AdicionarCompromissoDialog.getContentPane().setLayout(AdicionarCompromissoDialogLayout);
        AdicionarCompromissoDialogLayout.setHorizontalGroup(
            AdicionarCompromissoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AdicionarCompromissoDialogLayout.setVerticalGroup(
            AdicionarCompromissoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 102), new java.awt.Color(255, 153, 102)));

        jPanelCalendario.setBackground(new java.awt.Color(255, 153, 153));
        jPanelCalendario.setLayout(new java.awt.GridLayout(7, 7));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Dom");
        jButton1.setBorder(null);
        jPanelCalendario.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton2.setText("Seg");
        jButton2.setBorder(null);
        jPanelCalendario.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton3.setText("Ter");
        jButton3.setBorder(null);
        jPanelCalendario.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton4.setText("Qua");
        jButton4.setBorder(null);
        jPanelCalendario.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton5.setText("Qui");
        jButton5.setBorder(null);
        jPanelCalendario.add(jButton5);

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton7.setText("Sex");
        jButton7.setBorder(null);
        jPanelCalendario.add(jButton7);

        jButton6.setBackground(new java.awt.Color(255, 102, 102));
        jButton6.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("Sab");
        jButton6.setBorder(null);
        jPanelCalendario.add(jButton6);

        jButton8.setBackground(new java.awt.Color(255, 153, 153));
        jButton8.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton8.setText("1");
        jButton8.setBorder(null);
        jPanelCalendario.add(jButton8);

        jButton9.setBackground(new java.awt.Color(255, 153, 153));
        jButton9.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton9.setText("2");
        jButton9.setBorder(null);
        jPanelCalendario.add(jButton9);

        jButton10.setBackground(new java.awt.Color(255, 153, 153));
        jButton10.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton10.setText("3");
        jButton10.setBorder(null);
        jPanelCalendario.add(jButton10);

        jButton11.setBackground(new java.awt.Color(255, 153, 153));
        jButton11.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton11.setText("4");
        jButton11.setBorder(null);
        jPanelCalendario.add(jButton11);

        jButton12.setBackground(new java.awt.Color(255, 153, 153));
        jButton12.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton12.setText("5");
        jButton12.setBorder(null);
        jPanelCalendario.add(jButton12);

        jButton13.setBackground(new java.awt.Color(255, 153, 153));
        jButton13.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton13.setText("6");
        jButton13.setBorder(null);
        jPanelCalendario.add(jButton13);

        jButton14.setBackground(new java.awt.Color(255, 153, 153));
        jButton14.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton14.setText("7");
        jButton14.setBorder(null);
        jPanelCalendario.add(jButton14);

        jButton15.setBackground(new java.awt.Color(255, 153, 153));
        jButton15.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton15.setText("8");
        jButton15.setBorder(null);
        jPanelCalendario.add(jButton15);

        jButton16.setBackground(new java.awt.Color(255, 153, 153));
        jButton16.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton16.setText("9");
        jButton16.setBorder(null);
        jPanelCalendario.add(jButton16);

        jButton17.setBackground(new java.awt.Color(255, 153, 153));
        jButton17.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton17.setText("10");
        jButton17.setBorder(null);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanelCalendario.add(jButton17);

        jButton18.setBackground(new java.awt.Color(255, 153, 153));
        jButton18.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton18.setText("11");
        jButton18.setBorder(null);
        jPanelCalendario.add(jButton18);

        jButton19.setBackground(new java.awt.Color(255, 153, 153));
        jButton19.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton19.setText("12");
        jButton19.setBorder(null);
        jPanelCalendario.add(jButton19);

        jButton20.setBackground(new java.awt.Color(255, 153, 153));
        jButton20.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton20.setText("13");
        jButton20.setBorder(null);
        jPanelCalendario.add(jButton20);

        jButton21.setBackground(new java.awt.Color(255, 153, 153));
        jButton21.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton21.setText("14");
        jButton21.setBorder(null);
        jPanelCalendario.add(jButton21);

        jButton22.setBackground(new java.awt.Color(255, 153, 153));
        jButton22.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton22.setText("15");
        jButton22.setBorder(null);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanelCalendario.add(jButton22);

        jButton23.setBackground(new java.awt.Color(255, 153, 153));
        jButton23.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton23.setText("16");
        jButton23.setBorder(null);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanelCalendario.add(jButton23);

        jButton24.setBackground(new java.awt.Color(255, 153, 153));
        jButton24.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton24.setText("17");
        jButton24.setBorder(null);
        jPanelCalendario.add(jButton24);

        jButton25.setBackground(new java.awt.Color(255, 153, 153));
        jButton25.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton25.setText("18");
        jButton25.setBorder(null);
        jPanelCalendario.add(jButton25);

        jButton26.setBackground(new java.awt.Color(255, 153, 153));
        jButton26.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton26.setText("19");
        jButton26.setBorder(null);
        jPanelCalendario.add(jButton26);

        jButton27.setBackground(new java.awt.Color(255, 153, 153));
        jButton27.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton27.setText("20");
        jButton27.setBorder(null);
        jPanelCalendario.add(jButton27);

        jButton28.setBackground(new java.awt.Color(255, 153, 153));
        jButton28.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton28.setText("21");
        jButton28.setBorder(null);
        jPanelCalendario.add(jButton28);

        jButton29.setBackground(new java.awt.Color(255, 153, 153));
        jButton29.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton29.setText("22");
        jButton29.setBorder(null);
        jPanelCalendario.add(jButton29);

        jButton30.setBackground(new java.awt.Color(255, 153, 153));
        jButton30.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton30.setText("23");
        jButton30.setBorder(null);
        jPanelCalendario.add(jButton30);

        jButton31.setBackground(new java.awt.Color(255, 153, 153));
        jButton31.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton31.setText("24");
        jButton31.setBorder(null);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanelCalendario.add(jButton31);

        jButton32.setBackground(new java.awt.Color(255, 153, 153));
        jButton32.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton32.setText("25");
        jButton32.setBorder(null);
        jPanelCalendario.add(jButton32);

        jButton33.setBackground(new java.awt.Color(255, 153, 153));
        jButton33.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton33.setText("26");
        jButton33.setBorder(null);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanelCalendario.add(jButton33);

        jButton34.setBackground(new java.awt.Color(255, 153, 153));
        jButton34.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton34.setText("27");
        jButton34.setBorder(null);
        jPanelCalendario.add(jButton34);

        jButton35.setBackground(new java.awt.Color(255, 153, 153));
        jButton35.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton35.setText("28");
        jButton35.setBorder(null);
        jPanelCalendario.add(jButton35);

        jButton36.setBackground(new java.awt.Color(255, 153, 153));
        jButton36.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton36.setText("29");
        jButton36.setBorder(null);
        jPanelCalendario.add(jButton36);

        jButton37.setBackground(new java.awt.Color(255, 153, 153));
        jButton37.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton37.setText("30");
        jButton37.setBorder(null);
        jPanelCalendario.add(jButton37);

        jButton38.setBackground(new java.awt.Color(255, 153, 153));
        jButton38.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton38.setText("31");
        jButton38.setBorder(null);
        jPanelCalendario.add(jButton38);

        jButton39.setBackground(new java.awt.Color(255, 153, 153));
        jButton39.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton39.setBorder(null);
        jPanelCalendario.add(jButton39);

        jButton40.setBackground(new java.awt.Color(255, 153, 153));
        jButton40.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton40.setBorder(null);
        jPanelCalendario.add(jButton40);

        jButton41.setBackground(new java.awt.Color(255, 153, 153));
        jButton41.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton41.setBorder(null);
        jPanelCalendario.add(jButton41);

        jButton42.setBackground(new java.awt.Color(255, 153, 153));
        jButton42.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton42.setBorder(null);
        jPanelCalendario.add(jButton42);

        jButton43.setBackground(new java.awt.Color(255, 153, 153));
        jButton43.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton43.setBorder(null);
        jPanelCalendario.add(jButton43);

        jButton44.setBackground(new java.awt.Color(255, 153, 153));
        jButton44.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton44.setBorder(null);
        jPanelCalendario.add(jButton44);

        jButton45.setBackground(new java.awt.Color(255, 153, 153));
        jButton45.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton45.setBorder(null);
        jPanelCalendario.add(jButton45);

        jButton46.setBackground(new java.awt.Color(255, 153, 153));
        jButton46.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton46.setBorder(null);
        jPanelCalendario.add(jButton46);

        jButton47.setBackground(new java.awt.Color(255, 153, 153));
        jButton47.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton47.setBorder(null);
        jPanelCalendario.add(jButton47);

        jButton48.setBackground(new java.awt.Color(255, 153, 153));
        jButton48.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton48.setBorder(null);
        jPanelCalendario.add(jButton48);

        jButton49.setBackground(new java.awt.Color(255, 153, 153));
        jButton49.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton49.setBorder(null);
        jPanelCalendario.add(jButton49);

        mesAno.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        mesAno.setForeground(new java.awt.Color(255, 51, 51));
        mesAno.setText("Janeiro 2024");

        prox.setBackground(new java.awt.Color(0, 0, 0));
        prox.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        prox.setForeground(new java.awt.Color(255, 51, 51));
        prox.setText(">>");
        prox.setBorder(null);
        prox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxActionPerformed(evt);
            }
        });

        prev.setBackground(new java.awt.Color(0, 0, 0));
        prev.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        prev.setForeground(new java.awt.Color(255, 51, 51));
        prev.setText("<<");
        prev.setBorder(null);
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addComponent(prev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(mesAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(prox)
                        .addContainerGap(67, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesAno)
                    .addComponent(prev)
                    .addComponent(prox, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        voltar.setBackground(new java.awt.Color(0, 0, 0));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow left-circle (2).png"))); // NOI18N
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Calendário");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(voltar)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG1-removebg-preview (6) 1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG1-removebg-preview 1 (1).png"))); // NOI18N
        jLabel3.setText("DAIRO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
         mesAtual--;
            if (mesAtual < 0) {
                mesAtual = 11;
                anoAtual--;
            }
            atualizarCalendario(mesAno);
       
    }//GEN-LAST:event_prevActionPerformed

    private void proxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxActionPerformed
        mesAtual++;
            if (mesAtual > 11) {
                mesAtual = 0;
                anoAtual++;
            }
            atualizarCalendario(mesAno);
    }//GEN-LAST:event_proxActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        Principal p = new Principal();
        p.setUsuarioId(usuarioId);

        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
    
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AdicionarCompromissoDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCalendario;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mesAno;
    private javax.swing.JButton prev;
    private javax.swing.JButton prox;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
