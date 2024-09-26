package edu.grinnell.csc207.blocks;

/**
 * A horizontally flipped ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class HFlip implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** The original block. */
  AsciiBlock block;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original The original block.
   */
  public HFlip(AsciiBlock original) {
    this.block = original;
  } // HFlip(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Reverses a string.
   *
   * @param str string
   * @return reversed String
   */
  public static String reverseString(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    if (i < 0 || i >= block.height()) {
      throw new Exception("Row at index " + i + " is out of the valid range");
    }
    int maxLength = this.width();
    int wordLength = block.row(i).length();
    if (maxLength > wordLength) {
      return " ".repeat(maxLength - wordLength) + reverseString(block.row(i));
    } else {
      return reverseString(block.row(i));
    } // end of if
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.block.width();
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof HFlip) && (this.eqv((HFlip) other)));
  } // eqv(AsciiBlock)

  /**
   * Determine if another HFlip is structurally equivalent to this HFlip.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(HFlip other) {
    return this.block.eqv(other.block);
  } // eqv(HFlip)
} // class HFlip
