import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MarioGame extends JPanel implements ActionListener, KeyListener {

    private int marioX;           // Posição horizontal do Mario
    private Image marioImage;     // Imagem do Mario
    private Timer timer;          // Um temporizador para atualizar o jogo

    public MarioGame() {
        marioX = 50;  // Inicializa a posição horizontal do Mario
        ImageIcon marioIcon = new ImageIcon(".idea/download.png");  // Carrega a imagem do Mario
        Image marioOriginal = marioIcon.getImage();  // Obtém a imagem do ImageIcon

        // Redimensiona a imagem do Mario para uma largura e altura desejadas
        int novaLargura = 30;
        int novaAltura = 30;
        marioImage = marioOriginal.getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);

        timer = new Timer(10, this);  // Cria um temporizador para atualizar o jogo a cada 10 milissegundos
        timer.start();  // Inicia o temporizador

        addKeyListener(this);  // Adiciona o ouvinte de teclado (KeyListener) a este painel
        setFocusable(true);    // Permite que o painel receba o foco do teclado
        setFocusTraversalKeysEnabled(false);  // Desabilita a travessia do foco por padrão
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha o Mario na posição atual
        g.drawImage(marioImage, marioX, 20, this);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();  // Redesenha o painel, o que atualiza o jogo
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move o Mario para a esquerda ou direita quando as teclas de seta são pressionadas
        if (key == KeyEvent.VK_LEFT) {
            marioX -= 5;  // Mover para a esquerda
        } else if (key == KeyEvent.VK_RIGHT) {
            marioX += 5;  // Mover para a direita
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mario Game");  // Cria uma janela com o título "Mario Game"
        MarioGame game = new MarioGame();  // Cria uma instância do jogo

        frame.add(game);  // Adiciona o jogo à janela
        frame.setSize(800, 300);  // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fecha o programa quando a janela é fechada
        frame.setVisible(true);  // Torna a janela visível
    }
}
