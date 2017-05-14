package com.vsocolov.tide.labyrinth.service.impl;

import com.vsocolov.tide.labyrinth.exception.NoEscapeException;
import com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService;
import org.junit.Test;

import static com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LabyrinthEscapeServiceTest {

    private LabyrinthEscapeService service = new LabyrinthEscapeServiceImpl();

    @Test
    public void drawPathForEscape_should_draw_path_if_exist() throws NoEscapeException {
        char[][] lab = new char[][]{{WALL, WALL, WALL}, {WALL, FREE, FREE}, {WALL, FREE, WALL}, {WALL, WALL, WALL}};
        char[][] expLab = new char[][]{{WALL, WALL, WALL}, {WALL, PATH, PATH}, {WALL, PATH, WALL}, {WALL, WALL, WALL}};

        char[][] result = service.drawPathForEscape(lab, 2, 1);
        assertThat(result, equalTo(expLab));
    }

    @Test(expected = NoEscapeException.class)
    public void drawPathForEscape_should_throw_exception_if_path_not_exist() throws NoEscapeException {
        char[][] lab = new char[][]{{WALL, WALL, WALL}, {WALL, FREE, WALL}, {WALL, FREE, WALL}, {WALL, WALL, WALL}};

        service.drawPathForEscape(lab, 2, 1);
    }
}
