package edu.poker.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Rest API to poker comparison solution
 */
@Api(value = "call")
@RequestMapping(value = "")
interface PokerApi {
    @ApiOperation(value = "Compare Cards", notes = "Compare Cards of Two Players", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cards of players are successfully compared"),
            @ApiResponse(code = 400, message = "Invalid format of Players or Cards")})
    @RequestMapping(value = "/call",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Result> compareCards(@ApiParam(value = "Two Players with 5 cards each", required = true) @Valid @RequestBody Players players);

}
