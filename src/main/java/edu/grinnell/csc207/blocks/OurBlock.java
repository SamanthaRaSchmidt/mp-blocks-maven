package edu.grinnell.csc207.blocks;

/**
 * A grid of a single text block.
 *
 * @author Kostiantyn Tsymbal
 * @author Sam Schmidt
 */
public class OurBlock implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** One element of the grid. */
  AsciiBlock element;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+


  public OurBlock(AsciiBlock element) {
    this.element = element;
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
    return "0";
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 0;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
   return 0;
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
   * Determine if another ?? is structurally equivalent to this grid.
   *
   * @param other The grid to compare to this ??.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(OurBlock other) {
    return false;
  } // eqv(Grid)
} // class Grid
