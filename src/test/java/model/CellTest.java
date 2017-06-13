package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class CellTest {
    private Cell cell;

    @BeforeEach
    void setup(){
        int defaultRow = 1;
        int defaultCol = 1;
        cell = new Cell(defaultRow, defaultCol);
    }

    @Test
    void testCellClassConstructorReturnDefaultContent() {
        String expectedContent = " ";
        assertEquals(expectedContent, cell.toString());
    }

    @Test
    void testSetContentMethodSetsContentProperly() {
        String expectedContent = "X";
        cell.setContent(Seed.CROSS);
        assertEquals(expectedContent, cell.toString());
    }

    @Test
    void testClearMethodSetContentToEmpty() {
        String expectedContent = " ";
        cell.setContent(Seed.CROSS);
        cell.clear();
        assertEquals(expectedContent, cell.toString());
    }
}