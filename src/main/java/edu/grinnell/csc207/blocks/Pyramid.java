package edu.grinnell.csc207.blocks;

/**
 * Builds a pyramid of a given String.
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

  /** The number of rows the pyramid will have. */
  int numRows;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds a pyramid with the specified number of rows using element.
   *
   * @param elements An AsciiBlock
   * @param rows the number of rows the pyramid should end up with
   */
  public Pyramid(String elements, int rows) {
    this.element = elements;
    this.numRows = rows;
  } // Pyramid(String, int)

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
    String output = this.element.repeat(i) + this.element + this.element.repeat(i);
    int spaces = (width() - output.length()) / 2;
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
    } // endif
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
    return (other instanceof Pyramid) && (this.eqv((Pyramid) other));
  } // eqv(AsciiBlock)

  /**
   * Determine if another pyramid is structurally equivalent to this grid.
   *
   * @param other The grid to compare to this pyramid.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(Pyramid other) {
    return this.height() == other.height()
        && this.width() == other.width()
        && this.element.equals(other.element);
  } // eqv(Pyramid)
} // class Pyramid
