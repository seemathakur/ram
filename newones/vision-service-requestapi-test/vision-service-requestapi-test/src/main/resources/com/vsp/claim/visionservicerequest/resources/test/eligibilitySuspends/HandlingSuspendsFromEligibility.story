Handling suspends from Eligibility

Narrative:
As a Doctor
I want to Handling suspends from Eligibility

!-- We added AUTH-2737 to re-factor how we handle suspends from Eligibility

Meta: @skip
@jira AUTH-801
				 			 
Meta: 
@jira corrupted-client
Scenario: #1 - Set up with missing/Inv Zip Code and follow the link
Given a key memberPolicyKey of 12250699-0001-061882539
And a key consumerId of 1534870
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| PRELIQ0015  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #2 - Set up with Missing Student Verification and follow the link
Given a key memberPolicyKey of 30025017-0002-858247868
And a key consumerId of 2418078
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of 2015-05-28
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| PRELIQ0016  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #3 - Set up with Dependent Coverage Used and follow the link
Given a key memberPolicyKey of 12140859-0011-851444717
And a key consumerId of 303175881
And a key providerNetwork of AFPR
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| SRVPAT0006  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #4 - Set up with Member Plus Spouse Coverage Only and follow the link
Given a key memberPolicyKey of 12058969-0101-851354717
And a key consumerId of 303175423
And a key providerNetwork of 1000
And a key productPackageName of DEPPlus
And a list 
| productCatalogKey |
| Examination		|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| SRVPAT0007  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #5 - Set up with EFF Date > CLM PYMT Period and follow the link
Given a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of 2014-09-01
And a list 
| productCatalogKey |
| GenExam |
 
When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| AUTHOR0001  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #6 - Set up with Invalid Age for REL CD and follow the link
Given a key memberPolicyKey of 12154911-0105-858364717
And a key consumerId of 303175427
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| SRVPAT0008  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #7 - Set up with Member Over Plan Age and follow the link
Given a key memberPolicyKey of 12049413-0001-851364717
And a key consumerId of 303175432
And a key providerNetwork of 50CA
And a key productPackageName of PEC
And a list 
| productCatalogKey |
| Examination		|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| SRVMBR0012  |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |

Scenario: #8 - Set up with No Plan for Relation and follow the link
Given a key memberPolicyKey of 00857001-0100-851374717
And a key consumerId of 303175435
And a key effectiveDate of 2013-03-18
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam |

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| SRVPAT0009  |