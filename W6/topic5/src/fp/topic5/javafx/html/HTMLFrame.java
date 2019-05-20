package fp.topic5.javafx.html;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

// JavaFX WebView embedded in JSwing Frame example by Caspar
// See https://openjfx.io/openjfx-docs/ for configuration
// and note the VM args on the HTMLFrame run configuration ..

public class HTMLFrame extends JFrame
{
   private static final String WEB_URL = "https://www.rmit.edu.au";

   public HTMLFrame() throws Exception
   {
      super("Test HTML render");
      setBounds(100, 100, 800, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLayout(new BorderLayout());
      // a JComponent that can host JavaFX content
      final JFXPanel jfxPanel = new JFXPanel();

      // JavaFX components need to be managed by JavaFX
      Platform.runLater(new Runnable()
      {
         @Override
         public void run()
         {
            // JavaFX component to render HTML
            WebView webView = new WebView();
            // we can load it directly from a URL
            webView.getEngine().load(WEB_URL);

            jfxPanel.setScene(new Scene(webView));
         }
      });

      add(jfxPanel, BorderLayout.CENTER);
      setVisible(true);
   }

   public static void main(String[] args) throws Exception
   {
      new HTMLFrame();
   }
}