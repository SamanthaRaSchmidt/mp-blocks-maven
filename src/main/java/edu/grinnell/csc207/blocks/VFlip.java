package edu.grinnell.csc207.blocks;

/**
 * A vertically flipped ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Sam Schmidt
 * @author Koast Tsymbal
 */
public class VFlip implements AsciiBlock {
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
  public VFlip(AsciiBlock original) {
    this.block = original;
  } // VFlip(AsciiBlock)

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
    if (i < 0 || i >= height()) {
      throw new Exception("Row at index " + i + " is out of the valid range");
    } // end of if
    return block.row(height() - 1 - i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return block.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return block.width();
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return (other instanceof VFlip) && (this.eqv((VFlip) other));
  } // eqv(AsciiBlock)

  /**
   * Determine if another Flipped block is structually equivalent to this block.
   *
   * @param other The block to compare this block
   * @return true if the two flipped blocks are structurally equivalent
   */
  public boolean eqv(VFlip other) {
    return this.block.eqv(other.block);
  } // eqv(VFlip)
} // class VFlip
