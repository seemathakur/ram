$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/EInsurance/LensOptions/LensOptions.feature");
formatter.feature({
  "line": 1,
  "name": "Lens Option Updates",
  "description": "\r\nIn order to verify the available lens options for doctors\r\nAs a user of the VSP Online portal.\r\nI want to be able to validate from a supplied spreadsheet that all options are present.",
  "id": "lens-option-updates",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4698217469,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "# this is a comment"
    },
    {
      "line": 9,
      "value": "#  Scenario: [0]  Test Setup: Log on and navigate to setup for test"
    },
    {
      "line": 10,
      "value": "#    Given I navigate to the Eyefinity Logon Portal"
    },
    {
      "line": 11,
      "value": "#    When A user logs on with \u003ccredentials\u003e"
    },
    {
      "line": 12,
      "value": "#      |username|9498314144|"
    },
    {
      "line": 13,
      "value": "##      |password|4314|"
    },
    {
      "line": 14,
      "value": "#    Then I navigate to EInsurance homepage and enter \u003cauth\u003e and click go"
    },
    {
      "line": 15,
      "value": "#    |auth|10410721|"
    }
  ],
  "line": 17,
  "name": "[2] I run the Lens Options Update Additions from excel",
  "description": "",
  "id": "lens-option-updates;[2]-i-run-the-lens-options-update-additions-from-excel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I load the excel file \u003cfilename\u003e",
  "rows": [
    {
      "cells": [
        "filename",
        "LSUOneRow.xlsx"
      ],
      "line": 19
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I iterate through the rows.",
  "keyword": "Then "
});
formatter.match({
  "location": "LensOptionsTests.i_load_the_excel_file_filename(DataTable)"
});
formatter.result({
  "duration": 1822072118,
  "status": "passed"
});
formatter.match({
  "location": "LensOptionsTests.iIterateThroughTheRows()"
});
