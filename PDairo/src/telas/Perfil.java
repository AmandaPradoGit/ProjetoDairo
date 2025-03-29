package telas;

import banco.UsuarioDAO;
import dados.Cadastro;
import javax.swing.JOptionPane;

public class Perfil extends javax.swing.JFrame {
    private UsuarioDAO usuarioDAO;
    private Integer usuarioId;
    
    public Perfil() {
        initComponents();
        usuarioDAO = new UsuarioDAO();
        altSenha.setVisible(false);
        altEmail.setVisible(false);
        excluir.setVisible(false);
    }
    private void toggleSenha() {
        altSenha.setVisible(!altSenha.isVisible());
    }
    private void toggleEmail(){
        altEmail.setVisible(!altEmail.isVisible());
    }
    private void toggleExcluir(){
        excluir.setVisible(!excluir.isVisible());
    }
   
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
        exibirNomeUsuario(); 
        exibirEmailUsuario();
    }

    private void exibirNomeUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nome = usuarioDAO.buscarNomeUsuario(usuarioId); 
        nomeLabel.setText(nome);
    }
    public void exibirEmailUsuario() {
        String email = usuarioDAO.buscarEmailUsuario(usuarioId);  
        if (email != null) {
            emailLabel.setText(email);  
        } else {
            emailLabel.setText("Email não encontrado"); 
        }
    }
    private void redirecionarParaLogin() {
    this.dispose();

    Entrar telaLogin = new Entrar();  
    telaLogin.setVisible(true);  
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSenha = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        altSenha = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAtlsenha = new javax.swing.JButton();
        jsenhaAtual = new javax.swing.JPasswordField();
        jsenhaNova = new javax.swing.JPasswordField();
        excluir = new javax.swing.JPanel();
        jemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnexcluir = new javax.swing.JButton();
        jsenha = new javax.swing.JPasswordField();
        btnEmail = new javax.swing.JButton();
        altEmail = new javax.swing.JPanel();
        jemailNovo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAltemail = new javax.swing.JButton();
        jsenhaAtual2 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG1-removebg-preview (1) 1.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail:");

        voltar.setBackground(new java.awt.Color(0, 0, 0));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arrow left-circle (2).png"))); // NOI18N
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Informações");

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 2));

        nomeLabel.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        nomeLabel.setText("nome");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        emailLabel.setBackground(new java.awt.Color(0, 0, 0));
        emailLabel.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        emailLabel.setText("email");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        Logout.setBackground(new java.awt.Color(255, 153, 102));
        Logout.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        Logout.setText("LogOut");
        Logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 102, 51), new java.awt.Color(255, 102, 51)));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(voltar)
                .addGap(92, 92, 92)
                .addComponent(jLabel13)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));

        btnSenha.setBackground(new java.awt.Color(153, 255, 204));
        btnSenha.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnSenha.setForeground(new java.awt.Color(51, 51, 51));
        btnSenha.setText("Alterar senha");
        btnSenha.setBorder(null);
        btnSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 153, 153));
        btnExcluir.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(51, 51, 51));
        btnExcluir.setText("Excluir Conta");
        btnExcluir.setBorder(null);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        altSenha.setBackground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Senha atual:");

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nova senha:");

        btnAtlsenha.setBackground(new java.awt.Color(92, 122, 107));
        btnAtlsenha.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        btnAtlsenha.setText("Alterar");
        btnAtlsenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(153, 255, 204), new java.awt.Color(153, 255, 204)));
        btnAtlsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtlsenhaActionPerformed(evt);
            }
        });

        jsenhaAtual.setBackground(new java.awt.Color(51, 51, 51));
        jsenhaAtual.setForeground(new java.awt.Color(255, 255, 255));
        jsenhaAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 255, 204), new java.awt.Color(0, 255, 204)));

        jsenhaNova.setBackground(new java.awt.Color(51, 51, 51));
        jsenhaNova.setForeground(new java.awt.Color(255, 255, 255));
        jsenhaNova.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 255, 204), new java.awt.Color(153, 255, 204)));

        javax.swing.GroupLayout altSenhaLayout = new javax.swing.GroupLayout(altSenha);
        altSenha.setLayout(altSenhaLayout);
        altSenhaLayout.setHorizontalGroup(
            altSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altSenhaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(altSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jsenhaNova)
                    .addComponent(jsenhaAtual)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, altSenhaLayout.createSequentialGroup()
                        .addGroup(altSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(78, 78, 78)
                .addComponent(btnAtlsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        altSenhaLayout.setVerticalGroup(
            altSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(altSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(btnAtlsenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        excluir.setBackground(new java.awt.Color(0, 0, 0));

        jemail.setBackground(new java.awt.Color(51, 51, 51));
        jemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jemail.setForeground(new java.awt.Color(255, 255, 255));
        jemail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));
        jemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jemailActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-mail:");

        jLabel9.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Senha:");

        btnexcluir.setBackground(new java.awt.Color(203, 131, 131));
        btnexcluir.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        jsenha.setBackground(new java.awt.Color(51, 51, 51));
        jsenha.setForeground(new java.awt.Color(255, 255, 255));
        jsenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));

        javax.swing.GroupLayout excluirLayout = new javax.swing.GroupLayout(excluir);
        excluir.setLayout(excluirLayout);
        excluirLayout.setHorizontalGroup(
            excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, excluirLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jsenha)
                    .addComponent(jemail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, excluirLayout.createSequentialGroup()
                        .addGroup(excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(76, 76, 76)
                .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        excluirLayout.setVerticalGroup(
            excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(excluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(excluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnexcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnEmail.setBackground(new java.awt.Color(255, 102, 51));
        btnEmail.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnEmail.setForeground(new java.awt.Color(51, 51, 51));
        btnEmail.setText("Alterar e-mail");
        btnEmail.setBorder(null);
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        altEmail.setBackground(new java.awt.Color(0, 0, 0));

        jemailNovo.setBackground(new java.awt.Color(51, 51, 51));
        jemailNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jemailNovo.setForeground(new java.awt.Color(255, 255, 255));
        jemailNovo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 102), new java.awt.Color(255, 153, 102)));

        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Senha:");

        jLabel11.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Novo e-mail:");

        btnAltemail.setBackground(new java.awt.Color(158, 66, 35));
        btnAltemail.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        btnAltemail.setText("Alterar");
        btnAltemail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 153, 102), new java.awt.Color(255, 153, 102)));
        btnAltemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltemailActionPerformed(evt);
            }
        });

        jsenhaAtual2.setBackground(new java.awt.Color(51, 51, 51));
        jsenhaAtual2.setForeground(new java.awt.Color(255, 255, 255));
        jsenhaAtual2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 204, 153), new java.awt.Color(255, 204, 153)));

        javax.swing.GroupLayout altEmailLayout = new javax.swing.GroupLayout(altEmail);
        altEmail.setLayout(altEmailLayout);
        altEmailLayout.setHorizontalGroup(
            altEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altEmailLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(altEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jsenhaAtual2)
                    .addComponent(jemailNovo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, altEmailLayout.createSequentialGroup()
                        .addGroup(altEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(77, 77, 77)
                .addComponent(btnAltemail, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        altEmailLayout.setVerticalGroup(
            altEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsenhaAtual2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnAltemail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jemailNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("OCR A Extended", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Alterações");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG3-removebg-preview (1) 1.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG4-removebg-preview (2) 1.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/OIG1-removebg-preview (3) 1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(altSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(altEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(352, 352, 352))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(11, 11, 11)
                .addComponent(altSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(altEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jemailActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        Principal p = new Principal();
        p.setUsuarioId(usuarioId);

        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
    
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Entrar login = new Entrar();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void btnSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaActionPerformed
        toggleSenha();
    }//GEN-LAST:event_btnSenhaActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        toggleEmail();
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        toggleExcluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtlsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtlsenhaActionPerformed
    String senhaAtual = jsenhaAtual.getText().trim();
    String senhaNova = jsenhaNova.getText().trim();

    if (senhaAtual.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira a senha atual.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (senhaNova.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira a nova senha.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
    boolean senhaValida = usuarioDAO.verificarSenhaAtual(usuarioId, senhaAtual);

    if (!senhaValida) {
        JOptionPane.showMessageDialog(this, "Senha atual incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean sucesso = usuarioDAO.atualizarSenha(usuarioId, senhaNova);

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        altSenha.setVisible(false); 
        
        jsenhaAtual.setText("");
        jsenhaNova.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao alterar a senha.", "Erro", JOptionPane.ERROR_MESSAGE);
    }      
    }//GEN-LAST:event_btnAtlsenhaActionPerformed

    private void btnAltemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltemailActionPerformed
        String emailNovo = jemailNovo.getText().trim();
        String senhaAtual2 = jsenhaAtual2.getText().trim();
        
        if (senhaAtual2.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira a senha atual.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
        }
        if (emailNovo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira o novo email.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
        }
         boolean senhaValida = usuarioDAO.verificarSenhaAtual(usuarioId, senhaAtual2);

        if (!senhaValida) {
        JOptionPane.showMessageDialog(this, "Senha atual incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
        }

        boolean sucesso = usuarioDAO.atualizarEmail(usuarioId, emailNovo);
        
        if (sucesso) {
        JOptionPane.showMessageDialog(this, "Email alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        altSenha.setVisible(false); 
        
        jsenhaAtual.setText("");
        jemailNovo.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao alterar o email.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_btnAltemailActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
    String email = jemail.getText().trim(); 
    String senha = jsenha.getText().trim();  
    
    if (email.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha o e-mail e a senha para continuar.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    Cadastro cadastro = new Cadastro();
    cadastro.setEmail(email);
    cadastro.setSenha(senha);

    
    boolean sucesso = usuarioDAO.excluirUsuario(cadastro);

    if (sucesso) {
        JOptionPane.showMessageDialog(this, "Conta excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
       
        redirecionarParaLogin();
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao excluir conta. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnexcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JPanel altEmail;
    private javax.swing.JPanel altSenha;
    private javax.swing.JButton btnAltemail;
    private javax.swing.JButton btnAtlsenha;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSenha;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jemailNovo;
    private javax.swing.JPasswordField jsenha;
    private javax.swing.JPasswordField jsenhaAtual;
    private javax.swing.JPasswordField jsenhaAtual2;
    private javax.swing.JPasswordField jsenhaNova;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
