package edu.grinnell.csc207;

import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Pyramid;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Tests if it can return a single line given 1 character
   */
  @Test
  public void basicPyramidTest() throws Exception {
    Pyramid pyramid = new Pyramid("*", 1);
    assertEquals(1, pyramid.width(), "Width of a single element");
    assertEquals(1, pyramid.height(), "Height of only one element");
    assertEquals("*", pyramid.row(0), "Looks right");
  } // basicPyramidTest()

  /**
   * Tests if it can return a multiple lines given 1 character
   */
  @Test
  public void multipleRowPyramidTest() throws Exception {
    Pyramid pyramid = new Pyramid("*", 5);
    assertEquals(9, pyramid.width(), "Width of a multi row pyramid");
    assertEquals(5, pyramid.height(), "Height of multi row pyramid");
    assertEquals("    *    ", pyramid.row(0), "Looks right");
    assertEquals("   ***   ", pyramid.row(1), "Looks right");
    assertEquals("  *****  ", pyramid.row(2), "Looks right");
    assertEquals(" ******* ", pyramid.row(3), "Looks right");
    assertEquals("*********", pyramid.row(4), "Looks right");
  } // mutlipleRowPyramidTest()

  /**
   * Tests if it can return multiple lines given a longer string
   */
  @Test
  public void longStringPyramidTest() throws Exception {
    String longString = "HELLO THIS IS A REALLY REALLY LONG STRING";
    Pyramid pyramid = new Pyramid(longString, 2);
    assertEquals(longString.length() * 3, pyramid.width(), "Width of a long string");
    assertEquals(2, pyramid.height(), "Height of a long string");
    assertEquals(" ".repeat(longString.length()) + longString + " ".repeat(longString.length()), pyramid.row(0), "Looks right");
    assertEquals(longString.repeat(3), pyramid.row(1), "Looks right");
  } // longStringPyramidTest()

  /**
   * Tests the emptyString with 1 row
   */
  @Test
  public void emptyStringTestSingle() throws Exception {
    Pyramid pyramid = new Pyramid("", 1);
    assertEquals(0, pyramid.width(), "Width of a siiiingle element");
    assertEquals(0, pyramid.height(), "Height of only one element");
    assertEquals("", pyramid.row(0), "Looks right");
  } // emptyStringTestSingle()

   /**
   * Tests the emptyString with multiple rows
   */
  @Test
  public void emptyStringTestMultiple() throws Exception {
    Pyramid pyramid = new Pyramid("", 3);
    assertEquals(0, pyramid.width(), "Width of a siiiingle element");
    assertEquals(0, pyramid.height(), "Height of only one element");
    assertEquals("", pyramid.row(0), "Looks right");
    assertEquals("", pyramid.row(1), "Looks right");
    assertEquals("", pyramid.row(2), "Looks right");
  } // emptyStringTestMultiple()

   /**
   * Tests with slash characters and spaces
   * Helps to see how width is handled with \\
   */
  @Test
  public void slashesAndSpaces() throws Exception {
    Pyramid pyramid = new Pyramid("\\  /", 3);
    assertEquals(20, pyramid.width(), "Width of a single element");
    assertEquals(3, pyramid.height(), "Height of only one element");
    assertEquals("        \\  /        ", pyramid.row(0), "Looks right");
    assertEquals("    \\  /\\  /\\  /    ", pyramid.row(1), "Looks right");
    assertEquals("\\  /\\  /\\  /\\  /\\  /", pyramid.row(2), "Looks right");
  } // slashesAndSpaces()
} // class TestNewBlock
