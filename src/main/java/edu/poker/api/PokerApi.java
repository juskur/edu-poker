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
//    @ApiImplicitParams(
//            @ApiImplicitParam(
//            name = "players",
//            dataType = "Array[Player]",
//            required = true,
//            dataTypeClass = edu.poker.api.Players.class,
//            defaultValue = "[\n" +
//                    "  {\n" +
//                    "    \"name\": \"Vardenis\",\n" +
//                    "    \"cards\": [\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Jack\",\n" +
//                    "        \"suite\": \"Hearts\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"3\",\n" +
//                    "        \"suite\": \"Hearts\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Jack\",\n" +
//                    "        \"suite\": \"Spades\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Jack\",\n" +
//                    "        \"suite\": \"Diamonds\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Jack\",\n" +
//                    "        \"suite\": \"Clubs\"\n" +
//                    "      }\n" +
//                    "    ]\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"name\": \"Pavardenis\",\n" +
//                    "    \"cards\": [\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Ace\",\n" +
//                    "        \"suite\": \"Hearts\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"3\",\n" +
//                    "        \"suite\": \"Hearts\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"Ace\",\n" +
//                    "        \"suite\": \"Spades\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"3\",\n" +
//                    "        \"suite\": \"Diamonds\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"rank\": \"3\",\n" +
//                    "        \"suite\": \"Clubs\"\n" +
//                    "      }\n" +
//                    "    ]\n" +
//                    "  }\n" +
//                    "]\n",
//                    example = "[\n" +
//                            "  {\n" +
//                            "    \"name\": \"Vardenis\",\n" +
//                            "    \"cards\": [\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Jack\",\n" +
//                            "        \"suite\": \"Hearts\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"3\",\n" +
//                            "        \"suite\": \"Hearts\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Jack\",\n" +
//                            "        \"suite\": \"Spades\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Jack\",\n" +
//                            "        \"suite\": \"Diamonds\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Jack\",\n" +
//                            "        \"suite\": \"Clubs\"\n" +
//                            "      }\n" +
//                            "    ]\n" +
//                            "  },\n" +
//                            "  {\n" +
//                            "    \"name\": \"Pavardenis\",\n" +
//                            "    \"cards\": [\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Ace\",\n" +
//                            "        \"suite\": \"Hearts\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"3\",\n" +
//                            "        \"suite\": \"Hearts\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"Ace\",\n" +
//                            "        \"suite\": \"Spades\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"3\",\n" +
//                            "        \"suite\": \"Diamonds\"\n" +
//                            "      },\n" +
//                            "      {\n" +
//                            "        \"rank\": \"3\",\n" +
//                            "        \"suite\": \"Clubs\"\n" +
//                            "      }\n" +
//                            "    ]\n" +
//                            "  }\n" +
//                            "]\n",
//            examples = @io.swagger.annotations.Example(
//                    value = {
//                            @ExampleProperty(value = "[\n" +
//                                    "  {\n" +
//                                    "    \"name\": \"Vardenis\",\n" +
//                                    "    \"cards\": [\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Jack\",\n" +
//                                    "        \"suite\": \"Hearts\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"3\",\n" +
//                                    "        \"suite\": \"Hearts\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Jack\",\n" +
//                                    "        \"suite\": \"Spades\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Jack\",\n" +
//                                    "        \"suite\": \"Diamonds\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Jack\",\n" +
//                                    "        \"suite\": \"Clubs\"\n" +
//                                    "      }\n" +
//                                    "    ]\n" +
//                                    "  },\n" +
//                                    "  {\n" +
//                                    "    \"name\": \"Pavardenis\",\n" +
//                                    "    \"cards\": [\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Ace\",\n" +
//                                    "        \"suite\": \"Hearts\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"3\",\n" +
//                                    "        \"suite\": \"Hearts\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"Ace\",\n" +
//                                    "        \"suite\": \"Spades\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"3\",\n" +
//                                    "        \"suite\": \"Diamonds\"\n" +
//                                    "      },\n" +
//                                    "      {\n" +
//                                    "        \"rank\": \"3\",\n" +
//                                    "        \"suite\": \"Clubs\"\n" +
//                                    "      }\n" +
//                                    "    ]\n" +
//                                    "  }\n" +
//                                    "]\n", mediaType = "application/json")
//                    })
//        ))
    ResponseEntity<Result> compareCards(
            @ApiParam(value = "Two players with the cards to be compared", required = true,
                    examples = @io.swagger.annotations.Example(
                            value = {
                                    @ExampleProperty(value = "[\n" +
                                            "  {\n" +
                                            "    \"name\": \"Vardenis\",\n" +
                                            "    \"cards\": [\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Jack\",\n" +
                                            "        \"suite\": \"Hearts\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"3\",\n" +
                                            "        \"suite\": \"Hearts\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Jack\",\n" +
                                            "        \"suite\": \"Spades\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Jack\",\n" +
                                            "        \"suite\": \"Diamonds\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Jack\",\n" +
                                            "        \"suite\": \"Clubs\"\n" +
                                            "      }\n" +
                                            "    ]\n" +
                                            "  },\n" +
                                            "  {\n" +
                                            "    \"name\": \"Pavardenis\",\n" +
                                            "    \"cards\": [\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Ace\",\n" +
                                            "        \"suite\": \"Hearts\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"3\",\n" +
                                            "        \"suite\": \"Hearts\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"Ace\",\n" +
                                            "        \"suite\": \"Spades\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"3\",\n" +
                                            "        \"suite\": \"Diamonds\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"rank\": \"3\",\n" +
                                            "        \"suite\": \"Clubs\"\n" +
                                            "      }\n" +
                                            "    ]\n" +
                                            "  }\n" +
                                            "]\n", mediaType = "application/json")
                            }))
            @Valid @RequestBody Players body);
}
