import java.awt.*;
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.*;  
import javax.swing.*;      
import java.sql.*; 
class variablesl{
 static String username;
 static String code="";
 static int  eligible=0;
 static String voterid;
 static String gmail;

 
}
 
//intro page

public class voting123 extends variablesl {  
      public static void main(String[] arguments) {  
        
        JFrame f1=new JFrame("PasswordField Example"); 
        JButton log1=new JButton("LOGIN k");     
        JButton log=new JButton("Login");  
        log.setBounds(20,20, 120,30);  
        log.setFont(new Font("Verdana",Font.BOLD,15));
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        
        JButton sign=new JButton("Sign Up");  
        sign.setBounds(150,20,120,30);  
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.setFont(new Font("Verdana",Font.BOLD,15));
        JLabel l52=new JLabel();
        ImageIcon img=new ImageIcon("main.jpeg");
        l52.setIcon(img);
        l52.setBounds(0,0,612,408);
        log.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){ 
            f1.dispose();
          new Login();
          System.out.println(username);
         
          }
        });
        sign.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){ 
            f1.dispose(); 
            username="hello in login";
            System.out.println(username);
          new Signup();
          }
        });
       
      f1.add(log);
      f1.add(sign);
      f1.add(l52);
        f1.setSize(612,408);    
        f1.setLayout(null);    
        f1.setVisible(true);     
      }  
} 


//login page

 class Login extends variablesl{  
    Login(){
      JFrame f=new JFrame("Login"); 
      JTextField mailt=new JTextField();   
      JButton log=new JButton("Login");  
      JPasswordField value = new JPasswordField();   
      JLabel passj=new JLabel("Password:");
      JLabel maill=new JLabel("Enter your email");
      JLabel already=new JLabel("create an account..?");
      JLabel l53=new JLabel();
      ImageIcon img1=new ImageIcon("login.jpeg");
      l53.setIcon(img1);
      l53.setBounds(0,0,480,270);
      f.add(l53);
     
     
      already.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            f.dispose();
            new Signup();
        }

    });
   
    maill.setBounds(500,100, 150,30); 
    mailt.setBounds(500,125, 200,30);  
    passj.setBounds(500,150,100,30); 
    value.setBounds(500,175,200,30);
    log.setBounds(500,230,95,30);
    already.setBounds(540,210,200,10);
    log.setBackground(Color.BLACK);
     log.setForeground(Color.WHITE);
     log.setFont(new Font("Verdana",Font.BOLD,15));

      
      log.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){  
              Connection con=null;
              try{  
              Class.forName("com.mysql.jdbc.Driver");  
              con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
              //here sonoo is database name, root is username and password  
              System.out.print("Database is connected !");
              
                
          
              PreparedStatement pst = con.prepareStatement("Select * from details where email=? and pass=?");
              pst.setString(1, mailt.getText());
              pst.setString(2, value.getText());
              ResultSet rs = pst.executeQuery();
          
              boolean x = rs.next(); 
          
             
              if(x){
                Statement stmt = con.createStatement();
                String sql = "Select * from details where email='"+mailt.getText()+"' and pass='"+value.getText()+"'"; 
               
                ResultSet rs1 = stmt.executeQuery(sql);
                username=rs.getString("first")+" "+rs.getString("last");
                gmail=rs.getString("email");
                System.out.println(username);
                f.dispose();
                 new Home();
              }
           
             if(!x){
              JOptionPane.showMessageDialog(f,"credentials doesn't match");
              }
              
             }
              catch(Exception em){ System.out.println(em);} 
             
  
                  }  
              });  
              f.getContentPane().setBackground(new Color(245,247,240));
      f.add(log); 
      f.add(mailt);  
      f.add(maill); 
      f.add(passj);
      f.add(value);
      f.add(already);
     

      f.setSize(750,350);  
      f.setLayout(null);  
      f.setVisible(true);
  
   
   
  }  
}
   
