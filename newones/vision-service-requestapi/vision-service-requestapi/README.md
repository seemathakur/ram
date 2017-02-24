# Developer Guide: Vision Service Request API
Developer guide for interacting with Vision Service Request API

![Create Vision Service Request Flow](CreateVisionServiceRequestFlow.png)

## Pre-Requisites/Assumptions

Providers will authenticate using OAuth 2.0 (PingFed). You will need to create a PingFed OAuth client ID and logon credentials will need to be established for each DR office. The Vision Service Request API requires an OAuth token to obtain the service location so the authorization can be issued to the doctor's office.

All patients must be found in memberpolicies search

## Create Vision Service Request

1. Search memberpolicies and retrieve patient to whom the Vision Service Request will be issued. When you search for memberpolicies be sure to fill the asofdate parameter. This will be the effective date.
2. Retrieve eligibility for the patient. The asofdate will be the asofdate you searched memberpolicies with.
3. Create the vision service request to the corresponding eligibility network and product package. The effective date will be the asofdate which you searched memberpolicies with. Each eligibility product package on the eligibility response will have a link to create a vision service request. You will need to determine which network and product package you would like to issue to.

### Sample Response Snippet from Eligibility

```json
{
  "eligibleItems": [
    {
      "eligibilityInterval": {
        "begin": "2016-12-01",
        "end": "2017-11-30"
      },
      "description": "Exam",
      "productCatalogKey": "GenExam",
      "status": "AVAILABLE"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-01",
        "end": "2017-11-30"
      },
      "description": "Contact Lens Service",
      "productCatalogKey": "ContactLensService",
      "status": "AVAILABLE"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-01",
        "end": "2017-11-30"
      },
      "description": "Lens",
      "productCatalogKey": "Lens",
      "status": "AVAILABLE"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-01",
        "end": "2017-11-30"
      },
      "description": "Frame",
      "productCatalogKey": "Frame",
      "status": "AVAILABLE"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-01",
        "end": "2017-11-30"
      },
      "description": "Contact Lens",
      "productCatalogKey": "ContactLens",
      "status": "AVAILABLE"
    }
  ],
  "coverages": [],
  "name": "SignatureChoice",
  "description": "Signature Choice",
  "primaryProduct": true,
  "createVisionServiceRequest": {
    "href": "http://api-acpt.vsp.com:80/vision-service-requestapi-web/eligibility/30039427-0002-851104717-306032284-MLVN-SignatureChoice/visionservicerequests",
    "type": "application/vnd.vsp.visionservicerequest",
    "rel": "urn://vnd.vsp.rels/createvisionservicerequest"
  }
}
```
Once you have determined which network and package you can build your request body. The media type is VisionServiceRequest. You only need to specify the list of eligible product items you would like to reserve. 
The eligible product items you can choose from are the ones returned in the eligibility response for the given product pacakge and network (See sample Eligibility response snippet above)

### Sample Request: 

```
POST /vision-service-requestapi-web/eligibility/00857001-0100-858017570-300253761-1000-Signature/visionservicerequests HTTP/1.1
Host: ea-loadbal153.vsp.com
Authorization: bearer af95638f-027e-4a77-ade6-a4bd577199b8
Accept: application/vnd.vsp.visionservicerequest
Content-Type: application/vnd.vsp.visionservicerequest
Cache-Control: no-cache
Postman-Token: 2a91a26d-f898-e3f1-5dd9-2c902690fa8f

{
  "selectedEligibleProductItems" : [
    { "productCatalogKey" : "ContactLensService"},
    { "productCatalogKey" : "ContactLens"},
    { "productCatalogKey" : "Lens"},
    { "productCatalogKey" : "Frame"},
    { "productCatalogKey" : "GenExam"}
  ]
}
```

Creating a Vision Service Request will create a new Vision Service Request and also issue a corresponding BDS Authorization using an adapter to translate the product data to plan. This adapter is in place until the transition off BDS is complete and consuming applications no longer rely on BDS data. The BDS authorization number is the authorizationNumber

