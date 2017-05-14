package com.vsocolov.tide.labyrinth.api.resource;

import com.vsocolov.tide.labyrinth.api.PathConstants.Resources;
import com.vsocolov.tide.labyrinth.data.request.LabyrinthRequest;
import com.vsocolov.tide.labyrinth.data.response.LabyrinthResponse;
import com.vsocolov.tide.labyrinth.exception.NoEscapeException;
import com.vsocolov.tide.labyrinth.facade.LabyrinthFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import static com.vsocolov.tide.labyrinth.api.PathConstants.ROOT_PATH;
import static com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService.FREE;
import static com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService.PATH;
import static com.vsocolov.tide.labyrinth.service.LabyrinthEscapeService.WALL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LabyrinthResourceTest {

    private static final String RESOURCE = ROOT_PATH + Resources.ESCAPE;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void clean_should_pass_validation_and_clean_the_room() {
        final LabyrinthRequest request = new LabyrinthRequest();
        request.setStartPoint(new int[]{2, 1});
        request.setLabirinth(new char[][]{
                {WALL, WALL, WALL},
                {WALL, FREE, FREE},
                {WALL, FREE, WALL},
                {WALL, WALL, WALL}});
        char[][] expectedLab = {{WALL, WALL, WALL}, {WALL, PATH, PATH}, {WALL, PATH, WALL}, {WALL, WALL, WALL}};

        final ResponseEntity<LabyrinthResponse> response = restTemplate.postForEntity(RESOURCE, request,
                LabyrinthResponse.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getLabyrinth(), equalTo(expectedLab));
    }

    @Test
    public void clean_should_return_error_msg_there_is_no_escape() {
        final LabyrinthRequest request = new LabyrinthRequest();
        request.setStartPoint(new int[]{1, 1});
        request.setLabirinth(new char[][]{{WALL, WALL, WALL}, {WALL, FREE, WALL}, {WALL, WALL, WALL}});

        final ResponseEntity<LabyrinthResponse> response = restTemplate.postForEntity(RESOURCE, request,
                LabyrinthResponse.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getErrorMessage(), equalTo(LabyrinthFacade.NO_ESCAPE_ERROR_MESSAGE));
    }

    @Test(expected = RestClientException.class)
    public void clean_should_not_pass_validation_if_start_points_and_labyrinth_are_not_set() {
        restTemplate.postForEntity(RESOURCE, new LabyrinthRequest(), LabyrinthResponse.class);
    }
}
