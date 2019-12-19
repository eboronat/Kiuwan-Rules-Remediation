# Kiuwan_Rules_Remediation
If you are interested in getting the field 'REMEDIATION' of the Rules that detected defects in your application, then you can use this program as template. 

The program obtains all the rules violated in your application via the Kiuwan Rest API and it searchs the field Remediation per Rule in an Excel file (xlsx) which contains all the Rules information.

## Previous Steps
First of all, you will have to download a CSV file with all the rules information of your model and export it to xlsx format. For that:

1. Go to Models Management in Kiuwan's Administration Pannel and select your model in use. CLick on Rules tab. Next to the title there is a button where you can export the rules as CSV.

2. Open the CSV file with Google Sheets and download it as Microsoft Excel (xlsx). (For more info: https://www.kiuwan.com/docs/display/K5/Cannot+Import+CSV+Kiuwan+Reports+into+Microsoft+Excel#CannotImportCSVKiuwanReportsintoMicrosoftExcel-Problem )

## Running the program
Import the project as a Maven one to get dependencies.

1. Set your Kiuwan username and password in the corresponding variables.

2. The program receives 4 arguments: application name, source component name, source component type and navigation direction. You can edit (add, delete, modify) these arguments as you wish. They are used to create a JSON Object that is included into the POST request. You can see the structure of the JSON Object into (https://www.kiuwan.com/docs/display/K5/Architecture#Architecture-%C2%AB%C2%BBListimpactedcomponents).

## Output example
```
java -jar ImpactAnalysis.jar SAP1 E070 Table in

Executing request POST https://www.kiuwan.com/saas/rest/v1/arch/impact/searchTargets HTTP/1.1
----------------------------------------
HTTP/1.1 200 OK
----------------------------------------
Component Impacted Name: ZCL_IM_KW_BADI_REQ_CHECK (Type: class)
Component Impacted Name: ZKW_CL_CODE (Type: class)
```