```json
Sample Response:
{
  "trackingNumber": "100432215",
  "authorizationNumber": "10977304",
  "productPackageName": "Signature",
  "classId": "0100",
  "providerNetworkAccessPoint": {
    "serviceLocation": {
      "key": {
        "serviceLocationHashCode": "600 ",
        "serviceLocationSequence": "1"
      },
      "altairInd": false,
      "disabilityAccess": false,
      "dispensingInd": false,
      "name": "OPTOMETRIC CLINIC PA",
      "salesTaxExemptInd": false,
      "phoneNumber": "6015452020",
      "identifyingAddress": {},
      "physicalAddress": {
        "street1": "600 W PINE ST",
        "city": "HATTIESBURG",
        "stateCode": "MS",
        "zipCode": "39401",
        "zipExtension": "3834"
      },
      "mailingAddress": {}
    },
    "doctor": {
      "key": {},
      "address": {},
      "phone": "6015452020",
      "name": {},
      "lastUpdate": "0001-01-01T00:00:00.000-07:52:58"
    },
    "providerNetworkKey": {
      "networkId": "1000"
    },
    "accessPointEffectiveDate": "0001-01-01",
    "accessPointLimitDate": "2078-12-31",
    "networkDoctorListEffectiveDate": "0001-01-01",
    "networkDoctorListLimitDate": "2078-12-31"
  },
  "providerKey": {
    "providerTaxId": "640521701"
  },
  "patient": {
    "consumerId": "300253761",
    "name": {
      "firstName": "JASPERXXX",
      "lastName": "JACKS"
    },
    "addresses": [
      {
        "street1": "3333 QUALITY DRIVE",
        "city": "RANCHO CORDOVA",
        "stateCode": "CA",
        "zipCode": "95670",
        "zipExtension": "7985"
      }
    ],
    "phones": [
      {
        "number": "9999999",
        "prefix": "999"
      }
    ],
    "memberPolicyKey": {
      "clientId": "00857001",
      "divisionId": "0100",
      "policyId": "858017570"
    },
    "status": "A",
    "relationToSubscriber": "Member",
    "dateOfBirth": "1971-06-11",
    "gender": "M"
  },
  "member": {
    "name": {
      "firstName": "JASPERXXX",
      "lastName": "JACKS"
    },
    "addresses": [
      {
        "street1": "3333 QUALITY DRIVE",
        "city": "RANCHO CORDOVA",
        "stateCode": "CA",
        "zipCode": "95670",
        "zipExtension": "7985"
      }
    ],
    "phones": [
      {
        "number": "9999999",
        "prefix": "999"
      }
    ],
    "memberPolicyKey": {
      "clientId": "00857001",
      "divisionId": "0100",
      "policyId": "858017570"
    },
    "membershipId": "858017570",
    "dateOfBirth": "1971-06-11",
    "gender": "M"
  },
  "issueDate": "2016-12-08",
  "selectedEligibleProductItems": [
    {
      "eligibilityInterval": {
        "begin": "2016-12-08",
        "end": "2017-01-07"
      },
      "productCatalogKey": "ContactLens"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-08",
        "end": "2017-01-07"
      },
      "productCatalogKey": "Lens"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-08",
        "end": "2017-01-07"
      },
      "productCatalogKey": "Frame"
    },
    {
      "eligibilityInterval": {
        "begin": "2016-12-08",
        "end": "2017-01-07"
      },
      "productCatalogKey": "GenExam"
    }
  ]
}
```

### Response Codes
| Code | Response | 
|------| ---------|
| 200  | Success. The Vision Service Request and corresponding legacy authorization were created successfully.| 
| 204  | Success, but no Vision Service Request was created because no items requested were eligible. |
| 400  | Bad Request. No Vision Service Request was able to be created. The legacy authorization was not able to be issued |
| 404 | Not Found. No Vision Service Request was able to be created. The provider network was not able to be found. |
| 500 | Internal Server Error. No Vision Service Request was anle to be created |

## Search Vision Service Requests


1. Follow the visionservicerequests link on API Home with the following parameters: **client id**, **division id**, **policy id**, **consumer id**

### Sample Request

```
GET /service-requestapi-web/visionservicerequests?clientId=30039427&divisionId=0002&consumerId=306032284&policyId=851104717 HTTP/1.1
Host: ea-loadbal150
Authorization: bearer 4f456789-739e-429a-8ba5-1a684dbdec24
Accept: application/vnd.vsp.visionservicerequests
Content-Type: application/vnd.vsp.visionservicerequests
Cache-Control: no-cache
Postman-Token: 248f40d3-b080-ba5c-db30-7a79223641fa
```

### Response
List of media type VisionServiceRequests

| Code | Response | 
|------| ---------|
| 200 | Success and a list of results. |
| 200 | Success and no results found. |
| 400 | Invalid search parameters    |


## Delete Vision Service Request

1. Search for Vision Service Requests on API Home
2. Select Vision Service Request to delete from list returned
3. Follow the self link with DELETE operation


### Sample Request

```
DELETE /vision-service-requestapi-web/visionservicerequests/100432211 HTTP/1.1
Host: ea-loadbal150.vsp.com
Authorization: bearer dc611d16-ed8a-4d17-b132-09da609472f8
Accept: application/vnd.vsp.visionservicerequest
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: 655a7ba2-178e-0538-99cc-3c898292c859

grant_type=client_credentials&scope=rating_view%2Cprovider_view%2Cmember_view%2Celigibility_view%2Cproduct_view%2Cclient_view%2Cclaim_view%2Corder_view%2Clab_view%2Csupplier_view%2Creference_view%2Cwrite%3Aeligibility
```

| Code | Response | 
|------| ---------|
| 200  | Successful delete of vision service request and legacy authorization |
| 404  | Vision service request doesn't exist. |
| 400  | Unable to delete legacy authorization |