//signup page


 class Signup
{
    JFrame f=new JFrame();
    Signup()
    {
        System.out.print("hellloo");
        JLabel l1=new JLabel("First Name:");
        l1.setBounds(20,40,150,20);
        f.add(l1);
        JTextField t1=new JTextField();
        t1.setBounds(180,40,150,20);
        f.add(t1);
        JLabel l2=new JLabel("Last Name:");
        l2.setBounds(20,80,150,20);
        f.add(l2);
        JTextField t2=new JTextField();
        t2.setBounds(180,80,150,20);
        f.add(t2);
        JLabel l3=new JLabel("User Name:");
        l3.setBounds(20,120,150,20);
        f.add(l3);
        JTextField t3=new JTextField();
        t3.setBounds(180,120,150,20);
        f.add(t3);
        JLabel l4=new JLabel("Email Address:");
        l4.setBounds(20,160,150,20);
        f.add(l4);
        JTextField t4=new JTextField();
        t4.setBounds(180,160,150,20);
        f.add(t4);
        JLabel l5=new JLabel("Create a Password:");
        l5.setBounds(20,200,150,20);
        f.add(l5);
        JPasswordField p1=new JPasswordField();
        p1.setBounds(180,200,150,20);
        f.add(p1);
        JCheckBox c1=new JCheckBox("Show password");
        c1.setBounds(180,220,150,20);
        f.add(c1);
        c1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(c1.isSelected())
                {
                    p1.setEchoChar((char)0);
                }
                else
                {
                    p1.setEchoChar('*');
                }
            }
        });
        JLabel l6=new JLabel("Confirm Password:");
        l6.setBounds(20,260,150,20);
        f.add(l6);
        JPasswordField p2=new JPasswordField();
        p2.setBounds(180,260,150,20);
        f.add(p2);
        JCheckBox c2=new JCheckBox("Show password");
        c2.setBounds(180,280,150,20);
        c2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(c2.isSelected())
                {
                    p2.setEchoChar((char)0);
                }
                else
                {
                    p2.setEchoChar('*');
                }
            }
        });
        f.add(c2);
       JLabel l7=new JLabel("Mobile Number:");
       l7.setBounds(20,320,150,20);
       f.add(l7);
       JTextField t7=new JTextField();
       t7.setBounds(180,320,150,20);
       f.add(t7);
       JLabel l8=new JLabel("Gender:");
       l8.setBounds(20,360,150,20);
       f.add(l8);
       ButtonGroup bg=new ButtonGroup();
       JRadioButton r1=new JRadioButton("Male");
       JRadioButton r2=new JRadioButton("Female");

       
      
       r1.setBounds(180,360,70,20);
       r2.setBounds(270,360,100,20);
       f.add(r1);
       f.add(r2);
       bg.add(r1);
       bg.add(r2);
       JCheckBox c3=new JCheckBox("Please agree to our terms and conditions.By clicking above checkbox");
       c3.setBounds(20,380,430,20);
       f.add(c3);
       JLabel already=new JLabel("already have an account..?");
       already.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            f.dispose();
            new Login();
        }
           });
       already.setForeground(Color.BLUE);
       already.setBounds(100,420,200,15);
       f.add(already);
       JLabel l54=new JLabel();
       ImageIcon img2=new ImageIcon("demo23.jpeg");
       l54.setIcon(img2);
       l54.setBounds(450,0,677,574);
       f.add(l54);
       JButton b1=new JButton("Sign Up");
      
 
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       
        b1.setFont(new Font("Verdana",Font.BOLD,15));

       b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            String first=t1.getText();
            String last=t2.getText();
            String username=t3.getText();
            String email=t4.getText();
            String pass=p1.getText();
            String cpass=p2.getText();
            String mobile=t7.getText();
            // String gender=gen;
      
       b1.setBounds(180,440,100,40);
       f.add(b1);
       
        }
      });
      f.setSize(1100,600);
       f.setLayout(null);
       f.setVisible(true);
    }
   
}


//home page

class Home extends variablesl{  
  Home(){ 
    JFrame frame = new JFrame();   
    MyJComponent com = new MyJComponent();  
   JLabel home= new JLabel("home");
   home.setForeground(Color.WHITE);
   JLabel create= new JLabel("create");
    create.setForeground(Color.WHITE);
   JLabel voting= new JLabel("voting");
   voting.setForeground(Color.WHITE);
   JLabel results= new JLabel("results");
  results.setForeground(Color.WHITE);
  JLabel id= new JLabel("id controller");
  id.setForeground(Color.WHITE);
  id.setBounds(260,10,150,50);
  JLabel user= new JLabel(username);
  user.setForeground(Color.WHITE);
  user.setBounds(1000,10,150,50);
  JLabel out= new JLabel("logout");
  out.setForeground(Color.WHITE);
  out.setBounds(1100,10,80,50);
frame.add(out);
  frame.add(user);
   
    home.setBounds(10,10,50,50);
    create.setBounds(70,10,50,50);
    voting.setBounds(130,10,50,50);
    results.setBounds(200,10,50,50);
    JLabel l20=new JLabel("The Electoral System");
    l20.setBounds(350,300,800,60);
    l20.setFont(new Font("Verdana",Font.BOLD,40));
    l20.setForeground(Color.WHITE);
    frame.add(l20);

     JLabel l21=new JLabel("Choose Your Favourite");
    l21.setBounds(420,350,500,60);
    l21.setFont(new Font("Verdana",Font.ITALIC,25));
    l21.setForeground(Color.WHITE);
    frame.add(l21);
    
    JLabel l70=new JLabel("Choose Your Favourite");
    l70.setBounds(420,350,500,60);
    l70.setFont(new Font("Verdana",Font.ITALIC,25));
    l70.setForeground(Color.WHITE);
    frame.add(l70);
    JLabel l55=new JLabel();
    ImageIcon img5=new ImageIcon("home23.jpeg");
    l55.setIcon(img5);
    l55.setBounds(0,50,1280,655);
    frame.add(l55);
     

    create.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          frame.dispose();
          new Create();
      }
});
    voting.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        frame.dispose();
          new Voting();
      }
});
    results.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        frame.dispose();
          new Results();
      }
});
    id.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        frame.dispose();
          new voters();
      }
});
out.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    frame.dispose();
      new Login();
  }
});


    frame.add(l21);
    frame.setSize(1200,705);
    frame.add(id);
    frame.add(home);
    frame.add(create);
    frame.add(voting);
    frame.add(results);
    frame.add(com);  
    frame.setVisible(true);  
  }  
}



