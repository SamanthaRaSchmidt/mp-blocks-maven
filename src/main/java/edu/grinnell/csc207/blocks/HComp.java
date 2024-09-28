package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The horizontal composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Sam Schmidt
 * @author Koast Tsymbal
 */
public class HComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** The blocks. */
  AsciiBlock[] blocks;

  /** How the blocks are aligned. */
  VAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a horizontal composition of two blocks.
   *
   * @param alignment The way in which the blocks should be aligned.
   * @param leftBlock The block on the left.
   * @param rightBlock The block on the right.
   */
  public HComp(VAlignment alignment, AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {leftBlock, rightBlock};
  } // HComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a horizontal composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public HComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // HComp(Alignment, AsciiBLOCK[])

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    int maxHeight = this.height();
    if (i < 0 || i >= maxHeight) {
      throw new Exception("Row at index " + i + " is out of the valid range");
    } // end of if
    StringBuilder output = new StringBuilder();
    for (AsciiBlock block : blocks) {
      int space = maxHeight - block.height();
      if (align == VAlignment.TOP) {
        if (i > block.height() - 1) {
          output.append(" ".repeat(block.width()));
        } else {
          output.append(block.row(i));
        } // end of if
      } else if (align == VAlignment.BOTTOM) {
        if (i < space) {
          output.append(" ".repeat(block.width()));
        } else {
          output.append(block.row(i - space));
        } // end of if
      } else {
        int offsett = space / 2;
        if (i < offsett || i >= block.height() + offsett) {
          output.append(" ".repeat(block.width()));
        } else {
          output.append(block.row(i - offsett));
        } // end of if
      } // end of if
    } // end of loop
    return output.toString();
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int heighest = blocks[0].height();
    for (AsciiBlock block : blocks) {
      if (heighest < block.height()) {
        heighest = block.height();
      } // end of if
    } // end of for
    return heighest;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int total = 0;
    for (AsciiBlock block : blocks) {
      total += block.width();
    } // end of foor
    return total;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof HComp) && (this.eqv((HComp) other))); // STUB
  } // eqv(AsciiBlock)

  /**
   * Determine if another Hcomp is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(HComp other) {
    if (!this.align.equals(other.align) || this.blocks.length != other.blocks.length) {
      return false;
    } // end of if
    for (int i = 0; i < this.blocks.length; i++) {
      if (!this.blocks[i].eqv(other.blocks[i])) {
        return false;
      } // end of if
    } // end of for
    return true;
  } // eqv(HComp other)
} // class HComp
