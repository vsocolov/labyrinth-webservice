package com.vsocolov.tide.labyrinth.facade.impl;

import com.vsocolov.tide.labyrinth.data.request.LabyrinthRequest;
import com.vsocolov.tide.labyrinth.data.response.LabyrinthResponse;
import com.vsocolov.tide.labyrinth.exception.NoEscapeException;
import com.vsocolov.tide.labyrinth.facade.LabyrinthFacade;
import com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.vsocolov.tide.labyrinth.facade.LabyrinthFacade.NO_ESCAPE_ERROR_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LabyrinthFacadeTest {

    @InjectMocks
    private LabyrinthFacade facade = new LabyrinthFacadeImpl();

    @Mock
    private LabyrinthEscapeService labyrinthEscapeService;

    @Test
    public void escapeLabyrinth_should_return_drawn_lab() throws NoEscapeException {
        char[][] lab = new char[2][2];
        int startX = 0, startY = 0;
        final LabyrinthRequest request = new LabyrinthRequest(new int[]{startX, startY}, lab);

        when(labyrinthEscapeService.drawPathForEscape(lab, startX, startY)).thenReturn(lab);

        final LabyrinthResponse response = facade.escapeLabyrinth(request);
        assertThat(response.getLabyrinth(), equalTo(lab));
        assertThat(response.getErrorMessage(), is(nullValue()));
    }

    @Test
    public void escapeLabyrinth_should_return_error_msg_if_exception_is_thrown() throws NoEscapeException {
        char[][] lab = new char[2][2];
        int startX = 0, startY = 0;
        final LabyrinthRequest request = new LabyrinthRequest(new int[]{startX, startY}, lab);

        when(labyrinthEscapeService.drawPathForEscape(lab, startX, startY)).thenThrow(NoEscapeException.class);

        final LabyrinthResponse response = facade.escapeLabyrinth(request);
        assertThat(response.getLabyrinth(), is(nullValue()));
        assertThat(response.getErrorMessage(), equalTo(NO_ESCAPE_ERROR_MESSAGE));
    }
}