//election creation

 class Create extends variablesl{  
    Create(){  
      MyJComponent com = new MyJComponent();  
     JLabel home= new JLabel("home");
     home.setForeground(Color.WHITE);
 
     JLabel create= new JLabel("create");
      create.setForeground(Color.WHITE);
     JLabel voting= new JLabel("voting");
     voting.setForeground(Color.WHITE);
     JLabel results= new JLabel("results");
    results.setForeground(Color.WHITE);
    JLabel id= new JLabel("id controller");
    id.setForeground(Color.WHITE);
    id.setBounds(260,10,150,50);
      JFrame f = new JFrame();  
      JLabel user= new JLabel(username);
      user.setForeground(Color.WHITE);
      user.setBounds(1000,10,150,50);
      JLabel out= new JLabel("logout");
      out.setForeground(Color.WHITE);
  out.setBounds(1100,10,80,50);
  
   
      f.add(out);
    f.add(user);
    f.add(id);
      home.setBounds(10,10,50,50);
      create.setBounds(70,10,50,50);
      voting.setBounds(130,10,50,50);
      results.setBounds(200,10,50,50);
      JLabel l80=new JLabel();

      JLabel l23=new JLabel("Election Name:");
      l23.setBounds(300,120,150,20);
      
      f.add(l23);
      JTextField t20=new JTextField();
      t20.setBounds(470,120,150,20);
      f.add(t20);
      JLabel l24=new JLabel("Election Code:");
      l24.setBounds(640,120,150,20);
      f.add(l24);
      JTextField t21=new JTextField();
      t21.setBounds(810,120,150,20);
      f.add(t21);
      JLabel l25=new JLabel("Participant 1:");
      l25.setBounds(300,180,150,20);
      f.add(l25);
      JTextField t22=new JTextField();
      t22.setBounds(470,180,150,20);
      f.add(t22);
      JLabel l26=new JLabel("Symbol 1:");
      l26.setBounds(640,180,150,20);
      f.add(l26);
      JTextField t26=new JTextField();
      t26.setBounds(810,180,150,20);
      f.add(t26);
      JLabel l27=new JLabel("Participant 2:");
      l27.setBounds(300,260,150,20);
      f.add(l27);
      JTextField t23=new JTextField();
      t23.setBounds(470,260,150,20);
      f.add(t23);
      JLabel l28=new JLabel("Symbol 2:");
      l28.setBounds(640,260,150,20);
      f.add(l28);
      JTextField t27=new JTextField();
      t27.setBounds(810,260,150,20);
      f.add(t27);
      JLabel l29=new JLabel( "Participant 3:");
      l29.setBounds(300,340,150,20);
      f.add(l29);
      JTextField t24=new JTextField();
      t24.setBounds(470,340,150,20);
      f.add(t24);
      JLabel l30=new JLabel( "Symbol 3:");
      l30.setBounds(640,340,150,20);
      f.add(l30);
      JTextField t28=new JTextField();
      t28.setBounds(810,340,150,20);
      f.add(t28);
      JLabel l31=new JLabel("Participant 4:");
      l31.setBounds(300,420,150,20);
      f.add(l31);
      JTextField t25=new JTextField();
      t25.setBounds(470,420,150,20);
      f.add(t25);
      JLabel l32=new JLabel("Symbol 4:");
      l32.setBounds(640,420,150,20);
      f.add(l32);
      JTextField t29=new JTextField();
      t29.setBounds(810,420,150,20);
      f.add(t29);
    //   JLabel l33=new JLabel("Limit:");
    //     l33.setBounds(300,480,50,20);
    //     f.add(l33);
    //     JTextField t30=new JTextField();
    //     t30.setBounds(370,480,120,20);
    //     f.add(t30);
    //     JLabel l34=new JLabel("To");
    //     l34.setBounds(510,480,30,20);
    //     f.add(l34);
    //     JTextField t31=new JTextField();
    //     t31.setBounds(560,480,120,20);
    //     f.add(t31);
      JButton b22=new JButton("Create");
      b22.setBackground(Color.BLACK);
        b22.setForeground(Color.WHITE);
        b22.setFont(new Font("Verdana",Font.BOLD,15));

  
   
  
    


      
      b22.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){  
              String name=t20.getText();
              String code=t21.getText();
              String participant1=t22.getText();
              String symbol1=t26.getText();
              String participant2=t23.getText();
              String symbol2=t27.getText();
              String participant3=t24.getText();
              String symbol3=t28.getText();
              String participant4=t25.getText();
              String symbol4=t29.getText();
             

              // String gender=gen;
              Connection con=null;
              try{  
              Class.forName("com.mysql.jdbc.Driver");  
              con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
              //here sonoo is database name, root is username and password  
              System.out.print("Database is connected !");
              Statement st1= con.createStatement();
              String list=code+"v";
              String sql = "CREATE TABLE "+ list+
                     "( id VARCHAR(15), " + 
                     " password VARCHAR(15))";
              st1.executeUpdate(sql);
                

              Statement st2= con.createStatement();
              String list1=code+"p";
              String sql1 = "CREATE TABLE "+ list1+
                     "( id VARCHAR(15))";
              st2.executeUpdate(sql1);
          
              Statement st= con.createStatement();
              
        
              int r = st.executeUpdate("insert into elections values('"+name+"','"+code+"','"+participant1+"','"+symbol1+"','"+participant2+"','"+symbol2+"','"+participant3+"','"+symbol3+"','"+participant4+"','"+symbol4+"','"+0+"','"+0+"','"+0+"','"+0+"','"+123+"','"+456+"','"+0+"','"+gmail+"')");
             
              JOptionPane.showMessageDialog(f,"Successfully created.");
              t20.setText("");
              t21.setText("");
              t22.setText("");
              t23.setText("");
              t24.setText("");
              t25.setText("");
              t26.setText("");
              t27.setText("");
              t28.setText("");
              t29.setText("");
              
              

             
             
              }
              catch(Exception em){ System.out.println(em);}  
                  }  
              });  
      b22.setBounds(550,520,100,20);
      f.add(b22);
      f.setSize(1200,705); 

      home.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            f.dispose();
            new Home();
        }
 });
          voting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              f.dispose(); 
                new Voting();
            }
});
          results.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              f.dispose(); 
                new Results();
            }
});
out.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    f.dispose(); 
      new Login();
  }
});
id.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    f.dispose(); 
      new voters();
  }
});
f.getContentPane().setBackground(new Color(245,247,240));
      f.add(home);
      f.add(create);
      f.add(voting);
      f.add(results);
      f.add(com);  
      f.setVisible(true);  
    }  
}


