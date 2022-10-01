package com.algo.expert.binarysearchtrees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BstConstructionTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [13],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [22],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [14],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [12],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED1 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [13],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [22],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [14],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [12],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": \"12\", \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"12\", \"left\": \"5\", \"right\": \"15\", \"value\": 12},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"12\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"12\", \"left\": \"5\", \"right\": \"15\", \"value\": 12},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"12\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE2 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED2 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE3 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [6],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [11],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [16],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED3 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [6],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [11],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [16],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE4 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"remove\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED4 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE5 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"contains\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED5 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": \"5\", \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"15\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE6 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [3],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [4],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [6],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [7],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [8],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [9],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [11],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [12],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [13],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [14],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [16],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [17],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [18],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [19],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [20],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [4],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [6],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [8],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [11],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [13],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [17],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [19],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [3],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [4],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [6],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [7],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [8],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [9],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [9000],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 1\n" +
            "}";
    private static final String EXPECTED6 = "[\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [3],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [4],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [6],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [7],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [8],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [9],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [11],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [12],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [13],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [14],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [16],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 16}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [17],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": null, \"value\": 17}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [18],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": null, \"value\": 18}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [19],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": null, \"value\": 19}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [20],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [4],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [6],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [8],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "        {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [11],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [13],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"15\", \"value\": 14},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"16\", \"value\": 15},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"17\", \"value\": 16},\n" +
            "        {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [17],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "        {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [19],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [3],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [4],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": null, \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [6],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [7],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": \"7-2\", \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"7-2\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [8],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": \"7-2\", \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"7-2\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [9],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": \"7-2\", \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": \"9-2\", \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"9-2\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "        {\"id\": \"7-2\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": \"7-2\", \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": \"9-2\", \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": \"10-2\", \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"10-2\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"9-2\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "        {\"id\": \"7-2\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [9000],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "        {\"id\": \"3\", \"left\": \"1-2\", \"right\": \"5\", \"value\": 3},\n" +
            "        {\"id\": \"5\", \"left\": \"3-2\", \"right\": \"7\", \"value\": 5},\n" +
            "        {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"9\", \"value\": 7},\n" +
            "        {\"id\": \"9\", \"left\": \"7-2\", \"right\": \"10\", \"value\": 9},\n" +
            "        {\"id\": \"10\", \"left\": \"9-2\", \"right\": \"12\", \"value\": 10},\n" +
            "        {\"id\": \"12\", \"left\": \"10-2\", \"right\": \"14\", \"value\": 12},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": \"16\", \"value\": 14},\n" +
            "        {\"id\": \"16\", \"left\": null, \"right\": \"18\", \"value\": 16},\n" +
            "        {\"id\": \"18\", \"left\": null, \"right\": \"20\", \"value\": 18},\n" +
            "        {\"id\": \"20\", \"left\": null, \"right\": null, \"value\": 20},\n" +
            "        {\"id\": \"10-2\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"9-2\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "        {\"id\": \"7-2\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "        {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "        {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "        {\"id\": \"3-2\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "        {\"id\": \"1-2\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE7 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [3],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [4],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"remove\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 1\n" +
            "}";
    private static final String EXPECTED7 = "[\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [3],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [4],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "        {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "        {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "      ],\n" +
            "      \"root\": \"2\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE8 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [-2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [-3],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [-4],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"remove\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 1\n" +
            "}";
    private static final String EXPECTED8 = "[\n" +
            "  {\n" +
            "    \"arguments\": [-2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": \"-2\", \"right\": null, \"value\": 1},\n" +
            "        {\"id\": \"-2\", \"left\": null, \"right\": null, \"value\": -2}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [-3],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": \"-2\", \"right\": null, \"value\": 1},\n" +
            "        {\"id\": \"-2\", \"left\": \"-3\", \"right\": null, \"value\": -2},\n" +
            "        {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [-4],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"1\", \"left\": \"-2\", \"right\": null, \"value\": 1},\n" +
            "        {\"id\": \"-2\", \"left\": \"-3\", \"right\": null, \"value\": -2},\n" +
            "        {\"id\": \"-3\", \"left\": \"-4\", \"right\": null, \"value\": -3},\n" +
            "        {\"id\": \"-4\", \"left\": null, \"right\": null, \"value\": -4}\n" +
            "      ],\n" +
            "      \"root\": \"1\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"-2\", \"left\": \"-3\", \"right\": null, \"value\": -2},\n" +
            "        {\"id\": \"-3\", \"left\": \"-4\", \"right\": null, \"value\": -3},\n" +
            "        {\"id\": \"-4\", \"left\": null, \"right\": null, \"value\": -4}\n" +
            "      ],\n" +
            "      \"root\": \"-2\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE9 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [10],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED9 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [10],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"5\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": false,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"5\"\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String TEST_CASE10 = "{\n" +
            "  \"classMethodsToCall\": [\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [13],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [22],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [14],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [12],\n" +
            "      \"method\": \"insert\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [5],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [12],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [13],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [14],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [22],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [2],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [1],\n" +
            "      \"method\": \"remove\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"arguments\": [15],\n" +
            "      \"method\": \"contains\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rootValue\": 10\n" +
            "}";
    private static final String EXPECTED10 = "[\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": null, \"value\": 10},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [13],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [22],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [14],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [12],\n" +
            "    \"method\": \"insert\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": \"12\", \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "        {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": \"12\", \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "        {\"id\": \"5\", \"left\": \"2\", \"right\": null, \"value\": 5},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [5],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"2\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": \"12\", \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [12],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"2\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [13],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"2\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": \"14\", \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [14],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"2\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "        {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [22],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"2\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [2],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": \"1\", \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "        {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [1],\n" +
            "    \"method\": \"remove\",\n" +
            "    \"output\": null,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"arguments\": [15],\n" +
            "    \"method\": \"contains\",\n" +
            "    \"output\": true,\n" +
            "    \"tree\": {\n" +
            "      \"nodes\": [\n" +
            "        {\"id\": \"10\", \"left\": null, \"right\": \"15\", \"value\": 10},\n" +
            "        {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "      ],\n" +
            "      \"root\": \"10\"\n" +
            "    }\n" +
            "  }\n" +
            "]";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(TestCase testCase, List<Expected> expectedList) throws Exception {
        Assertions.assertEquals(testCase.calls.size(), expectedList.size());
        for (int i = 0; i < testCase.calls.size(); i++) {
            MethodCall call = testCase.calls.get(i);
            Method method = BstConstruction.BST.class.getMethod(call.method, int.class);
            Object result = method.invoke(testCase.root, call.arguments.toArray());
            Expected expected = expectedList.get(i);
            if (expected.output == null) {
                Assertions.assertSame(result, testCase.root);
            } else {
                Assertions.assertEquals(expected.output, result);
            }
            String message = String.format("method = %s, arguments = %s", call.method, call.arguments);
            assertTree(expected.tree, testCase.root, message);
        }
    }

    private void assertTree(BstConstruction.BST expected, BstConstruction.BST actual, String message) {
        if (expected == null && actual == null) return;
        Assertions.assertNotNull(expected, message);
        Assertions.assertNotNull(actual, message);
        Assertions.assertEquals(expected.value, actual.value, message);
        assertTree(expected.left, actual.left, message);
        assertTree(expected.right, actual.right, message);
    }

    static List<Arguments> params() {
        return List.of(
//                parseArguments(TEST_CASE1, EXPECTED1),
//                parseArguments(TEST_CASE2, EXPECTED2),
//                parseArguments(TEST_CASE3, EXPECTED3),
                parseArguments(TEST_CASE4, EXPECTED4),
                parseArguments(TEST_CASE5, EXPECTED5),
                parseArguments(TEST_CASE6, EXPECTED6),
                parseArguments(TEST_CASE7, EXPECTED7),
                parseArguments(TEST_CASE8, EXPECTED8),
                parseArguments(TEST_CASE9, EXPECTED9),
                parseArguments(TEST_CASE10, EXPECTED10)
        );
    }

    static Arguments parseArguments(String testCase, String expected) {
        JsonObject testObject = new Gson().fromJson(testCase, JsonElement.class).getAsJsonObject();
        BstConstruction.BST root = new BstConstruction.BST(
                testObject.getAsJsonPrimitive("rootValue").getAsInt()
        );
        List<MethodCall> calls = new ArrayList<>();
        for (JsonElement element : testObject.getAsJsonArray("classMethodsToCall")) {
            JsonObject object = element.getAsJsonObject();
            String method = object.getAsJsonPrimitive("method").getAsString();
            List<Object> arguments = new ArrayList<>();
            for (JsonElement argument : object.getAsJsonArray("arguments")) {
                arguments.add(argument.getAsInt());
            }
            calls.add(new MethodCall(method, arguments));
        }

        List<Expected> expectedList = new ArrayList<>();
        JsonArray expectedArray = new Gson().fromJson(expected, JsonElement.class).getAsJsonArray();
        for (JsonElement element : expectedArray) {
            JsonObject object = element.getAsJsonObject();
            JsonElement outputElement = object.get("output");
            Object output = outputElement.isJsonNull() ? null : outputElement.getAsBoolean();

            Map<String, BstConstruction.BST> map = new HashMap<>();
            JsonObject treeObject = object.getAsJsonObject("tree");
            for (JsonElement node : treeObject.getAsJsonArray("nodes")) {
                String id = node.getAsJsonObject().get("id").getAsString();
                int value = node.getAsJsonObject().get("value").getAsInt();
                map.put(id, new BstConstruction.BST(value));
            }
            for (JsonElement node : treeObject.getAsJsonArray("nodes")) {
                String id = node.getAsJsonObject().get("id").getAsString();
                JsonElement left = node.getAsJsonObject().get("left");
                JsonElement right = node.getAsJsonObject().get("right");
                if (!left.isJsonNull()) {
                    map.get(id).left = map.get(left.getAsString());
                }
                if (!right.isJsonNull()) {
                    map.get(id).right = map.get(right.getAsString());
                }
            }
            BstConstruction.BST tree = map.get(treeObject.get("root").getAsString());
            expectedList.add(new Expected(output, tree));
        }
        return Arguments.of(new TestCase(calls, root), expectedList);
    }

    static class TestCase {
        final List<MethodCall> calls;
        final BstConstruction.BST root;

        public TestCase(List<MethodCall> calls, BstConstruction.BST root) {
            this.calls = calls;
            this.root = root;
        }
    }

    static class MethodCall {
        final String method;
        final List<Object> arguments;

        public MethodCall(String method, List<Object> arguments) {
            this.method = method;
            this.arguments = arguments;
        }
    }

    static class Expected {
        final Object output;
        final BstConstruction.BST tree;

        public Expected(Object output, BstConstruction.BST tree) {
            this.output = output;
            this.tree = tree;
        }
    }
}
