package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Pyramid;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VFlip;

import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Sam Schmidt
 * @author Koast Tsymbal
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock block1 = new Pyramid(" Woah ", 6);
    AsciiBlock art = new Surrounded((new Surrounded(block1, '*')), '*');
    AsciiBlock artP2 = new VFlip(art);

    AsciiBlock.print(pen, art);
    AsciiBlock.print(pen, artP2);

    pen.close();
  } // main(String[])
} // class Art80x24