//voting page


class Voting extends variablesl{  
  
  Voting() {  
    MyJComponent com = new MyJComponent();  
   JLabel home= new JLabel("home");
   home.setForeground(Color.WHITE);
   JLabel create= new JLabel("create");
    create.setForeground(Color.WHITE);
   JLabel voting= new JLabel("voting");
   voting.setForeground(Color.WHITE);
   JLabel results= new JLabel("results");
  results.setForeground(Color.WHITE);
  JLabel id= new JLabel("id controller");
  id.setForeground(Color.WHITE);
  
    JFrame f = new JFrame(); 
    JLabel user= new JLabel(username);
    user.setForeground(Color.WHITE);
    user.setBounds(1000,10,150,50);
    JLabel out= new JLabel("logout");
    out.setForeground(Color.WHITE);
out.setBounds(1100,10,80,50);
  f.add(out);
    f.add(user);
    

    home.setBounds(10,10,50,50);
    create.setBounds(70,10,50,50);
    voting.setBounds(130,10,50,50);
    results.setBounds(200,10,50,50);
    id.setBounds(260,10,150,50);
    

    
    JTextField t32=new JTextField();
    t32.setBounds(550,100,150,20);
    f.add(t32);
    JButton b25=new JButton("Search");
    b25.setBounds(710,100,100,20);
    b25.setBackground(Color.BLACK);
    b25.setForeground(Color.WHITE);
   
    f.add(b25);
    JLabel l36=new JLabel("Code:");
    l36.setBounds(400,160,100,20);
    f.add(l36);
    JLabel t33=new JLabel();
    t33.setBounds(510,160,100,20);
    f.add(t33);
    JLabel l37=new JLabel("Members Participating:");
    l37.setBounds(400,200,150,20);
    f.add(l37);
    JLabel l1= new JLabel();
    JLabel l2= new JLabel();
    JLabel l3= new JLabel();
    JLabel l4= new JLabel();
    JLabel s1= new JLabel();
    JLabel s2= new JLabel();
    JLabel s3= new JLabel();
    JLabel s4= new JLabel();
    l1.setBounds(500,250,100,20);
    s1.setBounds(600,250,100,20);
    l2.setBounds(500,270,100,20);
    s2.setBounds(600,270,100,20);
    l3.setBounds(500,290,100,20);
    s3.setBounds(600,290,100,20);
    l4.setBounds(500,310,100,20);
    s4.setBounds(600,310,100,20);


    JLabel l38=new JLabel("Vote Your Favourite:");
    l38.setBounds(400,400,250,20);
    f.add(l38);
    JButton b26=new JButton("Vote");
    b26.setBounds(430,440,200,50);
    b26.setBackground(Color.BLACK);
    b26.setForeground(Color.WHITE);
    b26.setFont(new Font("Verdana",Font.BOLD,15));
  


    f.add(b26);
    JButton b27=new JButton("Vote");
    b27.setBounds(430,510,200,50);
    b27.setBackground(Color.BLACK);
    b27.setForeground(Color.WHITE);
    b27.setFont(new Font("Verdana",Font.BOLD,15));

    f.add(b27);

    
   
    JButton b28=new JButton("Vote");
    b28.setBounds(430,580,200,50);
    f.add(b28);
    b28.setBackground(Color.BLACK);
    b28.setForeground(Color.WHITE);
    b28.setFont(new Font("Verdana",Font.BOLD,15));


    
  
    JButton b29=new JButton("Vote");
    b29.setBounds(430,640,200,50);
    b29.setBackground(Color.BLACK);
    b29.setForeground(Color.WHITE);
    b29.setFont(new Font("Verdana",Font.BOLD,15));
    


    b25.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
          
          
          Connection con=null;
          try{  
          Class.forName("com.mysql.jdbc.Driver");  
          con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
          //here sonoo is database name, root is username and password  
          System.out.print("Database is connected !");
          
            
      
          Statement st= con.createStatement();
    
          ResultSet rs = st.executeQuery("select name,code,participant1,participant2,participant3,participant4,symbol1,symbol2,symbol3,symbol4 from elections"+" WHERE code = "+t32.getText());
          if(rs.next())
          {
            String name=rs.getString("name");
             code =rs.getString("code");
            String participant1=rs.getString("participant1");
            String participant2=rs.getString("participant2");
            String participant3=rs.getString("participant3");
            String participant4=rs.getString("participant4");
            String symbol1=rs.getString("symbol1");
            String symbol2=rs.getString("symbol2");
            String symbol3=rs.getString("symbol3");
            String symbol4=rs.getString("symbol4");
              b26.setText(symbol1);
            b27.setText(symbol2);
            b28.setText(symbol3);
            b29.setText(symbol4);
            t33.setText(code);
            l1.setText(participant1);
            l2.setText(participant2);
            l3.setText(participant3);
            l4.setText(participant4);
            s1.setText(symbol1);
            s2.setText(symbol2);s3.setText(symbol3);
            s4.setText(symbol4);
          
         

          }
          else{
            code="";
            b26.setText("vote");
            b27.setText("vote");
            b28.setText("vote");
            b29.setText("vote");
            t33.setText(code);
            l1.setText("");
            l2.setText("");
            l3.setText("");
            l4.setText("");
            s1.setText("");
            s2.setText("");s3.setText("");
            s4.setText("");
            JOptionPane.showMessageDialog(f,"code doesn't exist");

            

          }
          }
          catch(Exception em){ System.out.println(em);}  
              }  
          }); 



          b26.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                
                if(code!=""){
                  if(eligible==1){
                    Connection con=null;
                    try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
                    String vote=code+"p";
                    System.out.print("iam vote1 ");
                   Statement st= con.createStatement();
                   ResultSet rs = st.executeQuery("select vote1 from elections where code="+t33.getText());
              
                    
                    if(rs.next())
                    {
                      System.out.print("iam right");
                      rs = st.executeQuery("select * from "+vote+" where id='"+voterid+"'");
                      if(!(rs.next()))
                      {
                       
                      Statement st1= con.createStatement();
                    
                      st1.executeUpdate("UPDATE elections SET vote1=vote1+'"+1+"' where code='"+t33.getText()+"'");
                      int rs1 =st.executeUpdate("insert into "+vote+" values('"+voterid+"')");  
                      st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                      eligible=0;
                      JOptionPane.showMessageDialog(f,"thanks for voting");
                       
                      }
                      else{
                        JOptionPane.showMessageDialog(f,"you vote already");
                        Statement st1= con.createStatement();
                        st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                        eligible=0;
                      }
                    }
                   
      
      
                    }
                    catch(Exception em){ System.out.println(em);}  
                  }
                  else{
                    new ID();
                  }

                }
                else{
                  JOptionPane.showMessageDialog(f,"enter code");

                }
         
                    }  
                }); 

             
                        
                b27.addActionListener(new ActionListener(){  
                  public void actionPerformed(ActionEvent e){  
                      
                      
                 if(code!=""){
                  if(eligible==1){
                    Connection con=null;
                    try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
                    String vote=code+"p";
                    System.out.print("iam vote2 ");
                   Statement st= con.createStatement();
                   ResultSet rs = st.executeQuery("select vote2 from elections where code="+t33.getText());
              
                    
                    if(rs.next())
                    {
                      System.out.print("iam right");
                      rs = st.executeQuery("select * from "+vote+" where id='"+voterid+"'");
                      if(!(rs.next()))
                      {
                       
                      Statement st1= con.createStatement();
                    
                      st1.executeUpdate("UPDATE elections SET vote2=vote2+'"+1+"' where code='"+t33.getText()+"'");
                      int rs1 =st.executeUpdate("insert into "+vote+" values('"+voterid+"')");  
                      st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                      eligible=0;
                      JOptionPane.showMessageDialog(f,"thanks for voting");
                       
                      }
                      else{
                        JOptionPane.showMessageDialog(f,"you vote already");
                        Statement st1= con.createStatement();
                        st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                        eligible=0;
                      }
                    }
                   
      
      
                    }
                    catch(Exception em){ System.out.println(em);}  
                  }
                  else{
                    new ID();
                  }

                 }else{
                   JOptionPane.showMessageDialog(f,"enter code");
                 }
                          }  
                      }); 
                        
                      b28.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                            
                            
                        if(code!="")
                        {
                          if(eligible==1){
                            Connection con=null;
                            try{  
                            Class.forName("com.mysql.jdbc.Driver");  
                            con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
                            String vote=code+"p";
                            System.out.print("iam vote1 ");
                           Statement st= con.createStatement();
                           ResultSet rs = st.executeQuery("select vote3 from elections where code="+t33.getText());
                      
                            
                            if(rs.next())
                            {
                              System.out.print("iam right");
                              rs = st.executeQuery("select * from "+vote+" where id='"+voterid+"'");
                              if(!(rs.next()))
                              {
                               
                              Statement st1= con.createStatement();
                            
                              st1.executeUpdate("UPDATE elections SET vote3=vote3+'"+1+"' where code='"+t33.getText()+"'");
                              int rs1 =st.executeUpdate("insert into "+vote+" values('"+voterid+"')");  
                              st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                              eligible=0;
                              JOptionPane.showMessageDialog(f,"thanks for voting");
                               
                              }
                              else{
                                JOptionPane.showMessageDialog(f,"you vote already");
                                Statement st1= con.createStatement();
                                st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                                eligible=0;
                              }
                            }
                           
              
              
                            }
                            catch(Exception em){ System.out.println(em);}  
                          }
                          else{
                            new ID();
                          }
                        }
                        else{
                          JOptionPane.showMessageDialog(f,"enter code");
                        }
                                }  
                            }); 

                            b29.addActionListener(new ActionListener(){  
                              public void actionPerformed(ActionEvent e){  
                                  
                                  
                             if(code!=""){
                              if(eligible==1){
                                Connection con=null;
                                try{  
                                Class.forName("com.mysql.jdbc.Driver");  
                                con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
                                String vote=code+"p";
                                System.out.print("iam vote1 ");
                               Statement st= con.createStatement();
                               ResultSet rs = st.executeQuery("select vote4 from elections where code="+t33.getText());
                          
                                
                                if(rs.next())
                                {
                                  System.out.print("iam right");
                                  rs = st.executeQuery("select * from "+vote+" where id='"+voterid+"'");
                                  if(!(rs.next()))
                                  {
                                   
                                  Statement st1= con.createStatement();
                                
                                  st1.executeUpdate("UPDATE elections SET vote4=vote4+'"+1+"' where code='"+t33.getText()+"'");
                                  int rs1 =st.executeUpdate("insert into "+vote+" values('"+voterid+"')");  
                                  st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                                  eligible=0;
                                  JOptionPane.showMessageDialog(f,"thanks for voting");
                                   
                                  }
                                  else{
                                    JOptionPane.showMessageDialog(f,"you vote already");
                                    Statement st1= con.createStatement();
                                    st1.executeUpdate("UPDATE elections SET eligible='"+0+"' where code='"+code+"'");
                                    eligible=0;
                                  }
                                }
                               
                  
                  
                                }
                                catch(Exception em){ System.out.println(em);}  
                              }
                              else{
                                new ID();
                              }

                             }
                             else{
                               JOptionPane.showMessageDialog(f,"enter code");
                             }
                                      }  
                                  }); 
          

                          
                         

                  








    create.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               f.dispose();
                new Create();
            }
     });
    id.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
         f.dispose();
          new voters();
      }
});
     home.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          f.dispose();
          new Home();
      }
});
      results.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            f.dispose();
            new Results();
        }
});
out.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
     f.dispose();
      new Login();
  }
});
f.getContentPane().setBackground(new Color(245,247,240));
    f.add(s1);
    f.add(s2);
    f.add(s3);
    f.add(s4);
    f.add(l1);
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(b29);
    f.add(home);
    f.add(create);
    f.add(voting);
    f.add(results);
    f.add(id);
    f.add(com);  
    f.setSize(1200,800);  
    f.setVisible(true);  
  }  
}



