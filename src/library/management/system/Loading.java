
package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;

    Thread th;
    public static void main(String[] args)
    {
        new Loading().setVisible(true);
    }
    public void setUploading()
    {
      
        th.start();
       
        
    }
    public void run()
    {
        try{
            for(int i=0;i<101;i++)
            {
              
                int m=progressBar.getMaximum();
                int v=progressBar.getValue();
                if(v<m)
                {
                    progressBar.setValue(progressBar.getValue()+1);
                }
                else
                {
                   i=102;
                   setVisible(false);
                   new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Loading()
    {
        super("Loading");
        th=new Thread((Runnable)this);
        
        //setBounds(600,300,600,400);
         setBounds(300,100,600,400);
        contentPane=new JPanel();   
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbllibraryManagement=new JLabel("Smart Library v5.1");
        lbllibraryManagement.setForeground(Color.cyan);
        lbllibraryManagement.setFont(new Font("Trebuchet Ms",Font.BOLD,35));
        lbllibraryManagement.setBounds(130,46,500,35);
        contentPane.add(lbllibraryManagement);
        
        progressBar=new JProgressBar();
       progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);
        
        JLabel lblNewLabel_2=new JLabel("please wait.....");
        lblNewLabel_2.setForeground(new Color(160,82,45));
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,20));
        lblNewLabel_2.setBounds(200,165,150,20);
        contentPane.add(lblNewLabel_2);
        
        JPanel panel=new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0,0,590,390);
        contentPane.add(panel);
        
        setUploading();
        
    }
}
