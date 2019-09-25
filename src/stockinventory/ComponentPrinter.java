/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockinventory;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ComponentPrinter implements Printable {
   

        private  JPanel jp;
        private boolean fill;

        public ComponentPrinter(JPanel jp1, boolean fill) {
            this.jp = jp;
            this.fill = fill;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) throws PrinterException {

            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) g;
            g2.translate(format.getImageableX(), format.getImageableY());

            double width = (int) Math.floor(format.getImageableWidth());
            double height = (int) Math.floor(format.getImageableHeight());

            if (!fill) {

                width = Math.min(width, jp.getPreferredSize().width);
                height = Math.min(height, jp.getPreferredSize().height);

            }

            jp.setBounds(0, 0, (int) Math.floor(width), (int) Math.floor(height));
            if (jp.getParent() == null) {
                jp.addNotify();
            }
            jp.validate();
            jp.doLayout();
            jp.printAll(g2);
            if (jp.getParent() != null) {
                jp.removeNotify();
            }

            return Printable.PAGE_EXISTS;
        }

    /**
     *
     * @param grphcs
     * @param pf
     * @param i
     * @return
     * @throws PrinterException
     */
   
    

    }



