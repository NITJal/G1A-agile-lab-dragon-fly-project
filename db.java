import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class db implements myvariables {

String user=jTextField1.getText();

Connection myconnection=null;
//run when game ends
try
{
Class.forName("com.mysql.jdbc.Driver");
myconnection=DriverManager.getConnection(path+place,username,password);

    try
    {
    	int score=successfuljumps;
    	String q="update scorer set name=?,scored=?";
        PreparedStatement mystatement=myconnection.prepareStatement(q);

        mystatement.setString(1,user);
        mystatement.setString(2,""+score);

        mystatement.executeUpdate();
        
        String q2="Select * from scorer order by scored desc limit 10 ";
        
        PreparedStatement mystatement2=(PreparedStatement)myconnection.prepareStatement(q2);
        DefaultTableModel mymodel;
        ResultSet myresult = mystatement2.executeQuery();
        if(myresult.next())
        {
             mymodel=(DefaultTableModel) jTable1.getModel();
            do{
                String name,scored;
             
                name=myresult.getString("name");
               scored=myresult.getString("scored");                   
               mymodel.addRow(new Object[]{name,score});
                
            }
            while(myresult.next());
       }
        
    }

    catch(Exception e)
    {

        JOptionPane.showMessageDialog(rootPane, "error in query"+e.getMessage());
    }
    finally
    {
        myconnection.close();

    }
}
catch(Exception e)
{

    JOptionPane.showMessageDialog(rootPane,"error in connection"+e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
}         // TODO add your handling code here: