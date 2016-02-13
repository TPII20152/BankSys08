package banksys.atm;

import banksys.gui.ViewController;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import banksys.gui.View;

public class ATM24H {


  // using the graphic user interface "GUI"......
  public static View v = new View();
  public static ViewController vc = new ViewController(v);



  public static void main(String[] args) {

  UIManager.put("OptionPane.messageFont", new FontUIResource(v.mainFont));
  UIManager.put("OptionPane.buttonFont", new FontUIResource(v.mainFont));
  UIManager.put("OptionPane.background", Color.white);
  UIManager.put("Panel.background", Color.white);
    vc.control();
  }
}