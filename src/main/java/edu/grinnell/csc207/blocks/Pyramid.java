package edu.grinnell.csc207.blocks;

/**
 * Explanation.
 *
 * @author Kostiantyn Tsymbal
 * @author Sam Schmidt
 */
public class Pyramid implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** One element of the pyramid. */
 String element;

  /** The number of rows the pyramid will have */
  int numRows;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
 
  /**
   * Builds a pyramid with the specified number of rows using element.
   * @param element
   *  An AsciiBlock
   * @param numRows
   */
  public Pyramid(String element, int numRows) {
    this.element = element;
    this.numRows = numRows;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    int spaces = (width() - this.element.length()) / 2;
    String output = this.element.repeat(i);
    return " ".repeat(spaces) + output + " ".repeat(spaces);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    if (element.equals("")) {
      return 0;
    }
    return numRows;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int longest = this.element.length();
    if (numRows == 1) {
      return longest;
    } // end for
    for (int i = 1; i < numRows; i++) {
      longest += 2 * this.element.length();
    } // end for
   return longest;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return false;
  } // eqv(AsciiBlock)

  /**
   * Determine if another pyramid is structurally equivalent to this grid.
   *
   * @param other The grid to compare to this pyramid.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(Pyramid other) {
    return false;
  } // eqv(Pyramid)
} // class Pyramid