//people adding page
//id generator for particular page

 class ID extends variablesl
{
    JFrame f=new JFrame();
    ID()
    {
      JLabel l50=new JLabel("IDC:");
      l50.setBounds(450,250,100,20);
      f.add(l50);
      JTextField t50=new JTextField();
      t50.setBounds(570,250,100,20);
      f.add(t50);
      JLabel l51=new JLabel("Password:");
      l51.setBounds(450,300,100,20);
      f.add(l51);
      JTextField t51=new JTextField();
      t51.setBounds(570,300,100,20);
      f.add(t51);
      JButton b50=new JButton("Register");
      b50.setBounds(500,350,100,20);
      b50.setBackground(Color.BLACK);
      b50.setForeground(Color.WHITE);
      
      f.add(b50);
        b50.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Connection con=null;
                try{  
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
                PreparedStatement pst = con.prepareStatement("Select * from elections where code='"+code+"'");
                 ResultSet rs = pst.executeQuery();
                boolean x=rs.next();
               if(code!=" "){
                if (x) {
                  System.out.println("hi iam noobie");
                 String vote=code+"v";
                  Statement st= con.createStatement();
                   ResultSet rs1 = st.executeQuery("select * from "+ vote+" where id='"+t50.getText()+"'");
                   if(rs1.next())
                   {
                     System.out.println("iam registered");
                     
                      Statement st1= con.createStatement();
                      voterid=rs1.getString("id");
                      st1.executeUpdate("UPDATE elections SET eligible='"+1+"' where code='"+code+"'");
                      eligible=1;
                      f.dispose();
                   }
              //    int rs1 =st.executeUpdate("insert into "+voting+" values('"+t50.getText()+"','"+t51.getText()+"')");
              } 
              else {
                JOptionPane.showMessageDialog(f,"id and password don't match");
              }
               }
               else{
                JOptionPane.showMessageDialog(f,"enter valid code");
               }
               }
                catch(Exception em){ System.out.println(em);} 
               
    
                    }  
                });  
    
                f.getContentPane().setBackground(new Color(245,247,240));
                f.setSize(1200,705); 
        f.setLayout(null);
        f.setVisible(true);
    }
  
}


