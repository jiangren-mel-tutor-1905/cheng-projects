package fp.topic5.tacho;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * Tachometer Java Bean
 * 
 * @author Caspar Ryan, 2002
 * @version 1.0
 */

public class TachoBean extends JComponent
{
   private RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);

   // properties
   private int maxRPM;
   private int majorRPMIncrement;
   private int minorRPMIncrement;
   private int needleRadius;
   private int gaugeRadius;
   private int needleSweepDegrees;
   private int rpmValue;
   private int needleBasetrailPixels;
   private int needleTipPixels;
   private int needleThicknessPixels;
   private int minorGraduationValue;
   private int gaugeBodyThicknessPixels;
   private int majorGraduationValue;
   private int redline;

   // internal attributes
   private int originX;
   private int originY;
   private GeneralPath needlePolygon;
   private AffineTransform orgSwingJPanelTransform;
   // private Image offScreenBuffer;
   private int gaugeDegrees;
   private TexturePaint backgroundPainter = createTiledImagePainter("images/Marble.jpg");
   private GradientPaint gradientPainter = new GradientPaint(0, 0, Color.black, 255, 255, Color.gray, true);

   public TachoBean()
   {
      this(8000, 1000, 500, 100, 110, 270, 360, 10, 10, 6, 16, 500, 1000, 6500);
   }

   public TachoBean(int maxRPM, int majorRPMIncrement, int minorRPMIncrement, int needleRadius, int gaugeRadius,
      int needleSweepDegrees, int gaugeDegrees, int needleBasetrailPixels, int needleTipPixels,
      int needleThicknessPixels, int gaugeBodyThicknessPixels, int minorGraduationValue, int majorGraduationValue,
      int redline)
   {
      // setDoubleBuffered(false);
      setMaxRPM(maxRPM);
      setMajorRPMIncrement(majorRPMIncrement);
      setMinorRPMIncrement(minorRPMIncrement);
      setNeedleRadius(needleRadius);
      setGaugeRadius(gaugeRadius);
      setNeedleSweepDegrees(needleSweepDegrees);
      setGaugeDegrees(gaugeDegrees);
      setNeedleBasetrailPixels(needleBasetrailPixels);
      setNeedleTipPixels(needleTipPixels);
      setNeedleThicknessPixels(needleThicknessPixels);
      setMinorGraduationValue(minorGraduationValue);
      setGaugeBodyThicknessPixels(gaugeBodyThicknessPixels);
      setMajorGraduationValue(majorGraduationValue);
      setRedline(redline);

      originX = originY = getGaugeRadius() + getGaugeBodyThicknessPixels();
      renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      needlePolygon = getNeedlePolygon2D(originX, originX);
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(getGaugeRadius() * 2, getGaugeRadius() * 2);
   }

   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);

      // set basic graphics properties
      Graphics2D g2D = (Graphics2D) g;
      // store original transform for reset on exit
      orgSwingJPanelTransform = g2D.getTransform();
      Paint orgPaintColor = g2D.getPaint();
      g2D.setRenderingHints(renderHints);
      g2D.setStroke(new BasicStroke(2.0f));

      // helper methods to draw needle
      // Erase the previous image
      g2D.setColor(getBackground());
      g2D.fillRect(0, 0, getWidth(), getHeight());
      // draw gauge outline
      g2D.setColor(Color.black);
      drawGaugeFace(g2D);
      drawNewNeedle(g2D);

      // reset context
      g2D.setPaint(orgPaintColor);
      g2D.setTransform(orgSwingJPanelTransform);
   }

   public void needleSweep(final int minRPM, final int maxRPM)
   {
      // run in separate thread so that UI does not block
      new Thread()
      {
         @Override
         public void run()
         {
            for (int i = minRPM; i < getMaxRPM(); i += 10)
            {
               setRpmValue(i);
               try
               {
                  Thread.sleep(1);
               }
               catch (Exception e)
               {
               }
               SwingUtilities.invokeLater(new Runnable()
               {
                  @Override
                  public void run()
                  {
                     repaint();
                  }
               });
            }
         }
      }.start();
   }

   private GeneralPath getNeedlePolygon2D(int x, int y)
   {
      // lineTo points for needle polygon
      int xPoints[] = { x + getNeedleBasetrailPixels(), x - (getNeedleRadius() - getNeedleTipPixels()), x
         - getNeedleRadius(), x - (getNeedleRadius() - getNeedleTipPixels()), x + getNeedleBasetrailPixels() };
      int yPoints[] = { y + (getNeedleThicknessPixels() / 2), y + (getNeedleThicknessPixels() / 2), y, y
         - (getNeedleThicknessPixels() / 2), y - (getNeedleThicknessPixels() / 2) };

      GeneralPath needlePoly = new GeneralPath(); // GeneralPath.WIND_EVEN_ODD,
      // xPoints.length);

      needlePoly.moveTo(xPoints[0], yPoints[0]);
      for (int i = 1; i < xPoints.length; i++)
         needlePoly.lineTo(xPoints[i], yPoints[i]);
      needlePoly.closePath();

      return needlePoly;
   }

   public void drawGaugeFace(Graphics2D g2D)
   {
      double x1, y1, x2, y2;
      x1 = y1 = getGaugeBodyThicknessPixels() / 2;
      x2 = y2 = getGaugeRadius() * 2 + getGaugeBodyThicknessPixels();

      g2D.setPaint(gradientPainter);
      // g2D.setPaint(Color.black);
      g2D.setStroke(new BasicStroke((float) getGaugeBodyThicknessPixels()));
      Arc2D.Double gaugeFace = new Arc2D.Double(x1, y1, x2, y2, 0.0, (double) getGaugeDegrees(), Arc2D.Double.OPEN);
      g2D.draw(gaugeFace);

      // g2D.setPaint(Color.white);
      g2D.setPaint(backgroundPainter);
      g2D.fill(gaugeFace);
      g2D.setStroke(new BasicStroke(2.0f));
      drawGaugeGraduations(g2D);
   }

   public void drawGaugeGraduations(Graphics2D g2D)
   {
      double theta;

      int xOuter, xInner, yOuter, yInner;
      double r = getGaugeRadius() + (getGaugeBodyThicknessPixels() / 2);

      if (getMajorGraduationValue() != -1)
      {
         for (int i = 0; i <= getMaxRPM(); i += getMajorGraduationValue())
         {
            theta = (double) i / getMaxRPM() * (getNeedleSweepDegrees() / 180.0 * Math.PI);
            xOuter = (int) Math.round((double) originX - (r * Math.cos(theta)));
            yOuter = (int) Math.round((double) originY - (r * Math.sin(theta)));

            xInner = (int) Math.round((double) originX - (0.90 * r * Math.cos(theta)));
            yInner = (int) Math.round((double) originY - (0.90 * r * Math.sin(theta)));

            if (i >= getRedline())
               g2D.setColor(Color.red);
            else
               g2D.setColor(Color.black);
            g2D.drawLine(xOuter, yOuter, xInner, yInner);
         }
      }

      r -= 10;
      if (getMinorGraduationValue() != -1)
      {
         for (int i = 0; i <= getMaxRPM(); i += getMinorGraduationValue())
         {
            // don't overlap minor graduations
            if ((i % getMajorGraduationValue()) != 0)
            {
               theta = (double) i / getMaxRPM() * (getNeedleSweepDegrees() / 180.0 * Math.PI);
               xOuter = (int) Math.round((double) originX - (r * Math.cos(theta)));
               yOuter = (int) Math.round((double) originY - (r * Math.sin(theta)));

               xInner = (int) Math.round((double) originX - (0.95 * r * Math.cos(theta)));
               yInner = (int) Math.round((double) originY - (0.95 * r * Math.sin(theta)));

               if (i >= getRedline())
                  g2D.setColor(Color.red);
               else
                  g2D.setColor(Color.black);
               g2D.drawLine(xOuter, yOuter, xInner, yInner);
            }
         }
      }
   }

   private void drawNewNeedle(Graphics2D g2D)
   {
      // calculate transformation for correct needle position
      double theta = (double) rpmValue / (double) getMaxRPM() * ((double) getNeedleSweepDegrees() / 180.0 * Math.PI);
      g2D.rotate(theta, originX, originY);

      // draw needle and fill interior
      g2D.setPaint(Color.black);
      g2D.draw(needlePolygon);
      g2D.setPaint(Color.red);
      g2D.fill(needlePolygon);

      g2D.setPaint(Color.black);
      g2D.setTransform(orgSwingJPanelTransform);
      // draw needle 'pin'
      g2D.drawLine(originX, originY, originX, originY);
   }

   public void setGaugeDegrees(int gaugeDegrees)
   {
      this.gaugeDegrees = gaugeDegrees;
   }

   public int getGaugeDegrees()
   {
      return gaugeDegrees;
   }

   private TexturePaint createTiledImagePainter(String imageFile)
   {
      Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
      // synchronous image load
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try
      {
         tracker.waitForAll();
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }

      int imageHeight = image.getHeight(this);
      int imageWidth = image.getWidth(this);

      BufferedImage bufferedImage = new BufferedImage(imageHeight, imageHeight, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2d = bufferedImage.createGraphics();
      g2d.drawImage(image, 0, 0, this);

      return new TexturePaint(bufferedImage, new Rectangle(0, 0, imageWidth, imageHeight));
   }

   public int getMaxRPM()
   {
      return maxRPM;
   }

   public void setMaxRPM(int maxRPM)
   {
      this.maxRPM = maxRPM;
   }

   public void setMajorRPMIncrement(int majorRPMIncrement)
   {
      this.majorRPMIncrement = majorRPMIncrement;
   }

   public int getMajorRPMIncrement()
   {
      return majorRPMIncrement;
   }

   public void setMinorRPMIncrement(int minorRPMIncrement)
   {
      this.minorRPMIncrement = minorRPMIncrement;
   }

   public int getMinorRPMIncrement()
   {
      return minorRPMIncrement;
   }

   public void setNeedleRadius(int needleRadius)
   {
      this.needleRadius = needleRadius;
   }

   public int getNeedleRadius()
   {
      return needleRadius;
   }

   public void setNeedleSweepDegrees(int needleSweepDegrees)
   {
      this.needleSweepDegrees = needleSweepDegrees;
   }

   public int getNeedleSweepDegrees()
   {
      return needleSweepDegrees;
   }

   public void setRpmValue(int rpmValue)
   {
      this.rpmValue = rpmValue;
   }

   public int getRpmValue()
   {
      return rpmValue;
   }

   public void setGaugeRadius(int gaugeRadius)
   {
      this.gaugeRadius = gaugeRadius;
   }

   public int getGaugeRadius()
   {
      return gaugeRadius;
   }

   public void setNeedleBasetrailPixels(int needleBasetrailPixels)
   {
      this.needleBasetrailPixels = needleBasetrailPixels;
   }

   public int getNeedleBasetrailPixels()
   {
      return needleBasetrailPixels;
   }

   public void setNeedleTipPixels(int needleTipPixels)
   {
      this.needleTipPixels = needleTipPixels;
   }

   public int getNeedleTipPixels()
   {
      return needleTipPixels;
   }

   public void setNeedleThicknessPixels(int needleThicknessPixels)
   {
      this.needleThicknessPixels = needleThicknessPixels;
   }

   public int getNeedleThicknessPixels()
   {
      return needleThicknessPixels;
   }

   public void setGaugeBodyThicknessPixels(int gaugeBodyThicknessPixels)
   {
      this.gaugeBodyThicknessPixels = gaugeBodyThicknessPixels;
   }

   public int getGaugeBodyThicknessPixels()
   {
      return gaugeBodyThicknessPixels;
   }

   public void setMinorGraduationValue(int minorGraduationValue)
   {
      this.minorGraduationValue = minorGraduationValue;
   }

   public int getMinorGraduationValue()
   {
      return minorGraduationValue;
   }

   public void setMajorGraduationValue(int majorGraduationValue)
   {
      this.majorGraduationValue = majorGraduationValue;
   }

   public int getMajorGraduationValue()
   {
      return majorGraduationValue;
   }

   public void setRedline(int redline)
   {
      this.redline = redline;
   }

   public int getRedline()
   {
      return redline;
   }
}