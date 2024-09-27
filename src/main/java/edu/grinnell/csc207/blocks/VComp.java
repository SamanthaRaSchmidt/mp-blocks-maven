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

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
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
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    int maxHeight = this.height();
    int maxWidth = this.width();
    String output = new String(" ");
    if (i < 0 || i >= maxHeight) {
      throw new Exception("Row at index " + i + " is out of the valid range");
    } // end of if
      int space = maxWidth - blocks[i].width();
      for (AsciiBlock block : blocks) {
        int rowNum = 0;
        for (int j = 0; j < block.height(); j++, rowNum++) {
          if (rowNum == i) {
            output = block.row(j);
            if (align == HAlignment.LEFT) {
              output = output.concat(" ".repeat(space));
              return output;
            } else if (align == HAlignment.RIGHT){
              if(blocks[i].width() < maxWidth) {
                output = (" ".repeat(space)) + block.row(j);
                return output;
              } else {
                output = block.row(j);
                return output;
              }
            } else if (align == HAlignment.CENTER) {
              output = block.row(j);
              // I know the math for this as it's simple enough, I'll add it after I figure out the general output
              return output;
            }
          }
        }
      }
      return new String(output);
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
    int max = blocks[0].width();
    for (AsciiBlock block : blocks) {
      if (max < block.width()) {
        max = block.width();
      }
    } // end of for
    return max;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return false;       // STUB
  } // eqv(AsciiBlock)
} // class VComp