//voters registry page

class voters extends variablesl{  
  voters() {  
   JFrame frame = new JFrame();  
        MyJComponent com = new MyJComponent();  
        JLabel home= new JLabel("home");
        home.setForeground(Color.WHITE);
 
        JLabel create= new JLabel("create");
         create.setForeground(Color.WHITE);
        
 
        JLabel voting= new JLabel("voting");
        voting.setForeground(Color.WHITE);
 
        JLabel results= new JLabel("results");
       results.setForeground(Color.WHITE);
       JLabel id= new JLabel("id controller");
       id.setForeground(Color.WHITE);
       id.setBounds(260,10,150,50);
       JLabel user= new JLabel(username);
       user.setForeground(Color.WHITE);
       user.setBounds(1000,10,150,50);
       JLabel out= new JLabel("logout");
       out.setForeground(Color.WHITE);
   out.setBounds(1100,10,80,50);
       frame.add(out);
       frame.add(user);
 
       JLabel l49=new JLabel("code:");
       l49.setBounds(450,250,100,20);
       frame.add(l49);
       JTextField t49=new JTextField();
       t49.setBounds(570,250,100,20);
       frame.add(t49);
       JLabel l50=new JLabel("IDC:");
       l50.setBounds(450,300,100,20);
       frame.add(l50);
       JTextField t50=new JTextField();
       t50.setBounds(570,300,100,20);
       frame.add(t50);
       JLabel l51=new JLabel("Password:");
       l51.setBounds(450,350,100,20);
       frame.add(l51);
       JTextField t51=new JTextField();
       t51.setBounds(570,350,100,20);
       frame.add(t51);
       JButton b50=new JButton("Register");
       b50.setBounds(500,400,100,20);
       b50.setBackground(Color.BLACK);
       b50.setForeground(Color.WHITE);

       frame.add(b50);
     
      b50.addActionListener(new ActionListener(){  
       public void actionPerformed(ActionEvent e){  
           Connection con=null;
           try{  
           Class.forName("com.mysql.jdbc.Driver");  
           con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
           PreparedStatement pst = con.prepareStatement("Select * from elections where code="+t49.getText());
            ResultSet rs = pst.executeQuery();
           boolean x=rs.next();
          
           if (x) {
             System.out.println("hi iam noobie");
            String vote=t49.getText()+"v";
             Statement st= con.createStatement();
             System.out.println(gmail);
             PreparedStatement pst1 = con.prepareStatement("Select * from elections where email=? and code=? ");
              pst1.setString(1, gmail);
              pst1.setString(2,t49.getText());
              
              ResultSet rs12 = pst1.executeQuery();
             
              boolean x1 = rs12.next(); 
              System.out.println(x1);
              
             if(x1){
             int rs1 =st.executeUpdate("insert into "+vote+" values('"+t50.getText()+"','"+t51.getText()+"')");
             }
             else{
              JOptionPane.showMessageDialog(frame,"you are unauthorised");
             }
          
          }
          else{
            JOptionPane.showMessageDialog(frame,"no such type of election exist");
          }
          }
           catch(Exception em){ System.out.println(em);} 
          

               }  
           });  

     

        home.setBounds(10,10,50,50);
        create.setBounds(70,10,50,50);
        voting.setBounds(130,10,50,50);
        results.setBounds(200,10,50,50);
       
       
        frame.setSize(1200,705);  


        create.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               frame.dispose();
               new Create();
           }
    });
    home.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          frame.dispose();
          new Home();
      }
});
out.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
      frame.dispose();
      new Login();
  }
});
         voting.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               frame.dispose();
               new Voting();
           }
     });
     results.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
           frame.dispose();
           new Results();
       }
 });
 frame.getContentPane().setBackground(new Color(245,247,240));
        frame.add(home);
        frame.add(create);
        frame.add(voting);
        frame.add(results);
        frame.add(id);
        frame.add(com);  
        frame.setVisible(true);  
      }  
      
}

