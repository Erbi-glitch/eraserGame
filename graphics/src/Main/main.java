package Main;
import javax.imageio.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class main{
    public static void main(String[] args)
    {
        myFrame window = new myFrame();
    }
}

class myFrame extends JFrame
{
    public myFrame()
    {
       myPanel np = new myPanel();
       Container cont = getContentPane();
       cont.add(np);
       setBounds(500,50,1000,1000);
       setTitle("Game eraser");
       setVisible(true);
    }
}

class myPanel extends JPanel
{
    private int x = 0, y = 0;
    private int napr = 2;
    private Image img;
        private class myKey implements KeyListener {
            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                int key_ = e.getKeyCode();
                if(key_==65)napr=0;
                if(key_==87)napr=1;
                if(key_==68)napr=2;
                if(key_==83)napr=3;
            }

            public void keyReleased(KeyEvent e) {}
        }
    public myPanel() {
        addKeyListener(new myKey());
        setFocusable(true);
        Timer nt = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        if(napr==0)x--;
        if(napr==1)y--;
        if(napr==2)x++;
        if(napr==3)y++;
        repaint();
            }
        });
        nt.start();
        try
        {
            img = ImageIO.read(new File("D:\\java\\javaprogekt\\graphics\\img\\eraser.jpeg"));
        }
        catch (IOException exp) {}
    }
    public void paintComponent(Graphics gr)
    {
        gr.clearRect(x-1,y-1,img.getWidth(null)+2,img.getHeight(null)+2);
        gr.clearRect(x+1,y+1,img.getWidth(null)+2,img.getHeight(null)+2);
        gr.drawImage(img, x,y,null);
        if(x<=0)x++;
        if(x>=805)x--;
        if(y<=0)y++;
        if(y>880)y--;
    }
}