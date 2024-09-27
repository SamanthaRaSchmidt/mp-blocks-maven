package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Sam Schmidt
 * @author Koast Tsymbal
 */
public class VComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** The blocks. */
  AsciiBlock[] blocks;

  /** How the blocks are aligned. */
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment The way in which the blocks should be aligned.
   * @param topBlock The block on the top.
   * @param bottomBlock The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock, AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(HAlignment, AsciiBLOCK[])

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
    int maxLength = this.width();
    int currentHeight = 0;
    if (i < 0 || i >= maxHeight) {
      throw new Exception("Row at index " + i + " is out of the valid range");
    } // end of if
    for (AsciiBlock block : blocks) {
      if (currentHeight + block.height() > i) {
        int space = maxLength - block.width();
        String output = block.row(i - currentHeight);
        switch (align) {
          case LEFT:
            return output + " ".repeat(space);
          case RIGHT:
            return " ".repeat(space) + output;
          case CENTER:
            int offset = space / 2;
            return " ".repeat(offset) + output + " ".repeat(maxLength - block.width() - offset);
        } // end of switch
      } // end of if
      currentHeight += block.height();
    } // end of for
    return " ".repeat(maxLength);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int heighest = 0;
    for (AsciiBlock block : blocks) {
      heighest += block.height();
    } // end of for
    return heighest;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    if (blocks == null || blocks.length == 0) {
      return 0;
    } // end of if
    int max = blocks[0].width();
    for (AsciiBlock block : blocks) {
      if (max < block.width()) {
        max = block.width();
      } // end of if
    } // end of for
    return max;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return (other instanceof VComp) && (this.eqv((VComp) other)); // STUB
  } // eqv(AsciiBlock)

  /**
   * 
   * @param other
   * @return
   */
  public boolean eqv(VComp other){
    if(!this.align.equals(other.align) || this.blocks.length != other.blocks.length){
      return false;
    } // end of for
    for(int i = 0; i < this.blocks.length; i++){
      if(!this.blocks[i].eqv(other.blocks[i])){
        return false;
      } // end of if
    } // end if for
    return true;
  } //eqv(VComp)
} // class VComp