//results page

class Results extends variablesl{  
  Results() { 
    JFrame f = new JFrame();   
     MyJComponent com = new MyJComponent();  
     JLabel home= new JLabel("home");
     home.setForeground(Color.WHITE);
     JLabel create= new JLabel("create");
      create.setForeground(Color.WHITE);
     JLabel voting= new JLabel("voting");
     voting.setForeground(Color.WHITE);
     JLabel results= new JLabel("results");
    results.setForeground(Color.WHITE);
    JLabel id= new JLabel("id controller");
     id.setForeground(Color.WHITE);
     
       
     JLabel user= new JLabel(username);
       user.setForeground(Color.WHITE);
       user.setBounds(1000,10,150,50);
       JLabel out= new JLabel("logout");
       out.setForeground(Color.WHITE);
   out.setBounds(1100,10,80,50);
       f.add(out);
       f.add(user);
 
           JTextField t32=new JTextField();
     t32.setBounds(550,100,150,20);
     f.add(t32);
     JButton b25=new JButton("Search");
     b25.setBounds(710,100,100,20);
     b25.setBackground(Color.BLACK);
     b25.setForeground(Color.WHITE);
    
     f.add(b25);
     JLabel l36=new JLabel("Code:");
     l36.setBounds(450,160,100,20);
     f.add(l36);
     JLabel t33=new JLabel();
     t33.setBounds(570,160,100,20);
     f.add(t33);
     JLabel l37=new JLabel("Members Participating:");
     l37.setBounds(450,200,150,20);
     f.add(l37);
 
     JLabel winner=new JLabel();
     winner.setBounds(550,330,1000,20);
     f.add(winner);
     //height incresae and color
     JLabel l1= new JLabel();
     JLabel l2= new JLabel();
     JLabel l3= new JLabel();
     JLabel l4= new JLabel();
     JLabel s1= new JLabel();
     JLabel s2= new JLabel();
     JLabel s3= new JLabel();
     JLabel s4= new JLabel();
     l1.setBounds(500,250,100,20);
     s1.setBounds(600,250,100,20);
     l2.setBounds(500,270,100,20);
     s2.setBounds(600,270,100,20);
     l3.setBounds(500,290,100,20);
     s3.setBounds(600,290,100,20);
     l4.setBounds(500,310,100,20);
     s4.setBounds(600,310,100,20);
     JLabel v1= new JLabel();
     JLabel v2= new JLabel();
     JLabel v3= new JLabel();
     JLabel v4= new JLabel();
     v1.setBounds(700,250,100,20);
     v2.setBounds(700,270,100,20);
     v3.setBounds(700,290,100,20);
     v4.setBounds(700,310,100,20);
        b25.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
          
          
           
        Connection con=null;
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","");  
        //here sonoo is database name, root is username and password  
        System.out.print("Database is connected !");
        
          
    
        Statement st= con.createStatement();
  
        ResultSet rs = st.executeQuery("select * from elections"+" WHERE code = "+t32.getText());
        if(rs.next())
        {
          String name=rs.getString("name");
          String code =rs.getString("code");
          String participant1=rs.getString("participant1");
          String participant2=rs.getString("participant2");
          String participant3=rs.getString("participant3");
          String participant4=rs.getString("participant4");
          String symbol1=rs.getString("symbol1");
          String symbol2=rs.getString("symbol2");
          String symbol3=rs.getString("symbol3");
          String symbol4=rs.getString("symbol4");
         int vote1=rs.getInt("vote1");
        int vote2=rs.getInt("vote2");
         int vote3=rs.getInt("vote3");
          int  vote4=rs.getInt("vote4");
          
          t33.setText(code);
          l1.setText(participant1);
          l2.setText(participant2);
          l3.setText(participant3);
          l4.setText(participant4);
          s1.setText(symbol1);
          s2.setText(symbol2);
          s3.setText(symbol3);
          s4.setText(symbol4);
          v1.setText(String.valueOf(vote1));
          v2.setText(String.valueOf(vote2));
          v3.setText(String.valueOf(vote3));
          v4.setText(String.valueOf(vote4));
          if(vote1>vote2 && vote1>vote3 &&vote1>vote4){
              winner.setText(participant1+"won the election");
          }
          else if(vote2>vote3 && vote2>vote4){
              winner.setText(participant2+"won the election");
          }
          else if(vote3>vote4){
             winner.setText(participant3+"won the election");
          }
          else{
             winner.setText(participant4+"won the election");
          }
         System.out.println(vote1+vote2);
        
       

        }

        }
        catch(Exception em){ System.out.println(em);}  
            }  
        });
        create.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
             f.dispose();
              new Create();
          }
   });
   home.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        f.dispose();
        new Home();
    }
});
   voting.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseClicked(MouseEvent e) {
         f.dispose();
         new Voting();
     }
});
id.addMouseListener(new MouseAdapter() {
 @Override
 public void mouseClicked(MouseEvent e) {
     f.dispose();
     new voters();
 }
});
out.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
 f.dispose();
 new Login();
}
});

     home.setBounds(10,10,50,50);
     create.setBounds(70,10,50,50);
     voting.setBounds(130,10,50,50);
     results.setBounds(200,10,50,50);
     id.setBounds(260,10,150,50);
     f.setSize(1200,705); 
     f.getContentPane().setBackground(new Color(245,247,240));
    f.add(s1);
    f.add(s2);
    f.add(s3);
    f.add(s4);
    f.add(l1);
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(v1);
    f.add(v2);
    f.add(v3);
    f.add(v4);
     f.add(home);
     f.add(id);
     f.add(create);
     f.add(voting);
     f.add(results);
     f.add(com);  
     f.setVisible(true);  
   }  
 
}  

//navbar color page

//////////////////////////////
class MyJComponent extends JComponent {  
    public void paint(Graphics g) {  
      g.setColor(Color.BLACK);  
      g.fillRect(0, 0, 2000, 50);  
    }  
}  
class jcomponent2{  
   jcomponent2() {  
      MyJComponent com = new MyJComponent();  
     JLabel home= new JLabel("home");
     home.setForeground(Color.WHITE);
     JLabel create= new JLabel("create");
      create.setForeground(Color.WHITE);
     JLabel voting= new JLabel("voting");
     voting.setForeground(Color.WHITE);
     JLabel results= new JLabel("results");
    results.setForeground(Color.WHITE);
      JFrame frame = new JFrame("JComponent Example");  
      home.setBounds(10,10,50,50);
      create.setBounds(70,10,50,50);
      voting.setBounds(130,10,50,50);
      results.setBounds(200,10,50,50);
      frame.setSize(300,200);  
    
      frame.add(home);
      frame.add(create);
      frame.add(voting);
      frame.add(results);
      frame.add(com);  
      frame.setVisible(true);  
    }  
}